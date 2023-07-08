package com.farzin.cheffy.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.farzin.cheffy.ui.theme.mainGreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChangeStatusBarColor(
    navController: NavHostController,
) {

    val systemUiController = rememberSystemUiController()

    val statusBarColor = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.mainGreen else
        Color.White


    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor)
    }


}