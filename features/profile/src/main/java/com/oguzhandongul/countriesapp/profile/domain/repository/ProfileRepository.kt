package com.oguzhandongul.countriesapp.profile.domain.repository

import com.oguzhandongul.countriesapp.profile.data.model.ProfileData

interface ProfileRepository {
    suspend fun getProfileData(): ProfileData
}