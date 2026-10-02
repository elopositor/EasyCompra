package com.easycompra.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easycompra.NutriScore
import com.easycompra.Product

@Composable
fun PantallaDetalle(
    p: Product,
    esFavorito: Boolean,
    onVolver: () -> Unit,
    onAnadirALista: () -> Unit,
    onFavorito: () -> Unit,
) {
    val contexto = LocalContext.current
    var anadido by remember(p) { mutableStateOf(false) }

    Column(Modifier.fillMaxSize().background(Colores.Fondo)) {
        BarraVerde(
            titulo = p.name,
            navegacion = {
                IconButton(onClick = onVolver) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                }
            },
        )

        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
        ) {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Box(Modifier.background(Color.White).padding(8.dp)) {
                    FotoProducto(p.photo_url, Modifier.size(220.dp))
                }
            }
            Spacer(Modifier.height(16.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                if (p.supermarket.isNotBlank()) EtiquetaSupermercado(p.supermarket, grande = true)
                EtiquetaNutri(NutriScore.nota(p), grande = true)
            }
            Spacer(Modifier.height(14.dp))

            Text(p.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            p.brand?.ifBlank { null }?.let {
                Spacer(Modifier.height(8.dp))
                Text("Marca: $it", fontSize = 17.sp, color = Color.Gray)
            }
            Spacer(Modifier.height(14.dp))

            Row(verticalAlignment = Alignment.Bottom) {
                Cifra(p.unit_price?.let { euros(it) } ?: "—", "precio", Colores.Verde)
                p.reference_price?.let { ref ->
                    Spacer(Modifier.width(36.dp))
                    val unidad = p.reference_format?.trim()?.ifBlank { null }
                    Cifra(euros(ref), if (unidad != null) "por $unidad" else "referencia", Color(0xFF1F1F1F))
                }
            }
            Spacer(Modifier.height(18.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(
                    onClick = {
                        onAnadirALista()
                        anadido = true
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Colores.Verde),
                    modifier = Modifier.weight(1f).height(52.dp),
                ) {
                    Icon(Icons.Default.ShoppingCart, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text(if (anadido) "Añadir otro" else "Añadir a lista", fontSize = 16.sp)
                }
                OutlinedButton(
                    onClick = onFavorito,
                    modifier = Modifier.weight(1f).height(52.dp),
                ) {
                    Icon(
                        if (esFavorito) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Colores.Verde,
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(if (esFavorito) "Guardado" else "Favorito", fontSize = 16.sp, color = Colores.Verde)
                }
            }
            if (anadido) {
                Text(
                    "Añadido a Mi lista",
                    fontSize = 13.sp,
                    color = Colores.Verde,
                    modifier = Modifier.padding(top = 6.dp),
                )
            }
            Spacer(Modifier.height(18.dp))

            TablaNutricional(p)

            p.ingredients?.ifBlank { null }?.let { Bloque("Ingredientes", it) }
            p.allergens?.ifBlank { null }?.let { Bloque("Alérgenos", it) }

            p.share_url?.ifBlank { null }?.let { url ->
                TextButton(onClick = {
                    runCatching { contexto.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url))) }
                }) { Text("Ver en la web del supermercado", color = Colores.Verde) }
            }
            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun Cifra(valor: String, pie: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(valor, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = color)
        Text(pie, fontSize = 14.sp, color = Color.Gray)
    }
}

@Composable
private fun Tarjeta(contenido: @Composable () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
    ) {
        Column(Modifier.padding(18.dp)) { contenido() }
    }
}

@Composable
private fun TablaNutricional(p: Product) {
    val filas = listOf(
        "Energía" to p.energy_kcal_100g?.let { "${decimal(it, 0)} kcal" },
        "Grasas" to p.fat_100g?.let { "${decimal(it, 1)} g" },
        "  de las cuales saturadas" to p.saturated_fat_100g?.let { "${decimal(it, 1)} g" },
        "Hidratos de carbono" to p.carbohydrates_100g?.let { "${decimal(it, 1)} g" },
        "  de los cuales azúcares" to p.sugars_100g?.let { "${decimal(it, 1)} g" },
        "Proteínas" to p.proteins_100g?.let { "${decimal(it, 1)} g" },
        "Sal" to p.salt_100g?.let { "${decimal(it, 2)} g" },
    )
    if (filas.all { it.second == null }) return

    Tarjeta {
        Text(
            "Información nutricional (por 100 g)",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = Colores.Verde,
        )
        Spacer(Modifier.height(8.dp))
        filas.forEachIndexed { i, (nombre, valor) ->
            Row(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Text(nombre, fontSize = 16.sp, modifier = Modifier.weight(1f))
                Text(valor ?: "—", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            if (i < filas.lastIndex) HorizontalDivider(color = Color(0xFFE6E6E6))
        }
    }
}

@Composable
private fun Bloque(titulo: String, texto: String) {
    Tarjeta {
        Text(titulo, fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Colores.Verde)
        Spacer(Modifier.height(8.dp))
        Text(texto, fontSize = 15.sp)
    }
}
