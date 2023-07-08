package com.farzin.cheffy.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.farzin.cheffy.ui.screens.home.HomeScreen
import com.farzin.cheffy.ui.screens.onboarding.OnBoardingScreen
import com.farzin.cheffy.viewmodel.DataStoreViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){

        composable(Screens.Welcome.route){
            OnBoardingScreen(
                onClick = {
                    dataStoreViewModel.saveOnBoardingState(true)
                    navController.popBackStack()
                    navController.navigate(Screens.Home.route)
                }
            )
        }

        composable(Screens.Home.route){
            HomeScreen()
        }


    }

}