package com.example.mibolsillooficial.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.mibolsillooficial.ui.theme.MiBolsilloOficialTheme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart


private val GreenBackground = Color(0xFFA3C46B)
private val GreenTopBar    = Color(0xFFDDE682)
private val BubbleBg       = Color(0xFFFFFFFF)
private val BubbleStroke   = Color(0x33000000)

class HistorialEgresosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MiBolsilloOficialTheme { HistorialEgresosScreen() } }
    }
}

@Composable
fun HistorialEgresosScreen() {
    val ingresos = listOf(
        IngresoUI("Deporte", "Futsal en la bombonera", "S/ 7.00", "01/10/2025"),
        IngresoUI("Estudio", "Compra de libro", "S/ 40.00", "03/10/2025"),
        IngresoUI("Personal", "Compra de entrada", "S/ 25.00", "04/10/2025"),
        IngresoUI("Vestimenta", "Polera azul", "S/ 80.00", "05/10/2025"),
        IngresoUI("Deporte", "Futsal en la bombonera", "S/ 9.00", "06/10/2025"),
        IngresoUI("Fiesta", "Salida a la discoteca", "S/ 180.00", "07/10/2025")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenBackground)
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenTopBar)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "MiBol\$illo",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.Black
            )
            IconButton(onClick = { /* TODO: abrir menú lateral */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menú", tint = Color.Black)
            }
        }

        Spacer(Modifier.height(12.dp))

        Text(
            "HISTORIAL DE EGRESOS",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Black),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            items(ingresos) { ing ->
                IngresoBubble(ing)
            }
            item { Spacer(Modifier.height(8.dp)) }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0))
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* TODO: ir a egresos */ }) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "Egresos", tint = Color.Black)
            }
            IconButton(onClick = { /* TODO: home */ }) {
                Icon(Icons.Filled.Home, contentDescription = "Inicio", tint = Color.Black)
            }
            IconButton(onClick = { /* TODO: perfil */ }) {
                Icon(Icons.Filled.Person, contentDescription = "Perfil", tint = Color.Black)
            }
        }
    }
}

@Composable
private fun IngresoBubble(item: IngresoUI) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clip(RoundedCornerShape(26.dp))
            .background(BubbleBg)
            .border(width = 1.dp, color = BubbleStroke, shape = RoundedCornerShape(26.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(item.categoria, style = MaterialTheme.typography.labelLarge, color = Color.Black)
            Text(item.descripcion, style = MaterialTheme.typography.bodyMedium, color = Color.Black)
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(item.monto, style = MaterialTheme.typography.titleSmall, color = Color.Black)
            Text(item.fecha, style = MaterialTheme.typography.labelMedium, color = Color.DarkGray)
        }
    }

}

data class EgresoUI(
    val categoria: String,
    val descripcion: String,
    val monto: String,
    val fecha: String
)

@Preview(showBackground = true, backgroundColor = 0xFF9CCC65)
@Composable
fun HistorialEgresosPreview() {
    MiBolsilloOficialTheme { HistorialEgresosScreen() }
}
