package com.easycompra

import java.text.Normalizer

/**
 * Buscador de productos tolerante a como escribe la gente.
 *
 * Encuentra "Yogur Griego" escribiendo "yogures griegos", "YOGUR", "griego"
 * o "yougur": no distingue mayusculas ni acentos (tampoco la ñ), entiende
 * singulares y plurales, encuentra trozos de palabra ("desnatada" dentro de
 * "semidesnatada") y, si nada coincide, admite una o dos letras mal puestas.
 *
 * Las palabras parecidas solo se usan cuando no hay ninguna coincidencia
 * buena: si no, buscar "leche" traeria tambien las lechugas.
 *
 * Es Kotlin puro, sin nada de Android, para poder probarlo con tests.
 */
object Busqueda {

    /** Un producto con sus palabras ya normalizadas, preparado para buscar. */
    class Entrada(val producto: Product, val palabras: Set<String>)

    class Resultado(
        val productos: List<Product>,
        /** true = no habia coincidencias buenas y se muestran las parecidas. */
        val aproximado: Boolean,
    )

    private val DIACRITICOS = Regex("\\p{Mn}+")
    private val SEPARADORES = Regex("[^a-z0-9]+")

    /** "Yogur Griego, 0% M.G." -> ["yogur", "griego", "0", "m", "g"] */
    fun palabras(texto: String?): List<String> {
        if (texto.isNullOrBlank()) return emptyList()
        val sinAcentos = Normalizer.normalize(texto.lowercase(), Normalizer.Form.NFD)
            .replace(DIACRITICOS, "")
        return sinAcentos.split(SEPARADORES).filter { it.isNotEmpty() }
    }

    /**
     * Posibles singulares de lo buscado: "leches" -> "leche", "yogures" ->
     * "yogur". Deben coincidir con una palabra entera: "lech" no puede traer
     * las lechugas.
     */
    fun singulares(palabra: String): List<String> = buildList {
        if (palabra.length > 3 && palabra.endsWith("s")) add(palabra.dropLast(1))
        if (palabra.length > 4 && palabra.endsWith("es")) add(palabra.dropLast(2))
    }

    /** Se calcula una vez por catalogo, no en cada busqueda. */
    fun indexar(productos: List<Product>): List<Entrada> = productos.map { p ->
        Entrada(p, (palabras(p.name) + palabras(p.brand) + palabras(p.supermarket)).toSet())
    }

    /**
     * Devuelve los productos en grupos, cada uno ordenado con [orden]: primero
     * los que tienen la palabra exacta (o su singular), luego los que tienen
     * una palabra que empieza asi ("sal" -> "salmon") y despues los que solo la
     * contienen ("pollo" dentro de "repollo"). Si no hay ninguno, los
     * parecidos, de mas a menos.
     */
    fun buscar(entradas: List<Entrada>, consulta: String, orden: Comparator<Product>): Resultado {
        val terminos = palabras(consulta)
        if (terminos.isEmpty()) {
            return Resultado(entradas.map { it.producto }.sortedWith(orden), aproximado = false)
        }

        // Cada palabra distinta del catalogo se compara una sola vez, no una
        // vez por producto: hay unas pocas miles frente a decenas de miles.
        val vocabulario = HashSet<String>()
        entradas.forEach { vocabulario.addAll(it.palabras) }

        val buenos = terminos.map { t -> vocabulario.nivelesPara(t) }
        val grupos = Array(3) { ArrayList<Product>() }
        for (e in entradas) {
            val nivel = peorNivel(e, buenos) ?: continue
            grupos[nivel] += e.producto
        }
        if (grupos.any { it.isNotEmpty() }) {
            return Resultado(grupos.flatMap { it.sortedWith(orden) }, aproximado = false)
        }

        // Ninguna coincidencia buena: se prueba con palabras parecidas.
        val parecidas = terminos.map { t -> vocabulario.parecidasA(t) }
        val encontrados = entradas.mapNotNull { e ->
            var total = 0
            for (porPalabra in parecidas) {
                total += e.palabras.minOfOrNull { porPalabra[it] ?: Int.MAX_VALUE }
                    ?.takeIf { it != Int.MAX_VALUE } ?: return@mapNotNull null
            }
            e.producto to total
        }
        val porParecido = compareBy<Pair<Product, Int>> { it.second }.thenBy(orden) { it.first }
        return Resultado(encontrados.sortedWith(porParecido).map { it.first }, aproximado = true)
    }

    private const val EXACTA = 0
    private const val AL_PRINCIPIO = 1
    private const val DENTRO = 2

    /** Para un termino, que palabras del catalogo coinciden y como de bien. */
    private fun Set<String>.nivelesPara(termino: String): Map<String, Int> {
        val singulares = singulares(termino)
        val niveles = HashMap<String, Int>()
        for (palabra in this) {
            when {
                palabra == termino || palabra in singulares -> niveles[palabra] = EXACTA
                palabra.startsWith(termino) -> niveles[palabra] = AL_PRINCIPIO
                termino.length >= 4 && palabra.contains(termino) -> niveles[palabra] = DENTRO
            }
        }
        return niveles
    }

    /**
     * Un producto vale si cada termino coincide con alguna de sus palabras; su
     * grupo lo marca el termino que peor coincide. Null si alguno no coincide.
     */
    private fun peorNivel(e: Entrada, niveles: List<Map<String, Int>>): Int? {
        var peor = EXACTA
        for (porPalabra in niveles) {
            val mejor = e.palabras.minOfOrNull { porPalabra[it] ?: Int.MAX_VALUE } ?: return null
            if (mejor == Int.MAX_VALUE) return null
            if (mejor > peor) peor = mejor
        }
        return peor
    }

    /** Palabras del catalogo que se parecen al termino, con las letras de diferencia. */
    private fun Set<String>.parecidasA(termino: String): Map<String, Int> {
        val maximo = when {
            termino.length < 3 -> return emptyMap()   // "te", "1l": demasiado cortas
            termino.length <= 5 -> 1
            else -> 2
        }
        val resultado = HashMap<String, Int>()
        for (palabra in this) {
            // Contra la palabra entera y contra su principio, para que valga
            // tambien lo que se esta escribiendo a medias ("yogr" -> "yogur").
            // Con tres letras solo palabras enteras: "atn" -> "atun", pero no
            // cualquier palabra que empiece parecido.
            var mejor = distancia(termino, palabra, maximo)
            if (termino.length > 3) {
                for (n in termino.length - 1..termino.length + 1) {
                    if (n in 1 until palabra.length) {
                        mejor = minOf(mejor, distancia(termino, palabra.take(n), maximo))
                    }
                }
            }
            if (mejor <= maximo) resultado[palabra] = mejor
        }
        return resultado
    }

    /**
     * Letras que hay que cambiar, poner, quitar o intercambiar para pasar de
     * una palabra a otra ("lehce" -> "leche" = 1). Deja de contar al pasar de
     * [tope]: solo interesa saber si se parecen.
     */
    fun distancia(a: String, b: String, tope: Int = Int.MAX_VALUE): Int {
        if (kotlin.math.abs(a.length - b.length) > tope) return tope + 1
        val d = Array(a.length + 1) { IntArray(b.length + 1) }
        for (i in 0..a.length) d[i][0] = i
        for (j in 0..b.length) d[0][j] = j
        for (i in 1..a.length) {
            var minFila = Int.MAX_VALUE
            for (j in 1..b.length) {
                val coste = if (a[i - 1] == b[j - 1]) 0 else 1
                var v = minOf(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + coste)
                if (i > 1 && j > 1 && a[i - 1] == b[j - 2] && a[i - 2] == b[j - 1]) {
                    v = minOf(v, d[i - 2][j - 2] + 1)
                }
                d[i][j] = v
                if (v < minFila) minFila = v
            }
            if (minFila > tope) return tope + 1
        }
        return d[a.length][b.length]
    }
}
