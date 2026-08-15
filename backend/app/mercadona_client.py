import httpx

BASE_URL = "https://tienda.mercadona.es/api"
HEADERS = {"User-Agent": "EasyCompra-MVP/1.0"}

# Un sync completo hace ~700 peticiones de detalle: reutilizar la conexion
# evita rehacer el handshake TLS en cada una.
_client = httpx.Client(base_url=BASE_URL, headers=HEADERS, timeout=10)


def get_category_products(category_id: int) -> list[dict]:
    resp = _client.get(f"/categories/{category_id}/")
    resp.raise_for_status()
    data = resp.json()
    products = []
    for subcategory in data.get("categories", []):
        products.extend(subcategory.get("products", []))
    return products


def get_product_detail(product_id: str) -> dict:
    resp = _client.get(f"/products/{product_id}/")
    resp.raise_for_status()
    return resp.json()
