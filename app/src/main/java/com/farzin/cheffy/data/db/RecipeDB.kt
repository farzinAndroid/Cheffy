package com.farzin.cheffy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farzin.cheffy.data.model.db_model.DBRecipeModel

@Database(entities = [DBRecipeModel::class], version = 1, exportSchema = false)
abstract class RecipeDB : RoomDatabase() {

abstract fun provideDao() : RecipeDao



}