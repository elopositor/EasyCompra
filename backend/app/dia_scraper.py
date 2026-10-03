"""
Dia, a traves de su API, pero desde un navegador real (camoufox).

Desde septiembre de 2026 la API de Dia esta detras de Akamai y una peticion
HTTP directa recibe 403 "Access Denied", tambien con cabeceras de navegador.
Igual que con Carrefour: se abre la web con camoufox para que Akamai valide la
sesion y las llamadas a la API se hacen desde la pagina, con sus cookies.

Busqueda: /api/v1/search-back/search?q=...  -> 'search_items' (30 por pagina)
Ficha:    /api/v1/pdp-back/{object_id}      -> 'product'
"""
import asyncio
import json
from urllib.parse import quote

from camoufox.async_api import AsyncCamoufox

from . import normalize

BASE = "https://www.dia.es"

_FETCH_JS = """
async (url) => {
    const resp = await fetch(url, { headers: { Accept: "application/json" } });
    return { status: resp.status, body: await resp.text() };
}
"""


async def _json(page, ruta: str) -> dict | None:
    resp = await page.evaluate(_FETCH_JS, BASE + ruta)
    if resp["status"] != 200:
        print(f"[dia] {ruta}: HTTP {resp['status']}")
        return None
    try:
        return json.loads(resp["body"])
    except json.JSONDecodeError:
        print(f"[dia] {ruta}: la respuesta no es JSON (pagina de bloqueo)")
        return None


async def scrape_dia(queries: list[str]) -> list[dict]:
    productos: dict[str, dict] = {}
    # La busqueda da object_id y el producto se guarda por sku_id: se lleva
    # aparte lo ya visto para no pedir dos veces la misma ficha.
    vistos: set[str] = set()
    async with AsyncCamoufox(headless=True, geoip=True) as browser:
        page = await browser.new_page()
        await page.goto(BASE + "/", wait_until="domcontentloaded", timeout=60_000)
        await asyncio.sleep(4)
        try:
            await page.click("#onetrust-accept-btn-handler", timeout=3_000)
        except Exception:
            pass
        await page.mouse.move(400, 300)
        await asyncio.sleep(2)

        for query in queries:
            busqueda = await _json(page, f"/api/v1/search-back/search?q={quote(query)}")
            if busqueda is None:
                continue
            antes = len(productos)
            for item in busqueda.get("search_items") or []:
                oid = str(item.get("object_id"))
                if oid in vistos:
                    continue
                vistos.add(oid)
                ficha = await _json(page, f"/api/v1/pdp-back/{item['object_id']}")
                if ficha is None or "product" not in ficha:
                    continue
                try:
                    p = normalize.build_dia_product(item, ficha["product"])
                except Exception as e:
                    print(f"[dia] {item.get('object_id')}: {e}")
                    continue
                productos.setdefault(p["id"], p)
                await asyncio.sleep(0.2)
            print(f"[dia] '{query}': +{len(productos) - antes} nuevos (total {len(productos)})")
    return list(productos.values())
