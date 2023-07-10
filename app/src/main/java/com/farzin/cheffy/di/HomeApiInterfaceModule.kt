package com.farzin.cheffy.di

import com.farzin.cheffy.data.remote.home.HomeApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeApiInterfaceModule {


    @Provides
    @Singleton
    fun provideHomeApiInterface(retrofit: Retrofit) : HomeApiInterface =
        retrofit.create(HomeApiInterface::class.java)

}