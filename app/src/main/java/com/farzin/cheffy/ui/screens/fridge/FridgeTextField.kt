package com.farzin.cheffy.ui.screens.fridge

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farzin.cheffy.ui.theme.darkText
import com.farzin.cheffy.ui.theme.seeAllColor

@Composable
fun FridgeTextField(
    number: Int,
    onTextReady: (String) -> Unit,
) {

    var text by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "$number.",
            style = TextStyle(
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .weight(0.1f)
        )

        BasicTextField(
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.darkText,
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            ),
            value = text,
            onValueChange = {
                text = it
                onTextReady(text)
            },
            cursorBrush = SolidColor(MaterialTheme.colorScheme.seeAllColor),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .padding(horizontal = 16.dp)
                .weight(0.9f),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            color = MaterialTheme.colorScheme.seeAllColor,
                            width = 1.dp,
                            shape = Shapes().extraLarge
                        )
                        .padding(12.dp)
                ) {
                    /*//Icon(Icons.Default.Check, contentDescription = "", tint = Color.White)
                    if (text.isEmpty()) {
                        Text(text = "", color = Color(0x9C616161), fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.padding(3.dp))*/
                    innerTextField()
                }
            }
        )


    }


}