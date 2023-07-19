package com.farzin.cheffy.ui.screens.recipeDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.farzin.cheffy.R
import com.farzin.cheffy.ui.theme.seeAllColor

@Composable
fun SaveButton(
    onSaveClicked: () -> Unit,
    isSaved:Boolean
) {

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.seeAllColor)
            .size(40.dp)
            .clickable {
                onSaveClicked()
            },
        contentAlignment = Alignment.Center
    ) {

        if (isSaved){

            Icon(
                painter = painterResource(R.drawable.selected_saved),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                tint = Color.White
            )

        }else{

            Icon(
                painter = painterResource(R.drawable.unselected_saved),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                tint = Color.White
            )

        }


    }

}