package com.example.mibolsillooficial.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.draw.clip
import com.example.mibolsillooficial.ui.theme.MiBolsilloOficialTheme
import androidx.compose.ui.text.font.FontWeight

private val GreenBackground = Color(0xFFA3C46B)
private val GreenTopBar = Color(0xFFDDE682)
private val BubbleBg = Color(0xFFFFFFFF)
private val BubbleStroke = Color(0x33000000)

class DetalleGastoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MiBolsilloOficialTheme { DetalleGastoScreen() } }
    }
}

@Composable
fun DetalleGastoScreen() {
    // Datos de ejemplo para un ingreso
    val ingreso = DetalleIngresoUI("Estudio", "Compra de libro", "S/ 40.00", "03/10/2025")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenBackground)
            .padding(horizontal = 16.dp)
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
                "MiBolsillo",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.Black
            )
            IconButton(onClick = { /* TODO: abrir menú lateral */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menú", tint = Color.Black)
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            "DETALLE DE EGRESO",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Black),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(12.dp))

        GastoBubble(ingreso)

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { /* Acción de editar */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Editar Egreso")
        }

        Spacer(Modifier.weight(1f))

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
private fun GastoBubble(item: DetalleIngresoUI) {
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

data class DetalleGastoUI(
    val categoria: String,
    val descripcion: String,
    val monto: String,
    val fecha: String
)

@Preview(showBackground = true, backgroundColor = 0xFF9CCC65)
@Composable
fun DetalleGastoPreview() {
    MiBolsilloOficialTheme { DetalleGastoScreen() }
}
