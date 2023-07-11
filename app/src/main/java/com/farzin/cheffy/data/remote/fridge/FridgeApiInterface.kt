package com.farzin.cheffy.data.remote.fridge

import com.farzin.cheffy.data.model.fridge.FridgeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FridgeApiInterface {

    @GET("findByIngredients")
    suspend fun getRecipeByIngredient(
        @Query("number") number:Int = 100,
        @Query("ingredients") ingredients:String,
    ) : Response<FridgeModel>

}