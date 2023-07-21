package com.farzin.cheffy.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.farzin.cheffy.R
import com.farzin.cheffy.data.model.home.recommended_section.Result
import com.farzin.cheffy.ui.theme.mainGreen
import com.farzin.cheffy.ui.theme.searchBarColor
import com.farzin.cheffy.ui.theme.seeAllColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CuisineCard(
    item: Result,
    onClick:()->Unit
) {

    var text = ""

    Card(
        shape = Shapes().medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.searchBarColor
        ),

        modifier = Modifier
            .padding(horizontal = 16.dp)
            .width(200.dp)
            .height(250.dp)
            .clickable {
                onClick()
            }
    ) {

        Column() {
            Box(
                modifier = Modifier
                    .weight(0.7f)
                    .background(Color.Gray),
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(item.image)
                            .crossfade(100)
                            .build()
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )



                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(Shapes().medium)
                            .background(Color.LightGray.copy(0.7f))
                    ) {


                        Icon(
                            painter = painterResource(R.drawable.clock),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .size(12.dp),
                            tint = MaterialTheme.colorScheme.mainGreen
                        )

                        Text(
                            text = "${item.readyInMinutes}",
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.mainGreen
                            )
                        )

                        Text(
                            text = stringResource(R.string.min),
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.mainGreen
                            ),
                            modifier = Modifier.padding(end = 4.dp)
                        )


                    }


                }


                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomEnd
                ){

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(Shapes().medium)
                            .background(MaterialTheme.colorScheme.seeAllColor)
                    ) {


                        Icon(
                            painter = painterResource(R.drawable.heart),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .padding(vertical = 4.dp)
                                .size(12.dp),
                            tint = Color.White
                        )

                        Text(
                            text = item.aggregateLikes.toString(),
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ),
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .padding(vertical = 4.dp)
                        )

                    }

                }

            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .basicMarquee(
                        animationMode = MarqueeAnimationMode.Immediately,
                        iterations = Int.MAX_VALUE,
                        spacing = MarqueeSpacing(28.dp),
                        delayMillis = 0,
                        velocity = 20.dp
                    ),
                    maxLines = 1,

                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    item.cuisines.forEach { cuisine ->
                        text += " #$cuisine "
                    }
                    Text(
                        text = text,
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        ),
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .basicMarquee(
                                animationMode = MarqueeAnimationMode.Immediately,
                                iterations = Int.MAX_VALUE,
                                spacing = MarqueeSpacing(28.dp),
                                delayMillis = 0,
                                velocity = 20.dp
                            ),
                        maxLines = 1,
                    )
                }

            }

        }


    }


}