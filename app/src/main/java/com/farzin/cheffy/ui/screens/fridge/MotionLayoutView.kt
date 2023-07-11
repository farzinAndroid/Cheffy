package com.farzin.cheffy.ui.screens.fridge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.layoutId
import com.farzin.cheffy.R

@OptIn(ExperimentalMotionApi::class, ExperimentalMotionApi::class)
@Composable
fun MotionLayoutView(progress: Float, scrollableBody: @Composable () -> Unit) {

    val context = LocalContext.current

    val motionScene = remember {

        context.resources
            .openRawResource(R.raw.motion_general)
            .readBytes()
            .decodeToString()

    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        val properties = motionProperties(id = "title_txt")


        Image(
            painter = painterResource(id = R.drawable.image_placeholder),
            contentDescription = null,
            modifier = Modifier
                .layoutId("my_image")
        )

        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .layoutId("back_icon")
        )

        Text(
            text = "TrueLearn.ir",
            fontWeight = FontWeight.Bold,
            color = properties.value.color("text_color"),
            fontSize = 16.sp,
            modifier = Modifier.layoutId("title_txt")
        )



        Icon(
            imageVector = Icons.Filled.Share,
            tint = properties.value.color("text_color"),
            contentDescription = null,
            modifier = Modifier
                .layoutId("share_icon")
        )

        Box(modifier = Modifier.layoutId("content")){
            scrollableBody()
        }

    }
}