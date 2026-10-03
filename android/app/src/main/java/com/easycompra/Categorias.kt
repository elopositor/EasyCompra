package com.easycompra

/**
 * Categoria de un producto deducida de su nombre: los datos de los
 * supermercados no la traen (o cada uno la da a su manera).
 *
 * Manda la primera palabra reconocible, porque los nombres empiezan por el
 * tipo de producto: "Leche fermentada sabor chocolate" es un lacteo y
 * "Galletas con leche" son dulces. Lo de mascotas va siempre aparte, aunque
 * lleve "salmon" o "pollo".
 */
object Categorias {

    const val OTROS = "Otros"

    /** En el orden en que se ensenan los chips. */
    private val CATEGORIAS: List<Pair<String, List<String>>> = listOf(
        "Lácteos" to listOf(
            "leche", "yogur", "yogurt", "kefir", "queso", "mantequilla", "nata", "bifidus", "skyr",
            "cuajada", "natillas", "flan", "requeson", "petit", "margarina", "lacteo", "mozzarella",
            "burrata", "batido", "postre", "plantequilla", "preparado lacteo", "ricotta", "mascarpone",
        ),
        "Huevos" to listOf("huevo"),
        "Carne" to listOf(
            "pollo", "pavo", "cerdo", "ternera", "vacuno", "cordero", "conejo", "carne", "hamburguesa",
            "burger", "salchicha", "albondiga", "chuleta", "solomillo", "lomo", "costilla", "pechuga",
            "contramuslo", "muslo", "filete", "picada", "carcasa", "alitas", "alas", "secreto", "presa",
            "butifarra", "torrezno", "morro", "mollejas", "empanados", "codillo", "pato",
        ),
        "Embutido" to listOf(
            "jamon", "chorizo", "salchichon", "fuet", "lacon", "mortadela", "embutido", "salami",
            "fiambre", "longaniza", "sobrasada", "cecina", "morcilla", "bacon", "panceta", "chistorra",
            "txistorra", "espetec", "iberico", "foie", "pate",
        ),
        "Pescado" to listOf(
            "salmon", "atun", "merluza", "bacalao", "gamba", "langostino", "sardina", "mejillon",
            "pescado", "calamar", "sepia", "pulpo", "boqueron", "anchoa", "caballa", "trucha",
            "dorada", "lubina", "gallineta", "surimi", "marisco", "almeja", "berberecho", "bonito",
            "palitos", "abadejo", "rape", "emperador", "sardinilla", "chipiron", "poton", "almejon",
            "huevas", "tartar", "navaja", "zamburina", "pota", "melva", "ventresca",
        ),
        "Fruta y verdura" to listOf(
            "espinaca", "brocoli", "lechuga", "tomate", "manzana", "platano", "fruta", "verdura",
            "cebolla", "zanahoria", "pimiento", "calabacin", "berenjena", "pepino", "naranja", "limon",
            "mango", "pera", "melocoton", "fresa", "uva", "kiwi", "aguacate", "champinon", "seta",
            "ensalada", "patata", "coliflor", "puerro", "ajo", "hortaliza", "melon", "sandia", "pina",
            "mandarina", "arandano", "frambuesa", "cereza", "ciruela", "canonigo", "rucula", "brotes",
            "esparrago", "alcachofa", "judias verdes", "guisantes", "maiz", "acelga", "col", "kale",
            "remolacha", "boniato", "calabaza",
        ),
        "Legumbres" to listOf("lenteja", "garbanzo", "alubia", "judia", "legumbre", "hummus", "soja", "edamame"),
        "Pasta, arroz y cereales" to listOf(
            "cereal", "avena", "pasta", "arroz", "macarron", "espagueti", "spaghetti", "fideo", "pan",
            "harina", "muesli", "granola", "tortita", "cuscus", "quinoa", "tallarin", "lasana",
            "ravioli", "tortellini", "copos", "espiral", "penne", "tostada", "biscote", "panecillo",
            "baguette", "mollete", "wrap", "helices", "maccheroni", "noodles", "ramen", "cous", "couscous",
            "gnocchi", "fusilli", "tagliatelle", "risotto",
        ),
        "Frutos secos" to listOf(
            "almendra", "nuez", "nueces", "cacahuete", "anacardo", "pistacho", "avellana", "frutos secos",
            "pipas", "pasas", "datil", "orejones", "coctel", "cocktail", "semillas", "mix",
        ),
        "Dulces y snacks" to listOf(
            "chocolate", "galleta", "snack", "patatas fritas", "chips", "nachos", "palomitas", "croissant",
            "napolitana", "bolleria", "magdalena", "bizcocho", "pudding", "mousse", "helado", "caramelo",
            "golosina", "gominola", "nubes", "turron", "barrita", "crema de cacao", "cacao", "donut",
            "palmera", "gofre", "tarta", "brownie", "cookie", "mermelada", "miel", "bombon",
        ),
        "Platos preparados" to listOf(
            "pizza", "tortilla", "croqueta", "empanadilla", "empanada", "sopa", "caldo", "crema de",
            "gazpacho", "salmorejo", "nuggets", "rollitos", "preparado", "plato", "pure", "canelones",
            "paella", "fajitas", "burrito", "sandwich",
        ),
        "Bebidas" to listOf(
            "bebida", "zumo", "refresco", "agua", "cafe", "infusion", "smoothie", "cerveza", "vino",
            "isotonica", "horchata", "kombucha", "nectar", "tonica", "cola",
        ),
        "Aceite, salsas y especias" to listOf(
            "aceite", "salsa", "mayonesa", "ketchup", "mostaza", "vinagre", "especia", "sal", "azucar",
            "pimienta", "oregano", "tomate frito", "levadura", "edulcorante", "bechamel",
        ),
        "Mascotas" to listOf("gato", "gatos", "perro", "perros", "mascota", "felino", "canino"),
    )

    val TODAS: List<String> = CATEGORIAS.map { it.first } + OTROS

    // Las de varias palabras van aparte: se buscan en el nombre seguido.
    private val FRASES = CATEGORIAS.flatMap { (cat, claves) -> claves.filter { ' ' in it }.map { it to cat } }
    private val PALABRAS = CATEGORIAS.flatMap { (cat, claves) -> claves.filterNot { ' ' in it }.map { it to cat } }
    private val MASCOTAS = CATEGORIAS.first { it.first == "Mascotas" }.second.toSet()

    fun de(p: Product): String {
        val palabras = Busqueda.palabras(p.name)
        if (palabras.any { it in MASCOTAS }) return "Mascotas"

        // Donde empieza cada coincidencia, y gana la que antes aparezca.
        var mejorPosicion = Int.MAX_VALUE
        var mejor = OTROS
        val texto = palabras.joinToString(" ")
        for ((frase, cat) in FRASES) {
            val i = (" $texto ").indexOf(" $frase ")
            if (i >= 0) {
                val posicion = texto.substring(0, i).count { it == ' ' }
                if (posicion < mejorPosicion) { mejorPosicion = posicion; mejor = cat }
            }
        }
        palabras.forEachIndexed { i, palabra ->
            if (i >= mejorPosicion) return mejor
            val cat = PALABRAS.firstOrNull { (clave, _) -> encaja(palabra, clave) }?.second
            if (cat != null) return cat
        }
        return mejor
    }

    /**
     * "yogures" encaja con "yogur" y "chocolatina" con "chocolate"; pero "pan"
     * no encaja con "panceta" ni "tarta" con "tartar": empezar igual solo vale
     * con claves largas.
     */
    private fun encaja(palabra: String, clave: String): Boolean =
        palabra == clave || palabra == clave + "s" || palabra == clave + "es" ||
            (clave.length >= 7 && palabra.startsWith(clave))
}
