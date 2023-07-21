package com.farzin.cheffy.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.db_model.DBRecipeModel
import com.farzin.cheffy.data.model.detail.RecipeDetails
import com.farzin.cheffy.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repo: DetailRepository) : ViewModel() {

    val recipeDetail = MutableStateFlow<NetworkResult<RecipeDetails>>(NetworkResult.Loading())

    val recipes = repo.recipes

    var isSaved by mutableStateOf(false)

    fun insertRecipe(recipe: DBRecipeModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertRecipe(recipe)
        }

    }


    fun deleteRecipe(recipe: DBRecipeModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteRecipe(recipe)
        }

    }

    fun findById(id: Int): Int {

        return repo.findById(id)


    }


    fun getRecipeDetail(id: Int) {
        viewModelScope.launch {
            recipeDetail.emit(repo.getRecipeDetail(id))
        }
    }

}