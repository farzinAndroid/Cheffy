package com.farzin.cheffy.data.remote.home

import com.farzin.cheffy.data.model.home.RecommendationModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiInterface {


    @GET("complexSearch")
    suspend fun getRecommendation(
        @Query("number") number:Int = 100,
    ) : Response<RecommendationModel>

}