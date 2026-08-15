"""
Lidl Spain scraper usando Playwright.
Los datos del producto están en el atributo HTML data-gridbox-impression como JSON,
en la página de resultados de búsqueda (server-side rendered).
"""
import asyncio
import json
import re
from urllib.parse import unquote
from playwright.async_api import async_playwright

SEARCH_URL = "https://www.lidl.es/q/search?q={query}"

_NATA_RE = re.compile(r"\bnata\b", re.IGNORECASE)
_IMG_RE  = re.compile(r'data-gridbox-impression="%[^"]*?".*?<img[^>]+src="(https://[^"]+)"', re.DOTALL)


def _parse_html(html: str) -> list[dict]:
    products = []
    # El atributo contiene JSON URL-encoded: {"brand":"MILBONA","name":"Yogur","price":1.95,"id":"11008342",...}
    impressions = re.findall(r'data-gridbox-impression="([^"]+)"', html)
    # Imágenes de producto emparejadas por orden de aparición
    images = re.findall(
        r'class="[^"]*product-grid-box[^"]*".*?<img[^>]+src="(https://(?:www\.lidl\.es|cdn)[^"]+)"',
        html, re.DOTALL
    )
    for i, raw in enumerate(impressions):
        try:
            data = json.loads(unquote(raw))
        except Exception:
            continue
        name = data.get("name")
        if not name:
            continue
        pid = str(data.get("id", name))
        price = data.get("price")
        if isinstance(price, str):
            try:
                price = float(price.replace(",", "."))
            except Exception:
                price = None
        products.append({
            "supermarket": "Lidl",
            "external_id": pid,
            "name": name,
            "brand": data.get("brand") or "Lidl",
            "photo_url": images[i] if i < len(images) else None,
            "unit_price": price,
            "reference_price": None,
            "reference_format": None,
            "ean": None,
            "ingredients": None,
            "allergens": None,
            "contains_nata": False,
            "energy_kcal_100g": None,
            "fat_100g": None,
            "saturated_fat_100g": None,
            "carbohydrates_100g": None,
            "sugars_100g": None,
            "proteins_100g": None,
            "salt_100g": None,
            "share_url": f"https://www.lidl.es/p/{pid}",
        })
    return products


async def scrape_lidl(queries: list[str]) -> list[dict]:
    all_products: dict[str, dict] = {}
    async with async_playwright() as pw:
        browser = await pw.chromium.launch(
            headless=True,
            args=["--no-sandbox", "--disable-setuid-sandbox", "--disable-dev-shm-usage"],
        )
        context = await browser.new_context(
            user_agent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
            locale="es-ES",
            extra_http_headers={"Accept-Language": "es-ES,es;q=0.9"},
            viewport={"width": 1280, "height": 800},
        )
        page = await context.new_page()

        for query in queries:
            try:
                await page.goto(
                    SEARCH_URL.format(query=query),
                    wait_until="networkidle",
                    timeout=30_000,
                )
                await asyncio.sleep(2)

                # Aceptar cookies si aparecen
                try:
                    await page.click("#onetrust-accept-btn-handler", timeout=2000)
                    await asyncio.sleep(1)
                except Exception:
                    pass

                html = await page.content()
                products = _parse_html(html)
                for p in products:
                    key = f"lidl_{p['external_id']}"
                    if key not in all_products:
                        all_products[key] = {**p, "id": key}
                print(f"[Lidl] '{query}': {len(products)} productos")
            except Exception as e:
                print(f"[Lidl] Error en '{query}': {e}")
            await asyncio.sleep(1)

        await browser.close()
    return list(all_products.values())
