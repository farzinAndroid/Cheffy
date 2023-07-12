package com.farzin.cheffy.repository

import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.home.recommended_section.RecipeWithInfo
import com.farzin.cheffy.data.remote.home.BaseApiResponse
import com.farzin.cheffy.data.remote.serach.SearchApiInterface
import javax.inject.Inject

class SearchRepository @Inject constructor(private val api:SearchApiInterface) : BaseApiResponse() {

    suspend fun searchRecipes(q:String) : NetworkResult<RecipeWithInfo> =
        safeApiCall {
            api.searchRecipes(q)
        }

}