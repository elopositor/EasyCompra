package com.easycompra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import java.util.Locale

const val VERSION_APP = "v7"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme()) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Pantalla()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla(vm: MainViewModel = viewModel()) {
    val s by vm.state.collectAsState()
    var ajustesAbiertos by remember { mutableStateOf(false) }

    val visibles = remember(s.productos, s.busqueda, s.orden, s.sinNata) { vm.filtrar(s) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EasyCompra $VERSION_APP") },
                actions = {
                    IconButton(onClick = { vm.cargar() }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Recargar")
                    }
                    IconButton(onClick = { ajustesAbiertos = true }) {
                        Icon(Icons.Default.Settings, contentDescription = "Ajustes")
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
        ) {
            OutlinedTextField(
                value = s.busqueda,
                onValueChange = vm::setBusqueda,
                label = { Text("Buscar producto") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp),
            )

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                MainViewModel.SUPERMERCADOS.forEach { sm ->
                    FilterChip(
                        selected = s.supermercado == sm,
                        onClick = { vm.setSupermercado(sm) },
                        label = { Text(sm ?: "Todos") },
                    )
                }
            }

            Spacer(Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Orden.values().forEach { o ->
                    FilterChip(
                        selected = s.orden == o,
                        onClick = { vm.setOrden(o) },
                        label = { Text(o.etiqueta) },
                    )
                }
                FilterChip(
                    selected = s.sinNata,
                    onClick = { vm.setSinNata(!s.sinNata) },
                    label = { Text("Sin nata") },
                )
            }

            Spacer(Modifier.height(6.dp))

            when {
                s.cargando -> Caja { CircularProgressIndicator() }

                s.error != null -> Caja {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            s.error ?: "",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 24.dp),
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(s.servidor, fontSize = 12.sp, color = Color.Gray)
                        Spacer(Modifier.height(12.dp))
                        Button(onClick = { vm.cargar() }) { Text("Reintentar") }
                        TextButton(onClick = { ajustesAbiertos = true }) { Text("Cambiar servidor") }
                    }
                }

                visibles.isEmpty() -> Caja { Text("Sin resultados") }

                else -> {
                    if (s.aviso != null) {
                        Text(
                            s.aviso,
                            fontSize = 12.sp,
                            color = Color(0xFF8A5A00),
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        )
                    }
                    Text(
                        listOfNotNull(
                            "${visibles.size} productos",
                            fechaCorta(s.actualizado)?.let { "datos del $it" },
                        ).joinToString(" - "),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
                    )
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(visibles) { p -> Tarjeta(p) }
                    }
                }
            }
        }
    }

    if (ajustesAbiertos) {
        var url by remember { mutableStateOf(s.servidor) }
        var origen by remember { mutableStateOf(s.origen) }
        AlertDialog(
            onDismissRequest = { ajustesAbiertos = false },
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
            confirmButton = {
                TextButton(onClick = {
                    vm.setServidor(url.trim())
                    vm.setOrigen(origen)
                    ajustesAbiertos = false
                }) { Text("Guardar") }
            },
            dismissButton = {
                TextButton(onClick = { ajustesAbiertos = false }) { Text("Cancelar") }
            },
        )
    }
}

/** "2026-08-29T19:55:14+00:00" -> "29/08". Null si no tiene esa forma. */
private fun fechaCorta(iso: String?): String? {
    val partes = iso?.take(10)?.split("-") ?: return null
    return if (partes.size == 3) "${partes[2]}/${partes[1]}" else null
}

@Composable
private fun Caja(contenido: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { contenido() }
}

@Composable
private fun Tarjeta(p: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = p.photo_url,
                contentDescription = null,
                modifier = Modifier.size(64.dp),
            )
            Spacer(Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    p.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                val cabecera = listOfNotNull(
                    p.supermarket.ifBlank { null },
                    p.brand?.ifBlank { null },
                ).joinToString(" - ")
                if (cabecera.isNotEmpty()) {
                    Text(cabecera, fontSize = 12.sp, color = Color.Gray)
                }
                val nutricion = buildList {
                    p.energy_kcal_100g?.let { add("${it.toInt()} kcal") }
                    p.sugars_100g?.let { add("azucar ${num(it)} g") }
                    p.proteins_100g?.let { add("prot ${num(it)} g") }
                }.joinToString(" - ")
                if (nutricion.isNotEmpty()) {
                    Text(nutricion, fontSize = 11.sp, color = Color.Gray)
                }
            }
            Spacer(Modifier.width(8.dp))
            Text(
                p.unit_price?.let { "${num(it)} EUR" } ?: "-",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
        }
    }
}

private fun num(v: Double): String =
    if (v == v.toInt().toDouble()) v.toInt().toString()
    else String.format(Locale.US, "%.2f", v)
