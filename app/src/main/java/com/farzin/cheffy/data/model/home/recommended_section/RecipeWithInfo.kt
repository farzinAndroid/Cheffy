package com.farzin.cheffy.data.model.home.recommended_section

data class RecipeWithInfo(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)