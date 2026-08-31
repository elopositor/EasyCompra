<h1 align="center">EasyCompra</h1>

<p align="center">
  <b>Comparador de precios y nutrición de los supermercados españoles,<br>
  con app Android propia y sin ningún servidor que mantener.</b>
</p>

<p align="center">
  <img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=kotlin&logoColor=white">
  <img alt="Jetpack Compose" src="https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=flat-square&logo=jetpackcompose&logoColor=white">
  <img alt="Python" src="https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white">
  <img alt="FastAPI" src="https://img.shields.io/badge/FastAPI-009688?style=flat-square&logo=fastapi&logoColor=white">
  <img alt="GitHub Actions" src="https://img.shields.io/badge/GitHub%20Actions-2088FF?style=flat-square&logo=githubactions&logoColor=white">
  <img alt="Licencia MIT" src="https://img.shields.io/badge/licencia-MIT-blue?style=flat-square">
</p>

<p align="center">
  <a href="https://github.com/elopositor/EasyCompra-datos"><b>Datos abiertos</b></a>
</p>

---

Comparador de precios y datos nutricionales de supermercados españoles.
Reúne el catálogo de alimentación de **Carrefour, Lidl, Mercadona y Dia** en una
sola lista, lo enriquece con la información nutricional de OpenFoodFacts y lo
sirve a una app Android nativa desde la que buscar, filtrar y ordenar.

Estado actual: **v10** de la app Android.
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
backend/data/*.json  ──commit──►  histórico versionado en este repo
        │
        └──publica──►  github.com/elopositor/EasyCompra-datos  (público)
                                    │
                                    │  raw.githubusercontent.com
                                    ▼
                       App Android (Kotlin + Jetpack Compose)
```

Dos ideas sostienen el diseño:

1. **Los datos no se scrapean en tiempo real.** Un workflow de GitHub Actions
   sincroniza una vez al día y guarda el resultado como JSON en el repositorio.
2. **La app no necesita servidor.** Lee esos JSON directamente del repositorio
   público de datos, así que funciona con el PC apagado, desde 4G y sin abrir
   ningún puerto en casa. Guarda además una copia local para seguir funcionando
   sin conexión.

El backend FastAPI sigue existiendo y sirve los mismos datos, pero ahora es
**opcional**: solo hace falta para desarrollo. Se elige desde Ajustes en la app.

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
├── .github/workflows/
│   ├── sync_supermarkets.yml  Cron diario: sincroniza y publica los datos
│   └── build_apk.yml          Compila la APK (verificacion del build)
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

**Contrato de tipos.** Cada fuente devuelve los números a su manera: Mercadona
manda los precios como texto (`"1.05"`), Dia mezcla enteros y decimales, Lidl a
veces usa coma decimal. `normalize.coerce_types()` fija el tipo en un único punto
antes de escribir los JSON, de modo que los campos de precio y nutrición son
**siempre número o `null`**, nunca texto. Sin eso, el parser de la app rechazaba el
catálogo entero de Mercadona.

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

Cada cambio en `android/` dispara el workflow *Compilar APK*, que comprueba en
GitHub Actions que el proyecto sigue compilando.

**La APK no se distribuye desde aquí.** La app es de uso personal y se instala en
privado, así que el workflow no publica releases ni artefactos: en un repositorio
público cualquiera podría descargarlos. Lo que se publica es el código y los datos.

Para compilarla (requiere el SDK de Android):

```bash
cd android
./gradlew assembleDebug
# APK en android/app/build/outputs/apk/debug/
```

Al abrir la app, en **Ajustes** (icono de engranaje) se elige el origen de los datos:

- **Internet** (por defecto): descarga los JSON del repositorio público. No requiere
  nada encendido en casa.
- **Servidor propio**: la dirección del backend en la red local, por ejemplo
  `http://192.168.1.131:8123`.

La elección y la dirección quedan guardadas en `SharedPreferences`, y la última
descarga correcta se cachea en disco para poder abrir la app sin conexión.

Cinco secciones, en la barra inferior:

- **Buscar**: el comparador. Chips de supermercado, orden por precio / azúcares /
  nombre, filtro "sin nata", y tarjetas con foto, precio y nutrición.
- **Despensa**: lo que hay en casa, por ubicación (nevera, congelador, despensa,
  bebidas) y subcategoría. Un mismo producto puede estar en varios sitios a la vez.
  Cantidades, estado de stock y marcado de "necesito comprar".
- **Recetas**: alta y edición con ingredientes, unidades y pasos. Favoritas,
  ajuste de raciones que recalcula las cantidades, y para cada ingrediente si lo
  tienes en la despensa o cuánto falta. Botón para llevar lo que falta a la lista.
- **Semana**: planificador con las cuatro comidas del día, desde tus recetas o
  escrito a mano. Incluye un resumen de la semana y un botón que manda a la lista
  lo que falta para todo lo planificado.
- **Lista**: la lista de la compra. Se llena sola desde la despensa y las recetas.

La despensa, el recetario y el planificador se guardan en el móvil (Room); la
lista de la compra, en preferencias. El filtrado del buscador se hace en local
sobre lo ya descargado, fuera del hilo de la interfaz.

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

## Seguridad

- **La app no abre ningún puerto.** Es un cliente: descarga JSON por HTTPS y los
  pinta. Leyendo de GitHub no hay nada escuchando en la red de casa.
- **La API no tiene autenticación.** Por eso el backend es opcional y de uso local.
  Escucha en `0.0.0.0`, así que cualquiera en la misma WiFi puede llamarla; y
  `POST /sync/all` lanza navegadores (Playwright y camoufox) en la máquina que la
  ejecuta. **No exponerla a internet** —ngrok, redirección de puertos en el router—
  sin ponerle antes una clave.
- **Qué es público y qué no.** El código es público; el material sensible no está en
  él. El keystore de firma (`easycompra.jks` y su contraseña) vive fuera del control de
  versiones y solo existe como secret de Actions. Los JSON de precios se publican en
  `EasyCompra-datos`: datos de producto de supermercados, sin nada personal.
- **Credenciales.** El sync publica en el repositorio de datos con una *deploy key*
  de escritura, guardada como secret `DATOS_DEPLOY_KEY` y limitada a ese único
  repositorio. No hay tokens ni claves en el código; `.env` y `*.db` están en
  `.gitignore`.
- La IP privada que aparece como valor por defecto (`192.168.1.131`) es una dirección
  de red local (RFC1918): no es accesible desde internet y no identifica nada.

## Futuras mejoras

### Prioridad alta

- **Comparar el mismo producto entre supermercados.** Es el objetivo que da nombre al
  proyecto y todavía no existe: agrupar por EAN (o por nombre normalizado cuando no
  haya EAN) y mostrar una tarjeta por producto con el precio de cada cadena.
- **Precio por unidad de referencia.** El modelo ya guarda `reference_price` y
  `reference_format`, pero la app enseña `unit_price`. Comparar €/kg y €/L es la
  única forma honesta de comparar formatos distintos.
- **`DB_PATH` desde el entorno.** `docker-compose.yml` define la variable `DB_PATH`,
  pero `db.py` la ignora y usa una ruta fija (`sqlite:///easycompra.db`), así que la
  base de datos no acaba en el volumen montado. Leerla con `os.getenv`. Afecta solo
  al backend opcional.

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

Lo que tenía la v5 y aún no se ha reconstruido (ver `referencia/LEEME.md`):

- **Vincular un ingrediente a un producto concreto de la despensa.** Ahora el cruce
  se hace por nombre exacto o por `linkedProductId`, pero no hay pantalla para
  elegir el producto: la v5 tenía un "Busca el producto de tu despensa que
  corresponde a…". Sin eso, "Tomate frito" y "tomate frito Hacendado" no se cruzan.
- **Ficha de detalle del producto** con nutrición completa, alérgenos, NutriScore y
  enlace al supermercado (`share_url`).
- **Favoritos de productos** y el comparador entre dos productos.
- **Modo cocinar** paso a paso, y los avisos de descongelar (`DefrostAlert`).

Y lo que no tenía ninguna de las dos:

- Lista de la compra con reparto por supermercado según dónde salga más barato.
- Escaneo de códigos de barras para buscar un producto por EAN.
- Caducidades en la despensa, con aviso de lo que va a vencer.
- Modo oscuro: el tema está fijado a `lightColorScheme()`.
- Favoritos y filtros nutricionales configurables, más allá del "sin nata" actual
  (sin lactosa, sin azúcares añadidos, alto en proteína, por alérgeno).

### Infraestructura y calidad

- **Búsqueda y paginación en el servidor.** Ahora la app descarga la lista entera y
  filtra en memoria; con más productos dejará de escalar.
- **Tests de contrato de los scrapers**, que avisen cuando un supermercado cambia su
  HTML o su API en vez de descubrirlo por un JSON vacío, con notificación al fallar el
  workflow.
- **Build `release` de verdad**: la firma ya está resuelta con un keystore propio y
  estable (secrets `ANDROID_KEYSTORE_B64` y `ANDROID_KEYSTORE_PASSWORD`), pero lo que se
  publica sigue siendo el build `debug`. Falta un `release` con R8 y recursos minificados.
- Linter y tipos en el backend (`ruff` + `mypy`) y CI que compile la app en cada push.
- Caché HTTP (ETag / `Cache-Control`) y compresión gzip en `/products`.

---

## Licencia

El **código** de este repositorio se publica bajo licencia [MIT](LICENSE).

Los **datos** no son míos: pertenecen a sus respectivos supermercados y a OpenFoodFacts
(ODbL). La recogida es de uso personal y no comercial, se limita a información de producto
ya visible en sus webs y no incluye ningún dato de personas.
