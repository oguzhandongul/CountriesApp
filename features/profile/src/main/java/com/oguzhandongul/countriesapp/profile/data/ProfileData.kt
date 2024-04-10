package com.oguzhandongul.countriesapp.profile.data

import com.oguzhandongul.countriesapp.profile.data.Experience

// Sample data for the profile
data class ProfileData(
    val name: String,
    val profileImage: String, // Use a drawable resource ID for the image
    val summary: String,
    val education: List<Experience>,
    val experience: List<Experience>
)

