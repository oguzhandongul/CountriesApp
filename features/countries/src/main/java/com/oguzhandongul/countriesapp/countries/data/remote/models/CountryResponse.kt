package com.oguzhandongul.countriesapp.countries.data.remote.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryResponse(
    val name: CountryName,
    val tld: List<String>,
    val cca2: String,
    val currencies: Map<String, Currency?>?,
    val capital: List<String>?,
    val region: String?,
    val subregion: String?,
    val languages: Map<String, String>?,
    val latlng: List<Double>, // Latitude and Longitude
    val area: Double,
    val population: Long,
    val flags: CountryFlags,
    val continents: List<String>
)