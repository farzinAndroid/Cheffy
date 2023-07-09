package com.farzin.cheffy.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.farzin.cheffy.ui.screens.home.HomeScreen
import com.farzin.cheffy.ui.screens.onboarding.OnBoardingScreen
import com.farzin.cheffy.ui.screens.save.SaveScreen
import com.farzin.cheffy.ui.screens.search.SearchScreen
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
    ) {
        composable(Screens.Welcome.route) {

            OnBoardingScreen(
                onClick = {
                    dataStoreViewModel.saveOnBoardingState(true)
                    navController.popBackStack()
                    navController.navigate(Screens.Home.route)
                }
            )


        }

        composable(Screens.Home.route) {
            HomeScreen()
        }

        composable(Screens.Save.route) {
            SaveScreen()
        }

        composable(Screens.Search.route) {
            SearchScreen()
        }


    }

}