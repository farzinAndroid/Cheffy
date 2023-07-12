package com.farzin.cheffy.repository

import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.detail.RecipeDetails
import com.farzin.cheffy.data.remote.detail.DetailApiInterface
import com.farzin.cheffy.data.remote.BaseApiResponse
import javax.inject.Inject

class DetailRepository @Inject constructor(private val api:DetailApiInterface) : BaseApiResponse() {

    suspend fun getRecipeDetail(id:Int) : NetworkResult<RecipeDetails> =
        safeApiCall {
            api.getRecipeDetail(id)
        }

}