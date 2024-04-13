package com.oguzhandongul.countriesapp.profile.data

import com.oguzhandongul.countriesapp.profile.data.model.Experience
import com.oguzhandongul.countriesapp.profile.data.model.ProfileData

object DataProvider {
    fun getProfileData(): ProfileData {
        return ProfileData(
            name = "Oguzhan Dongul",
            profileImage = "",
            summary = "Senior Mobile Engineer with...",
            education = listOf(
                Experience(
                    title = "Edu 1",
                    organization = "Org 1",
                    duration = "5 years"
                )
            ),
            experience = listOf(
                Experience(
                    title = "Exp 1",
                    organization = "Exp 2",
                    duration = "3 years"
                )
            )
        )
    }
}