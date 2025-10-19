package com.example.mibolsillooficial.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import com.example.mibolsillooficial.ui.theme.MiBolsilloOficialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.input.TextFieldValue

private val GreenBackground = Color(0xFFA3C46B)
private val GreenTopBar = Color(0xFFDDE682)

class BuscarIngresosEgresosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MiBolsilloOficialTheme { BuscarIngresosEgresosScreen() } }
    }
}

@Composable
fun BuscarIngresosEgresosScreen() {
    var query = TextFieldValue("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenBackground)
            .padding(16.dp)
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
            "Buscar Ingresos/Egresos",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        BasicTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp),
            textStyle = MaterialTheme.typography.bodyLarge,
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Buscar...", style = MaterialTheme.typography.bodyLarge)
                    Box(modifier = Modifier.fillMaxWidth()) {
                        innerTextField()
                    }
                }
            }
        )

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {

        }

        Spacer(modifier = Modifier.weight(1f))

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

@Preview(showBackground = true)
@Composable
fun BuscarIngresosEgresosPreview() {
    MiBolsilloOficialTheme { BuscarIngresosEgresosScreen() }
}
