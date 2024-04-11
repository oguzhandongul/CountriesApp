package com.oguzhandongul.countriesapp.profile.di

import android.content.Context
import com.oguzhandongul.countriesapp.profile.data.repository.ProfileRepositoryImpl
import com.oguzhandongul.countriesapp.profile.domain.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {
    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Singleton
    @Provides
    fun provideProfileRepo(context: Context): ProfileRepository = ProfileRepositoryImpl(context = context)
}