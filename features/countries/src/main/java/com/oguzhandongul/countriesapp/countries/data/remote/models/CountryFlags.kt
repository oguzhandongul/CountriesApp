package com.oguzhandongul.countriesapp.countries.data.remote.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryFlags(
    val png: String,
    val svg: String
)