package com.easycompra.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easycompra.datos.ArticuloLista
import com.easycompra.datos.DatosViewModel

@Composable
fun PantallaLista(vm: DatosViewModel, articulos: List<ArticuloLista>) {
    var nuevo by remember { mutableStateOf("") }

    val pendientes = articulos.filterNot { it.comprado }
    val comprados = articulos.filter { it.comprado }

    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedTextField(
                value = nuevo,
                onValueChange = { nuevo = it },
                label = { Text("Añadir a la lista") },
                singleLine = true,
                modifier = Modifier.weight(1f),
            )
            IconButton(onClick = {
                vm.anadirALista(nuevo)
                nuevo = ""
            }) {
                Icon(Icons.Default.Add, contentDescription = "Añadir")
            }
        }

        if (articulos.isEmpty()) {
            Vacio("La lista está vacía.\n\nSe llena sola desde la despensa (con el carrito)\ny desde las recetas (\"Comprar lo que falta\").")
            return@Column
        }

        Row(
            Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "${pendientes.size} por comprar",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.weight(1f),
            )
            if (comprados.isNotEmpty()) {
                TextButton(onClick = { vm.vaciarComprados() }) {
                    Text("Quitar ${comprados.size} comprados", fontSize = 12.sp)
                }
            }
        }

        LazyColumn(Modifier.fillMaxSize()) {
            items(pendientes, key = { it.id }) { FilaArticulo(vm, it) }
            if (comprados.isNotEmpty()) {
                item {
                    Text(
                        "Ya en el carro",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    )
                }
            }
            items(comprados, key = { it.id }) { FilaArticulo(vm, it) }
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
                fontSize = 14.sp,
                textDecoration = if (articulo.comprado) TextDecoration.LineThrough else null,
                color = if (articulo.comprado) Color.Gray else Color.Unspecified,
            )
            val detalle = listOfNotNull(
                articulo.cantidad.ifBlank { null },
                articulo.origen.takeIf { it != "manual" },
            ).joinToString(" · ")
            if (detalle.isNotEmpty()) {
                Text(detalle, fontSize = 11.sp, color = Color.Gray)
            }
        }
        IconButton(onClick = { vm.borrarDeLista(articulo.id) }) {
            Icon(Icons.Default.Delete, contentDescription = "Quitar", tint = Color.Gray)
        }
    }
}
