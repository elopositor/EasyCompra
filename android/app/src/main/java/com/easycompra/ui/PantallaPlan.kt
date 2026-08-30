package com.easycompra.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easycompra.datos.Conversor
import com.easycompra.datos.DatosViewModel
import com.easycompra.datos.EntradaPlan
import com.easycompra.datos.RecetaCompleta
import com.easycompra.datos.Vocabulario
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Composable
fun PantallaPlan(
    vm: DatosViewModel,
    entradas: List<EntradaPlan>,
    recetas: List<RecetaCompleta>,
) {
    // Lunes de la semana que se esta viendo.
    var lunes by remember {
        mutableStateOf(LocalDate.now().minusDays((LocalDate.now().dayOfWeek.value - 1).toLong()))
    }
    var anadiendo by remember { mutableStateOf<Pair<LocalDate, String>?>(null) }

    val dias = remember(lunes) { (0..6).map { lunes.plusDays(it.toLong()) } }
    val porDia = remember(entradas, dias) {
        entradas.filter { it.date in dias.map(LocalDate::toString) }.groupBy { it.date }
    }

    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextButton(onClick = { lunes = lunes.minusWeeks(1) }) { Text("< Anterior") }
            Text(
                "${lunes.dayOfMonth} - ${lunes.plusDays(6).dayOfMonth} de ${mesCorto(lunes)}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.onSurface,
            )
            TextButton(onClick = { lunes = lunes.plusWeeks(1) }) { Text("Siguiente >") }
        }

        AnalisisSemana(dias, porDia, recetas)

        LazyColumn(Modifier.fillMaxSize()) {
            dias.forEach { dia ->
                item(key = dia.toString()) {
                    DiaDelPlan(
                        dia = dia,
                        entradas = porDia[dia.toString()].orEmpty(),
                        onAnadir = { comida -> anadiendo = dia to comida },
                        onBorrar = { vm.borrarDelPlan(it) },
                    )
                }
            }
            item {
                Column(Modifier.padding(16.dp)) {
                    Button(
                        onClick = { vm.comprarParaLaSemana(dias) },
                        modifier = Modifier.fillMaxWidth(),
                    ) { Text("Llevar a la lista lo que falta esta semana") }
                    Spacer(Modifier.height(40.dp))
                }
            }
        }
    }

    val destino = anadiendo
    if (destino != null) {
        DialogoPlanificar(
            fecha = destino.first,
            comida = destino.second,
            recetas = recetas,
            onCerrar = { anadiendo = null },
            onGuardar = { nombre, recetaId, raciones, notas ->
                vm.planificar(destino.first, destino.second, nombre, recetaId, raciones, notas)
                anadiendo = null
            },
        )
    }
}

/**
 * Resumen de la semana: cuantas comidas hay puestas y cuantas quedan sueltas.
 * Es la version util del "Analisis de la semana" que tenia la v5.
 */
@Composable
private fun AnalisisSemana(
    dias: List<LocalDate>,
    porDia: Map<String, List<EntradaPlan>>,
    recetas: List<RecetaCompleta>,
) {
    val total = dias.size * Vocabulario.COMIDAS.size
    val puestas = porDia.values.sumOf { it.size }
    val conReceta = porDia.values.flatten().count { it.recipeId != null }
    val hoy = LocalDate.now()
    val diasSinNada = dias.count { d ->
        !d.isBefore(hoy) && porDia[d.toString()].isNullOrEmpty()
    }

    Card(
        Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
    ) {
        Column(Modifier.padding(12.dp)) {
            Text("Análisis de la semana", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            Text(
                "$puestas de $total comidas planificadas · $conReceta con receta",
                fontSize = 12.sp,
            )
            if (diasSinNada > 0) {
                Text(
                    "Te quedan $diasSinNada días por delante sin nada previsto.",
                    fontSize = 12.sp,
                    color = Color(0xFF8A5A00),
                )
            }
        }
    }
}

@Composable
private fun DiaDelPlan(
    dia: LocalDate,
    entradas: List<EntradaPlan>,
    onAnadir: (String) -> Unit,
    onBorrar: (EntradaPlan) -> Unit,
) {
    val esHoy = dia == LocalDate.now()
    Column(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)) {
        Text(
            if (esHoy) "${diaLargo(dia)} · hoy" else diaLargo(dia),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = if (esHoy) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
        )
        Vocabulario.COMIDAS.forEach { comida ->
            val delSlot = entradas.filter { it.mealSlot == comida }
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable { onAnadir(comida) }
                    .padding(vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(Vocabulario.iconoComida(comida), fontSize = 15.sp)
                Spacer(Modifier.width(8.dp))
                Text(comida, fontSize = 12.sp, color = Color.Gray, modifier = Modifier.width(74.dp))
                Column(Modifier.weight(1f)) {
                    if (delSlot.isEmpty()) {
                        Text("—", fontSize = 13.sp, color = Color.LightGray)
                    } else {
                        delSlot.forEach { entrada ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Column(Modifier.weight(1f)) {
                                    Text(entrada.displayName, fontSize = 13.sp)
                                    val detalle = listOfNotNull(
                                        "${Conversor.formato(entrada.servings)} raciones",
                                        entrada.notes.ifBlank { null },
                                    ).joinToString(" · ")
                                    Text(detalle, fontSize = 11.sp, color = Color.Gray)
                                }
                                IconButton(onClick = { onBorrar(entrada) }) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Quitar",
                                        tint = Color.Gray,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DialogoPlanificar(
    fecha: LocalDate,
    comida: String,
    recetas: List<RecetaCompleta>,
    onCerrar: () -> Unit,
    onGuardar: (String, String?, Float, String) -> Unit,
) {
    var nombre by remember { mutableStateOf("") }
    var recetaId by remember { mutableStateOf<String?>(null) }
    var raciones by remember { mutableStateOf("2") }
    var notas by remember { mutableStateOf("") }
    var busqueda by remember { mutableStateOf("") }

    val sugeridas = recetas.filter {
        busqueda.isBlank() || it.receta.name.contains(busqueda.trim(), true)
    }.take(8)

    AlertDialog(
        onDismissRequest = onCerrar,
        title = { Text("${Vocabulario.iconoComida(comida)} $comida · ${diaLargo(fecha)}") },
        text = {
            Column(Modifier.heightIn(max = 400.dp).verticalScroll(rememberScrollState())) {
                Text("Desde tus recetas", fontSize = 12.sp, color = Color.Gray)
                OutlinedTextField(
                    value = busqueda,
                    onValueChange = { busqueda = it },
                    label = { Text("Buscar receta") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                )
                if (recetas.isEmpty()) {
                    Text(
                        "Todavía no tienes recetas guardadas.",
                        fontSize = 11.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp),
                    )
                }
                sugeridas.forEach { receta ->
                    FilterChip(
                        selected = recetaId == receta.receta.id,
                        onClick = {
                            if (recetaId == receta.receta.id) {
                                recetaId = null
                            } else {
                                recetaId = receta.receta.id
                                nombre = receta.receta.name
                                raciones = receta.receta.baseServings.toString()
                            }
                        },
                        label = { Text(receta.receta.name) },
                        modifier = Modifier.padding(vertical = 2.dp),
                    )
                }

                Spacer(Modifier.height(10.dp))
                Text("O escríbelo a mano", fontSize = 12.sp, color = Color.Gray)
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it; recetaId = null },
                    label = { Text("Qué se come") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = raciones,
                    onValueChange = { raciones = it.filter { c -> c.isDigit() || c == '.' || c == ',' } },
                    label = { Text("Raciones") },
                    singleLine = true,
                    modifier = Modifier.width(120.dp),
                )

                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = notas,
                    onValueChange = { notas = it },
                    label = { Text("Notas (opcional)") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onGuardar(
                        nombre,
                        recetaId,
                        raciones.replace(',', '.').toFloatOrNull() ?: 2f,
                        notas,
                    )
                },
                enabled = nombre.isNotBlank(),
            ) { Text("Guardar") }
        },
        dismissButton = { TextButton(onClick = onCerrar) { Text("Cancelar") } },
    )
}
