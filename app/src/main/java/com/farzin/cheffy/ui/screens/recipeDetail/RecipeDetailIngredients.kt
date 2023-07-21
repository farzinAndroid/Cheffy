package com.farzin.cheffy.ui.screens.recipeDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farzin.cheffy.R
import com.farzin.cheffy.data.model.detail.ExtendedIngredient
import com.farzin.cheffy.ui.theme.darkText

@Composable
fun RecipeDetailIngredients(
    list:List<ExtendedIngredient>
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = stringResource(R.string.ingredients),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                color = MaterialTheme.colorScheme.darkText
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            list.forEach{ ingredient ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Text(
                        text = stringResource(R.string.dot_bullet),
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            color = MaterialTheme.colorScheme.darkText
                        ),
                        modifier = Modifier
                            .weight(0.1f)
                    )

                    Text(
                        text = ingredient.original,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            color = MaterialTheme.colorScheme.darkText
                        ),
                        modifier = Modifier
                            .weight(0.9f)
                    )

                }
            }

        }

    }

}