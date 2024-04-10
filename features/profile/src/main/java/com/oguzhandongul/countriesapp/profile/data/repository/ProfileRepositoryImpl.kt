package com.oguzhandongul.countriesapp.profile.data.repository

import android.content.Context
import com.oguzhandongul.countriesapp.profile.R
import com.oguzhandongul.countriesapp.profile.data.model.ProfileData
import com.oguzhandongul.countriesapp.profile.data.model.ProfileDataAdapter
import com.oguzhandongul.countriesapp.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(private val context: Context) : ProfileRepository {
    private val profileDataAdapter = ProfileDataAdapter

    override suspend fun getProfileData(): ProfileData {
        val inputStream = context.resources.openRawResource(R.raw.profile)
        val json = inputStream.bufferedReader().use { it.readText() }
        return profileDataAdapter.adapter.fromJson(json)!!
    }
}