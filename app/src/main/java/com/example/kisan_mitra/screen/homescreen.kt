package com.example.kisan_mitra.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kisan_mitra.data.NavItem
import com.example.kisan_mitra.ui.theme.cantoraone
import com.example.kisan_mitra.screen.Notification

import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homescreen(navController: NavHostController)
{
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())


    val navItemList = listOf(
        NavItem("Home",Icons.Default.Home,0),
        NavItem("Notification",Icons.Default.Notifications,5),
        NavItem("Contact Us",Icons.Default.Call,0),
        NavItem("Profile",Icons.Default.Person,0),

        )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF11BD28), titleContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = { /* do somet

                    hing */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        text = "KisanMitra",
                        fontSize = 32.sp,
                        fontFamily = cantoraone,
                    )
                },

                scrollBehavior = scrollBehavior
            )})
    {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                NavigationBar {
                    navItemList.forEachIndexed{
                            index, navItem ->
                        NavigationBarItem(
                            selected = selectedIndex==index,
                            onClick = {

                            },
                            icon = {
                                BadgedBox(badge = {
                                    if(navItem.badgeCount>0)
                                        Badge(){
                                            Text(text = navItem.badgeCount.toString())
                                        }
                                }) {
                                    Icon(imageVector = navItem.icon, contentDescription =null )
                                }

                            },
                            label = {
                                Text(text = navItem.label)
                            }

                        )
                    }
                }
            }

        ) { innerPadding ->
            ContentScreen(modifier=Modifier.padding(innerPadding),selectedIndex)
        }


    }



}




@Composable
fun ContentScreen(modifier: Modifier=Modifier,selectedIndex:Int)
{
    when(selectedIndex)
    {
        0->HomePage()
        1->Notification()
        2->Contact()
        3-> Profile()
    }
}

