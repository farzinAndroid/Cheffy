package com.farzin.cheffy.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ScrollableContent() {

    LazyColumn(){
        items(100){
            Text(text = it.toString())
        }
    }

}