"""
Froiz, desde la API de su tienda online (supermercado.froiz.com).

La web corporativa (froiz.es) solo ensena folletos, pero sus ofertas enlazan a
la tienda, que lee el catalogo de servicios.froiz.com/api/products: JSON
publico, paginado y sin necesidad de entrar. Unos 6.800 articulos en ~34
peticiones; se queda la comida y la bebida sin alcohol.

Las fotos de la API vienen firmadas y caducan en unas horas; la variante
"desktop" de Cloudflare Images funciona sin firma, asi que se usa esa.
"""
import asyncio
import re

import httpx

API = "https://servicios.froiz.com/api/products"
TIENDA = "https://supermercado.froiz.com/product"
IMAGENES = "https://imagedelivery.net/laxGYDNZyT04iZVpzPzryw"
PAGINA = 200
MAX_PAGINAS = 100  # tope de seguridad

HEADERS = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
                  "(KHTML, like Gecko) Chrome/129.0 Safari/537.36",
    "Accept": "application/json",
}

# Categorias que no son comida: drogueria y perfumeria (7) e infantil (35).
SIN_COMIDA = {7, 35}
# De "Bodega y bebidas" (6) solo aguas, refrescos y zumos: nada de alcohol.
BEBIDAS = 6
SECCION_SIN_ALCOHOL = "aguas-refrescos-y-zumos"

UNIDADES = {"Kilogramo": "kg", "Litro": "l", "Unidad": "ud", "Docena": "docena"}

_NATA_RE = re.compile(r"\bnata\b", re.IGNORECASE)


def _numero(valor) -> float | None:
    try:
        return float(valor) if valor not in (None, "") else None
    except (TypeError, ValueError):
        return None


def _producto(p: dict) -> dict | None:
    if p.get("category_id") in SIN_COMIDA or not p.get("enabled", True):
        return None
    if p.get("category_id") == BEBIDAS and p.get("section_slug") != SECCION_SIN_ALCOHOL:
        return None
    nombre = p.get("name")
    if not nombre:
        return None

    # order_price es lo que se paga hoy (con la oferta, si la hay).
    precio = _numero(p.get("order_price")) or _numero(p.get("base_price"))
    unidad = UNIDADES.get(p.get("measurement_unit"))
    cantidad = _numero(p.get("measurement_unit_ratio"))
    # 2,99 € por 0,225 kg -> 13,29 €/kg. Lo que se vende a granel tiene 1.
    referencia = round(precio / cantidad, 2) if precio and unidad and cantidad else None

    pid = str(p["id"])
    return {
        "supermarket": "Froiz",
        "external_id": pid,
        "id": f"froiz_{pid}",
        "name": nombre,
        "brand": p.get("brand_name"),
        "photo_url": f"{IMAGENES}/{p['image_id']}/desktop" if p.get("image_id") else None,
        "unit_price": precio,
        "reference_price": referencia,
        "reference_format": unidad,
        "ean": None,
        "ingredients": None,
        "allergens": None,
        "contains_nata": bool(_NATA_RE.search(nombre)),
        "energy_kcal_100g": None,
        "fat_100g": None,
        "saturated_fat_100g": None,
        "carbohydrates_100g": None,
        "sugars_100g": None,
        "proteins_100g": None,
        "salt_100g": None,
        "share_url": f"{TIENDA}/{p['slug']}" if p.get("slug") else None,
    }


def _scrape() -> list[dict]:
    todos: dict[str, dict] = {}
    leidos = 0
    with httpx.Client(headers=HEADERS, timeout=60, follow_redirects=True) as client:
        for pagina in range(1, MAX_PAGINAS + 1):
            resp = client.get(API, params={"page": pagina, "size": PAGINA})
            resp.raise_for_status()
            datos = resp.json()
            productos = datos.get("products") or []
            leidos += len(productos)
            for p in filter(None, map(_producto, productos)):
                todos.setdefault(p["id"], p)
            if pagina >= (datos.get("stats") or {}).get("totalPages", 0) or not productos:
                break
    print(f"[Froiz] {leidos} articulos en el catalogo, {len(todos)} de comida y bebida sin alcohol")
    return list(todos.values())


async def scrape_froiz() -> list[dict]:
    return await asyncio.to_thread(_scrape)
