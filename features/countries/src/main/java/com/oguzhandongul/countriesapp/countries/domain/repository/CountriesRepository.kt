package com.oguzhandongul.countriesapp.countries.domain.repository

import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail

interface CountriesRepository {
    suspend fun getCountries(): Result<List<String>>
    suspend fun getCountryData(name: String): Result<CountryDetail>
}