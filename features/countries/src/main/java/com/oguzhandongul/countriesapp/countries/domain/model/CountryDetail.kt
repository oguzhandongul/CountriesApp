package com.oguzhandongul.countriesapp.countries.domain.model

data class CountryDetail(
    val name: String,
    val capital: String?,
    val currency: String?,
    val area: String,
    val population: String,
    val flagUrl: String,
    val continents: String,
    val languages: String,
)