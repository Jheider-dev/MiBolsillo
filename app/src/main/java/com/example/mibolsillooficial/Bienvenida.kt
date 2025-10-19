package com.example.mibolsillooficial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mibolsillooficial.ui.theme.MiBolsilloOficialTheme

class Bienvenida : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiBolsilloOficialTheme {
                PantallaBienvenida()
            }
        }
    }
}

@Composable
fun PantallaBienvenida() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA6C66A)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Text(
                text = "Bienvenido...",
                fontSize = 26.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(id = R.drawable.pregunta),
                contentDescription = "Imagen de bienvenida",
                modifier = Modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(30.dp))
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "¡Bienvenido a MiBol\$illo! 💰\n Empieza hoy a controlar tus gastos, ahorrar con propósito y alcanzar tus metas financieras de forma sencilla.",
                fontSize = 15.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* TODO: acción al presionar */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(150.dp)
                    .height(45.dp)
            ) {
                Text(
                    text = "¡VAMOS!!!",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaBienvenida() {
    MiBolsilloOficialTheme {
        PantallaBienvenida()
    }
}
