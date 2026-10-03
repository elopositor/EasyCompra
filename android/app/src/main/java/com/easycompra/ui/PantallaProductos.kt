package com.easycompra.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.easycompra.MainViewModel
import com.easycompra.Orden
import com.easycompra.Origen
import com.easycompra.Product
import com.easycompra.clave
import android.widget.Toast
import java.util.Locale

/**
 * [estadoLista] y [vistoId] vienen de fuera para que sobrevivan al ir al
 * detalle y volver: asi la lista sigue donde se dejo.
 */
@Composable
fun PantallaProductos(
    vm: MainViewModel,
    estadoLista: LazyListState,
    vistoId: Int,
    onVisto: (Int) -> Unit,
    onAbrir: (Product) -> Unit,
    onAnadirALista: (Product) -> Unit,
) {
    val s by vm.state.collectAsState()
    val contexto = LocalContext.current
    // Al volver del detalle con una busqueda puesta, la barra sigue abierta:
    // si no, la lista quedaria filtrada sin que se viera por que.
    var buscando by remember { mutableStateOf(s.busqueda.isNotEmpty()) }
    var ajustesAbiertos by remember { mutableStateOf(false) }

    // Atras con la busqueda abierta la cierra, no sale de la app.
    BackHandler(enabled = buscando) {
        buscando = false
        vm.setBusqueda("")
    }

    // Se ha cambiado un filtro o la busqueda: arriba, para ver los resultados
    // desde el primero. Al volver del detalle el id es el mismo y no se mueve.
    LaunchedEffect(s.resultadoId) {
        if (s.resultadoId != vistoId) {
            runCatching { estadoLista.scrollToItem(0) }
            onVisto(s.resultadoId)
        }
    }

    Column(Modifier.fillMaxSize()) {
        if (buscando) {
            BarraBusqueda(
                texto = s.busqueda,
                onTexto = vm::setBusqueda,
                onCerrar = {
                    buscando = false
                    vm.setBusqueda("")
                },
            )
        } else {
            BarraVerde(
                titulo = "EasyCompra",
                acciones = {
                    IconButton(onClick = { vm.cargar(forzar = true) }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Sincronizar")
                    }
                    IconButton(onClick = { buscando = true }) {
                        Icon(Icons.Default.Search, contentDescription = "Buscar")
                    }
                    MenuAjustes(onAjustes = { ajustesAbiertos = true })
                },
            )
        }

        Filtros(vm, s)

        when {
            s.cargando && s.visibles.isEmpty() -> Caja { CircularProgressIndicator() }

            s.error != null && s.visibles.isEmpty() -> Caja {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        s.error ?: "",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 24.dp),
                    )
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = { vm.cargar() }) { Text("Reintentar") }
                    TextButton(onClick = { ajustesAbiertos = true }) { Text("Ajustes") }
                }
            }

            s.visibles.isEmpty() -> Caja {
                Text(
                    if (s.busqueda.isNotBlank()) "Nada parecido a \"${s.busqueda.trim()}\""
                    else "Sin resultados.\nPulsa 🔄 para sincronizar.",
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 24.dp),
                )
            }

            else -> {
                Avisos(s)
                LazyColumn(state = estadoLista, modifier = Modifier.fillMaxSize()) {
                    // Con clave estable, al filtrar se reutilizan las filas
                    // que ya estaban en pantalla en vez de rehacerlas todas.
                    items(s.visibles, key = { clave(it) }) { p ->
                        val favorito = clave(p) in s.favoritos
                        TarjetaProducto(
                            p = p,
                            orden = s.orden,
                            favorito = favorito,
                            onClick = { onAbrir(p) },
                            onAnadirALista = {
                                onAnadirALista(p)
                                Toast.makeText(contexto, "Añadido a Mi lista", Toast.LENGTH_SHORT).show()
                            },
                            onFavorito = {
                                vm.alternarFavorito(p)
                                Toast.makeText(
                                    contexto,
                                    if (favorito) "Quitado de favoritos" else "Guardado en favoritos",
                                    Toast.LENGTH_SHORT,
                                ).show()
                            },
                        )
                    }
                }
            }
        }
    }

    if (ajustesAbiertos) {
        DialogoAjustes(
            origenActual = s.origen,
            servidorActual = s.servidor,
            onCerrar = { ajustesAbiertos = false },
            onGuardar = { origen, url ->
                vm.setServidor(url)
                vm.setOrigen(origen)
                ajustesAbiertos = false
            },
        )
    }
}

/** La barra verde convertida en buscador. El campo va en el titulo. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BarraBusqueda(texto: String, onTexto: (String) -> Unit, onCerrar: () -> Unit) {
    val foco = remember { FocusRequester() }
    val teclado = LocalSoftwareKeyboardController.current

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onCerrar) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Cerrar busqueda")
            }
        },
        title = {
            TextField(
                value = texto,
                onValueChange = onTexto,
                placeholder = { Text("Buscar producto...", color = Color.White.copy(alpha = 0.7f)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { teclado?.hide() }),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White.copy(alpha = 0.5f),
                ),
                modifier = Modifier.fillMaxWidth().focusRequester(foco),
            )
        },
        actions = {
            if (texto.isNotEmpty()) {
                IconButton(onClick = { onTexto("") }) {
                    Icon(Icons.Default.Clear, contentDescription = "Borrar busqueda")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Colores.Verde,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
    )

    // Teclado abierto al entrar a buscar, no al volver con la busqueda hecha.
    // Si el campo aun no esta listo, no pasa nada: se toca y ya.
    LaunchedEffect(Unit) { if (texto.isEmpty()) runCatching { foco.requestFocus() } }
}

@Composable
private fun MenuAjustes(onAjustes: () -> Unit) {
    var abierto by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { abierto = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Mas opciones")
        }
        DropdownMenu(expanded = abierto, onDismissRequest = { abierto = false }) {
            DropdownMenuItem(
                text = { Text("Origen de los datos") },
                onClick = {
                    abierto = false
                    onAjustes()
                },
            )
        }
    }
}

@Composable
private fun Filtros(vm: MainViewModel, s: com.easycompra.UiState) {
    Column(Modifier.padding(top = 8.dp)) {
        // Supermercados: se pueden marcar varios. Ninguno marcado = Todos.
        Row(
            Modifier.horizontalScrollable().padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            FilterChip(
                selected = s.supermercados.isEmpty(),
                onClick = { vm.setSupermercado(null) },
                label = { Text("Todos") },
            )
            MainViewModel.SUPERMERCADOS.filterNotNull().forEach { sm ->
                FilterChip(
                    selected = sm in s.supermercados,
                    onClick = { vm.setSupermercado(sm) },
                    label = { Text(sm) },
                )
            }
            FilterChip(
                selected = s.soloFavoritos,
                onClick = { vm.setSoloFavoritos(!s.soloFavoritos) },
                leadingIcon = { Icon(Icons.Default.Favorite, contentDescription = null, Modifier.size(16.dp)) },
                label = { Text("Favoritos") },
            )
        }

        if (s.categorias.isNotEmpty()) {
            Row(
                Modifier.horizontalScrollable().padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                FilterChip(
                    selected = s.categoria == null,
                    onClick = { vm.setCategoria(null) },
                    label = { Text("Todas") },
                )
                s.categorias.forEach { c ->
                    FilterChip(
                        selected = s.categoria == c,
                        onClick = { vm.setCategoria(if (s.categoria == c) null else c) },
                        label = { Text(c) },
                    )
                }
            }
        }

        // Pulsar la pestana que ya esta elegida invierte el orden; la flecha
        // dice en que sentido va.
        val indice = Orden.entries.indexOf(s.orden)
        val deMenorAMayor = s.orden.deMenorAMayor != s.invertido
        ScrollableTabRow(
            selectedTabIndex = indice,
            containerColor = Colores.Fondo,
            contentColor = Colores.Verde,
            edgePadding = 12.dp,
            indicator = { posiciones ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(posiciones[indice]),
                    color = Colores.Verde,
                )
            },
        ) {
            Orden.entries.forEach { o ->
                Tab(
                    selected = s.orden == o,
                    onClick = { vm.setOrden(o) },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(o.etiqueta, fontSize = 15.sp)
                            if (s.orden == o) {
                                Spacer(Modifier.width(4.dp))
                                Icon(
                                    if (deMenorAMayor) Icons.Default.ArrowUpward else Icons.Default.ArrowDownward,
                                    contentDescription = if (deMenorAMayor) "de menor a mayor" else "de mayor a menor",
                                    modifier = Modifier.size(16.dp),
                                )
                            }
                        }
                    },
                    selectedContentColor = Colores.Verde,
                    unselectedContentColor = Colores.Verde,
                )
            }
        }
    }
}

@Composable
private fun Avisos(s: com.easycompra.UiState) {
    val avisos = listOfNotNull(
        s.aviso,
        if (s.aproximado) "No hay nada con \"${s.busqueda.trim()}\". Lo más parecido:" else null,
    )
    avisos.forEach {
        Text(
            it,
            fontSize = 12.sp,
            color = Color(0xFF8A5A00),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
        )
    }
    Text(
        listOfNotNull(
            "${s.visibles.size} productos",
            fechaCorta(s.actualizado)?.let { "datos del $it" },
        ).joinToString(" · "),
        fontSize = 12.sp,
        color = Color.Gray,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
    )
}

/** Tocar abre el detalle; mantener pulsado, el menu de lista y favoritos. */
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TarjetaProducto(
    p: Product,
    orden: Orden,
    favorito: Boolean,
    onClick: () -> Unit,
    onAnadirALista: () -> Unit,
    onFavorito: () -> Unit,
) {
    var menu by remember { mutableStateOf(false) }
    val vibracion = LocalHapticFeedback.current

    Box(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .combinedClickable(
                        onClick = onClick,
                        onLongClick = {
                            vibracion.performHapticFeedback(HapticFeedbackType.LongPress)
                            menu = true
                        },
                        onLongClickLabel = "Añadir a Mi lista o a favoritos",
                    )
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                FotoProducto(p.photo_url, Modifier.size(88.dp))
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (p.supermarket.isNotBlank()) EtiquetaSupermercado(p.supermarket)
                        Spacer(Modifier.weight(1f))
                        if (favorito) {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Favorito",
                                tint = Colores.Verde,
                                modifier = Modifier.size(20.dp),
                            )
                        }
                    }
                    Spacer(Modifier.height(6.dp))
                    Text(
                        p.name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            p.unit_price?.let { euros(it) } ?: "—",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Colores.Verde,
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(dato(p, orden), fontSize = 14.sp, color = Color.Gray)
                    }
                }
            }
        }

        DropdownMenu(expanded = menu, onDismissRequest = { menu = false }) {
            DropdownMenuItem(
                text = { Text("Añadir a Mi lista") },
                leadingIcon = { Icon(Icons.Default.ShoppingCart, contentDescription = null, tint = Colores.Verde) },
                onClick = {
                    menu = false
                    onAnadirALista()
                },
            )
            DropdownMenuItem(
                text = { Text(if (favorito) "Quitar de favoritos" else "Guardar en favoritos") },
                leadingIcon = {
                    Icon(
                        if (favorito) Icons.Default.FavoriteBorder else Icons.Default.Favorite,
                        contentDescription = null,
                        tint = Colores.Verde,
                    )
                },
                onClick = {
                    menu = false
                    onFavorito()
                },
            )
        }
    }
}

/** Lo que se ensena junto al precio, segun la pestana de orden. */
private fun dato(p: Product, orden: Orden): String = when (orden) {
    Orden.AZUCARES -> p.sugars_100g?.let { "${decimal(it, 1)} g az." } ?: "— g az."
    Orden.CALORIAS -> p.energy_kcal_100g?.let { "${decimal(it, 0)} kcal" } ?: "— kcal"
    Orden.GRASAS -> p.fat_100g?.let { "${decimal(it, 1)} g grasas" } ?: "— g grasas"
    Orden.PROTEINAS -> p.proteins_100g?.let { "${decimal(it, 1)} g prot." } ?: "— g prot."
    Orden.PRECIO -> precioReferencia(p) ?: ""
}

@Composable
fun FotoProducto(url: String?, modifier: Modifier) {
    AsyncImage(
        // Mercadona sirve sus fotos a 3600x3600: se pide el tamano justo.
        model = ImageRequest.Builder(LocalContext.current)
            .data(fotoPequena(url))
            .size(300)
            .crossfade(false)
            .build(),
        contentDescription = null,
        modifier = modifier,
    )
}

@Composable
private fun Caja(contenido: @Composable () -> Unit) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { contenido() }
}

@Composable
private fun DialogoAjustes(
    origenActual: Origen,
    servidorActual: String,
    onCerrar: () -> Unit,
    onGuardar: (Origen, String) -> Unit,
) {
    var url by remember { mutableStateOf(servidorActual) }
    var origen by remember { mutableStateOf(origenActual) }
    AlertDialog(
        onDismissRequest = onCerrar,
        title = { Text("Origen de los datos") },
        text = {
            Column {
                FilterChip(
                    selected = origen == Origen.GITHUB,
                    onClick = { origen = Origen.GITHUB },
                    label = { Text("Internet (recomendado)") },
                )
                Text(
                    "Descarga los datos publicados cada dia. No hace falta " +
                        "tener el ordenador encendido.",
                    fontSize = 11.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp, bottom = 10.dp),
                )
                FilterChip(
                    selected = origen == Origen.SERVIDOR,
                    onClick = { origen = Origen.SERVIDOR },
                    label = { Text("Servidor propio") },
                )
                Text(
                    "Solo si tienes el backend arrancado en casa.",
                    fontSize = 11.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp),
                )
                if (origen == Origen.SERVIDOR) {
                    Spacer(Modifier.height(6.dp))
                    OutlinedTextField(
                        value = url,
                        onValueChange = { url = it },
                        singleLine = true,
                        label = { Text("Direccion") },
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        },
        confirmButton = { TextButton(onClick = { onGuardar(origen, url.trim()) }) { Text("Guardar") } },
        dismissButton = { TextButton(onClick = onCerrar) { Text("Cancelar") } },
    )
}

private val ES = Locale.forLanguageTag("es-ES")

fun decimal(v: Double, decimales: Int): String = String.format(ES, "%.${decimales}f", v)

/** 4.19 -> "4,19 €" */
fun euros(v: Double): String = "${decimal(v, 2)} €"

/** "7,50 €/kg", si el supermercado da precio de referencia. */
fun precioReferencia(p: Product): String? {
    val precio = p.reference_price ?: return null
    val unidad = unidadReferencia(p) ?: return euros(precio)
    return "${euros(precio)}/$unidad"
}

/** Cada supermercado lo escribe a su manera: "KILO", "kg", "LITRO"... */
fun unidadReferencia(p: Product): String? {
    val u = p.reference_format?.trim()?.lowercase()?.ifBlank { null } ?: return null
    return when (u) {
        "kilo", "kilos", "kilogramo", "kg" -> "kg"
        "litro", "litros", "l", "lt" -> "l"
        "unidad", "unidades", "ud", "uds", "u" -> "ud"
        "docena" -> "docena"
        else -> u
    }
}

/** "2026-08-29T19:55:14+00:00" -> "29/08". Null si no tiene esa forma. */
private fun fechaCorta(iso: String?): String? {
    val partes = iso?.take(10)?.split("-") ?: return null
    return if (partes.size == 3) "${partes[2]}/${partes[1]}" else null
}

private val TAMANO_EN_URL = Regex("([?&])(w|h|width|height)=\\d+")

/** Baja el tamano que se pide en la URL de la foto, si la fuente lo admite. */
private fun fotoPequena(url: String?): String? = url?.replace(TAMANO_EN_URL) {
    "${it.groupValues[1]}${it.groupValues[2]}=300"
}
