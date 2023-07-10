package com.farzin.cheffy.data.model.home.recommended_section

data class Equipment(
    val id: Int,
    val image: String,
    val localizedName: String,
    val name: String,
    val temperature: Temperature?
)