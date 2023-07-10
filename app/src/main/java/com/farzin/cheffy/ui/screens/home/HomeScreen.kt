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
import com.farzin.cheffy.ui.theme.statusBarColor
import com.farzin.cheffy.viewmodel.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {

    LaunchedEffect(true){
        getAllServerResults(homeViewModel)
    }

    Home()
}

@Composable
fun Home() {

    LazyColumn(
        modifier = Modifier
            .padding(bottom = 40.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.statusBarColor)
    ){
        item { HomeTopBarSection() }
        item { SearchSection() }
        item { RecommendationSection() }
        item { TopCuisinesSection() }
    }

}

private fun getAllServerResults(vm:HomeViewModel){
    vm.getAllServerResults()
}