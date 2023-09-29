package com.farzin.cheffy.ui.screens.fridge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FridgeScreen(navController: NavController) {

    Fridge(navController)

}

@Composable
fun Fridge(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
    ) {

        FridgeSection(navController = navController)


    }


}