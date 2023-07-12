package com.farzin.cheffy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.home.recommended_section.RecipeWithInfo
import com.farzin.cheffy.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repo:SearchRepository) : ViewModel() {

    val recipeSearch = MutableStateFlow<NetworkResult<RecipeWithInfo>>(NetworkResult.Loading())

    fun searchRecipes(q:String){

        viewModelScope.launch {
            recipeSearch.emit(repo.searchRecipes(q))
        }

    }

    fun validateQuery(query: String): Boolean = query.length >= 3

}