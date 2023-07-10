package com.farzin.cheffy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.home.recommended_section.RecipeWithInfo
import com.farzin.cheffy.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: HomeRepository) : ViewModel() {

    val reccommended = MutableStateFlow<NetworkResult<RecipeWithInfo>>(NetworkResult.Loading())
    val recommendedCuisines =
        MutableStateFlow<NetworkResult<RecipeWithInfo>>(NetworkResult.Loading())


    fun getAllServerResults() {
        viewModelScope.launch {

            launch {
                reccommended.emit(repo.getRecommendation())
            }

            launch {
                recommendedCuisines.emit(repo.getRecommendedCuisines(getCuisine()))
            }

        }
    }


    private fun getCuisine(): String {
        val cuisines = listOf(
            "African",
            "Asian",
            "American",
            "British",
            "Cajun",
            "Caribbean",
            "Chinese",
            "Eastern European",
            "European",
            "French",
            "German",
            "Greek",
            "Indian",
            "Irish",
            "Italian",
            "Japanese",
            "Jewish",
            "Korean",
            "Latin American",
            "Mediterranean",
            "Mexican",
            "Middle Eastern",
            "Nordic",
            "Southern",
            "Spanish",
            "Thai",
            "Vietnamese"
        )
        val index = (System.currentTimeMillis() / (24 * 60 * 60 * 1000)) % cuisines.size
        return cuisines[index.toInt()]
    }


}