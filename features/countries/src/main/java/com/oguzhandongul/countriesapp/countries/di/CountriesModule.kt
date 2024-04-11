package com.oguzhandongul.countriesapp.countries.di

import android.content.Context
import com.oguzhandongul.countriesapp.countries.data.remote.ApiService
import com.oguzhandongul.countriesapp.countries.data.repository.CountriesRepositoryImpl
import com.oguzhandongul.countriesapp.countries.domain.repository.CountriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CountriesModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideCountriesRepo(apiService: ApiService, context: Context): CountriesRepository =
        CountriesRepositoryImpl(apiService = apiService, context = context)

}