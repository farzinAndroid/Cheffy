package com.farzin.cheffy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.home.RecommendationModel
import com.farzin.cheffy.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo:HomeRepository) : ViewModel() {

    val reccommended = MutableStateFlow<NetworkResult<RecommendationModel>>(NetworkResult.Loading())



    fun getAllServerResults(){
        viewModelScope.launch {

            launch {
                reccommended.emit(repo.getRecommendation())
            }

        }
    }


}