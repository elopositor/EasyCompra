"""Script de sync rápido de Lidl, para ejecutar desde el .bat de arranque."""
from .sync import sync_lidl, FOOD_QUERIES
from .db import init_db

if __name__ == "__main__":
    init_db()
    count = sync_lidl(FOOD_QUERIES)
    print(f"Lidl: {count} productos sincronizados.")
