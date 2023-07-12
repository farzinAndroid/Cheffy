package com.farzin.cheffy.data.remote.serach

import com.farzin.cheffy.data.model.home.recommended_section.RecipeWithInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiInterface {

    @GET("complexSearch")
    suspend fun searchRecipes(
        @Query("query") q:String,
        @Query("number") number:Int = 100,
        @Query("addRecipeInformation") addRecipeInformation:Boolean = true,
    ) : Response<RecipeWithInfo>

}