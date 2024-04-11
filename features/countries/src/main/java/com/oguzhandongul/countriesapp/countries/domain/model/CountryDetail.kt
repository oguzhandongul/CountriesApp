package com.oguzhandongul.countriesapp.countries.domain.model

data class CountryDetail(
    val name: String,
    val region: String,
    val subregion: String = "N/A",
    val capital: String = "N/A",
    val currency: String = "N/A",
    val area: String = "N/A",
    val population: String = "N/A",
    val flagUrl: String = "N/A",
    val continents: String = "N/A",
    val languages: String = "N/A",
)