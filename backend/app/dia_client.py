import httpx

BASE_URL = "https://www.dia.es/api/v1"
HEADERS = {"User-Agent": "EasyCompra-MVP/1.0"}

# Un sync completo hace ~600 peticiones de detalle: reutilizamos la conexion.
_client = httpx.Client(base_url=BASE_URL, headers=HEADERS, timeout=10)


def search_products(query: str) -> list[dict]:
    resp = _client.get("/search-back/search", params={"q": query})
    resp.raise_for_status()
    return resp.json().get("search_items", [])


def get_product_detail(product_id: str) -> dict:
    resp = _client.get(f"/pdp-back/{product_id}")
    resp.raise_for_status()
    return resp.json()["product"]
