package com.example.mibolsillooficial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mibolsillooficial.ui.theme.MiBolsilloOficialTheme
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Size

class Principal : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiBolsilloOficialTheme {
                PantallaPrincipal()
            }
        }
    }
}

@Composable
fun PantallaPrincipal() {
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior() },
        containerColor = Color(0xFFA6C66A)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "RESUMEN GENERAL",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            GraficoCircular(
                valores = listOf(40f, 30f, 10f, 7f, 13f),
                colores = listOf(
                    Color(0xFF00B0F0),
                    Color(0xFF0070C0),
                    Color(0xFFFFA500),
                    Color(0xFF92D050),
                    Color(0xFF7F7F7F)
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

            FilaResumen(
                icono = R.drawable.ingreso,
                texto = "INGRESOS: 249"
            )

            Spacer(modifier = Modifier.height(16.dp))

            FilaResumen(
                icono = R.drawable.gasto,
                texto = "GASTOS: 229"
            )
        }
    }
}

@Composable
fun BarraSuperior() {
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
            tint = Color.Black
        )
    }
}

@Composable
fun GraficoCircular(valores: List<Float>, colores: List<Color>) {
    Canvas(
        modifier = Modifier
            .size(180.dp)
            .padding(8.dp)
    ) {
        var startAngle = 0f
        valores.zip(colores).forEach { (valor, color) ->
            val sweepAngle = (valor / valores.sum()) * 360f
            drawArc(
                color = color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true,
                size = Size(size.width, size.height)
            )
            startAngle += sweepAngle
        }
    }
}

@Composable
fun FilaResumen(icono: Int, texto: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Image(
            painter = painterResource(id = icono),
            contentDescription = "Icono",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Box(
            modifier = Modifier
                .background(Color(0xFFD9D9D9), RoundedCornerShape(4.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(text = texto, color = Color.Black, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun BarraInferior() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD9D9D9))
            .padding(vertical = 6.dp),
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
fun VistaPreviaInicio() {
    MiBolsilloOficialTheme {
        PantallaPrincipal()
    }
}
