"""
Script para GitHub Actions.
Ejecuta las cuatro fuentes (Carrefour, Lidl, Mercadona y Dia) y guarda los
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
]


def _write(name: str, products: list[dict]) -> int:
    path = DATA_DIR / f"{name}.json"
    if not products:
        print(f"[{name}] 0 productos: se conserva el JSON anterior, no se sobreescribe")
        return 0
    path.write_text(json.dumps(products, ensure_ascii=False, indent=2), encoding="utf-8")
    print(f"[{name}] {len(products)} productos -> {path}")
    return len(products)


def _dedupe(products: list[dict]) -> dict[str, dict]:
    return {p["id"]: p for p in products}


async def sync_carrefour() -> int:
    from .carrefour_scraper import scrape_carrefour
    return _write("carrefour", await scrape_carrefour(FOOD_QUERIES))


async def sync_lidl() -> int:
    from .lidl_scraper import scrape_lidl
    return _write("lidl", await scrape_lidl(FOOD_QUERIES))


def sync_mercadona() -> int:
    from . import normalize
    products: dict[str, dict] = {}
    for category_id in normalize.MERCADONA_CATEGORIES:
        try:
            nuevos = _dedupe(normalize.get_mercadona_category(category_id))
        except Exception as e:
            print(f"[mercadona] categoria {category_id}: {e}")
            continue
        before = len(products)
        products.update({k: v for k, v in nuevos.items() if k not in products})
        print(f"[mercadona] categoria {category_id}: +{len(products) - before} nuevos (total {len(products)})")
    return _write("mercadona", list(products.values()))


def sync_dia() -> int:
    from . import normalize
    products: dict[str, dict] = {}
    for query in FOOD_QUERIES:
        try:
            nuevos = _dedupe(normalize.get_dia_search(query))
        except Exception as e:
            print(f"[dia] '{query}': {e}")
            continue
        before = len(products)
        products.update({k: v for k, v in nuevos.items() if k not in products})
        print(f"[dia] '{query}': +{len(products) - before} nuevos (total {len(products)})")
    return _write("dia", list(products.values()))


async def main() -> int:
    print("=== EasyCompra Sync ===")
    counts = {
        "Carrefour": await sync_carrefour(),
        "Lidl": await sync_lidl(),
        # Mercadona y Dia son APIs JSON sincronas: van en un hilo aparte.
        "Mercadona": await asyncio.to_thread(sync_mercadona),
        "Dia": await asyncio.to_thread(sync_dia),
    }
    print("=== Completado: " + " + ".join(f"{n} {name}" for name, n in counts.items()) + " ===")

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
