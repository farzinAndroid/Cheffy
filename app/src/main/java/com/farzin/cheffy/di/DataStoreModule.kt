package com.farzin.cheffy.di

import android.content.Context
import com.farzin.cheffy.data.dataStore.DataStoreRepository
import com.farzin.cheffy.data.dataStore.DataStoreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {


    @Singleton
    @Provides
    fun provideDataStoreRepo(
        @ApplicationContext context: Context,
    ): DataStoreRepository = DataStoreRepositoryImpl(context)

}