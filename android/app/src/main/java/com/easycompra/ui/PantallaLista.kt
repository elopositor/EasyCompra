package com.easycompra.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easycompra.datos.ArticuloLista
import com.easycompra.datos.DatosViewModel
import com.easycompra.datos.ItemCompra

private val AzulOscuro = Color(0xFF1A1A5E)

@Composable
fun PantallaLista(vm: DatosViewModel, articulos: List<ArticuloLista>, productos: List<ItemCompra>) {
    var confirmarVaciar by remember { mutableStateOf(false) }
    var nuevo by remember { mutableStateOf("") }

    val pendientes = articulos.filterNot { it.comprado }
    val comprados = articulos.filter { it.comprado }
    val deDespensa = pendientes.filter { it.origen == "despensa" }
    val deRecetas = pendientes.filter { it.origen.startsWith("receta") }
    val aMano = pendientes - deDespensa.toSet() - deRecetas.toSet()
    val total = productos.size + pendientes.size

    Column(Modifier.fillMaxSize().background(Colores.Fondo)) {
        BarraVerde(
            titulo = "Mi Lista",
            subtitulo = "$total ${if (total == 1) "elemento" else "elementos"}",
            acciones = {
                if (productos.isNotEmpty()) {
                    IconButton(onClick = { confirmarVaciar = true }) {
                        Icon(Icons.Default.DeleteSweep, contentDescription = "Vaciar lista de comparación")
                    }
                }
            },
        )

        LazyColumn(Modifier.fillMaxSize()) {
            if (total == 0) {
                item {
                    Text(
                        "Tu lista está vacía\n\nAñade productos desde el detalle, marca\n" +
                            "\"necesito comprar\" en tu Despensa\no cocina una Receta",
                        textAlign = TextAlign.Center,
                        color = Color.Gray,
                        modifier = Modifier.fillMaxWidth().padding(top = 48.dp, bottom = 24.dp),
                    )
                }
            }

            items(productos, key = { it.clave }) { item ->
                TarjetaItem(
                    item,
                    onCantidad = { vm.cambiarCantidad(item.clave, it) },
                )
            }
            if (productos.isNotEmpty()) {
                item { Resumen(productos) }
            }

            seccion("Desde tu Despensa", deDespensa, vm)
            seccion("Desde recetas", deRecetas, vm)
            seccion("Otros", aMano, vm)

            item {
                Row(
                    Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    OutlinedTextField(
                        value = nuevo,
                        onValueChange = { nuevo = it },
                        label = { Text("Añadir a mano") },
                        singleLine = true,
                        modifier = Modifier.weight(1f),
                    )
                    IconButton(onClick = {
                        vm.anadirALista(nuevo)
                        nuevo = ""
                    }) {
                        Icon(Icons.Default.Add, contentDescription = "Añadir", tint = Colores.Verde)
                    }
                }
            }

            if (comprados.isNotEmpty()) {
                item {
                    Row(
                        Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text("Ya en el carro", fontSize = 13.sp, color = Color.Gray, modifier = Modifier.weight(1f))
                        TextButton(onClick = { vm.vaciarComprados() }) {
                            Text("Quitar ${comprados.size}", fontSize = 12.sp)
                        }
                    }
                }
                items(comprados, key = { it.id }) { FilaArticulo(vm, it) }
            }
            item { Spacer(Modifier.height(24.dp)) }
        }
    }

    if (confirmarVaciar) {
        AlertDialog(
            onDismissRequest = { confirmarVaciar = false },
            title = { Text("Vaciar lista de comparación") },
            text = { Text("Se quitan los ${productos.size} productos con precio. Lo que viene de la despensa y de las recetas se queda.") },
            confirmButton = {
                TextButton(onClick = {
                    vm.vaciarListaProductos()
                    confirmarVaciar = false
                }) { Text("Vaciar") }
            },
            dismissButton = { TextButton(onClick = { confirmarVaciar = false }) { Text("Cancelar") } },
        )
    }
}

private fun androidx.compose.foundation.lazy.LazyListScope.seccion(
    titulo: String,
    articulos: List<ArticuloLista>,
    vm: DatosViewModel,
) {
    if (articulos.isEmpty()) return
    item(key = "titulo-$titulo") {
        Text(
            titulo,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Colores.Verde,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 4.dp),
        )
    }
    items(articulos, key = { it.id }) { FilaArticulo(vm, it) }
}

@Composable
private fun TarjetaItem(item: ItemCompra, onCantidad: (Int) -> Unit) {
    val p = item.producto
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 5.dp),
    ) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            FotoProducto(p.photo_url, Modifier.size(64.dp))
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                if (p.supermarket.isNotBlank()) EtiquetaSupermercado(p.supermarket)
                Spacer(Modifier.height(6.dp))
                Text(p.name, fontSize = 15.sp, fontWeight = FontWeight.Medium, maxLines = 2, overflow = TextOverflow.Ellipsis)
                Spacer(Modifier.height(4.dp))
                val precio = p.unit_price
                if (precio != null) {
                    Text(
                        "${euros(precio)} c/u" + if (item.cantidad > 1) "  ·  total ${euros(precio * item.cantidad)}" else "",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Colores.Verde,
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                FilledTonalIconButton(onClick = { onCantidad(item.cantidad - 1) }, modifier = Modifier.size(40.dp)) {
                    Icon(
                        if (item.cantidad > 1) Icons.Default.Remove else Icons.Default.Delete,
                        contentDescription = if (item.cantidad > 1) "Quitar uno" else "Eliminar",
                    )
                }
                Text(
                    "${item.cantidad}",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(28.dp),
                )
                FilledTonalIconButton(onClick = { onCantidad(item.cantidad + 1) }, modifier = Modifier.size(40.dp)) {
                    Icon(Icons.Default.Add, contentDescription = "Añadir uno")
                }
            }
        }
    }
}

/** Lo que cuesta la lista en cada supermercado, como en la v5. */
@Composable
private fun Resumen(productos: List<ItemCompra>) {
    val porSuper = productos.groupBy { it.producto.supermarket.ifBlank { "Otros" } }
        .mapValues { (_, items) -> items.sumOf { it.total ?: 0.0 } }
        .toSortedMap()
    val total = porSuper.values.sum()

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Colores.VerdeClaro),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 10.dp),
    ) {
        Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Resumen de costes estimado", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = AzulOscuro)
            porSuper.forEach { (sm, importe) ->
                Row(Modifier.fillMaxWidth()) {
                    Text(sm.replaceFirstChar { it.uppercase() }, fontSize = 17.sp, color = AzulOscuro, modifier = Modifier.weight(1f))
                    Text(euros(importe), fontSize = 17.sp, fontWeight = FontWeight.Bold, color = AzulOscuro)
                }
            }
            HorizontalDivider(color = AzulOscuro.copy(alpha = 0.2f))
            Row(Modifier.fillMaxWidth()) {
                Text("Total estimado", fontSize = 19.sp, fontWeight = FontWeight.Bold, color = AzulOscuro, modifier = Modifier.weight(1f))
                Text(euros(total), fontSize = 19.sp, fontWeight = FontWeight.Bold, color = AzulOscuro)
            }
            Text("* Precios orientativos. Pueden variar en tienda.", fontSize = 12.sp, color = AzulOscuro.copy(alpha = 0.7f))
        }
    }
}

@Composable
private fun FilaArticulo(vm: DatosViewModel, articulo: ArticuloLista) {
    Row(
        Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = articulo.comprado,
            onCheckedChange = { vm.marcarComprado(articulo.id, it) },
        )
        Column(Modifier.weight(1f)) {
            Text(
                articulo.nombre,
                fontSize = 15.sp,
                textDecoration = if (articulo.comprado) TextDecoration.LineThrough else null,
                color = if (articulo.comprado) Color.Gray else Color.Unspecified,
            )
            val detalle = listOfNotNull(
                articulo.cantidad.ifBlank { null },
                articulo.origen.takeIf { it.startsWith("receta: ") }?.removePrefix("receta: "),
            ).joinToString(" · ")
            if (detalle.isNotEmpty()) {
                Text(detalle, fontSize = 12.sp, color = Color.Gray)
            }
        }
        IconButton(onClick = { vm.borrarDeLista(articulo.id) }) {
            Icon(Icons.Default.Delete, contentDescription = "Quitar", tint = Color.Gray)
        }
    }
}
