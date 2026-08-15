"""
Carrefour Spain scraper usando camoufox (Firefox stealth).

La search API de Carrefour devuelve JSON, pero esta detras de Akamai: una
peticion HTTP directa recibe 403. Por eso abrimos la homepage con camoufox
para que Akamai valide la sesion, y despues llamamos a la API desde el
contexto de la pagina, que ya lleva las cookies buenas.

Parametros obligatorios: internal=true, session=empathy, instance=x-carrefour
y env. Si falta cualquiera de ellos la API responde 403 con una pagina HTML.
Productos en: response['content']['docs']
"""
import asyncio
import json
import re
from urllib.parse import urlencode

from camoufox.async_api import AsyncCamoufox

_NATA_RE = re.compile(r"\bnata\b", re.IGNORECASE)

SEARCH_API = "https://www.carrefour.es/search-api/query/v1/search"

# rows admite hasta 48. Con valores mas altos (100) la API devuelve un unico
# producto en lugar de fallar, asi que no conviene subirlo.
ROWS_PER_QUERY = 48

# Llamamos a la API desde la pagina para heredar las cookies de Akamai.
_FETCH_JS = """
async (url) => {
    const resp = await fetch(url, { headers: { Accept: "application/json" } });
    return { status: resp.status, body: await resp.text() };
}
"""


def _search_url(query: str, start: int = 0, rows: int = ROWS_PER_QUERY) -> str:
    params = {
        "internal": "true",
        "query": query,
        "instance": "x-carrefour",
        "env": "https://www.carrefour.es",
        "scope": "mobile",
        "lang": "es",
        "session": "empathy",
        "start": start,
        "rows": rows,
    }
    return f"{SEARCH_API}?{urlencode(params)}"


def _extract_docs(api_data: dict) -> list[dict]:
    docs = api_data.get("content", {}).get("docs", [])
    products = []
    for item in docs:
        name = item.get("display_name") or item.get("name")
        if not name:
            continue
        ean = str(item.get("ean13") or item.get("ean") or "")
        # La search API no expone ingredientes; queda vacio salvo que vuelva.
        ingredients = re.sub(r"<[^>]+>", "", item.get("ingredients") or "")
        price = item.get("active_price") or item.get("app_price")
        if isinstance(price, str):
            try:
                price = float(re.sub(r"[^\d,.]", "", price).replace(",", "."))
            except Exception:
                price = None
        external_id = str(item.get("product_id") or item.get("catalog_ref_id") or name)
        products.append({
            "supermarket": "Carrefour",
            "external_id": external_id,
            "id": f"carrefour_{external_id}",
            "name": name,
            "brand": item.get("brand"),
            "photo_url": item.get("image_path"),
            "unit_price": float(price) if price is not None else None,
            "reference_price": None,
            "reference_format": item.get("measure_unit"),
            "ean": ean if ean else None,
            "ingredients": ingredients or None,
            "allergens": None,
            "contains_nata": bool(_NATA_RE.search(ingredients)),
            "energy_kcal_100g": None,
            "fat_100g": None,
            "saturated_fat_100g": None,
            "carbohydrates_100g": None,
            "sugars_100g": None,
            "proteins_100g": None,
            "salt_100g": None,
            "share_url": f"https://www.carrefour.es{item['url']}" if item.get("url") else None,
        })
    return products


async def scrape_carrefour(queries: list[str]) -> list[dict]:
    all_products: dict[str, dict] = {}
    fallos: list[str] = []

    async with AsyncCamoufox(headless=True, geoip=True) as browser:
        page = await browser.new_page()

        # Homepage: Akamai valida la sesion y deja las cookies en el contexto.
        await page.goto("https://www.carrefour.es/", wait_until="networkidle", timeout=45_000)
        await asyncio.sleep(2)
        try:
            await page.click("#onetrust-accept-btn-handler", timeout=3_000)
        except Exception:
            pass
        await asyncio.sleep(1)
        await page.mouse.move(500, 300)
        await asyncio.sleep(1)

        for query in queries:
            try:
                resp = await page.evaluate(_FETCH_JS, _search_url(query))
            except Exception as e:
                fallos.append(f"{query}: {e}")
                print(f"[Carrefour] '{query}': error llamando a la API ({e})")
                continue

            if resp["status"] != 200:
                fallos.append(f"{query}: HTTP {resp['status']}")
                print(f"[Carrefour] '{query}': HTTP {resp['status']} (sesion Akamai rechazada)")
                continue

            try:
                data = json.loads(resp["body"])
            except json.JSONDecodeError:
                fallos.append(f"{query}: respuesta no JSON")
                print(f"[Carrefour] '{query}': la respuesta no es JSON (pagina de bloqueo)")
                continue

            before = len(all_products)
            for p in _extract_docs(data):
                all_products.setdefault(p["id"], p)
            print(f"[Carrefour] '{query}': +{len(all_products) - before} nuevos (total {len(all_products)})")
            await asyncio.sleep(0.5)

    if fallos:
        print(f"[Carrefour] {len(fallos)}/{len(queries)} queries fallaron: {'; '.join(fallos[:5])}")

    return list(all_products.values())
