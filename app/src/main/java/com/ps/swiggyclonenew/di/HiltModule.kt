package com.ps.swiggyclonenew.di

import com.ps.swiggyclonenew.repository.MealRepo
import com.ps.swiggyclonenew.retrofit.MealAPI
import com.ps.swiggyclonenew.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule  {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMealAPI(retrofit: Retrofit): MealAPI {
        return retrofit.create(MealAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideDataRepository(apiService: MealAPI): MealRepo {
        return MealRepo(apiService)
    }

}