package com.farzin.cheffy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.detail.RecipeDetails
import com.farzin.cheffy.data.model.home.recommended_section.RecipeWithInfo
import com.farzin.cheffy.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repo:DetailRepository) : ViewModel() {

    val recipeDetail = MutableStateFlow<NetworkResult<RecipeDetails>>(NetworkResult.Loading())

    fun getRecipeDetail(id:Int){
        viewModelScope.launch {
            recipeDetail.emit(repo.getRecipeDetail(id))
        }
    }

}