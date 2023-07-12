package com.farzin.cheffy.ui.screens.recipeDetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farzin.cheffy.R
import com.farzin.cheffy.ui.theme.darkText
import com.farzin.cheffy.ui.theme.iconColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeDetailTitle(
    title: String,
    min: Int,
    servings: Int,
    credit: String,
) {

    val creditText =
        if (credit.isNullOrBlank() || credit.isNullOrEmpty()) stringResource(R.string.unkmown)
        else credit

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .padding(horizontal = 8.dp)
        ) {

            Column(
                modifier = Modifier
                    .weight(0.8f)
                    .padding(start = 24.dp)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        color = MaterialTheme.colorScheme.darkText,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
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
                            tint = MaterialTheme.colorScheme.darkText
                        )

                        Text(
                            text = " $min ${stringResource(R.string.min)}",
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                color = MaterialTheme.colorScheme.darkText,
                                fontWeight = FontWeight.Normal
                            )
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
                            tint = MaterialTheme.colorScheme.darkText
                        )

                        Text(
                            text = " $servings ${stringResource(R.string.servings)}",
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                color = MaterialTheme.colorScheme.darkText,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }



                    Text(
                        text = creditText,
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            color = MaterialTheme.colorScheme.darkText,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier
                            .width(50.dp)
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

            Column(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LikeButton()
            }

        }

    }

}