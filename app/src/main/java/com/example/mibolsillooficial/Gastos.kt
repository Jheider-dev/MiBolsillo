package com.example.mibolsillooficial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mibolsillooficial.ui.theme.MiBolsilloOficialTheme

class Gastos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiBolsilloOficialTheme {
                PantallaGastos()
            }
        }
    }
}

@Composable
fun PantallaGastos() {
    Scaffold(
        topBar = { BarraSuperiorGastos() },
        bottomBar = { BarraInferiorGastos() },
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
                text = "GASTOS ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TablaGastos()

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BotonAc(texto = "AGREGAR")
                BotonAc(texto = "EDITAR")
            }
        }
    }
}

@Composable
fun BarraSuperiorGastos() {
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
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menú",
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun TablaGastos() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(2.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE8F5CD))
                .border(1.dp, Color.Black)
        ) {
            EncabezadoTab(texto = "Fecha", peso = 0.8f)
            EncabezadoTab(texto = "Concepto", peso = 1.5f)
            EncabezadoTab(texto = "Gastos", peso = 1f)
            EncabezadoTab(texto = "Total", peso = 0.8f)
        }

        repeat(12) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
            ) {
                CeldaTab(peso = 0.8f)
                CeldaTab(peso = 1.5f)
                CeldaTab(peso = 1f)
                CeldaTab(peso = 0.8f)
            }
        }
    }
}

@Composable
fun RowScope.EncabezadoTab(texto: String, peso: Float) {
    Box(
        modifier = Modifier
            .weight(peso)
            .height(36.dp)
            .border(0.5.dp, Color.Black)
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = texto,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RowScope.CeldaTab(peso: Float) {
    Box(
        modifier = Modifier
            .weight(peso)
            .fillMaxHeight()
            .border(0.5.dp, Color.Black)
            .background(Color.White)
    )
}

@Composable
fun BotonAc(texto: String) {
    Button(
        onClick = { },
        modifier = Modifier
            .width(130.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            text = texto,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BarraInferiorGastos() {
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
fun VistaPreviaGastos() {
    MiBolsilloOficialTheme {
        PantallaGastos()
    }
}