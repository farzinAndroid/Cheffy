package com.farzin.cheffy.ui.screens.fridge

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farzin.cheffy.R
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.fridge.FridgeModelItem
import com.farzin.cheffy.data.model.home.recommended_section.Result
import com.farzin.cheffy.viewmodel.FridgeViewModel
import com.farzin.cheffy.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun FridgeSection(
    fridgeViewModel: FridgeViewModel = hiltViewModel(),
) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var loading by remember { mutableStateOf(false) }
    var recipeByIngredientList = remember<List<FridgeModelItem>> { emptyList() }

    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }


    val result by fridgeViewModel.recipeByIngredient.collectAsState()
    when (result) {
        is NetworkResult.Success -> {
            recipeByIngredientList = result.data ?: emptyList()
            loading = false

            if(recipeByIngredientList.isEmpty()){
                Toast.makeText(
                    context,
                    "ingrediets are not valid",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("TAG", "recipeByIngredientList error  ${result.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.whats_in_your_kitchen),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = stringResource(R.string.add_up_three_ingredients),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )


            FridgeTextField(
                number = 1,
                onTextReady = {
                    text1 = it
                }
            )
            FridgeTextField(
                number = 2,
                onTextReady = {
                    text2 = it
                }
            )
            FridgeTextField(
                number = 3,
                onTextReady = {
                    text3 = it
                }
            )


            FridgeButton(
                onClick = {

                   /* if (text1.isNullOrBlank() || text2.isNullOrBlank() || text3.isNullOrBlank()){

                        Toast.makeText(
                            context,
                            "all fields should be filled",
                            Toast.LENGTH_LONG
                        ).show()

                    }*/

                        scope.launch {
                            getRecipeByIngredientFromServer(fridgeViewModel, "potato,tomato,egg")
                        }





                }
            )


            LazyColumn(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {

                items(recipeByIngredientList){fridgeModel->
                    FridgeRecipeItem(fridgeModel)
                }

            }

        }




}

private fun getRecipeByIngredientFromServer(vm: FridgeViewModel, ingredients: String) {
    vm.getRecipeByIngredientFromServer(ingredients)

}