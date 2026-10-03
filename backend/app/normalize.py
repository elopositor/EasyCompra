import re
import time

from . import dia_client, mercadona_client, openfoodfacts_client

# IDs de subcategoria de Mercadona (el endpoint /api/categories/{id}/ solo
# acepta subcategorias; los IDs de primer nivel devuelven 404).
# Seleccion equivalente a FOOD_QUERIES: lacteos, cereales, proteina y conservas.
MERCADONA_CATEGORIES = [
    103,  # Yogures desnatados
    104,  # Yogures naturales y sabores
    105,  # Bifidus
    108,  # Yogures liquidos
    109,  # Yogures griegos
    72,   # Leche y bebidas vegetales
    77,   # Huevos
    75,   # Mantequilla y margarina
    53,   # Queso untable, fresco y especialidades
    54,   # Queso curado, semicurado y tierno
    56,   # Queso lonchas, rallado y en porciones
    78,   # Cereales
    118,  # Arroz
    120,  # Pasta y fideos
    121,  # Legumbres
    122,  # Atun y otras conservas de pescado
    133,  # Frutos secos y fruta desecada
    43,   # Embutido
    38,   # Aves y pollo
    31,   # Pescado fresco
]

NUTRITION_DEFAULTS = {
    "energy_kcal_100g": None,
    "fat_100g": None,
    "saturated_fat_100g": None,
    "carbohydrates_100g": None,
    "sugars_100g": None,
    "proteins_100g": None,
    "salt_100g": None,
}


def _strip_html(text: str | None) -> str:
    if not text:
        return ""
    return re.sub(r"<[^>]+>", "", text)


# Mercadona sirve la foto "zoom" a 3600x3600, que en la app ocupa un hueco de
# 64dp: son megas de descarga y de memoria para nada. Se pide un tamano acorde.
_URL_SIZE_RE = re.compile(r"([?&])(w|h|width|height)=\d+")
FOTO_PX = 300


def _photo_url(detail: dict) -> str | None:
    photos = detail.get("photos") or []
    primera = photos[0] if photos else {}
    url = (
        primera.get("regular")
        or primera.get("zoom")
        or primera.get("thumbnail")
        or detail.get("thumbnail")
    )
    if not url:
        return None
    return _URL_SIZE_RE.sub(rf"\g<1>\g<2>={FOTO_PX}", url)


def _contains_nata(ingredients: str) -> bool:
    return bool(re.search(r"\bnata\b", ingredients.lower()))


# Cada fuente devuelve los numeros a su manera: Mercadona manda los precios
# como texto ("1.05"), Dia mezcla int y float y Lidl a veces usa coma decimal.
# El consumidor (la app) espera siempre numero o null, asi que el tipo se fija
# aqui, en un unico sitio, antes de escribir los JSON.
NUMERIC_FIELDS = (
    "unit_price",
    "reference_price",
    "energy_kcal_100g",
    "fat_100g",
    "saturated_fat_100g",
    "carbohydrates_100g",
    "sugars_100g",
    "proteins_100g",
    "salt_100g",
)

_NUMBER_RE = re.compile(r"-?\d+(?:\.\d+)?")


def to_float(value) -> float | None:
    """Convierte a float lo que venga: '1,05', '1.05 EUR', 3, 3.0, None."""
    if value is None or isinstance(value, bool):
        return None
    if isinstance(value, (int, float)):
        return float(value)
    if isinstance(value, str):
        match = _NUMBER_RE.search(value.strip().replace(",", "."))
        if match:
            try:
                return float(match.group())
            except ValueError:
                return None
    return None


def coerce_types(product: dict) -> dict:
    """Fija el tipo de cada campo del producto antes de publicarlo."""
    clean = dict(product)
    for field in NUMERIC_FIELDS:
        if field in clean:
            clean[field] = to_float(clean[field])
    clean["contains_nata"] = bool(clean.get("contains_nata"))
    return clean


# Secciones de primer nivel que no son comida: bodega (alcohol), cosmetica,
# parafarmacia, bebe y limpieza. Todo lo demas entra, fruta y verdura incluida.
MERCADONA_SIN_COMIDA = {19, 20, 21, 22, 23, 24, 26}


def get_mercadona_subcategorias() -> list[int]:
    """Todas las subcategorias de comida, leidas del arbol de la tienda.

    Primero las de MERCADONA_CATEGORIES, para que si hay que racionar las
    fichas (ver sync_to_json) sean las de siempre las que no se queden sin.
    """
    todas = [
        sub["id"]
        for seccion in mercadona_client.get_category_tree()
        if seccion.get("id") not in MERCADONA_SIN_COMIDA
        for sub in seccion.get("categories", [])
    ]
    return MERCADONA_CATEGORIES + [c for c in todas if c not in MERCADONA_CATEGORIES]


def mercadona_desde_listado(summary: dict) -> dict:
    """Producto con lo que trae el listado de la categoria, sin pedir su ficha:
    nombre, precio, precio por kilo, foto y enlace. Sin marca ni nutricion."""
    precios = summary.get("price_instructions") or {}
    external_id = str(summary["id"])
    return {
        "supermarket": "Mercadona",
        "external_id": external_id,
        "id": f"mercadona_{external_id}",
        "name": summary.get("display_name"),
        "brand": None,
        "photo_url": summary.get("thumbnail"),
        "unit_price": precios.get("unit_price"),
        "reference_price": precios.get("reference_price"),
        "reference_format": precios.get("reference_format"),
        "ean": None,
        "ingredients": None,
        "allergens": None,
        "contains_nata": False,
        "share_url": summary.get("share_url"),
        **NUTRITION_DEFAULTS,
        "con_ficha": False,
    }


def build_mercadona_product(summary: dict) -> dict:
    detail = mercadona_client.get_product_detail(summary["id"])
    ean = detail.get("ean")
    nutrition = NUTRITION_DEFAULTS
    if ean:
        off_nutrition = openfoodfacts_client.get_nutrition_by_ean(ean)
        time.sleep(0.3)  # avoid OpenFoodFacts rate limiting (429)
        if off_nutrition:
            nutrition = {**NUTRITION_DEFAULTS, **off_nutrition}
    ingredients = _strip_html(detail.get("nutrition_information", {}).get("ingredients"))
    external_id = str(detail["id"])

    return {
        "supermarket": "Mercadona",
        "external_id": external_id,
        "id": f"mercadona_{external_id}",
        "name": detail["display_name"],
        "brand": detail.get("details", {}).get("brand"),
        "photo_url": _photo_url(detail),
        "unit_price": detail.get("price_instructions", {}).get("unit_price"),
        "reference_price": detail.get("price_instructions", {}).get("reference_price"),
        "reference_format": detail.get("price_instructions", {}).get("reference_format"),
        "ean": ean,
        "ingredients": ingredients,
        "allergens": _strip_html(detail.get("nutrition_information", {}).get("allergens")),
        "contains_nata": _contains_nata(ingredients),
        "share_url": detail.get("share_url"),
        **nutrition,
        "con_ficha": True,
    }


def _parse_dia_nutrition(nutritional_info: dict | None) -> dict:
    if not nutritional_info:
        return NUTRITION_DEFAULTS
    values = nutritional_info.get("nutritional_values") or {}
    nutrition = {**NUTRITION_DEFAULTS, "energy_kcal_100g": values.get("energy_value")}

    field_by_title = {
        "Grasas": "fat_100g",
        "de las cuales saturadas": "saturated_fat_100g",
        "Hidratos de Carbono": "carbohydrates_100g",
        "de los cuales azúcares": "sugars_100g",
        "Proteínas": "proteins_100g",
        "Sal": "salt_100g",
    }
    def normalize_title(title: str) -> str:
        return re.sub(r"\s+", " ", title.replace("\xa0", " ")).strip()

    for entry in values.get("values", []):
        field = field_by_title.get(normalize_title(entry.get("title", "")))
        if field:
            nutrition[field] = entry.get("value_per_100_g")
        for item in entry.get("items", []):
            field = field_by_title.get(normalize_title(item.get("title", "")))
            if field:
                nutrition[field] = item.get("value_per_100_g")

    return nutrition


def build_dia_product(item: dict, detail: dict | None = None) -> dict:
    """item: resultado de la busqueda. detail: su ficha, si ya se ha descargado
    (el sync la trae desde el navegador; el servidor la pide aqui)."""
    if detail is None:
        detail = dia_client.get_product_detail(item["object_id"])
    ingredients = _strip_html(detail.get("ingredients", {}).get("text"))
    images = detail.get("images") or []
    external_id = str(detail["sku_id"])

    return {
        "supermarket": "Dia",
        "external_id": external_id,
        "id": f"dia_{external_id}",
        "name": detail.get("primary_info", {}).get("title") or item.get("display_name"),
        "brand": item.get("brand"),
        "photo_url": f"https://www.dia.es{images[0]}" if images else None,
        "unit_price": detail.get("prices", {}).get("price"),
        "reference_price": detail.get("prices", {}).get("price_per_unit"),
        "reference_format": detail.get("prices", {}).get("measure_unit"),
        "ean": None,
        "ingredients": ingredients,
        "allergens": None,
        "contains_nata": _contains_nata(ingredients),
        "share_url": f"https://www.dia.es{item['url']}" if item.get("url") else None,
        **_parse_dia_nutrition(detail.get("nutritional_info")),
    }


def get_mercadona_category(category_id: int) -> list[dict]:
    summaries = mercadona_client.get_category_products(category_id)
    return [build_mercadona_product(s) for s in summaries]


def get_dia_search(query: str) -> list[dict]:
    items = dia_client.search_products(query)
    return [build_dia_product(i) for i in items]
