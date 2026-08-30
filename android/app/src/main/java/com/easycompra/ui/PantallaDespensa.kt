package com.easycompra.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easycompra.datos.Conversor
import com.easycompra.datos.DatosViewModel
import com.easycompra.datos.EstadoStock
import com.easycompra.datos.ProductoConUbicaciones
import com.easycompra.datos.UbicacionDespensa
import com.easycompra.datos.Vocabulario

@Composable
fun PantallaDespensa(vm: DatosViewModel, despensa: List<ProductoConUbicaciones>) {
    var anadiendo by remember { mutableStateOf(false) }
    var filtro by remember { mutableStateOf<String?>(null) }
    var busqueda by remember { mutableStateOf("") }

    val visibles = remember(despensa, filtro, busqueda) {
        despensa.filter { p ->
            val porUbicacion = filtro == null || p.ubicaciones.any { it.category == filtro }
            val porTexto = busqueda.isBlank() || p.producto.name.contains(busqueda.trim(), true)
            porUbicacion && porTexto
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { anadiendo = true }) {
                Icon(Icons.Default.Add, contentDescription = "Añadir a la despensa")
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            OutlinedTextField(
                value = busqueda,
                onValueChange = { busqueda = it },
                label = { Text("Buscar en la despensa") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp),
            )

            Row(
                Modifier.horizontalScrollable().padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                FilterChip(
                    selected = filtro == null,
                    onClick = { filtro = null },
                    label = { Text("Todo") },
                )
                Vocabulario.DESPENSA.keys.forEach { ubicacion ->
                    FilterChip(
                        selected = filtro == ubicacion,
                        onClick = { filtro = ubicacion },
                        label = { Text(ubicacion) },
                    )
                }
            }

            Spacer(Modifier.height(6.dp))

            if (visibles.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        if (despensa.isEmpty()) "Tu despensa está vacía.\nPulsa + para añadir lo que tengas en casa."
                        else "Nada que coincida.",
                        color = Color.Gray,
                    )
                }
            } else {
                LazyColumn(Modifier.fillMaxSize()) {
                    items(visibles, key = { it.producto.id }) { producto ->
                        TarjetaDespensa(vm, producto)
                    }
                }
            }
        }
    }

    if (anadiendo) {
        DialogoAnadirDespensa(
            onCerrar = { anadiendo = false },
            onGuardar = { nombre, cat, sub, cant, unidad, desc ->
                vm.anadirADespensa(nombre, cat, sub, cant, unidad, desc)
                anadiendo = false
            },
        )
    }
}

@Composable
private fun TarjetaDespensa(vm: DatosViewModel, item: ProductoConUbicaciones) {
    Card(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp)) {
        Column(Modifier.padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    item.producto.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    modifier = Modifier.weight(1f),
                )
                val (texto, color) = when (item.estado) {
                    EstadoStock.OK -> "Tienes" to Color(0xFF2E7D32)
                    EstadoStock.BAJO -> "Queda poco" to Color(0xFF8A5A00)
                    EstadoStock.VACIO -> "Se acabó" to Color(0xFFB3261E)
                }
                Text(texto, fontSize = 11.sp, color = color, fontWeight = FontWeight.Medium)
                IconButton(onClick = {
                    vm.marcarPorComprar(item.producto, !item.producto.needsToBuy)
                }) {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "Necesito comprar",
                        tint = if (item.producto.needsToBuy) MaterialTheme.colorScheme.primary
                        else Color.Gray,
                    )
                }
                IconButton(onClick = { vm.borrarDeDespensa(item.producto) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Borrar", tint = Color.Gray)
                }
            }

            item.ubicaciones.forEach { ubicacion ->
                FilaUbicacion(vm, ubicacion)
            }
        }
    }
}

@Composable
private fun FilaUbicacion(vm: DatosViewModel, ubicacion: UbicacionDespensa) {
    Row(
        Modifier.fillMaxWidth().padding(top = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1f)) {
            Text("${ubicacion.category} · ${ubicacion.subcategory}", fontSize = 12.sp, color = Color.Gray)
            if (ubicacion.description.isNotBlank()) {
                Text(ubicacion.description, fontSize = 11.sp, color = Color.Gray)
            }
        }
        IconButton(onClick = { vm.cambiarCantidad(ubicacion, ubicacion.quantity - 1f) }) {
            Icon(Icons.Default.Remove, contentDescription = "Quitar una")
        }
        Text(
            "${Conversor.formato(ubicacion.quantity)} ${ubicacion.unit}",
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
        )
        IconButton(onClick = { vm.cambiarCantidad(ubicacion, ubicacion.quantity + 1f) }) {
            Icon(Icons.Default.Add, contentDescription = "Añadir una")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DialogoAnadirDespensa(
    onCerrar: () -> Unit,
    onGuardar: (String, String, String, Float, String, String) -> Unit,
) {
    var nombre by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf(Vocabulario.DESPENSA.keys.first()) }
    var subcategoria by remember { mutableStateOf(Vocabulario.DESPENSA.values.first().first()) }
    var cantidad by remember { mutableStateOf("1") }
    var unidad by remember { mutableStateOf(Vocabulario.UNIDADES_DESPENSA.first()) }
    var descripcion by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onCerrar,
        title = { Text("Añadir a la despensa") },
        text = {
            Column(Modifier.heightIn(max = 420.dp).verticalScroll(rememberScrollState())) {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Producto") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(Modifier.height(10.dp))
                Text("¿Dónde está?", fontSize = 12.sp, color = Color.Gray)
                Row(
                    Modifier.horizontalScrollable(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Vocabulario.DESPENSA.keys.forEach { c ->
                        FilterChip(
                            selected = categoria == c,
                            onClick = {
                                categoria = c
                                subcategoria = Vocabulario.DESPENSA[c]?.first() ?: ""
                            },
                            label = { Text(c) },
                        )
                    }
                }

                Spacer(Modifier.height(6.dp))
                Row(
                    Modifier.horizontalScrollable(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Vocabulario.DESPENSA[categoria].orEmpty().forEach { s ->
                        FilterChip(
                            selected = subcategoria == s,
                            onClick = { subcategoria = s },
                            label = { Text(s) },
                        )
                    }
                }

                Spacer(Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    OutlinedTextField(
                        value = cantidad,
                        onValueChange = { cantidad = it.filter { c -> c.isDigit() || c == '.' || c == ',' } },
                        label = { Text("Cantidad") },
                        singleLine = true,
                        modifier = Modifier.width(110.dp),
                    )
                    Spacer(Modifier.width(8.dp))
                    Row(
                        Modifier.horizontalScrollable(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        Vocabulario.UNIDADES_DESPENSA.forEach { u ->
                            FilterChip(
                                selected = unidad == u,
                                onClick = { unidad = u },
                                label = { Text(u) },
                            )
                        }
                    }
                }

                Spacer(Modifier.height(10.dp))
                OutlinedTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    label = { Text("Nota (opcional)") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                val cant = cantidad.replace(',', '.').toFloatOrNull() ?: 1f
                onGuardar(nombre, categoria, subcategoria, cant, unidad, descripcion)
            }) { Text("Guardar") }
        },
        dismissButton = { TextButton(onClick = onCerrar) { Text("Cancelar") } },
    )
}
