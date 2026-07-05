import asyncio
from sqlalchemy.orm import Session

from . import normalize
from .carrefour_scraper import scrape_carrefour
from .lidl_scraper import scrape_lidl
from .db import engine, init_db, upsert_product

FOOD_QUERIES = [
    "yogur", "kefir", "leche", "queso", "huevos",
    "cereales", "avena", "legumbres", "atun", "frutos secos",
    "pasta", "arroz", "conservas", "embutido", "mantequilla",
    "proteinas", "pollo", "salmon", "brocoli", "espinacas",
]


def sync_mercadona_category(category_id: int) -> int:
    products = normalize.get_mercadona_category(category_id)
    with Session(engine) as session:
        for product in products:
            upsert_product(session, product)
        session.commit()
    return len(products)


def sync_dia_search(query: str) -> int:
    products = normalize.get_dia_search(query)
    with Session(engine) as session:
        for product in products:
            upsert_product(session, product)
        session.commit()
    return len(products)


def sync_carrefour(queries: list[str] = FOOD_QUERIES) -> int:
    products = asyncio.run(scrape_carrefour(queries))
    with Session(engine) as session:
        for p in products:
            upsert_product(session, {
                "supermarket": p["supermarket"],
                "external_id": p["external_id"],
                "name": p["name"],
                "brand": p.get("brand"),
                "photo_url": p.get("photo_url"),
                "unit_price": p.get("unit_price"),
                "reference_price": p.get("reference_price"),
                "reference_format": p.get("reference_format"),
                "ean": p.get("ean"),
                "ingredients": p.get("ingredients"),
                "allergens": p.get("allergens"),
                "contains_nata": p.get("contains_nata", False),
                "nutriscore_grade": p.get("nutriscore_grade"),
                "energy_kcal_100g": p.get("energy_kcal_100g"),
                "fat_100g": p.get("fat_100g"),
                "saturated_fat_100g": p.get("saturated_fat_100g"),
                "carbohydrates_100g": p.get("carbohydrates_100g"),
                "sugars_100g": p.get("sugars_100g"),
                "proteins_100g": p.get("proteins_100g"),
                "salt_100g": p.get("salt_100g"),
                "share_url": p.get("share_url"),
            })
        session.commit()
    return len(products)


def sync_lidl(queries: list[str] = FOOD_QUERIES) -> int:
    products = asyncio.run(scrape_lidl(queries))
    with Session(engine) as session:
        for p in products:
            upsert_product(session, {
                "supermarket": p["supermarket"],
                "external_id": p["external_id"],
                "name": p["name"],
                "brand": p.get("brand"),
                "photo_url": p.get("photo_url"),
                "unit_price": p.get("unit_price"),
                "reference_price": p.get("reference_price"),
                "reference_format": p.get("reference_format"),
                "ean": p.get("ean"),
                "ingredients": p.get("ingredients"),
                "allergens": p.get("allergens"),
                "contains_nata": p.get("contains_nata", False),
                "nutriscore_grade": p.get("nutriscore_grade"),
                "energy_kcal_100g": p.get("energy_kcal_100g"),
                "fat_100g": p.get("fat_100g"),
                "saturated_fat_100g": p.get("saturated_fat_100g"),
                "carbohydrates_100g": p.get("carbohydrates_100g"),
                "sugars_100g": p.get("sugars_100g"),
                "proteins_100g": p.get("proteins_100g"),
                "salt_100g": p.get("salt_100g"),
                "share_url": p.get("share_url"),
            })
        session.commit()
    return len(products)


if __name__ == "__main__":
    from .normalize import MERCADONA_CATEGORIES
    init_db()
    for cat_id in MERCADONA_CATEGORIES:
        n = sync_mercadona_category(cat_id)
        print(f"Mercadona cat {cat_id}: {n}")
    for q in ["kefir", "yogur", "leche", "queso"]:
        n = sync_dia_search(q)
        print(f"Dia '{q}': {n}")
    print("Carrefour:", sync_carrefour())
    print("Lidl:", sync_lidl())
