package com.farzin.cheffy.di

import android.content.Context
import androidx.room.Room
import com.farzin.cheffy.data.db.RecipeDB
import com.farzin.cheffy.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {


    @Provides
    @Singleton
    fun provideDataBaseModule(
        @ApplicationContext c : Context
    ) =
        Room.databaseBuilder(
            c,
            RecipeDB::class.java,
            DATABASE_NAME
        ).build()

}