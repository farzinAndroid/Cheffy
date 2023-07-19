package com.farzin.cheffy.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farzin.cheffy.data.model.db_model.DBRecipeModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipe(recipe:DBRecipeModel)

    @Query("select * from recipe_table")
    fun getAllRecipes() : Flow<List<DBRecipeModel>>

    @Delete
    suspend fun deleteRecipe(recipe:DBRecipeModel)

    @Query("select * from recipe_table where itemId = :id")
    fun findById(id:Int) : Int

}