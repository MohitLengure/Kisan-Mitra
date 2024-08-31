package com.example.kisan_mitra.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.ExperimentalSafeArgsApi
import androidx.navigation.NavHostController

@OptIn(ExperimentalSafeArgsApi::class)
@Composable
fun signup(navController: NavHostController){
    var passwordA by remember {
        mutableStateOf("")
    }
    var passwordB by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var emailid by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(color = Color(0xFF11BD28))
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text="KisanMitra",
            fontSize=32.sp,
            color = Color.White,
            //fontFamily = @font/cantora_regular,


        )
    }


}