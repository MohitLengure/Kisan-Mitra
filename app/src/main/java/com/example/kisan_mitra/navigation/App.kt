package com.example.kisan_mitra.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kisan_mitra.screen.forgotpassword
import com.example.kisan_mitra.screen.homescreen
import com.example.kisan_mitra.screen.login
import com.example.kisan_mitra.screen.signup


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App(modifier: Modifier = Modifier)
{
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination =SP)
    {
        composable<LP> {
            login(
                navController
            )
        }
        composable<SP> {
            signup(
                navController
            )
        }
        composable<FP> {
            forgotpassword(
                navController
            )
        }
        composable<HP> {
            homescreen(
                navController
            )
        }
    }

}