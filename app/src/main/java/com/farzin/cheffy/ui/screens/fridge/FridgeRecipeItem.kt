package com.farzin.cheffy.ui.screens.fridge

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.farzin.cheffy.R
import com.farzin.cheffy.data.model.fridge.FridgeModelItem
import com.farzin.cheffy.ui.theme.darkText
import com.farzin.cheffy.ui.theme.searchBarColor
import com.farzin.cheffy.ui.theme.unusedIngredientColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FridgeRecipeItem(
    item:FridgeModelItem
) {

    val context = LocalContext.current
    var missed = ""
    var used = ""

    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable { },
        shape = Shapes().medium,
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.searchBarColor
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(context)
                        .data(item.image)
                        .crossfade(100)
                        .scale(Scale.FIT)
                        .build()
                ),
                contentDescription = "",
                modifier = Modifier
                    .weight(0.4f),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(0.6f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        color = MaterialTheme.colorScheme.darkText,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(0.4f)
                )

                Row(
                    modifier =Modifier
                        .fillMaxWidth()
                        .weight(0.3f)
                ) {



                    item.missedIngredients.forEach {
                        missed += "#${it.name}  "
                    }

                    Text(
                        text = missed,
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            color = MaterialTheme.colorScheme.unusedIngredientColor,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .basicMarquee(
                                animationMode = MarqueeAnimationMode.Immediately,
                                iterations = Int.MAX_VALUE,
                                spacing = MarqueeSpacing(28.dp),
                                delayMillis = 0,
                                velocity = 20.dp
                            )
                    )

                }



                Row(
                    modifier =Modifier
                        .fillMaxWidth()
                        .weight(0.3f)
                ) {

                    item.usedIngredients.forEach {
                        used += "#${it.name}  "
                    }
                    Text(
                        text = used,
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            color = Color.Gray,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .basicMarquee(
                                animationMode = MarqueeAnimationMode.Immediately,
                                iterations = Int.MAX_VALUE,
                                spacing = MarqueeSpacing(28.dp),
                                delayMillis = 0,
                                velocity = 20.dp
                            )
                    )
                }
            }
        }
    }
}