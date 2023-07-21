package com.farzin.cheffy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.fridge.FridgeModel
import com.farzin.cheffy.repository.FridgeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FridgeViewModel @Inject constructor(private val repo:FridgeRepository) : ViewModel() {

    val recipeByIngredient = MutableStateFlow<NetworkResult<FridgeModel>>(NetworkResult.Loading())


    fun getRecipeByIngredientFromServer(ingredient:String) {
        viewModelScope.launch {

            launch {
                recipeByIngredient.emit(repo.getRecipeByIngredient(ingredient))
            }

        }
    }

}