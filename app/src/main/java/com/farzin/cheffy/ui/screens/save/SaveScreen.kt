package com.farzin.cheffy.ui.screens.save

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.cheffy.navigation.Screens
import com.farzin.cheffy.ui.screens.home.RecommendationCard
import com.farzin.cheffy.viewmodel.DetailViewModel

@Composable
fun SaveScreen(navController: NavController) {
    SaveSection(navController)
}


@Composable
fun SaveSection(
    navController: NavController,
    detailViewModel: DetailViewModel = hiltViewModel(),
) {



    val savedRecipesResult = detailViewModel.recipes.collectAsState(initial = emptyList())

    val list = savedRecipesResult.value


    LazyVerticalGrid(
        modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 60.dp),
        columns = GridCells.Fixed(2)
    ){

        items(list){item ->
            RecommendationCard(
                item = item,
                onClick = {
                    navController.navigate(Screens.Detail.route + "/${item.itemId}")
                }
            )
        }

    }


}