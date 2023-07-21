package com.farzin.cheffy.di

import com.farzin.cheffy.data.remote.fridge.FridgeApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FridgeApiInterfaceModule {


    @Provides
    @Singleton
    fun provideFridgeApiInterface(retrofit: Retrofit) : FridgeApiInterface =
        retrofit.create(FridgeApiInterface::class.java)

}