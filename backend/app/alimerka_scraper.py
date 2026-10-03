"""
Alimerka, desde su tienda online (alimerkaonline.es, Salesforce Commerce Cloud).

La tienda no ensena productos hasta que se entra como invitado con un codigo
postal: lo mismo que hace su web (Stores-FindByZipcode + cookie "logged").
Se usa el de Oviedo; los precios pueden variar algo segun la zona.

Despues, cada seccion se pide entera a Search-UpdateGrid, que devuelve el
HTML de las tarjetas de producto. No necesita navegador.
"""
import asyncio
import html
import re

import httpx

BASE = "https://www.alimerkaonline.es"
SITIO = f"{BASE}/on/demandware.store/Sites-Alimerka-Site/default"
CODIGO_POSTAL = "33001"

# Secciones de comida y bebida sin alcohol, como en el resto de supermercados.
# Fuera: alcohol, droguerias, higiene, bazar e infantil.
SECCIONES = [
    "101",    # Alimentacion
    "103",    # Carniceria
    "104",    # Charcuteria
    "201",    # Fruta y verdura
    "202",    # Pescaderia
    "203",    # Pan y bolleria
    "204",    # Congelados
    "206",    # Mascotas
    "10201",  # Aguas
    "10205",  # Refrescos
    "10299",  # Zumos y mostos
]
PAGINA = 500

HEADERS = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
                  "(KHTML, like Gecko) Chrome/129.0 Safari/537.36",
    "Accept-Language": "es-ES,es;q=0.9",
}

_NATA_RE = re.compile(r"\bnata\b", re.IGNORECASE)
_TARJETA_RE = re.compile(r'<div class="product" data-pid="([^"]+)">(.*?)(?=<div class="product" data-pid=|\Z)', re.S)


def _texto(fragmento: str | None) -> str | None:
    if not fragmento:
        return None
    limpio = html.unescape(re.sub(r"<[^>]+>", " ", fragmento))
    return re.sub(r"\s+", " ", limpio).strip() or None


def _frase(texto: str) -> str:
    """'PANETTONE CLÁSICO 750 G.' -> 'Panettone clásico 750 g.' Como los demás."""
    t = texto.strip().lower()
    return t[:1].upper() + t[1:]


def _numero(texto: str | None) -> float | None:
    if not texto:
        return None
    m = re.search(r"\d+(?:[.,]\d+)?", texto)
    return float(m.group(0).replace(",", ".")) if m else None


def _producto(pid: str, bloque: str) -> dict | None:
    nombre = _texto((re.search(r'class="pdp-link">\s*<a[^>]*>(.*?)</a>', bloque, re.S) or [None, None])[1])
    if not nombre:
        return None
    marca = _texto((re.search(r'class="card__body-title">\s*<a[^>]*>(.*?)</a>', bloque, re.S) or [None, None])[1])
    precio = re.search(r'class="sales">\s*<span class="value" content="([\d.]+)"', bloque)
    por_unidad = re.search(r'class="unit-price-per-unit">\s*\(([^)]*)\)', bloque)
    foto = re.search(r'class="tile-image"\s+src="([^"]+)"', bloque)
    enlace = re.search(r'class="pdp-link">\s*<a class="link" href="([^"]+)"', bloque)

    referencia, formato = None, None
    if por_unidad:
        texto = html.unescape(por_unidad.group(1))   # "9,27 €/kg"
        referencia = _numero(texto)
        formato = texto.split("/")[-1].strip() if "/" in texto else None

    return {
        "supermarket": "Alimerka",
        "external_id": pid,
        "id": f"alimerka_{pid}",
        "name": _frase(nombre),
        "brand": marca.title() if marca else None,
        "photo_url": foto.group(1) if foto else None,
        "unit_price": float(precio.group(1)) if precio else None,
        "reference_price": referencia,
        "reference_format": formato,
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
        "share_url": enlace.group(1) if enlace else None,
    }


def _scrape() -> list[dict]:
    todos: dict[str, dict] = {}
    with httpx.Client(headers=HEADERS, timeout=90, follow_redirects=True) as client:
        # Entrar como invitado: sin esto las secciones salen vacias.
        client.get(BASE + "/")
        resp = client.get(
            f"{SITIO}/Stores-FindByZipcode",
            params={"consent": "true", "zipCode": CODIGO_POSTAL},
            headers={"X-Requested-With": "XMLHttpRequest", "Accept": "application/json"},
        )
        resp.raise_for_status()
        client.cookies.set("logged", "true", domain="www.alimerkaonline.es")

        for seccion in SECCIONES:
            antes = len(todos)
            inicio = 0
            while True:
                try:
                    resp = client.get(f"{SITIO}/Search-UpdateGrid", params={
                        "cgid": seccion, "start": inicio, "sz": PAGINA,
                    })
                    resp.raise_for_status()
                except Exception as e:
                    print(f"[Alimerka] seccion {seccion}: {e}")
                    break
                tarjetas = _TARJETA_RE.findall(resp.text)
                for pid, bloque in tarjetas:
                    if f"alimerka_{pid}" in todos:
                        continue
                    p = _producto(pid, bloque)
                    if p:
                        todos[p["id"]] = p
                if len(tarjetas) < PAGINA:
                    break
                inicio += PAGINA
            print(f"[Alimerka] seccion {seccion}: +{len(todos) - antes} nuevos (total {len(todos)})")
    return list(todos.values())


async def scrape_alimerka() -> list[dict]:
    return await asyncio.to_thread(_scrape)
