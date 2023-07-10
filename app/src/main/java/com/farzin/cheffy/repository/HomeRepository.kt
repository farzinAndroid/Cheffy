package com.farzin.cheffy.repository

import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.home.RecommendationModel
import com.farzin.cheffy.data.remote.home.BaseApiResponse
import com.farzin.cheffy.data.remote.home.HomeApiInterface
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api:HomeApiInterface) : BaseApiResponse()  {


    suspend fun getRecommendation() : NetworkResult<RecommendationModel> =
        recommendedSafeApiCall {
            api.getRecommendation()
        }
}