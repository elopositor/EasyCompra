"""
Script para GitHub Actions.
Ejecuta los scrapers de Carrefour y Lidl y guarda los resultados
como JSON en backend/data/, que luego se commitea al repositorio.
El servidor FastAPI sirve esos JSON directamente.
"""
import asyncio
import json
import os
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


async def sync_carrefour():
    from .carrefour_scraper import scrape_carrefour
    products = await scrape_carrefour(FOOD_QUERIES)
    path = DATA_DIR / "carrefour.json"
    path.write_text(json.dumps(products, ensure_ascii=False, indent=2), encoding="utf-8")
    print(f"[Carrefour] {len(products)} productos -> {path}")
    return len(products)


async def sync_lidl():
    from .lidl_scraper import scrape_lidl
    products = await scrape_lidl(FOOD_QUERIES)
    path = DATA_DIR / "lidl.json"
    path.write_text(json.dumps(products, ensure_ascii=False, indent=2), encoding="utf-8")
    print(f"[Lidl] {len(products)} productos -> {path}")
    return len(products)


async def main():
    print("=== EasyCompra Sync ===")
    n_carrefour = await sync_carrefour()
    n_lidl = await sync_lidl()
    print(f"=== Completado: {n_carrefour} Carrefour + {n_lidl} Lidl ===")


if __name__ == "__main__":
    asyncio.run(main())
