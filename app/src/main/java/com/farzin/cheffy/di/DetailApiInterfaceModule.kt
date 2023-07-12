package com.farzin.cheffy.di

import com.farzin.cheffy.data.remote.detail.DetailApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailApiInterfaceModule {

    @Provides
    @Singleton
    fun provideDetailApiInterface(retrofit: Retrofit) : DetailApiInterface =
        retrofit.create(DetailApiInterface::class.java)

}