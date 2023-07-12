package com.farzin.cheffy.ui.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

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
            onBackClick = {
                navController.popBackStack()
            },
            navController = navController
        )

    }


}