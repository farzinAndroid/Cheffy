package com.farzin.cheffy.navigation

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavItem(
    val deselectedIcon:Painter,
    val selectedIcon:Painter,
    val route:String
)
