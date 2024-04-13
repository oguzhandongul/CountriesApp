package com.oguzhandongul.countriesapp.profile.data.repository

import com.oguzhandongul.countriesapp.core.utils.ResourceHelper
import com.oguzhandongul.countriesapp.core.utils.extensions.bufferToJson
import com.oguzhandongul.countriesapp.profile.R
import com.oguzhandongul.countriesapp.profile.data.model.ProfileData
import com.oguzhandongul.countriesapp.profile.data.model.ProfileDataAdapter
import com.oguzhandongul.countriesapp.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(private val resourceHelper: ResourceHelper) : ProfileRepository {
    private val profileDataAdapter = ProfileDataAdapter

    override suspend fun getProfileData(): Result<ProfileData> {
        return try {
            val inputStream = resourceHelper.getRaw(R.raw.profile)
            val json = inputStream.bufferToJson()
            val response = profileDataAdapter.adapter.fromJson(json)
            response?.run {
                Result.success(this)
            } ?: throw Exception()
        } catch (exception: Exception) {
            Result.failure(exception)
        }

    }
}