package com.farzin.cheffy.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.farzin.cheffy.ui.theme.mainGreen
import com.farzin.cheffy.ui.theme.onBoarding

@Composable
fun SearchScreen(navController: NavHostController) {
    Search(navController = navController)
}

@Composable
fun Search(navController: NavHostController) {




    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        SearchSection(
            onClick = {
                navController.popBackStack()
            }
        )

    }


}