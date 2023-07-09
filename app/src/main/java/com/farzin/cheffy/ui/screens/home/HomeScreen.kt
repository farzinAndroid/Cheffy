package com.farzin.cheffy.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.farzin.cheffy.navigation.Screens
import com.farzin.cheffy.ui.theme.bottomBarColor
import com.farzin.cheffy.ui.theme.statusBarColor

@Composable
fun HomeScreen() {
    Home()
}

@Composable
fun Home() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.statusBarColor)
    ){}

}