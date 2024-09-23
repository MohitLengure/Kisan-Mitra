package com.example.kisan_mitra.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kisan_mitra.navigation.HP
import com.example.kisan_mitra.navigation.LP
import com.example.kisan_mitra.ui.theme.cantoraone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homescreen(navController: NavHostController)
{
   Scaffold(
       topBar = {
           TopAppBar(
               colors = TopAppBarDefaults.topAppBarColors(
                   containerColor = Color(0xFF11BD28),
                   titleContentColor = Color.White,
               ),
               title = {
                   Text(
               text = "Kisan Mitra",
               fontSize = 18.sp,
               fontFamily = cantoraone,
           ) },
               navigationIcon = {
                   Image(
                       imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                       contentDescription = null
                   )
                   Button(onClick = {
                       navController.navigate(LP)
                   }) {

                   }
               }
           )
               }

   ) {
       Column(modifier= Modifier.padding(it)){
           LazyColumn {
               items(10) {
                   Card(modifier=Modifier.padding(10.dp))
                   {
                       Box(modifier= Modifier
                           .fillMaxSize()
                           .background(Color.Gray))
                       Row(modifier=Modifier.fillMaxSize())
                       {
                           Text(text = "Item $it")
                       }
                   }
               }

           }
           }
   }
}