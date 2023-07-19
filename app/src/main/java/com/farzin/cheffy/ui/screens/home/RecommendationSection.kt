package com.farzin.cheffy.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.farzin.cheffy.R
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.home.recommended_section.Result
import com.farzin.cheffy.navigation.Screens
import com.farzin.cheffy.ui.theme.seeAllColor
import com.farzin.cheffy.viewmodel.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun RecommendationSection(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {


    var loading by remember { mutableStateOf(false) }
    var recommendedList = remember<List<Result>> { emptyList() }
    val state = rememberPagerState()

    val result by homeViewModel.recommended.collectAsState()
    when(result){
        is NetworkResult.Success->{
            recommendedList = result.data?.results ?: emptyList()
            loading = false
        }
        is NetworkResult.Error->{
            loading = false
            Log.e("TAG","recommendedList error  ${result.message}")
        }
        is NetworkResult.Loading->{
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
                .padding(vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.recommedations),
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



        LazyRow(
            modifier =Modifier
                .fillMaxWidth(),
        ){
            items(recommendedList){item->
                RecommendationCard(
                    item = item,
                    onClick = {id->
                        navController.navigate(Screens.Detail.route+"/$id"){
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }



    }


}


