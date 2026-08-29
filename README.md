# EasyCompra

Comparador de precios y datos nutricionales de supermercados españoles.
Reúne el catálogo de alimentación de **Carrefour, Lidl, Mercadona y Dia** en una
sola lista, lo enriquece con la información nutricional de OpenFoodFacts y lo
sirve a una app Android nativa desde la que buscar, filtrar y ordenar.

Estado actual: **v2** del repositorio, **v6** de la app Android.
Datos vivos: ~1.800 productos (Mercadona 706 · Dia 502 · Carrefour 471 · Lidl 121),
actualizados automáticamente cada día a las 06:00 UTC. La cifra baila entre
sincronizaciones según lo que devuelva cada fuente.

---

## Cómo funciona

```
GitHub Actions (cron diario 06:00 UTC)
        │
        │  scrapers + APIs públicas + OpenFoodFacts
        ▼
backend/data/*.json  ──commit al repo──►  histórico versionado en git
        │
        ▼
FastAPI  (backend/app/main.py, puerto 8123)
        │  GET /products
        ▼
App Android (Kotlin + Jetpack Compose)
```

La pieza clave es que **los datos no se scrapean en tiempo real**. Un workflow de
GitHub Actions ejecuta la sincronización una vez al día, guarda el resultado como
JSON dentro del propio repositorio y lo commitea. El servidor FastAPI se limita a
leer esos JSON y servirlos, así que arranca en un segundo y no depende de que los
supermercados respondan cuando el usuario abre la app.

### Fuentes de datos

| Supermercado | Método | Notas |
|---|---|---|
| **Mercadona** | API pública `tienda.mercadona.es/api` | Por categorías. Solo acepta IDs de subcategoría; los de primer nivel devuelven 404. |
| **Dia** | API pública `dia.es/api/v1` | Por búsquedas de texto. |
| **Carrefour** | `search-api` + **camoufox** (Firefox stealth) | Está detrás de Akamai: una petición HTTP directa recibe 403. Se abre la home con camoufox para que Akamai valide la sesión y se llama a la API desde el contexto de la página, heredando sus cookies. |
| **Lidl** | Scraping HTML con **Playwright** | Los productos vienen serializados en el atributo `data-gridbox-impression` de la página de resultados. |
| **OpenFoodFacts** | API pública por EAN | Aporta la nutrición (kcal, azúcares, proteínas, sal…) cuando el supermercado da el código de barras. |

Las búsquedas se hacen sobre una lista fija de 20 términos de alimentación
(`FOOD_QUERIES`: yogur, kéfir, leche, queso, huevos, cereales, avena, legumbres,
atún, frutos secos, pasta, arroz, conservas, embutido, mantequilla, proteínas,
pollo, salmón, brócoli, espinacas) y sobre 20 subcategorías de Mercadona.

### Protección contra sincronizaciones vacías

Si una fuente devuelve 0 productos, `sync_to_json.py` **no sobreescribe** su JSON
—conserva los últimos datos buenos— y termina con código 1 para que Actions marque
la ejecución en rojo en lugar de commitear un fichero vacío en silencio.

---

## Estructura del repositorio

```
EasyCompra/
├── .github/workflows/sync_supermarkets.yml   Cron diario de sincronización
├── backend/
│   ├── app/
│   │   ├── main.py                FastAPI: /products, /health, /sync/*
│   │   ├── db.py                  Modelo SQLAlchemy + upsert (SQLite)
│   │   ├── normalize.py           Normaliza cada fuente al modelo común
│   │   ├── mercadona_client.py    API Mercadona
│   │   ├── dia_client.py          API Dia
│   │   ├── carrefour_scraper.py   Carrefour vía camoufox
│   │   ├── lidl_scraper.py        Lidl vía Playwright
│   │   ├── openfoodfacts_client.py
│   │   ├── sync.py                Sincroniza a la base de datos SQLite
│   │   └── sync_to_json.py        Sincroniza a JSON (el que usa Actions)
│   ├── data/*.json                Datos servidos por la API
│   ├── Dockerfile / docker-compose.yml
│   └── setup.sh                   Despliegue en Oracle Cloud Free Tier
├── android/                       App Kotlin + Compose (Gradle 8.5, SDK 34)
├── INICIAR_SERVIDOR.bat           Arranque local en Windows + túnel ngrok
└── VERSION
```

---

## Modelo de producto

Común a las cuatro fuentes (`backend/app/db.py`, espejado en `android/…/Data.kt`):

`supermarket`, `external_id`, `name`, `brand`, `photo_url`, `unit_price`,
`reference_price`, `reference_format`, `ean`, `ingredients`, `allergens`,
`contains_nata`, `energy_kcal_100g`, `fat_100g`, `saturated_fat_100g`,
`carbohydrates_100g`, `sugars_100g`, `proteins_100g`, `salt_100g`, `share_url`.

`contains_nata` es un flag calculado buscando la palabra *nata* en los
ingredientes, para el filtro rápido de la app.

---

## API

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/products` | Lista de productos. Parámetros: `supermarket`, `exclude_ingredient`, `sort_by` (por defecto `sugars_100g`). |
| `GET` | `/health` | Estado del servicio y recuento de productos por supermercado, en base de datos y en JSON. |
| `POST` | `/sync/mercadona/{category_id}` | Sincroniza una subcategoría de Mercadona. |
| `POST` | `/sync/dia?q=…` | Sincroniza una búsqueda de Dia. |
| `POST` | `/sync/carrefour` | Lanza el scraper de Carrefour en segundo plano. |
| `POST` | `/sync/lidl` | Lanza el scraper de Lidl en segundo plano. |
| `POST` | `/sync/all` | Sincronización completa de las cuatro fuentes (varios minutos). |

Los endpoints `/sync/*` escriben en la base de datos SQLite y existen sobre todo
para desarrollo: en producción quien manda es el workflow de GitHub Actions.

---

## Puesta en marcha

### Backend en local (Windows)

```bat
INICIAR_SERVIDOR.bat
```

Sincroniza Lidl, arranca `uvicorn` en el puerto 8123 y abre un túnel ngrok para
llegar desde el móvil sin estar en la misma WiFi. Requiere `ngrok.exe` junto al .bat.

O a mano:

```bash
cd backend
pip install -r requirements.txt
playwright install chromium
python -m camoufox fetch          # solo si vas a scrapear Carrefour
python -m uvicorn app.main:app --host 0.0.0.0 --port 8123
```

### Backend con Docker

```bash
cd backend
docker compose up -d --build
```

Levanta dos servicios: la API en el 8123 y un contenedor `cron` que relanza el
sync completo cada 24 h.

### Backend en Oracle Cloud Free Tier

```bash
bash backend/setup.sh
```

Instala Docker, abre el puerto 8123 en iptables y levanta el compose. Falta abrir
también el 8123 en la *Security List* de la VCN desde la consola de Oracle.

### App Android

```bash
cd android
./gradlew assembleDebug
# APK en android/app/build/outputs/apk/debug/
```

También hay APKs ya compilados en la raíz (`EasyCompra-v6.apk`). Al abrir la app,
en **Ajustes** (icono de engranaje) se indica la dirección del backend: la IP local
del PC (`http://192.168.1.131:8123`) o la URL de ngrok. Queda guardada en
`SharedPreferences`.

Pantalla única: buscador, chips de supermercado, orden por precio / azúcares /
nombre, filtro "sin nata" y lista de tarjetas con foto, precio y nutrición. El
filtrado y la ordenación se hacen en local sobre lo ya descargado.

---

## Notas de compatibilidad

La app **v5** se cerraba al arrancar cuando el backend dejó de enviar
`nutriscore_grade`: su modelo lo declaraba obligatorio y kotlinx.serialization
lanzaba `MissingFieldException`. Como el código fuente de la v5 se perdió, la API
sigue enviando ese campo a `null` (`LEGACY_FIELDS` en `main.py`) para no romper las
instalaciones antiguas.

En la **v6** todos los campos del modelo son opcionales y con valor por defecto, y
el parser usa `ignoreUnknownKeys` y `coerceInputValues`, así que añadir o quitar
campos en el backend ya no puede tumbar la app.

---

## Futuras mejoras

### Prioridad alta

- **Backend público y estable.** Hoy la app apunta a una IP de red local o a una URL
  de ngrok que cambia en cada arranque. Desplegar el backend en un host fijo
  (el script de Oracle Cloud Free Tier ya existe) y fijar esa URL como valor por defecto.
- **Modo sin servidor.** Como los JSON ya viven en el repositorio, la app podría
  leerlos directamente desde GitHub Raw o GitHub Pages y funcionar sin backend
  alguno. Es la vía más rápida para que deje de depender del PC de casa.
- **`DB_PATH` desde el entorno.** `docker-compose.yml` define la variable `DB_PATH`,
  pero `db.py` la ignora y usa una ruta fija (`sqlite:///easycompra.db`), así que la
  base de datos no acaba en el volumen montado. Leerla con `os.getenv`.
- **Comparar el mismo producto entre supermercados.** Es el objetivo que da nombre al
  proyecto y todavía no existe: agrupar por EAN (o por nombre normalizado cuando no
  haya EAN) y mostrar una tarjeta por producto con el precio de cada cadena.
- **Precio por unidad de referencia.** El modelo ya guarda `reference_price` y
  `reference_format`, pero la app enseña `unit_price`. Comparar €/kg y €/L es la
  única forma honesta de comparar formatos distintos.

### Datos y cobertura

- **Mejorar la cobertura nutricional.** Depende de que el supermercado dé el EAN y de
  que el producto esté en OpenFoodFacts; muchos se quedan sin datos. Opciones: parsear
  la ficha nutricional del propio supermercado como respaldo, cachear los EAN sin
  resultado para no repetir peticiones, y extender el enriquecimiento a Carrefour y Lidl.
- **Ampliar el catálogo.** Las 20 búsquedas fijas dejan fuera buena parte de la
  alimentación. Recorrer el árbol de categorías completo en lugar de buscar por términos.
- **Más cadenas:** Alcampo, Eroski, Consum, Aldi.
- **Histórico de precios.** Los JSON llevan meses commiteándose a diario, así que la
  serie temporal ya existe dentro del historial de git: solo falta extraerla, mostrar
  la evolución del precio y avisar cuando un producto baja.

### App Android

- Ficha de detalle del producto: ingredientes completos, alérgenos, tabla nutricional
  y enlace a la web del supermercado (`share_url`).
- Lista de la compra, con reparto por supermercado según dónde salga más barato.
- Caché local (Room o DataStore) para poder abrir la app sin conexión.
- Escaneo de códigos de barras para buscar un producto por EAN.
- Modo oscuro: el tema está fijado a `lightColorScheme()`.
- Favoritos y filtros nutricionales configurables, más allá del "sin nata" actual
  (sin lactosa, sin azúcares añadidos, alto en proteína, por alérgeno).

### Infraestructura y calidad

- **Búsqueda y paginación en el servidor.** Ahora la app descarga la lista entera y
  filtra en memoria; con más productos dejará de escalar.
- **Tests de contrato de los scrapers**, que avisen cuando un supermercado cambia su
  HTML o su API en vez de descubrirlo por un JSON vacío, con notificación al fallar el
  workflow.
- **Publicar los APK como GitHub Releases** en lugar de dejarlos en el árbol del
  repositorio (27 MB de binarios sin trackear en la raíz).
- **Firmar la APK de release**: la configuración de Gradle solo define el build `debug`,
  sin minificar.
- Linter y tipos en el backend (`ruff` + `mypy`) y CI que compile la app en cada push.
- Caché HTTP (ETag / `Cache-Control`) y compresión gzip en `/products`.

---

## Licencia

Proyecto personal, sin licencia definida. Los datos pertenecen a sus respectivos
supermercados y a OpenFoodFacts (ODbL); el scraping es de uso privado y no comercial.
