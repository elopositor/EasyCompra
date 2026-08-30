# Referencia: la app v5

El código fuente de la app v5 se perdió. Esta carpeta es lo que se pudo
recuperar de ella, y está aquí para que no vuelva a pasar.

## Qué hay

`v5-descompilada/` — 153 clases descompiladas de `EasyCompra-v5.apk` con
[jadx](https://github.com/skylot/jadx) 1.5.6. Es Java generado a partir del
bytecode: **no compila y no es para compilarlo**. Sirve como especificación —
dice exactamente qué hacía la app y con qué datos.

Lo legible es la capa de datos (entidades, DAOs, repositorios, constantes) y la
lógica de negocio. Las pantallas Compose salen muy desfiguradas por el
compilador: de ellas se aprovechan los textos y la estructura de estado
(`PantryUiState`, `RecipeUiState`, `PlannerUiState`).

## Qué era la v5

App distinta de la actual, con identificador `com.easycompra.app` (la actual es
`com.easycompra`), lo que explica que pudieran convivir instaladas.

Tres bases de datos Room:

| Base | Tablas |
|---|---|
| `PantryDatabase` | `pantry_products`, `pantry_locations` |
| `RecipeDatabase` | `recipes`, `recipe_ingredients`, `recipe_steps` |
| `PlannerDatabase` | `planner_entries` |

Y, fuera de Room, en preferencias: lista de la compra (`ShoppingListStore`),
favoritos (`FavoritesStore`), caché de productos (`ProductCache`) y orden de la
despensa (`PantryOrderStore`).

Vocabulario exacto de la app, tal cual estaba:

- **Ubicaciones de despensa**: Nevera, Congelador, Despensa, Bebidas, Otros
  (cada una con sus subcategorías: Lácteos, Carnes, Pescados y Mariscos…).
- **Unidades de despensa**: unidad, ración, g, kg, ml, l, lata, bote, paquete,
  caja, bolsa, botella, docena, taza, cucharada.
- **Estado de stock**: OK, LOW, EMPTY.
- **Categorías de receta**: Desayunos, Comidas rápidas, Comidas elaboradas,
  Cenas, Postres, Snacks, Bebidas, Otras.
- **Dificultad**: Fácil, Media, Difícil.
- **Comidas del día**: Desayuno ☀️, Comida 🍽️, Merienda ☕, Cena 🌙.
- **Estado de un ingrediente** frente a la despensa: `OK(disponible)`,
  `Partial(disponible, falta)`, `Missing`.
- **Conversión de unidades**: peso (g, kg) y volumen (ml, l, taza = 240 ml,
  cucharada…). Solo convierte dentro del mismo grupo.

Otras piezas de dominio: `WeekAnalysis` (el "Análisis de la semana" del
planificador), `DefrostAlert` (avisos de descongelar), `PantryTip`,
`IngredientNeed` y `RecipeShoppingStore` (llevar los ingredientes que faltan a
la lista de la compra).

## Diferencia importante con la app actual

La v5 hablaba **directamente** con las APIs de Mercadona, Dia y OpenFoodFacts
desde el móvil (`network/MercadonaService`, `DiaService`,
`OpenFoodFactsService`), además de con un `CloudService`. La app actual lee los
JSON ya preparados del repositorio de datos, que es más rápido y no depende de
que esas APIs respondan.

## La APK original

`EasyCompra-v5.apk` está publicada como release `v5-historico` en el
repositorio, para que el binario tampoco dependa de que sobreviva en un disco.
