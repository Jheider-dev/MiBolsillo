package com.example.mibolsillooficial.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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

private val GreenBackground = Color(0xFFA3C46B)
private val GreenTopBar = Color(0xFFDDE682)

class FeedbackActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MiBolsilloOficialTheme { FeedbackScreen() } }
    }
}

@Composable
fun FeedbackScreen() {
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
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menú", tint = Color.Black)
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            "Feedback",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        TextField(
            value = "",
            onValueChange = { /* Handle text change */ },
            label = { Text("Escribe tu comentario o sugerencia") },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle feedback submission */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Enviar Feedback")
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
            IconButton(onClick = { }) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "Egresos", tint = Color.Black)
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Home, contentDescription = "Inicio", tint = Color.Black)
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Person, contentDescription = "Perfil", tint = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedbackPreview() {
    MiBolsilloOficialTheme { FeedbackScreen() }
}
