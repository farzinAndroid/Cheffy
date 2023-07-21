package com.farzin.cheffy.repository

import com.farzin.cheffy.data.db.RecipeDao
import com.farzin.cheffy.data.model.NetworkResult
import com.farzin.cheffy.data.model.db_model.DBRecipeModel
import com.farzin.cheffy.data.model.detail.RecipeDetails
import com.farzin.cheffy.data.remote.BaseApiResponse
import com.farzin.cheffy.data.remote.detail.DetailApiInterface
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val api:DetailApiInterface,
    private val dao:RecipeDao
    ) : BaseApiResponse() {


    val recipes = dao.getAllRecipes()

    suspend fun insertRecipe(recipe: DBRecipeModel){
        dao.insertRecipe(recipe)
    }

    suspend fun deleteRecipe(recipe: DBRecipeModel){
        dao.deleteRecipe(recipe)
    }

    fun findById(id:Int) : Int{
       return dao.findById(id)
    }


    suspend fun getRecipeDetail(id:Int) : NetworkResult<RecipeDetails> =
        safeApiCall {
            api.getRecipeDetail(id)
        }

}