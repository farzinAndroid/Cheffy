package com.farzin.cheffy.ui.screens.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.farzin.cheffy.R
import com.farzin.cheffy.data.model.home.recommended_section.Result
import com.farzin.cheffy.ui.theme.darkText
import com.farzin.cheffy.ui.theme.iconColor
import com.farzin.cheffy.ui.theme.searchBarColor
import com.farzin.cheffy.ui.theme.searchColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchFoodItem(
    item:Result
) {


    val c = LocalContext.current

    val summary = item.summary

    val annotatedText = remember(summary) {
        HtmlCompat.fromHtml(summary, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable {  },
        shape = Shapes().large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.searchBarColor
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
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
                            tint = Color.Gray
                        )

                        Text(
                            text = "${item.readyInMinutes} ${stringResource(R.string.min)}",
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.darkText
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
                            tint = Color.Gray
                        )

                        Text(
                            text = item.servings.toString(),
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.darkText
                            ),
                            modifier = Modifier,
                            maxLines =1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.darkText
                        ),
                        modifier = Modifier
                            .basicMarquee(
                                animationMode = MarqueeAnimationMode.Immediately,
                                iterations = Int.MAX_VALUE,
                                spacing = MarqueeSpacing(28.dp),
                                delayMillis = 0,
                                velocity = 20.dp
                            ),
                        maxLines =1,
                        overflow = TextOverflow.Ellipsis,


                    )

                }

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Text(
                        text = annotatedText.toString(),
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        ),
                        modifier = Modifier,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,


                        )
                }

            }

            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(c)
                        .data(item.image)
                        .crossfade(100)
                        .build()
                ),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.4f),
                contentScale = ContentScale.Crop
            )

        }


    }

}