package com.farzin.cheffy.data.model.home

data class RecommendationModel(
    val number: Int,
    val offset: Int,
    val results: List<Recommendation>,
    val totalResults: Int
)