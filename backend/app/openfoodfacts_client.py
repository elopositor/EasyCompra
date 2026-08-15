import time

import httpx

BASE_URL = "https://world.openfoodfacts.org/api/v2"
HEADERS = {"User-Agent": "EasyCompra-MVP/1.0"}

_client = httpx.Client(base_url=BASE_URL, headers=HEADERS, timeout=10)


def get_nutrition_by_ean(ean: str) -> dict | None:
    resp = _client.get(f"/product/{ean}.json")
    if resp.status_code == 429:
        time.sleep(1.5)
        resp = _client.get(f"/product/{ean}.json")
    if resp.status_code != 200:
        return None
    data = resp.json()
    if data.get("status") != 1:
        return None
    nutriments = data["product"].get("nutriments", {})
    return {
        "energy_kcal_100g": nutriments.get("energy-kcal_100g"),
        "fat_100g": nutriments.get("fat_100g"),
        "saturated_fat_100g": nutriments.get("saturated-fat_100g"),
        "carbohydrates_100g": nutriments.get("carbohydrates_100g"),
        "sugars_100g": nutriments.get("sugars_100g"),
        "proteins_100g": nutriments.get("proteins_100g"),
        "salt_100g": nutriments.get("salt_100g"),
    }
