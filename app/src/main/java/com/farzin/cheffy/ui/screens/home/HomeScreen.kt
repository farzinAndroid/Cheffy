package com.farzin.cheffy.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.farzin.cheffy.navigation.Screens
import com.farzin.cheffy.ui.theme.statusBarColor
import com.farzin.cheffy.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    LaunchedEffect(true){
        getAllServerResults(homeViewModel)
    }

    Home(navController)
}

@Composable
fun Home(navController: NavHostController,) {

    LazyColumn(
        modifier = Modifier
            .padding(bottom = 40.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.statusBarColor)
    ){
        item { HomeTopBarSection() }
        item { SearchSection(
            onClick = {
                navController.navigate(Screens.Search.route)
            }
        ) }
        item { RecommendationSection(navController = navController) }
        item { TopCuisinesSection(navController = navController) }
    }

}

private fun getAllServerResults(vm:HomeViewModel){
    vm.getRecommendedFoodsFromServer()
}