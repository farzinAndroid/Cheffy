package com.farzin.cheffy.data.remote.home

import com.farzin.cheffy.data.model.home.recommended_section.RecipeWithInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiInterface {


    @GET("complexSearch")
    suspend fun getRecommendation(
        @Query("number") number:Int = 10,
        @Query("addRecipeInformation") addRecipeInformation:Boolean = true,
    ) : Response<RecipeWithInfo>

    @GET("complexSearch")
    suspend fun getRecommendedCuisines(
        @Query("number") number:Int = 10,
        @Query("addRecipeInformation") addRecipeInformation:Boolean = true,
        @Query("cuisine") cuisine:String,
    ) : Response<RecipeWithInfo>

}