package com.oguzhandongul.countriesapp.profile.domain.usecase

import com.oguzhandongul.countriesapp.profile.data.model.ProfileData
import com.oguzhandongul.countriesapp.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class GetProfileDataUseCase @Inject constructor(private val profileRepository: ProfileRepository) {
    suspend operator fun invoke(): Result<ProfileData> = profileRepository.getProfileData()
}