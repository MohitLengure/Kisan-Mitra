package com.example.kisan_mitra.screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.kisan_mitra.MainActivity
import com.example.kisan_mitra.R
import com.example.kisan_mitra.ui.theme.Kisan_MitraTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashScreen:ComponentActivity (){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kisan_MitraTheme {
                Splashscreen()
            }
        }
    }

    @Preview
    @Composable
    private fun Splashscreen() {
        val alpha=remember{
            androidx.compose.animation.core.Animatable(0f)
        }
        LaunchedEffect(key1 = true){
            alpha.animateTo(1f,
                animationSpec = tween(1500)
            )
            delay(2000)
            startActivity(Intent(this@SplashScreen,MainActivity::class.java))
        }
        Box(modifier=Modifier
            .fillMaxSize()
            .background(Color(0xFF11BD28)),
            contentAlignment = Alignment.Center)
        {
            Image(
                modifier = Modifier.alpha(alpha.value), painter = painterResource(id = R.drawable.flashscreen), contentDescription =null )
        }
    }

}
