package com.farzin.cheffy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.cheffy.data.dataStore.DataStoreRepository
import com.farzin.cheffy.data.dataStore.DataStoreRepositoryImpl
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(private val repo:DataStoreRepository) : ViewModel() {



    companion object{
        const val ON_BOARDING_KEY = "on_boarding_key"
    }


    fun saveOnBoardingState(value:Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repo.putBoolean(ON_BOARDING_KEY,value)
        }
    }

    fun getOnBoardingState() : Boolean? = runBlocking {
        repo.getBoolean(ON_BOARDING_KEY)
    }

}