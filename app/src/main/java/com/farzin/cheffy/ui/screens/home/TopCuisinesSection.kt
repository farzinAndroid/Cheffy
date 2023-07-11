package com.farzin.cheffy.ui.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farzin.cheffy.R
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.home.recommended_section.Result
import com.farzin.cheffy.ui.theme.mainGreen
import com.farzin.cheffy.ui.theme.seeAllColor
import com.farzin.cheffy.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun TopCuisinesSection(
    homeViewModel: HomeViewModel = hiltViewModel(),
) {



    val cuisines = listOf(
        "Asian",
        "African",
        "European",
        "Middle Eastern",
        "American",
    )

    var selectedTabIndex by remember { mutableStateOf(0) }
    var scope= rememberCoroutineScope()

    var loading by remember { mutableStateOf(false) }
    var recommendedCuisinesList = remember<List<Result>> { emptyList() }

    val result by homeViewModel.recommendedCuisines.collectAsState()
    when (result) {
        is NetworkResult.Success -> {
            recommendedCuisinesList = result.data?.results ?: emptyList()
            loading = false
//            Log.e("TAG","success ${result.data?.results?.get(0)?.pricePerServing}")
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("TAG", "recommendedCuisinesList Error  ${result.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }




    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.top_cuisines),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            )

            Text(
                text = stringResource(R.string.see_all),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.seeAllColor
                )
            )
        }



        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
                .height(60.dp)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            cuisines.forEachIndexed { index, c ->
                CuisineScrollItem(
                    title = c,
                    selectedTabIndex = selectedTabIndex,
                    index = index,
                    onClick = {
                        selectedTabIndex = index
                    }
                )
            }

        }

        /*ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = {
                TabRowDefaults.Indicator(
                    color = Color.Transparent
                )
            },
            divider = {
                Divider(
                    color = Color.Transparent
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            edgePadding = 0.dp
        ) {

            cuisines.forEachIndexed { index, cuisine ->

                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    content = {

                        CuisineScrollItem(
                            title = cuisine,
                            selectedTabIndex = selectedTabIndex,
                            index = index
                        )

                    },
                    selectedContentColor = MaterialTheme.colorScheme.seeAllColor,
                    unselectedContentColor = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  }
                )

            }

        }*/

        when(selectedTabIndex){
            0->{

                LaunchedEffect(true) {
                    getTopCuisineFromServer(homeViewModel,cuisines[0])
                }

                LazyRow(modifier = Modifier.fillMaxWidth()){
                    items(recommendedCuisinesList){item->
                        CuisineCard(item = item)
                    }
                }
            }
            1->{
                LaunchedEffect(true) {
                    getTopCuisineFromServer(homeViewModel,cuisines[1])
                }

                LazyRow(modifier = Modifier.fillMaxWidth()){
                    items(recommendedCuisinesList){item->
                        CuisineCard(item = item)
                    }
                }
            }
            2->{
                LaunchedEffect(true) {
                    getTopCuisineFromServer(homeViewModel,cuisines[2])
                }

                LazyRow(modifier = Modifier.fillMaxWidth()){
                    items(recommendedCuisinesList){item->
                        CuisineCard(item = item)
                    }
                }
            }
            3->{
                LaunchedEffect(true) {
                    getTopCuisineFromServer(homeViewModel,cuisines[3])
                }

                LazyRow(modifier = Modifier.fillMaxWidth()){
                    items(recommendedCuisinesList){item->
                        CuisineCard(item = item)
                    }
                }
            }
            4->{
                LaunchedEffect(true) {
                    getTopCuisineFromServer(homeViewModel,cuisines[4])
                }

                LazyRow(modifier = Modifier.fillMaxWidth()){
                    items(recommendedCuisinesList){item->
                        CuisineCard(item = item)
                    }
                }
            }

        }




    }

}

private fun getTopCuisineFromServer(vm:HomeViewModel,cuisine:String){
        vm.getTopCuisineFromServer(cuisine)

}