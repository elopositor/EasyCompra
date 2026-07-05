"""
Carrefour Spain scraper usando camoufox (Firefox stealth).
Estrategia:
  1. Carga la homepage para que Akamai valide la sesion.
  2. Navega directamente a /?query=X para cada busqueda (URL SPA de Carrefour).
  3. Intercepta la respuesta de search-api/query/v1/search.
Productos en: response['content']['docs']
"""
import asyncio
import re
from camoufox.async_api import AsyncCamoufox

_NATA_RE = re.compile(r"\bnata\b", re.IGNORECASE)
_SEARCH_API = "search-api/query/v1/search"


def _extract_docs(api_data: dict) -> list[dict]:
    docs = api_data.get("content", {}).get("docs", [])
    products = []
    for item in docs:
        name = item.get("display_name") or item.get("name")
        if not name:
            continue
        ean = str(item.get("ean13") or item.get("ean") or "")
        ingredients = re.sub(r"<[^>]+>", "", item.get("ingredients") or "")
        price = item.get("active_price") or item.get("app_price")
        if isinstance(price, str):
            try:
                price = float(re.sub(r"[^\d,.]", "", price).replace(",", "."))
            except Exception:
                price = None
        products.append({
            "supermarket": "Carrefour",
            "external_id": str(item.get("product_id") or item.get("catalog_ref_id") or name),
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
            "nutriscore_grade": None,
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

    async with AsyncCamoufox(headless=True, geoip=True) as browser:
        page = await browser.new_page()

        # 1. Homepage: Akamai valida la sesion
        await page.goto("https://www.carrefour.es/", wait_until="networkidle", timeout=45_000)
        await asyncio.sleep(2)
        try:
            await page.click("#onetrust-accept-btn-handler", timeout=3_000)
        except Exception:
            pass
        await asyncio.sleep(1)
        await page.mouse.move(500, 300)
        await asyncio.sleep(1)

        # 2. Una busqueda por query navegando directamente a la URL del SPA
        for query in queries:
            captured: list[dict] = []

            async def on_resp(r, cap=captured):
                if _SEARCH_API in r.url and r.status == 200:
                    try:
                        data = await r.json()
                        if data.get("content", {}).get("docs"):
                            cap.append(data)
                    except Exception:
                        pass

            page.on("response", on_resp)
            try:
                await page.goto(
                    f"https://www.carrefour.es/?query={query}",
                    wait_until="networkidle",
                    timeout=25_000,
                )
                await asyncio.sleep(1.5)
            except Exception:
                pass
            page.remove_listener("response", on_resp)

            before = len(all_products)
            for data in captured:
                for p in _extract_docs(data):
                    key = f"carrefour_{p['external_id']}"
                    if key not in all_products:
                        all_products[key] = p
            print(f"[Carrefour] '{query}': +{len(all_products) - before} nuevos (total {len(all_products)})")

    return list(all_products.values())
