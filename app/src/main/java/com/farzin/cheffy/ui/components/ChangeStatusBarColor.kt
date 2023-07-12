package com.farzin.cheffy.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.farzin.cheffy.navigation.Screens
import com.farzin.cheffy.ui.theme.mainGreen
import com.farzin.cheffy.ui.theme.searchColor
import com.farzin.cheffy.ui.theme.statusBarColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChangeStatusBarColor(
    navController: NavHostController,
) {

    val backStack by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()

    val statusBarColor = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.mainGreen else
        Color.White

    val status = MaterialTheme.colorScheme.statusBarColor
    val searchStatus = MaterialTheme.colorScheme.searchColor

    when(backStack?.destination?.route){
        Screens.Welcome.route->{
            SideEffect {
                systemUiController.setStatusBarColor(statusBarColor)
            }
        }
        Screens.Search.route->{
            SideEffect {
                systemUiController.setStatusBarColor(searchStatus)
            }
        }

        else->{
            SideEffect {
                systemUiController.setStatusBarColor(status)
            }
        }
    }




}