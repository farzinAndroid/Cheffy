package com.farzin.cheffy.data.remote.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.farzin.cheffy.data.model.home.Recommendation
import com.farzin.cheffy.ui.theme.searchBarColor

@Composable
fun RecommendationCard(
    item:Recommendation
) {

    val image = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(item.image)
            .crossfade(100)
            .scale(Scale.FILL)
            .build()
    )

    Card(
        modifier = Modifier
            .width(200.dp)
            .height(270.dp)
            .padding(16.dp)
            .clickable { },
        shape = Shapes().medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.searchBarColor
        )
    ) {

        Column{

            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(item.image)
                        .crossfade(100)
                        .build()
                ),
                contentDescription = "",
                modifier = Modifier
                    .weight(0.8f),
                contentScale = ContentScale.Crop
            )

            Text(
                text = item.title,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .weight(0.2f)
                    .padding(vertical = 8.dp)
                    .padding(horizontal = 8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

        }

    }


}