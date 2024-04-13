package com.oguzhandongul.countriesapp.countries.data.remote.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryName(
    val common: String,
    val official: String? = null // Optional field
)