package com.example.kisan_mitra.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kisan_mitra.screen.forgotpassword
import com.example.kisan_mitra.screen.homescreen
import com.example.kisan_mitra.screen.login
import com.example.kisan_mitra.screen.signup
import com.example.kisan_mitra.ui.AppViewModel


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App(modifier: Modifier = Modifier)
{
    val navController= rememberNavController()
    val appViewModel: AppViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination =LP)
    {
        composable<LP> {
            login(
                navController,appViewModel
            )
        }
        composable<SP> {
            signup(
                navController,appViewModel
            )
        }
        composable<FP> {
            forgotpassword(
                navController
            )
        }
        composable<HP> {
            //activity.window.statusBarColor = getColor(R.color.black)
            homescreen(
                navController
            )
        }

    }

}