package com.easycompra.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import com.easycompra.datos.EstadoIngrediente
import com.easycompra.datos.Ingrediente
import com.easycompra.datos.Necesidades
import com.easycompra.datos.PasoReceta
import com.easycompra.datos.ProductoConUbicaciones
import com.easycompra.datos.Receta
import com.easycompra.datos.RecetaCompleta
import com.easycompra.datos.Vocabulario

@Composable
fun PantallaRecetas(
    vm: DatosViewModel,
    recetas: List<RecetaCompleta>,
    despensa: List<ProductoConUbicaciones>,
) {
    var abierta by remember { mutableStateOf<String?>(null) }
    var editando by remember { mutableStateOf<RecetaCompleta?>(null) }
    var creando by remember { mutableStateOf(false) }

    val seleccionada = recetas.firstOrNull { it.receta.id == abierta }

    when {
        creando || editando != null -> EditorReceta(
            original = editando,
            onCancelar = { creando = false; editando = null },
            onGuardar = { receta, ingredientes, pasos ->
                vm.guardarReceta(receta, ingredientes, pasos)
                creando = false
                editando = null
            },
        )

        seleccionada != null -> DetalleReceta(
            vm = vm,
            receta = seleccionada,
            despensa = despensa,
            onVolver = { abierta = null },
            onEditar = { editando = seleccionada },
        )

        else -> ListaRecetas(
            vm = vm,
            recetas = recetas,
            onAbrir = { abierta = it },
            onCrear = { creando = true },
        )
    }
}

@Composable
private fun ListaRecetas(
    vm: DatosViewModel,
    recetas: List<RecetaCompleta>,
    onAbrir: (String) -> Unit,
    onCrear: () -> Unit,
) {
    var categoria by remember { mutableStateOf<String?>(null) }
    var soloFavoritas by remember { mutableStateOf(false) }

    val visibles = recetas.filter {
        (categoria == null || it.receta.category == categoria) &&
            (!soloFavoritas || it.receta.isFavorite)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onCrear) {
                Icon(Icons.Default.Add, contentDescription = "Nueva receta")
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            Row(
                Modifier.horizontalScrollable().padding(horizontal = 12.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                FilterChip(
                    selected = categoria == null && !soloFavoritas,
                    onClick = { categoria = null; soloFavoritas = false },
                    label = { Text("Todas") },
                )
                FilterChip(
                    selected = soloFavoritas,
                    onClick = { soloFavoritas = !soloFavoritas },
                    label = { Text("Favoritas") },
                )
                Vocabulario.CATEGORIAS_RECETA.forEach { c ->
                    FilterChip(
                        selected = categoria == c,
                        onClick = { categoria = if (categoria == c) null else c },
                        label = { Text(c) },
                    )
                }
            }

            if (visibles.isEmpty()) {
                Vacio(
                    if (recetas.isEmpty()) "No hay recetas todavía.\nPulsa + para escribir la primera."
                    else "Ninguna receta en este filtro."
                )
            } else {
                LazyColumn(Modifier.fillMaxSize()) {
                    items(visibles, key = { it.receta.id }) { receta ->
                        TarjetaReceta(vm, receta, onAbrir)
                    }
                }
            }
        }
    }
}

@Composable
private fun TarjetaReceta(vm: DatosViewModel, item: RecetaCompleta, onAbrir: (String) -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .clickable { onAbrir(item.receta.id) }
    ) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(item.receta.name, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                val detalle = listOfNotNull(
                    item.receta.category,
                    item.receta.difficulty,
                    item.receta.prepTimeMinutes.takeIf { it > 0 }?.let { "$it min" },
                    "${item.ingredientes.size} ingredientes",
                ).joinToString(" · ")
                Text(detalle, fontSize = 12.sp, color = Color.Gray)
            }
            IconButton(onClick = { vm.marcarFavorita(item.receta) }) {
                Icon(
                    if (item.receta.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorita",
                    tint = if (item.receta.isFavorite) MaterialTheme.colorScheme.primary else Color.Gray,
                )
            }
        }
    }
}

@Composable
private fun DetalleReceta(
    vm: DatosViewModel,
    receta: RecetaCompleta,
    despensa: List<ProductoConUbicaciones>,
    onVolver: () -> Unit,
    onEditar: () -> Unit,
) {
    var raciones by remember(receta.receta.id) {
        mutableStateOf(receta.receta.baseServings.toFloat())
    }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        Row(Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onVolver) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
            }
            Text(
                receta.receta.name,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                modifier = Modifier.weight(1f),
            )
            IconButton(onClick = onEditar) {
                Icon(Icons.Default.Edit, contentDescription = "Editar")
            }
            IconButton(onClick = { vm.borrarReceta(receta.receta); onVolver() }) {
                Icon(Icons.Default.Delete, contentDescription = "Eliminar receta")
            }
        }

        Text(
            listOfNotNull(
                receta.receta.category,
                receta.receta.difficulty,
                receta.receta.prepTimeMinutes.takeIf { it > 0 }?.let { "$it min" },
            ).joinToString(" · "),
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(Modifier.height(12.dp))

        Row(
            Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Raciones", fontSize = 14.sp, modifier = Modifier.weight(1f))
            OutlinedButton(onClick = { if (raciones > 1f) raciones -= 1f }) { Text("-") }
            Text(
                Conversor.formato(raciones),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 14.dp),
            )
            OutlinedButton(onClick = { raciones += 1f }) { Text("+") }
        }

        Spacer(Modifier.height(12.dp))
        Text(
            "Ingredientes",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        receta.ingredientes.forEach { ingrediente ->
            FilaIngrediente(ingrediente, raciones, receta.receta.baseServings, despensa)
        }

        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { vm.comprarLoQueFalta(receta, raciones) },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        ) { Text("Comprar lo que falta") }

        if (receta.pasos.isNotEmpty()) {
            Spacer(Modifier.height(16.dp))
            Text(
                "Preparación",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
            receta.pasos.sortedBy { it.stepNumber }.forEach { paso ->
                Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp)) {
                    Text(
                        "${paso.stepNumber}.",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(24.dp),
                    )
                    Column {
                        Text(paso.description, fontSize = 14.sp)
                        if (paso.timeMinutes > 0) {
                            Text("${paso.timeMinutes} min", fontSize = 11.sp, color = Color.Gray)
                        }
                    }
                }
            }
        }

        if (receta.receta.notes.isNotBlank()) {
            Spacer(Modifier.height(12.dp))
            Text("Notas", fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 16.dp))
            Text(
                receta.receta.notes,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            )
        }

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun FilaIngrediente(
    ingrediente: Ingrediente,
    raciones: Float,
    racionesBase: Int,
    despensa: List<ProductoConUbicaciones>,
) {
    val factor = if (racionesBase > 0) raciones / racionesBase else 1f
    val estado = Necesidades.estado(ingrediente, raciones, racionesBase, despensa)

    Row(
        Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1f)) {
            Text(ingrediente.name, fontSize = 14.sp)
            if (ingrediente.ingredientNotes.isNotBlank()) {
                Text(ingrediente.ingredientNotes, fontSize = 11.sp, color = Color.Gray)
            }
        }
        Text(
            "${Conversor.formato(ingrediente.baseQuantity * factor)} ${ingrediente.unit}",
            fontSize = 13.sp,
            modifier = Modifier.padding(end = 10.dp),
        )
        val (texto, color) = when (estado) {
            is EstadoIngrediente.Suficiente -> "tienes" to Color(0xFF2E7D32)
            is EstadoIngrediente.Parcial ->
                "faltan ${Conversor.formato(estado.falta)}" to Color(0xFF8A5A00)
            EstadoIngrediente.Falta -> "falta" to Color(0xFFB3261E)
        }
        Text(texto, fontSize = 11.sp, color = color, fontWeight = FontWeight.Medium)
    }
}

/** Alta y edicion de recetas: cabecera, ingredientes y pasos. */
@Composable
private fun EditorReceta(
    original: RecetaCompleta?,
    onCancelar: () -> Unit,
    onGuardar: (Receta, List<Ingrediente>, List<PasoReceta>) -> Unit,
) {
    val base = original?.receta ?: Receta(name = "")
    var nombre by remember { mutableStateOf(base.name) }
    var categoria by remember { mutableStateOf(base.category) }
    var dificultad by remember { mutableStateOf(base.difficulty) }
    var tiempo by remember { mutableStateOf(base.prepTimeMinutes.takeIf { it > 0 }?.toString() ?: "") }
    var racionesBase by remember { mutableStateOf(base.baseServings.toString()) }
    var notas by remember { mutableStateOf(base.notes) }

    val ingredientes = remember {
        mutableStateListOf<Ingrediente>().apply { addAll(original?.ingredientes.orEmpty()) }
    }
    val pasos = remember {
        mutableStateListOf<PasoReceta>().apply {
            addAll(original?.pasos.orEmpty().sortedBy { it.stepNumber })
        }
    }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)) {
        Text(
            if (original == null) "Nueva receta" else "Editar receta",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
        )
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre de la receta *") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(8.dp))
        Row(Modifier.horizontalScrollable(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Vocabulario.CATEGORIAS_RECETA.forEach { c ->
                FilterChip(selected = categoria == c, onClick = { categoria = c }, label = { Text(c) })
            }
        }

        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Vocabulario.DIFICULTADES.forEach { d ->
                FilterChip(selected = dificultad == d, onClick = { dificultad = d }, label = { Text(d) })
            }
        }

        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = tiempo,
                onValueChange = { tiempo = it.filter { c -> c.isDigit() } },
                label = { Text("Minutos") },
                singleLine = true,
                modifier = Modifier.weight(1f),
            )
            OutlinedTextField(
                value = racionesBase,
                onValueChange = { racionesBase = it.filter { c -> c.isDigit() } },
                label = { Text("Raciones") },
                singleLine = true,
                modifier = Modifier.weight(1f),
            )
        }

        Spacer(Modifier.height(16.dp))
        Text("Ingredientes", fontWeight = FontWeight.SemiBold)
        ingredientes.forEachIndexed { indice, ingrediente ->
            Row(Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = ingrediente.name,
                    onValueChange = { ingredientes[indice] = ingrediente.copy(name = it) },
                    label = { Text("Ingrediente") },
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                )
                Spacer(Modifier.width(6.dp))
                OutlinedTextField(
                    value = Conversor.formato(ingrediente.baseQuantity),
                    onValueChange = {
                        val v = it.replace(',', '.').toFloatOrNull() ?: 0f
                        ingredientes[indice] = ingrediente.copy(baseQuantity = v)
                    },
                    label = { Text("Cant.") },
                    singleLine = true,
                    modifier = Modifier.width(80.dp),
                )
                IconButton(onClick = { ingredientes.removeAt(indice) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Quitar ingrediente")
                }
            }
            Row(Modifier.horizontalScrollable(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Vocabulario.UNIDADES_RECETA.forEach { u ->
                    FilterChip(
                        selected = ingrediente.unit == u,
                        onClick = { ingredientes[indice] = ingrediente.copy(unit = u) },
                        label = { Text(u) },
                    )
                }
            }
        }
        TextButton(onClick = {
            ingredientes.add(Ingrediente(recipeId = base.id, name = "", baseQuantity = 1f))
        }) { Text("+ Añadir ingrediente") }

        Spacer(Modifier.height(12.dp))
        Text("Pasos", fontWeight = FontWeight.SemiBold)
        pasos.forEachIndexed { indice, paso ->
            Row(Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("${indice + 1}.", modifier = Modifier.width(24.dp))
                OutlinedTextField(
                    value = paso.description,
                    onValueChange = { pasos[indice] = paso.copy(description = it) },
                    label = { Text("Qué hacer") },
                    modifier = Modifier.weight(1f),
                )
                IconButton(onClick = { pasos.removeAt(indice) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Quitar paso")
                }
            }
        }
        TextButton(onClick = {
            pasos.add(PasoReceta(recipeId = base.id, stepNumber = pasos.size + 1, description = ""))
        }) { Text("+ Añadir paso") }

        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = notas,
            onValueChange = { notas = it },
            label = { Text("Notas (opcional)") },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = {
                    onGuardar(
                        base.copy(
                            name = nombre.trim(),
                            category = categoria,
                            difficulty = dificultad,
                            prepTimeMinutes = tiempo.toIntOrNull() ?: 0,
                            baseServings = racionesBase.toIntOrNull()?.coerceAtLeast(1) ?: 1,
                            notes = notas.trim(),
                        ),
                        ingredientes.filter { it.name.isNotBlank() },
                        pasos.filter { it.description.isNotBlank() },
                    )
                },
                enabled = nombre.isNotBlank(),
            ) { Text("Guardar") }
            OutlinedButton(onClick = onCancelar) { Text("Cancelar") }
        }
        Spacer(Modifier.height(32.dp))
    }
}
