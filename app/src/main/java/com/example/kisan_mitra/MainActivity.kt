package com.example.kisan_mitra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kisan_mitra.ui.theme.Kisan_MitraTheme
import com.example.kisan_mitra.navigation.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kisan_MitraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Box(modifier=Modifier.padding(innerPadding))
                    {
                        App()
                    }
            }
            }
        }
    }
}
