package com.example.mibolsillooficial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mibolsillooficial.ui.theme.MiBolsilloOficialTheme

class GastosTendencias : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiBolsilloOficialTheme {
                PantallaGastosTend()
            }
        }
    }
}

@Composable
fun PantallaGastosTend() {
    Scaffold(
        topBar = { BarraSuperiorTend() },
        bottomBar = { BarraInferiorTend() },
        containerColor = Color(0xFFA6C66A)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "GRAFICO DE TENDENCIAS",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            GraficoBar()

            Spacer(modifier = Modifier.height(24.dp))

            FilaResumenTend(
                icono = "💰",
                texto = "INGRESOS: 249",
                colorFondo = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            FilaResumenTend(
                icono = "💸",
                texto = "GASTOS: 229",
                colorFondo = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .background(Color(0xFFE8F0D5), RoundedCornerShape(8.dp))
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "SALDO TOTAL: 20",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun BarraSuperiorTend() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD8EE87))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "MiBol\$illo",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menú",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun GraficoBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Gastos de la primera semana del mes",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            val categories = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")
            val colors = listOf(
                Color(0xFF92D050),
                Color(0xFFFFA500),
                Color(0xFF7F7F7F)
            )
            val barsPerDay = colors.size
            val barWidth = size.width / (categories.size * barsPerDay + categories.size + 1)
            val maxHeight = size.height - 40f

            val data = listOf(
                listOf(60f, 40f, 30f),
                listOf(70f, 65f, 50f),
                listOf(85f, 75f, 40f),
                listOf(75f, 70f, 60f),
                listOf(80f, 85f, 55f)
            )

            for (i in 0..5) {
                val y = maxHeight - (i * maxHeight / 5)
                drawLine(
                    color = Color.LightGray,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = 1f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                )
            }

            categories.forEachIndexed { dayIndex, _ ->
                val dayData = data[dayIndex]
                dayData.forEachIndexed { barIndex, value ->
                    val x = ((barsPerDay + 1) * dayIndex + barIndex + 1) * barWidth
                    val barHeight = (value / 100f) * maxHeight

                    drawRect(
                        color = colors[barIndex],
                        topLeft = Offset(x, maxHeight - barHeight),
                        size = androidx.compose.ui.geometry.Size(barWidth * 0.8f, barHeight)
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            LeyendaIt(color = Color(0xFF92D050), texto = "Comidas")
            LeyendaIt(color = Color(0xFFFFA500), texto = "Universidad")
            LeyendaIt(color = Color(0xFF7F7F7F), texto = "Transporte")
        }
    }
}

@Composable
fun LeyendaIt(color: Color, texto: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color)
        )
        Text(
            text = texto,
            fontSize = 8.sp,
            color = Color.Black
        )
    }
}

@Composable
fun FilaResumenTend(icono: String, texto: String, colorFondo: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .background(colorFondo, RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFF2D4A2B), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icono,
                fontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = texto,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun BarraInferiorTend() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD9D9D9))
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Carrito",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Inicio",
            tint = Color.Black,
            modifier = Modifier.size(32.dp)
        )
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Perfil",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaTend() {
    MiBolsilloOficialTheme {
        PantallaGastosTend()
    }
}