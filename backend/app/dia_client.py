import httpx

BASE_URL = "https://www.dia.es/api/v1"
HEADERS = {"User-Agent": "EasyCompra-MVP/1.0"}


def search_products(query: str) -> list[dict]:
    resp = httpx.get(f"{BASE_URL}/search-back/search", params={"q": query}, headers=HEADERS, timeout=10)
    resp.raise_for_status()
    return resp.json().get("search_items", [])


def get_product_detail(product_id: str) -> dict:
    resp = httpx.get(f"{BASE_URL}/pdp-back/{product_id}", headers=HEADERS, timeout=10)
    resp.raise_for_status()
    return resp.json()["product"]
