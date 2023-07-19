package com.farzin.cheffy.ui.screens.search

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.cheffy.R
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.home.recommended_section.Result
import com.farzin.cheffy.navigation.Screens
import com.farzin.cheffy.ui.theme.searchColor
import com.farzin.cheffy.viewmodel.SearchViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SearchSection(
    onBackClick: () -> Unit,
    navController: NavController,
    searchViewModel: SearchViewModel = hiltViewModel(),
) {

    var text by remember { mutableStateOf("") }

    var searchJob by remember { mutableStateOf<Job?>(null) }
    val courotinScope = rememberCoroutineScope()


    var loading by remember { mutableStateOf(false) }
    var searchList = remember<List<Result>> { emptyList() }

    val result by searchViewModel.recipeSearch.collectAsState()
    when(result){
        is NetworkResult.Success->{
            searchList = result.data?.results ?: emptyList()
            loading = false
        }
        is NetworkResult.Error->{
            loading = false
            Log.e("TAG","searchList error  ${result.message}")
        }
        is NetworkResult.Loading->{
            loading = true
        }
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            color = MaterialTheme.colorScheme.searchColor
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {

                        Box(
                            modifier =
                            Modifier
                                .padding(16.dp)
                                .size(35.dp)
                                .align(Alignment.TopStart)
                                .clip(Shapes().extraLarge)
                                .background(Color.White)
                                .clickable {
                                    onBackClick()
                                }
                        ) {

                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                tint = MaterialTheme.colorScheme.searchColor
                            )
                        }


                        Text(
                            text = stringResource(R.string.recipes),
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            textAlign = TextAlign.Center
                        )

                    }
                }

                BasicTextField(
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    ),
                    value = text,
                    onValueChange = {
                        text = it
                        searchJob?.cancel()
                        searchJob = courotinScope.launch {
                            delay(1000)
                            if (searchViewModel.validateQuery(text)){
                                searchRecipes(searchViewModel,text)
                            }
                        }
                    },
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.searchColor),
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(vertical = 16.dp)
                        .clip(Shapes().extraLarge)
                        .background(Color.White)
                        .fillMaxWidth()
                        .height(45.dp),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                                .padding(horizontal = 16.dp)
                                .weight(0.9f)
                        ) {
                            innerTextField()
                        }
                    })
            }

        }


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(1000.dp)
        ){

            items(searchList){item->
                SearchFoodItem(
                    item = item,
                    onClick = {
                        navController.navigate(Screens.Detail.route+"/${item.id}") {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }

        }



    }


}

private fun searchRecipes(vm:SearchViewModel,q:String){
    vm.searchRecipes(q)
}