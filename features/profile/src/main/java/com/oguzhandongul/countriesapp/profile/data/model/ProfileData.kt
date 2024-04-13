package com.oguzhandongul.countriesapp.profile.data.model

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

// Sample data for the profile
@JsonClass(generateAdapter = true)
data class ProfileData(  // Template to support different image types
    val name: String,
    val profileImage: String,
    val summary: String,
    val education: List<Experience>,
    val experience: List<Experience>
)

object ProfileDataAdapter {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val adapter = moshi.adapter(ProfileData::class.java)
}