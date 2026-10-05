package com.easycompra

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.easycompra.datos.DatosViewModel
import com.easycompra.ui.Colores
import com.easycompra.ui.PantallaCiudad
import com.easycompra.ui.PantallaDespensa
import com.easycompra.ui.PantallaDetalle
import com.easycompra.ui.PantallaLista
import com.easycompra.ui.PantallaPlan
import com.easycompra.ui.PantallaProductos
import com.easycompra.ui.PantallaRecetas
import com.easycompra.ui.TemaEasyCompra

const val VERSION_APP = "v17"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Antes de nada: si la app se cierra, que quede registrado por que.
        RegistroFallos.instalar(this)
        super.onCreate(savedInstanceState)
        setContent {
            TemaEasyCompra { AppEasyCompra() }
        }
    }
}

/** Las cinco secciones de la v5, en su mismo orden. */
private enum class Seccion(val etiqueta: String, val icono: ImageVector) {
    PRODUCTOS("Productos", Icons.Default.Home),
    LISTA("Mi lista", Icons.Default.ShoppingCart),
    DESPENSA("Despensa", Icons.Default.Kitchen),
    RECETAS("Recetas", Icons.AutoMirrored.Filled.MenuBook),
    SEMANA("Semana", Icons.Default.CalendarMonth),
}

@Composable
fun AppEasyCompra() {
    var seccion by remember { mutableStateOf(Seccion.PRODUCTOS) }
    var detalle by remember { mutableStateOf<Product?>(null) }

    // Aqui y no dentro de Productos: al abrir un producto esa pantalla se va,
    // y al volver la lista tiene que seguir por donde estaba.
    val estadoListaProductos = rememberLazyListState()
    var resultadoVisto by rememberSaveable { mutableIntStateOf(-1) }

    val catalogo: MainViewModel = viewModel()
    val datos: DatosViewModel = viewModel()
    val contexto = LocalContext.current
    var informeFallo by remember { mutableStateOf(RegistroFallos.leer(contexto)) }

    val estado by catalogo.state.collectAsState()
    val despensa by datos.despensa.collectAsState()
    val recetas by datos.recetas.collectAsState()
    val plan by datos.plan.collectAsState()
    val lista by datos.lista.collectAsState()
    val listaProductos by datos.listaProductos.collectAsState()

    val enLista = listaProductos.size + lista.count { !it.comprado }

    // Atras desde el detalle vuelve a la lista de productos.
    BackHandler(enabled = detalle != null) { detalle = null }

    // Primera vez: antes que nada, la ciudad. Se recuerda para las siguientes.
    if (estado.ciudad == null) {
        PantallaCiudad(onElegir = { catalogo.setCiudad(it) })
        return
    }

    Scaffold(
        containerColor = Colores.Fondo,
        bottomBar = {
            NavigationBar {
                Seccion.entries.forEach { s ->
                    NavigationBarItem(
                        selected = seccion == s,
                        onClick = {
                            seccion = s
                            detalle = null
                        },
                        icon = {
                            if (s == Seccion.LISTA && enLista > 0) {
                                BadgedBox(badge = { Badge { Text("$enLista") } }) {
                                    Icon(s.icono, contentDescription = s.etiqueta)
                                }
                            } else {
                                Icon(s.icono, contentDescription = s.etiqueta)
                            }
                        },
                        // En una linea aunque la pantalla sea estrecha: "Productos", no "Product-os".
                        label = { Text(s.etiqueta, fontSize = 12.sp, maxLines = 1, softWrap = false) },
                    )
                }
            }
        },
    ) { padding ->
        Box(Modifier.padding(padding).fillMaxSize()) {
            val abierto = detalle
            when {
                seccion == Seccion.PRODUCTOS && abierto != null -> PantallaDetalle(
                    p = abierto,
                    esFavorito = clave(abierto) in estado.favoritos,
                    onVolver = { detalle = null },
                    onAnadirALista = { datos.anadirProducto(abierto) },
                    onFavorito = { catalogo.alternarFavorito(abierto) },
                )
                seccion == Seccion.PRODUCTOS -> PantallaProductos(
                    vm = catalogo,
                    estadoLista = estadoListaProductos,
                    vistoId = resultadoVisto,
                    onVisto = { resultadoVisto = it },
                    onAbrir = { detalle = it },
                    onAnadirALista = { datos.anadirProducto(it) },
                )
                seccion == Seccion.LISTA -> PantallaLista(datos, lista, listaProductos)
                seccion == Seccion.DESPENSA -> PantallaDespensa(datos, despensa)
                seccion == Seccion.RECETAS -> PantallaRecetas(datos, recetas, despensa)
                else -> PantallaPlan(datos, plan, recetas)
            }
        }
    }

    // Informe del ultimo cierre inesperado, si lo hubo.
    val informe = informeFallo
    if (informe != null) {
        AlertDialog(
            onDismissRequest = { informeFallo = null },
            title = { Text("La app se cerró la última vez") },
            text = {
                Column(
                    modifier = Modifier
                        .heightIn(max = 320.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(informe, fontSize = 11.sp)
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    val envio = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_SUBJECT, "EasyCompra: informe de cierre")
                        putExtra(Intent.EXTRA_TEXT, informe)
                    }
                    runCatching {
                        contexto.startActivity(Intent.createChooser(envio, "Enviar informe"))
                    }
                }) { Text("Enviar") }
            },
            dismissButton = {
                TextButton(onClick = {
                    RegistroFallos.borrar(contexto)
                    informeFallo = null
                }) { Text("Descartar") }
            },
        )
    }
}
