package com.example.kisan_mitra.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.sp
import androidx.navigation.ExperimentalSafeArgsApi
import androidx.navigation.NavHostController
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import com.example.kisan_mitra.R
import com.example.kisan_mitra.ui.theme.cantoraone
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kisan_mitra.navigation.LP
import com.example.kisan_mitra.navigation.SP


@OptIn(ExperimentalSafeArgsApi::class)

@Composable
fun login(navController: NavHostController){

    var emailid by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }

    //
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF11BD28))
        , verticalArrangement = Arrangement.Top
        , horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.padding(20.dp))
            Image(
                painter = painterResource(id = R.drawable.logo)
                    ,modifier = Modifier.size(160.dp)
                ,contentDescription = null
            )
        Spacer(modifier = Modifier.padding(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.9f)
                .fillMaxHeight(fraction = 0.6f)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.White)

        ){
        Column(modifier = Modifier
            .fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(
                text = "Login Page", fontFamily = cantoraone, color = Color(0xFF11BD28),fontSize = 30.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))
            //email
            TextField(modifier = Modifier, value = emailid, onValueChange ={
                emailid = it
                println(it)
            },colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),placeholder = {
                Text(text = "user@gmail.com", color = Color.Black)
            }
                ,leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                })

            //password
            TextField(modifier = Modifier, value = password, onValueChange ={
                password = it
                println(it)
            }, colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),placeholder = {
                Text(text = "*******",color = Color.Black)
            }
                ,leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                })

            TextButton(modifier = Modifier.align(Alignment.Start),
                onClick = {
                    navController.navigate(SP)
                }
            ) {

                //Icon(Icons.Default.Add,"")
                Text(
                    text = "Forgot Password?",
                    fontSize = 16.sp, color = Color.Red, fontFamily = cantoraone
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))
            //Sign Up Button
            Button(onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF11BD28), contentColor = Color.White)
            )
             {
                 Text(text = "Sign Up"
                     , fontFamily = cantoraone
                     , color = Color.White
                     , fontSize = 30.sp
                 )
            }

        }

        }

        Spacer(modifier = Modifier.padding(10.dp))
        //
        TextButton(onClick = {
            navController.navigate(LP)
        }) {
            Text(text = "Not Yet register?\n Sign Up "
                ,textAlign = TextAlign.Center
                ,fontSize = 20.sp
                ,color = Color.White
                ,fontFamily = cantoraone)

        }


    }


}