package com.oguzhandongul.countriesapp.countries.data.remote.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Currency(
    val name: String,
    val symbol: String? = null // Optional field
)