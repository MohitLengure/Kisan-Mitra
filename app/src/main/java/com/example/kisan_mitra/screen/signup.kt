package com.example.kisan_mitra.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.kisan_mitra.navigation.LP
import com.example.kisan_mitra.ui.AppViewModel
import com.example.kisan_mitra.ui.theme.cambayregular
import com.example.kisan_mitra.ui.theme.cantoraone



@Composable
fun signup(navController: NavHostController,viewModel: AppViewModel =hiltViewModel()){

    val state = viewModel.singUpUserState.collectAsState()
    val context = LocalContext.current

    when {
        state.value.Loading -> {
            Box(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            )
            {
                CircularProgressIndicator()
            }
        }

        state.value.Error != null -> {
            Box(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            )
            {
                Text(text = state.value.Error.toString())
            }
        }

        state.value.Data != null -> {
            Box(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            )
            {
                CircularProgressIndicator(
                    color = androidx.compose.ui.graphics.Color.Blue,
                    strokeWidth = 8.dp
                )
                Toast.makeText(context, "SignUp Successful Wait a Movement", Toast.LENGTH_SHORT).show()
                navController.navigate(LP)
            }

        }
    }



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
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
      //Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "KisanMitra",
            fontSize = 32.sp,
            color = Color.White,
            fontFamily = cantoraone,
        )
        Text(
            text = "किसानों को सशक्त बनाना, जीवन को समृद्ध बनाना",
            fontSize = 16.sp,
            color = Color.White,
            fontFamily = cambayregular,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(10.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.9f)
                .fillMaxHeight(fraction = 0.8f)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.White)
                .padding(top = 10.dp)

        ) {
            Column(
                modifier = Modifier.fillMaxSize()
               ,verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

            )
            {
                Text(
                    text = "Sign Up",
                    textAlign = TextAlign.Center,
                    color = Color(0xFF11BD28),
                    fontSize = 26.sp,
                    fontFamily = cantoraone
                )

                Spacer(modifier = Modifier.padding(10.dp))
                //Name
                OutlinedTextField(modifier = Modifier, value = name, onValueChange = {
                    name = it
                    println(it)
                }, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), placeholder = { Text(text = "Name",color = Color.Black) }, leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                }
                )

                Spacer(modifier = Modifier.padding(10.dp))
                //Phone Number
                OutlinedTextField(modifier = Modifier, value = phone, onValueChange = {
                    phone = it
                    println(it)
                }, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ), placeholder =
                {
                    Text(text = "Phone Number",color = Color.Black)
                }, leadingIcon = {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                }
                )

                //Email
                Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(modifier = Modifier, value = emailid, onValueChange = {
                    emailid = it
                    println(it)
                }, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),placeholder = {
                    Text(text = "abc@gmail.com",color = Color.Black)
                                 }
                    ,leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                }
                )


                //Password
                Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(modifier = Modifier, value = passwordA, onValueChange = {
                    passwordA = it
                    println(it)
                }, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),placeholder = {
                    Text(text = "Enter Password",color = Color.Black)
                }
                    ,leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                    }
                )

                //Re-Enter Passord
                Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(modifier = Modifier, value = passwordB, onValueChange = {
                    passwordB = it
                    println(it)
                }, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),placeholder = {
                    Text(text = "Re-Enter Password",color = Color.Black)
                }
                    ,leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                    }
                )

                Spacer(modifier = Modifier.padding(10.dp))
                //Sign Up Button
                    Button(onClick = {
                        if(passwordA==passwordB)
                        {
                            viewModel.signUpUser(name,emailid,phone,passwordA)
                        }
                        else
                        {
                            Toast.makeText(null, "Password Not Match", Toast.LENGTH_SHORT).show()
                        }


//                        if (Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
//                            Toast.makeText(null, "Enter Valid Email", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Toast.makeText(null, "SignUp Successful", Toast.LENGTH_SHORT).show()
//                            //navController.navigate(LP)
//                        }
                    },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 80.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF11BD28), contentColor = Color.White
                        )
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
        //Already an user button
        Spacer(modifier = Modifier.padding(10.dp))
       TextButton(onClick = {
           navController.navigate(LP)
       }) {
           Text(text = "Already an user?\n Login ", textAlign = TextAlign.Center,fontSize = 20.sp, color = Color.White, fontFamily = cantoraone)
           
       }
        }
    }





