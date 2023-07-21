package com.farzin.cheffy.ui.screens.recipeDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.farzin.cheffy.data.model.detail.RecipeDetails
import com.farzin.cheffy.ui.theme.searchBarColor
import com.farzin.cheffy.ui.theme.searchColor

@Composable
fun RecipeDetailHeader(
    recipeDetail : RecipeDetails,
    onBackButtonClicked:()->Unit
) {

    val c = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.searchBarColor),

        ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
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

    }

}