package com.farzin.cheffy.di

import com.farzin.cheffy.data.remote.serach.SearchApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchApiInterfaceModule {

    @Provides
    @Singleton
    fun provideSearchApiInterface(retrofit: Retrofit): SearchApiInterface =
        retrofit.create(SearchApiInterface::class.java)

}