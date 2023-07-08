package com.farzin.cheffy.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val ColorScheme.onBoarding: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF605212) else Color(0xFFFFFFFF)

val ColorScheme.mainGreen: Color
    @Composable
    get() = Color(0xFF605212)

val ColorScheme.onBoardingButton: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFFFFFF) else Color(0xFF605212)



