package com.oguzhandongul.countriesapp.profile.di

import com.oguzhandongul.countriesapp.core.utils.ResourceHelper
import com.oguzhandongul.countriesapp.profile.data.repository.ProfileRepositoryImpl
import com.oguzhandongul.countriesapp.profile.domain.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {

    @Singleton
    @Provides
    fun provideProfileRepo(resourceHelper: ResourceHelper): ProfileRepository =
        ProfileRepositoryImpl(resourceHelper = resourceHelper)
}