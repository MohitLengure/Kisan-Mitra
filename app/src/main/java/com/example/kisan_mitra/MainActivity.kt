package com.example.kisan_mitra

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.kisan_mitra.ui.theme.Kisan_MitraTheme
import com.example.kisan_mitra.navigation.App
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.enableEdgeToEdge

@AndroidEntryPoint
class MainActivity : androidx.activity.ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kisan_MitraTheme {
                Surface(modifier = Modifier.fillMaxSize())
                {
                    App()
            }
            }
        }
    }
}
