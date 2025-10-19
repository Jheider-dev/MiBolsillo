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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mibolsillooficial.ui.theme.MiBolsilloOficialTheme

class GastosEditar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiBolsilloOficialTheme {
                PantallaEditarGastos()
            }
        }
    }
}

@Composable
fun PantallaEditarGastos() {
    var categoria by remember { mutableStateOf("Oseo") }
    var monto by remember { mutableStateOf("150.00") }
    var descripcion by remember { mutableStateOf("Poco comun") }
    var fecha by remember { mutableStateOf("18/10/2025") }

    Scaffold(
        topBar = { BarraSuperiorEdit() },
        bottomBar = { BarraInferiorEdit() },
        containerColor = Color(0xFFA6C66A)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "EDITAR GASTO",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Modifica tus gastos",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.gasto),
                    contentDescription = "Icono editar",
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = categoria,
                onValueChange = { categoria = it },
                placeholder = { Text("Categoría...") },
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = monto,
                onValueChange = { monto = it },
                placeholder = { Text("Monto...") },
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                placeholder = { Text("Descripción...") },
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = fecha,
                onValueChange = { fecha = it },
                placeholder = { Text("Fecha...") },
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /* Acción guardar */ },
                    modifier = Modifier
                        .width(140.dp)
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2D5016)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "GUARDAR",
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = { /* Acción eliminar */ },
                    modifier = Modifier
                        .width(140.dp)
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB71C1C)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "ELIMINAR",
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun BarraSuperiorEdit() {
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
fun BarraInferiorEdit() {
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
fun VistaPreviaEditarGastos() {
    MiBolsilloOficialTheme {
        PantallaEditarGastos()
    }
}