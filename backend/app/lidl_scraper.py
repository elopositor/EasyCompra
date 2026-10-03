"""
Lidl Spain, a traves de la API de busqueda que usa su propia web.

Antes se leia el HTML de la pagina de resultados con Playwright, que solo
trae los 8 primeros productos de cada busqueda. La API devuelve JSON y no
necesita navegador.

Lidl publica online muy poca alimentacion (unos 220 productos entre casi
6.000 articulos de bazar y ropa), y buscar por palabras se dejaba la mitad.
Asi que se recorre el catalogo entero (q=*) y se queda solo la comida.

Productos en: response['items'][i]['gridbox']['data']
"""
import asyncio
import re

import httpx

SEARCH_API = "https://www.lidl.es/q/api/search"
# Con paginas mas grandes (dice admitir 1000) la API corta antes de tiempo y
# devuelve los articulos sin categoria: 100 es lo que funciona. Entrega unos
# 60 por pagina, asi que el catalogo entero son ~100 peticiones (2 minutos).
PAGINA = 100
# Tope de seguridad por si un dia la paginacion no termina.
MAX_PAGINAS = 200

HEADERS = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
                  "(KHTML, like Gecko) Chrome/129.0 Safari/537.36",
    # Con "application/json" a secas la API responde 406.
    "Accept": "*/*",
    "Accept-Language": "es-ES,es;q=0.9",
}

# Solo alimentacion: "Food" y fruta y verdura ("F+V").
CATEGORIAS_COMIDA = {"Food", "F+V"}

_NATA_RE = re.compile(r"\bnata\b", re.IGNORECASE)
# "4x150 g", "1 kg", "1,5 l", "500 ml", "6 x 1 l"
_ENVASE_RE = re.compile(
    r"(?:(\d+)\s*x\s*)?(\d+(?:[.,]\d+)?)\s*(kg|g|l|ml|cl)\b", re.IGNORECASE
)


def _precio(data: dict) -> float | None:
    precio = (data.get("price") or {}).get("price")
    if precio is None:
        # Algunos productos solo tienen precio con Lidl Plus.
        for oferta in data.get("lidlPlus") or []:
            precio = (oferta.get("price") or {}).get("price")
            if precio is not None:
                break
    try:
        return float(precio) if precio is not None else None
    except (TypeError, ValueError):
        return None


def _envase(data: dict) -> str | None:
    texto = ((data.get("price") or {}).get("packaging") or {}).get("text")
    if not texto:
        for oferta in data.get("lidlPlus") or []:
            texto = ((oferta.get("price") or {}).get("packaging") or {}).get("text")
            if texto:
                break
    return texto


def _precio_por_kilo(precio: float | None, envase: str | None) -> tuple[float | None, str | None]:
    """'4x150 g' a 1,49 € -> (2.48, 'kg'). Sin envase reconocible, (None, None)."""
    if precio is None or not envase:
        return None, None
    m = _ENVASE_RE.search(envase)
    if not m:
        return None, None
    unidades = int(m.group(1)) if m.group(1) else 1
    cantidad = float(m.group(2).replace(",", ".")) * unidades
    unidad = m.group(3).lower()
    base, nombre = {"kg": (1, "kg"), "g": (1000, "kg"), "l": (1, "l"), "ml": (1000, "l"), "cl": (100, "l")}[unidad]
    total = cantidad / base
    if total <= 0:
        return None, None
    return round(precio / total, 2), nombre


def _producto(item: dict) -> dict | None:
    data = (item.get("gridbox") or {}).get("data") or {}
    if data.get("category") not in CATEGORIAS_COMIDA:
        return None
    nombre = data.get("title") or data.get("fullTitle")
    if not nombre:
        return None
    pid = str(data.get("productId") or data.get("itemId") or item.get("code") or nombre)
    precio = _precio(data)
    envase = _envase(data)
    por_kilo, unidad = _precio_por_kilo(precio, envase)
    descripcion = re.sub(r"<[^>]+>", " ", (data.get("keyfacts") or {}).get("description") or "")
    marca = (data.get("brand") or {}).get("name")

    return {
        "supermarket": "Lidl",
        "external_id": pid,
        "id": f"lidl_{pid}",
        # El envase ayuda a distinguir variantes: "Yogur bífidus (4x150 g)".
        "name": f"{nombre} ({envase})" if envase and envase.lower() != "a granel" else nombre,
        "brand": marca.title() if marca else "Lidl",
        "photo_url": data.get("image"),
        "unit_price": precio,
        "reference_price": por_kilo,
        "reference_format": unidad,
        "ean": None,
        "ingredients": None,
        "allergens": None,
        "contains_nata": bool(_NATA_RE.search(f"{nombre} {descripcion}")),
        "energy_kcal_100g": None,
        "fat_100g": None,
        "saturated_fat_100g": None,
        "carbohydrates_100g": None,
        "sugars_100g": None,
        "proteins_100g": None,
        "salt_100g": None,
        "share_url": f"https://www.lidl.es{data['canonicalUrl']}" if data.get("canonicalUrl") else None,
    }


def _scrape() -> list[dict]:
    todos: dict[str, dict] = {}
    leidos = 0
    with httpx.Client(headers=HEADERS, timeout=30, follow_redirects=True) as client:
        for pagina in range(MAX_PAGINAS):
            resp = client.get(SEARCH_API, params={
                "q": "*",
                "offset": leidos,
                "fetchsize": PAGINA,
                "locale": "es_ES",
                "assortment": "ES",
                "version": "2.1.0",
            })
            resp.raise_for_status()
            datos = resp.json()
            items = datos.get("items") or []
            if not items:
                break
            leidos += len(items)
            for p in filter(None, map(_producto, items)):
                todos.setdefault(p["id"], p)
            if leidos >= (datos.get("numFound") or 0):
                break
    print(f"[Lidl] {leidos} articulos en el catalogo, {len(todos)} de alimentacion")
    return list(todos.values())


async def scrape_lidl(queries: list[str] | None = None) -> list[dict]:
    # Misma firma que antes (async, con busquedas) para no tocar quien la
    # llama; las busquedas ya no hacen falta porque se lee el catalogo entero.
    return await asyncio.to_thread(_scrape)
