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

val ColorScheme.bottomBarColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF605212) else Color(0xFF9B9A9A)

val ColorScheme.bottomItemColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFFFFFF) else Color(0xFF605212)

val ColorScheme.statusBarColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF313131) else Color(0xFFFFFFFF)

val ColorScheme.chefHatColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFFFFFF) else Color(0xFF00A324)

val ColorScheme.searchBarColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF464646) else Color(0xFFE2E1E1)

val ColorScheme.seeAllColor: Color
    @Composable
    get() = Color(0xFF00A324)

val ColorScheme.iconColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFFFFFF) else Color(0xFF00A324)

val ColorScheme.darkText: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFFFFFF) else Color(0xFF000000)

val ColorScheme.unusedIngredientColor: Color
    @Composable
    get() = Color(0xFFFA2C2C)


val ColorScheme.searchColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF464646) else Color(0xFF00A324)


val ColorScheme.loading: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFFFFFF) else Color(0xFF00A324)





