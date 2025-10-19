package com.example.mibolsillooficial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.Image

class IngresoAg : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiBolsilloOficialTheme {
                PantallaAgregarIngreso()
            }
        }
    }
}

@Composable
fun PantallaAgregarIngreso() {
    Scaffold(
        topBar = { BarraSuperiorAgregar() },
        bottomBar = { BarraInferiorAgregar() },
        containerColor = Color(0xFFA6C66A)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Título "AGREGAR INGRESO"
            Text(
                text = "AGREGAR INGRESO",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Icono y texto "Registra tus ingresos"
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Registra tus ingresos",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 12.dp)
                )
                // Icono de ingreso (puedes usar un drawable o un icono personalizado)
                Image(
                    painter = painterResource(id = R.drawable.ingresos),
                    contentDescription = "Imagen ingreso",
                    modifier = Modifier.size(48.dp)
                )

            }

            Spacer(modifier = Modifier.height(32.dp))

            // Campo Categoría
            CampoTextoAgregar(placeholder = "Categoría")

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Monto
            CampoTextoAgregar(placeholder = "Monto")

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Descripción
            CampoTextoAgregar(placeholder = "Descripción...")

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Fecha
            CampoTextoAgregar(placeholder = "Fecha")

            Spacer(modifier = Modifier.height(32.dp))

            // Botón AGREGAR
            Button(
                onClick = { },
                modifier = Modifier
                    .width(150.dp)
                    .height(42.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "AGREGAR",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun BarraSuperiorAgregar() {
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
fun CampoTextoAgregar(placeholder: String) {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray,
                fontSize = 14.sp
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
        ),
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
fun BarraInferiorAgregar() {
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
fun VistaPreviaAgregarIngreso() {
    MiBolsilloOficialTheme {
        PantallaAgregarIngreso()
    }
}