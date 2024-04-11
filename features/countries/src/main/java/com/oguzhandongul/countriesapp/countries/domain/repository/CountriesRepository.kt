package com.oguzhandongul.countriesapp.countries.domain.repository

interface CountriesRepository {
    suspend fun getCountries(): Result<List<String>>
}