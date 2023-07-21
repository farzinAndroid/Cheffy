package com.farzin.cheffy.repository

import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.fridge.FridgeModel
import com.farzin.cheffy.data.remote.BaseApiResponse
import com.farzin.cheffy.data.remote.fridge.FridgeApiInterface
import javax.inject.Inject

class FridgeRepository @Inject constructor(private val api:FridgeApiInterface) : BaseApiResponse() {

    suspend fun getRecipeByIngredient(ingredients:String) :NetworkResult<FridgeModel> =
        safeApiCall {
            api.getRecipeByIngredient(ingredients = ingredients)
        }


}