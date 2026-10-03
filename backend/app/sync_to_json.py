"""
Script para GitHub Actions.
Ejecuta las fuentes (Carrefour, Lidl, Mercadona, Dia, Alimerka y Froiz) y guarda los
resultados como JSON en backend/data/, que luego se commitea al repositorio.
El servidor FastAPI sirve esos JSON directamente.

Si alguna fuente devuelve 0 productos:
  - no se sobreescribe su JSON, para conservar los ultimos datos buenos;
  - el script termina con codigo 1, para que Actions lo marque en rojo en vez
    de commitear un fichero vacio en silencio.
"""
import asyncio
import json
import sys
from pathlib import Path

DATA_DIR = Path(__file__).parent.parent / "data"
DATA_DIR.mkdir(exist_ok=True)

FOOD_QUERIES = [
    "yogur", "kefir", "leche", "queso", "huevos",
    "cereales", "avena", "legumbres", "atun", "frutos secos",
    "pasta", "arroz", "conservas", "embutido", "mantequilla",
    "proteinas", "pollo", "salmon", "brocoli", "espinacas",
    # Fruta y verdura: sin estas busquedas no salian ni la lechuga.
    "fruta", "verdura", "lechuga", "ensalada", "tomate", "manzana",
    "platano", "naranja", "patata", "cebolla", "zanahoria", "pimiento",
]


def _write(name: str, products: list[dict]) -> int:
    path = DATA_DIR / f"{name}.json"
    if not products:
        print(f"[{name}] 0 productos: se conserva el JSON anterior, no se sobreescribe")
        return 0
    # Tipos fijados aqui: la app espera numero o null, nunca texto.
    from .normalize import coerce_types

    products = [coerce_types(p) for p in products]
    path.write_text(json.dumps(products, ensure_ascii=False, indent=2), encoding="utf-8")
    print(f"[{name}] {len(products)} productos -> {path}")
    return len(products)


def _write_index(counts: dict[str, int]) -> None:
    """Manifiesto que la app lee primero: fecha del sync y que hay disponible."""
    from datetime import datetime, timezone

    index = {
        "updated_at": datetime.now(timezone.utc).isoformat(timespec="seconds"),
        "supermarkets": {},
        "total": 0,
    }
    for name in ("alimerka", "carrefour", "dia", "froiz", "lidl", "mercadona"):
        path = DATA_DIR / f"{name}.json"
        if not path.exists():
            continue
        try:
            productos = json.loads(path.read_text(encoding="utf-8"))
        except Exception:
            continue
        index["supermarkets"][name] = {
            "file": f"{name}.json",
            "count": len(productos),
            # Si la fuente fallo, sus datos son los del sync anterior.
            "fresh": counts.get(name.capitalize(), 0) > 0,
        }
        index["total"] += len(productos)

    (DATA_DIR / "index.json").write_text(
        json.dumps(index, ensure_ascii=False, indent=2), encoding="utf-8"
    )
    print(f"[index] {index['total']} productos en total -> {DATA_DIR / 'index.json'}")


def _dedupe(products: list[dict]) -> dict[str, dict]:
    return {p["id"]: p for p in products}


async def sync_carrefour() -> int:
    from .carrefour_scraper import scrape_carrefour
    return _write("carrefour", await scrape_carrefour(FOOD_QUERIES))


async def sync_lidl() -> int:
    from .lidl_scraper import scrape_lidl
    return _write("lidl", await scrape_lidl(FOOD_QUERIES))


# Fichas nuevas de Mercadona por sync: cada una cuesta ~1 s (ficha + Open Food
# Facts). Con el catalogo entero (~3.500) se pasaria del tiempo del workflow,
# asi que se completan poco a poco: lo ya conocido se reaprovecha.
MAX_FICHAS_MERCADONA = 400

# Lo que solo trae la ficha y no cambia de un dia para otro.
_CAMPOS_FICHA = (
    "brand", "photo_url", "ean", "ingredients", "allergens", "contains_nata",
    "energy_kcal_100g", "fat_100g", "saturated_fat_100g", "carbohydrates_100g",
    "sugars_100g", "proteins_100g", "salt_100g",
)


def _anteriores(name: str) -> dict[str, dict]:
    path = DATA_DIR / f"{name}.json"
    try:
        return {p["id"]: p for p in json.loads(path.read_text(encoding="utf-8"))}
    except Exception:
        return {}


def sync_mercadona() -> int:
    from . import mercadona_client, normalize

    anteriores = _anteriores("mercadona")
    products: dict[str, dict] = {}
    fichas = 0
    for category_id in normalize.get_mercadona_subcategorias():
        try:
            listado = mercadona_client.get_category_products(category_id)
        except Exception as e:
            print(f"[mercadona] categoria {category_id}: {e}")
            continue
        before = len(products)
        for summary in listado:
            p = normalize.mercadona_desde_listado(summary)
            if p["id"] in products:
                continue
            previo = anteriores.get(p["id"])
            # Los JSON de antes de este cambio no llevan "con_ficha" pero todos
            # se hicieron con ficha.
            if previo and previo.get("con_ficha", True):
                # Precio de hoy, ficha de antes.
                p.update({k: previo.get(k) for k in _CAMPOS_FICHA})
                p["con_ficha"] = True
            elif fichas < MAX_FICHAS_MERCADONA:
                try:
                    p = normalize.build_mercadona_product(summary)
                    fichas += 1
                except Exception as e:
                    print(f"[mercadona] ficha {p['id']}: {e}")
            products[p["id"]] = p
        print(f"[mercadona] categoria {category_id}: +{len(products) - before} nuevos (total {len(products)})")
    sin = sum(1 for p in products.values() if not p.get("con_ficha"))
    print(f"[mercadona] {fichas} fichas nuevas; {sin} productos aun sin ficha (se completan en los proximos syncs)")
    return _write("mercadona", list(products.values()))


async def sync_dia() -> int:
    from .dia_scraper import scrape_dia
    return _write("dia", await scrape_dia(FOOD_QUERIES))


async def sync_alimerka() -> int:
    from .alimerka_scraper import scrape_alimerka
    return _write("alimerka", await scrape_alimerka())


async def sync_froiz() -> int:
    from .froiz_scraper import scrape_froiz
    return _write("froiz", await scrape_froiz())


async def main() -> int:
    print("=== EasyCompra Sync ===")
    counts = {
        "Carrefour": await sync_carrefour(),
        "Lidl": await sync_lidl(),
        # Mercadona es una API JSON sincrona: va en un hilo aparte.
        "Mercadona": await asyncio.to_thread(sync_mercadona),
        # Dia, como Carrefour, necesita navegador por Akamai.
        "Dia": await sync_dia(),
        # Alimerka: su tienda online, sin navegador (catalogo por secciones).
        "Alimerka": await sync_alimerka(),
        # Froiz: la API publica de su tienda online, sin navegador.
        "Froiz": await sync_froiz(),
    }
    print("=== Completado: " + " + ".join(f"{n} {name}" for name, n in counts.items()) + " ===")

    # El indice se escribe siempre, tambien si alguna fuente ha fallado: refleja
    # lo que hay publicado ahora mismo y marca que fuentes son de este sync.
    _write_index(counts)

    vacias = [name for name, n in counts.items() if n == 0]
    if vacias:
        print(
            f"ERROR: sin productos en {', '.join(vacias)}. "
            "Se conservan los datos anteriores y se marca la ejecucion como fallida.",
            file=sys.stderr,
        )
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(asyncio.run(main()))
