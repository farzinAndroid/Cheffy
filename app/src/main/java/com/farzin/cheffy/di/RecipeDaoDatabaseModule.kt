package com.farzin.cheffy.di

import com.farzin.cheffy.data.db.RecipeDB
import com.farzin.cheffy.data.db.RecipeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeDaoDatabaseModule {

    @Provides
    @Singleton
    fun provideRecipeDao(db:RecipeDB) : RecipeDao =
        db.provideDao()

}