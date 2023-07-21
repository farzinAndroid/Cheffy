package com.farzin.cheffy.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.farzin.cheffy.navigation.Screens
import com.farzin.cheffy.ui.theme.statusBarColor
import com.farzin.cheffy.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {

    LaunchedEffect(true) {
        getAllServerResults(homeViewModel)
    }

    Home(navController,homeViewModel)
}

@Composable
fun Home(navController: NavHostController,homeViewModel: HomeViewModel,) {


   SwipeRefreshSection(
       homeViewModel = homeViewModel,
       navController = navController
   )

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SwipeRefreshSection(
    homeViewModel: HomeViewModel,
    navController: NavHostController,
) {

    val onRefresh = rememberCoroutineScope()
    val swipeRefreshState = rememberPullRefreshState(refreshing = false, onRefresh = {
        onRefresh.launch {
            getAllServerResults(homeViewModel)
            Log.e("TAG", "Refresh")
        }
    })

    Box(
        Modifier.pullRefresh(swipeRefreshState)
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(bottom = 60.dp)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.statusBarColor)
        ) {
            item { HomeTopBarSection() }
            item {
                SearchSection(
                    onClick = {
                        navController.navigate(Screens.Search.route)
                    }
                )
            }
            item { RecommendationSection(navController = navController) }
            item { TopCuisinesSection(navController = navController) }
        }


        PullRefreshIndicator(
            refreshing = false,
            state = swipeRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
        )
    }

}

private fun getAllServerResults(vm: HomeViewModel) {
    vm.getRecommendedFoodsFromServer()
}