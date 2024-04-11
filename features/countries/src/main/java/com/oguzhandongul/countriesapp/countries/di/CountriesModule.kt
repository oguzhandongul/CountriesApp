package com.oguzhandongul.countriesapp.countries.di

import android.content.Context
import com.oguzhandongul.countriesapp.countries.data.repository.CountriesRepositoryImpl
import com.oguzhandongul.countriesapp.countries.domain.repository.CountriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CountriesModule {
    @Singleton
    @Provides
    fun provideCountriesRepo(context: Context): CountriesRepository = CountriesRepositoryImpl(context = context)
}