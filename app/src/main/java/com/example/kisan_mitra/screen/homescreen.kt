package com.example.kisan_mitra.screen

import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kisan_mitra.navigation.LP
import com.example.kisan_mitra.ui.theme.cantoraone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homescreen(navController: NavHostController)
{
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val WebView=webscreen()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF11BD28), titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = "KisanMitra",
                        fontSize = 32.sp,
                        fontFamily = cantoraone,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(LP)
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
                )
        },

    ) {
        Column(modifier=Modifier.padding(it)){
            Button(onClick = {
                WebView.WebView(url = "www.google.com")
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red, contentColor = Color.White
                )
            ) {
                Text(text = "Link1")

            }
            }
        }
    }





