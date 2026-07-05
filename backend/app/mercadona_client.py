import httpx

BASE_URL = "https://tienda.mercadona.es/api"
HEADERS = {"User-Agent": "EasyCompra-MVP/1.0"}


def get_category_products(category_id: int) -> list[dict]:
    resp = httpx.get(f"{BASE_URL}/categories/{category_id}/", headers=HEADERS, timeout=10)
    resp.raise_for_status()
    data = resp.json()
    products = []
    for subcategory in data.get("categories", []):
        products.extend(subcategory.get("products", []))
    return products


def get_product_detail(product_id: str) -> dict:
    resp = httpx.get(f"{BASE_URL}/products/{product_id}/", headers=HEADERS, timeout=10)
    resp.raise_for_status()
    return resp.json()
