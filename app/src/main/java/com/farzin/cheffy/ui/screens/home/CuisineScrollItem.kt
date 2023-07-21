package com.farzin.cheffy.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farzin.cheffy.ui.theme.darkText
import com.farzin.cheffy.ui.theme.seeAllColor

@Composable
fun CuisineScrollItem(
    title: String,
    selectedTabIndex:Int,
    index:Int,
    onClick:()->Unit
) {

    val textColor = if (selectedTabIndex == index) MaterialTheme.colorScheme.seeAllColor
    else MaterialTheme.colorScheme.darkText

    val surfaceColor = if (selectedTabIndex == index) MaterialTheme.colorScheme.seeAllColor.copy(0.2f)
        else Color.Transparent


    Surface(
        modifier = Modifier
            .height(40.dp)
            .wrapContentWidth()
            .clickable { onClick() },
        shape = Shapes().small,
        border = BorderStroke(width = 1.dp, color = textColor),
        color = surfaceColor
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = title,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            )

        }

    }


}