package com.farzin.cheffy.ui.screens.recipeDetail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.db_model.DBRecipeModel
import com.farzin.cheffy.data.model.detail.RecipeDetails
import com.farzin.cheffy.data.model.detail.WinePairing
import com.farzin.cheffy.ui.theme.searchBarColor
import com.farzin.cheffy.ui.theme.searchColor
import com.farzin.cheffy.utils.Constants.PLACEHOLDER
import com.farzin.cheffy.viewmodel.DetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun RecipeDetailScreen(
    id: Int,
    detailViewModel: DetailViewModel = hiltViewModel(),
    onBackButtonClicked: () -> Unit,
) {



    LaunchedEffect(true) {
        getRecipeDetailFromServer(detailViewModel, id)
    }

    val scope = rememberCoroutineScope()
    var loading by remember { mutableStateOf(false) }
    var isSaved by remember { mutableStateOf(false) }
    var recipeDetail = remember { emptyRecipeDetails() }
    val c = LocalContext.current


    LaunchedEffect(true){

        scope.launch(Dispatchers.IO) {
            isSaved = if (detailViewModel.findById(id) == id){

                Log.e("TAG","already exists")
                true

            }else{

                Log.e("TAG","dont exists")
                false

            }
        }

    }


    val result by detailViewModel.recipeDetail.collectAsState()
    when (result) {
        is NetworkResult.Success -> {
            recipeDetail = result.data ?: emptyRecipeDetails()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("TAG", "recipeDetail error  ${result.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }


    if (loading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.searchBarColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.searchBarColor),

            ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    Image(
                        painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(c)
                                .data(recipeDetail.image)
                                .scale(Scale.FIT)
                                .crossfade(100)
                                .build()
                        ),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )

                    Box(
                        modifier =
                        Modifier
                            .padding(16.dp)
                            .size(35.dp)
                            .align(Alignment.TopStart)
                            .clip(Shapes().extraLarge)
                            .background(Color.White)
                            .clickable {
                                onBackButtonClicked()
                            }
                    ) {

                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            tint = MaterialTheme.colorScheme.searchColor
                        )
                    }


                }


            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f),
                shape = RoundedCornerShape(
                    topStartPercent = 8,
                    topEndPercent = 8,
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    item {
                        RecipeDetailTitle(
                            title = recipeDetail.title,
                            min = recipeDetail.readyInMinutes,
                            servings = recipeDetail.servings,
                            credit = recipeDetail.creditsText,
                            onSaveClicked = {

                                if (isSaved){
                                    isSaved = !isSaved
                                    detailViewModel.deleteRecipe(
                                        DBRecipeModel(
                                            itemId = recipeDetail.id,
                                            image = recipeDetail.image ?: PLACEHOLDER,
                                            title = recipeDetail.title,
                                            desc = recipeDetail.summary,
                                            serving = recipeDetail.servings,
                                            time = recipeDetail.readyInMinutes,
                                            source = recipeDetail.sourceName
                                        )
                                    )
                                } else{
                                    isSaved = !isSaved
                                    detailViewModel.insertRecipe(
                                        DBRecipeModel(
                                            itemId = recipeDetail.id,
                                            image = recipeDetail.image ?: PLACEHOLDER,
                                            title = recipeDetail.title,
                                            desc = recipeDetail.summary,
                                            serving = recipeDetail.servings,
                                            time = recipeDetail.readyInMinutes,
                                            source = recipeDetail.sourceName
                                        )
                                    )
                                }


                            },
                            isSaved = isSaved
                        )
                    }

                    item {
                        RecipeDetailDescription(
                            desc = recipeDetail.summary
                        )
                    }

                    item {
                        RecipeDetailIngredients(
                            list = recipeDetail.extendedIngredients
                        )
                    }

                    item {
                        RecipeDetailSteps(
                            steps = recipeDetail.analyzedInstructions
                        )
                    }

                }


            }


        }
    }


}

private fun getRecipeDetailFromServer(vm: DetailViewModel, id: Int) {
    vm.getRecipeDetail(id)
}

private fun emptyRecipeDetails(): RecipeDetails {
    return RecipeDetails(
        aggregateLikes = 0,
        analyzedInstructions = emptyList(),
        cheap = false,
        cookingMinutes = 0,
        creditsText = "",
        cuisines = emptyList(),
        dairyFree = false,
        diets = emptyList(),
        dishTypes = emptyList(),
        extendedIngredients = emptyList(),
        gaps = "",
        glutenFree = false,
        healthScore = 0,
        id = 0,
        image = "",
        imageType = "",
        instructions = "",
        license = "",
        lowFodmap = false,
        occasions = emptyList(),
        originalId = null,
        preparationMinutes = 0,
        pricePerServing = 0.0,
        readyInMinutes = 0,
        servings = 0,
        sourceName = "",
        sourceUrl = "",
        spoonacularSourceUrl = "",
        summary = "",
        sustainable = false,
        title = "",
        vegan = false,
        vegetarian = false,
        veryHealthy = false,
        veryPopular = false,
        weightWatcherSmartPoints = 0,
        winePairing = WinePairing(emptyList(), "", emptyList())
    )
}