package com.farzin.cheffy.data.remote.detail

import com.farzin.cheffy.data.model.detail.RecipeDetails
import com.farzin.cheffy.data.model.home.recommended_section.RecipeWithInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailApiInterface {

    @GET("{id}/information")
    suspend fun getRecipeDetail(
        @Path(
            value = "id",
            encoded = true
        ) id: Int,
    ): Response<RecipeDetails>

}