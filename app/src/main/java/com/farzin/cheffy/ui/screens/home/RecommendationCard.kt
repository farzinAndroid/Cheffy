package com.farzin.cheffy.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.farzin.cheffy.R
import com.farzin.cheffy.data.model.db_model.DBRecipeModel
import com.farzin.cheffy.data.model.home.recommended_section.Result
import com.farzin.cheffy.ui.theme.iconColor
import com.farzin.cheffy.ui.theme.searchBarColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendationCard(
    item: Result,
    onClick:(Int)->Unit
) {

    Card(
        modifier = Modifier
            .width(200.dp)
            .height(270.dp)
            .padding(16.dp)
            .clickable { onClick(item.id) },
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
                    .weight(0.7f),
                contentScale = ContentScale.Crop
            )

            Text(
                text = item.title,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .weight(0.2f)
                    .padding(vertical = 8.dp)
                    .padding(horizontal = 8.dp)
                    .basicMarquee(
                        animationMode = MarqueeAnimationMode.Immediately,
                        iterations = Int.MAX_VALUE,
                        spacing = MarqueeSpacing(28.dp),
                        delayMillis = 0,
                        velocity = 20.dp
                    ),
                maxLines =1,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.clock),
                        contentDescription = "",
                        modifier = Modifier
                            .size(14.dp),
                        tint = MaterialTheme.colorScheme.iconColor
                    )

                    Text(
                        text = "${item.readyInMinutes} ${stringResource(R.string.min)}",
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier,
                        maxLines =1,
                        overflow = TextOverflow.Ellipsis
                    )
                }




                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.serving),
                        contentDescription = "",
                        modifier = Modifier
                            .size(14.dp),
                        tint = MaterialTheme.colorScheme.iconColor
                    )

                    Text(
                        text = item.servings.toString(),
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier,
                        maxLines =1,
                        overflow = TextOverflow.Ellipsis
                    )
                }


            }


        }

    }


}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendationCard(
    item: DBRecipeModel,
    onClick:(Int)->Unit
) {

    Card(
        modifier = Modifier
            .width(200.dp)
            .height(270.dp)
            .padding(16.dp)
            .clickable { onClick(item.itemId) },
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
                    .weight(0.7f),
                contentScale = ContentScale.Crop
            )

            Text(
                text = item.title,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .weight(0.2f)
                    .padding(vertical = 8.dp)
                    .padding(horizontal = 8.dp)
                    .basicMarquee(
                        animationMode = MarqueeAnimationMode.Immediately,
                        iterations = Int.MAX_VALUE,
                        spacing = MarqueeSpacing(28.dp),
                        delayMillis = 0,
                        velocity = 20.dp
                    ),
                maxLines =1,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.clock),
                        contentDescription = "",
                        modifier = Modifier
                            .size(14.dp),
                        tint = MaterialTheme.colorScheme.iconColor
                    )

                    Text(
                        text = "${item.time} ${stringResource(R.string.min)}",
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier,
                        maxLines =1,
                        overflow = TextOverflow.Ellipsis
                    )
                }




                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.serving),
                        contentDescription = "",
                        modifier = Modifier
                            .size(14.dp),
                        tint = MaterialTheme.colorScheme.iconColor
                    )

                    Text(
                        text = item.serving.toString(),
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier,
                        maxLines =1,
                        overflow = TextOverflow.Ellipsis
                    )
                }


            }


        }

    }


}