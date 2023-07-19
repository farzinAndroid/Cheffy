package com.farzin.cheffy.data.model.db_model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.farzin.cheffy.utils.Constants.TABLE_NAME

@Entity(TABLE_NAME)
data class DBRecipeModel(
    @PrimaryKey
    val itemId:Int,
    val image:String,
    val title:String,
    val desc:String,
    val serving:Int,
    val time:Int,
    val source:String
)
