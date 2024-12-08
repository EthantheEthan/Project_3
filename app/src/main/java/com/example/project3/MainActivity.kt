package com.example.project3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project3.ui.theme.Project3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project3Theme {
                Box(modifier = Modifier.fillMaxSize().background(Color(0xFF4CAF50))) {
                    Scaffold { innerPadding ->
                        Greeting(
                            name = "Ethan Holley",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var visibleImage by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hi $name!",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        //First Button
        Button(
            onClick = {
                if (visibleImage == 1) visibleImage = 0 else visibleImage = 1
            },
            modifier = Modifier.size(96.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB0E0E6)
            )
        ) {
            Text(text = "\uD83D\uDC2C", fontSize = 40.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        //Second Button
        Button(
            onClick = {
                if (visibleImage == 2) visibleImage = 0 else visibleImage = 2
            },
            modifier = Modifier.size(96.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0B192C)
            )
        ) {
            Text(text = "\uD83E\uDE90", fontSize = 40.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        //Third Button
        Button(
            onClick = {
                if (visibleImage == 3) visibleImage = 0 else visibleImage = 3
            },
            modifier = Modifier.size(96.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(0xFF54C392)
            )
        ) {
            Text(text = "\uD83D\uDDFF", fontSize = 40.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Crossfade(targetState = visibleImage) { target ->
            when (target) {
                1 -> {
                    Image(
                        painter = painterResource(id = R.drawable.image1),
                        contentDescription = "Image of Dolphin",
                        modifier = Modifier.size(500.dp)
                    )
                }
                2 -> {
                    Image(
                        painter = painterResource(id = R.drawable.image2),
                        contentDescription = "Image of Black Hole",
                        modifier = Modifier.size(500.dp)
                    )
                }
                3 -> {
                    Image(
                        painter = painterResource(id = R.drawable.image3),
                        contentDescription = "Easter Island",
                        modifier = Modifier.size(500.dp)
                    )
                }
                else -> {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Project3Theme {
        Greeting("Android")
    }
}