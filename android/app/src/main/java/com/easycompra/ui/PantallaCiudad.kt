package com.easycompra.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easycompra.Ciudad
import com.easycompra.Ciudades

/** Lo que se ensena al abrir la app por primera vez. */
@Composable
fun PantallaCiudad(onElegir: (Ciudad) -> Unit) {
    Column(Modifier.fillMaxSize().background(Colores.Fondo)) {
        BarraVerde(titulo = "EasyCompra")
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
        ) {
            Text("¿Dónde compras?", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(
                "Cada supermercado tiene precios y productos distintos según la ciudad. " +
                    "Podrás cambiarla cuando quieras en Ajustes.",
                fontSize = 15.sp,
                color = Color.Gray,
            )
            Spacer(Modifier.height(20.dp))
            SelectorCiudad(actual = null, textoBoton = "Empezar", onElegir = onElegir)
        }
    }
}

/** Desde Ajustes, para cambiarla. */
@Composable
fun DialogoCiudad(actual: Ciudad?, onCerrar: () -> Unit, onElegir: (Ciudad) -> Unit) {
    AlertDialog(
        onDismissRequest = onCerrar,
        title = { Text("Ciudad") },
        text = {
            Column(Modifier.verticalScroll(rememberScrollState())) {
                SelectorCiudad(actual = actual, textoBoton = "Guardar", onElegir = onElegir)
            }
        },
        confirmButton = {},
        dismissButton = { TextButton(onClick = onCerrar) { Text("Cancelar") } },
    )
}

/** Ciudades sugeridas a un toque, o cualquier otra por su codigo postal. */
@Composable
private fun SelectorCiudad(actual: Ciudad?, textoBoton: String, onElegir: (Ciudad) -> Unit) {
    var cp by remember { mutableStateOf(actual?.cp.orEmpty()) }
    var nombre by remember { mutableStateOf(actual?.nombre.orEmpty()) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Ciudades.SUGERIDAS.chunked(2).forEach { fila ->
            androidx.compose.foundation.layout.Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                fila.forEach { c ->
                    FilterChip(
                        selected = cp == c.cp,
                        onClick = { cp = c.cp; nombre = c.nombre },
                        label = { Text(c.nombre, fontSize = 16.sp) },
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }

        Spacer(Modifier.height(4.dp))
        Text("Otra ciudad", fontSize = 14.sp, color = Color.Gray)
        OutlinedTextField(
            value = cp,
            onValueChange = { nuevo ->
                cp = nuevo.filter { it.isDigit() }.take(5)
                // Si se escribe a mano, el nombre de la sugerida ya no vale.
                if (Ciudades.SUGERIDAS.none { it.cp == cp && it.nombre == nombre }) {
                    if (Ciudades.SUGERIDAS.any { it.nombre == nombre }) nombre = ""
                }
            },
            label = { Text("Código postal") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = cp.length == 5 && !Ciudades.cpValido(cp),
            modifier = Modifier.fillMaxWidth(),
        )
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre (opcional)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(4.dp))
        Button(
            onClick = { onElegir(Ciudad(cp, nombre.trim())) },
            enabled = Ciudades.cpValido(cp),
            colors = ButtonDefaults.buttonColors(containerColor = Colores.Verde),
            modifier = Modifier.fillMaxWidth().height(50.dp),
        ) { Text(textoBoton, fontSize = 16.sp) }
    }
}
