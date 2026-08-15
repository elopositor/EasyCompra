import asyncio
import json
import re
from pathlib import Path

from fastapi import BackgroundTasks, FastAPI, Query
from sqlalchemy.orm import Session

from . import sync
from .db import Product, engine, init_db

app = FastAPI(title="EasyCompra API")

DATA_DIR = Path(__file__).parent.parent / "data"

# Supermercados servidos desde JSON (actualizado por GitHub Actions)
JSON_SUPERMARKETS = {"Carrefour", "Lidl", "Mercadona", "Dia"}

# Compatibilidad con la app Android v5, cuyo codigo fuente ya no tenemos.
# Deserializa con kotlinx.serialization y su modelo incluye nutriscore_grade
# sin valor por defecto: si el campo no llega, lanza MissingFieldException y la
# app se cierra. El campo esta eliminado del modelo, los scrapers y los datos,
# pero la API lo sigue enviando a null para no romper esa version instalada.
LEGACY_FIELDS = {"nutriscore_grade": None}


def _with_legacy_fields(product: dict) -> dict:
    return {**LEGACY_FIELDS, **product}


def _load_json_products(supermarket: str) -> list[dict]:
    path = DATA_DIR / f"{supermarket.lower()}.json"
    if not path.exists():
        return []
    try:
        return json.loads(path.read_text(encoding="utf-8"))
    except Exception:
        return []


@app.on_event("startup")
def on_startup():
    init_db()


def _product_to_dict(product: Product) -> dict:
    return {column.name: getattr(product, column.name) for column in Product.__table__.columns}


@app.get("/products")
def list_products(
    supermarket: str | None = Query(default=None),
    exclude_ingredient: str | None = Query(default=None),
    sort_by: str = Query(default="sugars_100g"),
):
    products: list[dict] = []

    if supermarket in JSON_SUPERMARKETS:
        products = _load_json_products(supermarket)
    elif supermarket is None:
        # Todos: combinar DB + JSONs
        with Session(engine) as session:
            products = [_product_to_dict(p) for p in session.query(Product).all()]
        for sm in JSON_SUPERMARKETS:
            json_products = _load_json_products(sm)
            existing_ids = {p.get("external_id") for p in products}
            products += [p for p in json_products if p.get("external_id") not in existing_ids]
    else:
        with Session(engine) as session:
            q = session.query(Product).filter(Product.supermarket == supermarket)
            products = [_product_to_dict(p) for p in q.all()]

    if exclude_ingredient:
        pattern = re.compile(rf"\b{re.escape(exclude_ingredient.lower())}\b")
        products = [p for p in products if not pattern.search((p["ingredients"] or "").lower())]

    def sort_key(p):
        value = p.get(sort_by)
        return value if value is not None else float("inf")

    return [_with_legacy_fields(p) for p in sorted(products, key=sort_key)]


@app.get("/health")
def health():
    with Session(engine) as session:
        total = session.query(Product).count()
        db_counts = {
            sm: session.query(Product).filter_by(supermarket=sm).count()
            for sm in sorted(JSON_SUPERMARKETS)
        }
    return {
        "status": "ok",
        "total_products": total,
        "by_supermarket": db_counts,
        "json_products": {sm: len(_load_json_products(sm)) for sm in sorted(JSON_SUPERMARKETS)},
    }


# ── Sync endpoints ─────────────────────────────────────────────────────────

@app.post("/sync/mercadona/{category_id}")
def sync_mercadona(category_id: int):
    count = sync.sync_mercadona_category(category_id)
    return {"supermarket": "Mercadona", "category_id": category_id, "synced": count}


@app.post("/sync/dia")
def sync_dia(q: str = Query(...)):
    count = sync.sync_dia_search(q)
    return {"supermarket": "Dia", "query": q, "synced": count}


@app.post("/sync/carrefour")
def sync_carrefour(background_tasks: BackgroundTasks):
    background_tasks.add_task(sync.sync_carrefour)
    return {"status": "iniciado", "supermarket": "Carrefour"}


@app.post("/sync/lidl")
def sync_lidl(background_tasks: BackgroundTasks):
    background_tasks.add_task(sync.sync_lidl)
    return {"status": "iniciado", "supermarket": "Lidl"}


@app.post("/sync/all")
def sync_all(background_tasks: BackgroundTasks):
    """Sync completo de todos los supermercados (tarda varios minutos)."""
    from .normalize import MERCADONA_CATEGORIES

    def _run_all():
        for cat_id in MERCADONA_CATEGORIES:
            try:
                sync.sync_mercadona_category(cat_id)
            except Exception as e:
                print(f"Mercadona {cat_id}: {e}")
        for q in sync.FOOD_QUERIES:
            try:
                sync.sync_dia_search(q)
            except Exception as e:
                print(f"Dia '{q}': {e}")
        try:
            sync.sync_carrefour()
        except Exception as e:
            print(f"Carrefour: {e}")
        try:
            sync.sync_lidl()
        except Exception as e:
            print(f"Lidl: {e}")
        print("Sync completo finalizado.")

    background_tasks.add_task(_run_all)
    return {"status": "iniciado", "message": "Sincronizando todos los supermercados en segundo plano"}
