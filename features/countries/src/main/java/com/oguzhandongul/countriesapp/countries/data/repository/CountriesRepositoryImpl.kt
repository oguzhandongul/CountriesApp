package com.oguzhandongul.countriesapp.countries.data.repository

import com.oguzhandongul.countriesapp.core.utils.ResourceHelper
import com.oguzhandongul.countriesapp.countries.R
import com.oguzhandongul.countriesapp.countries.data.remote.ApiService
import com.oguzhandongul.countriesapp.countries.domain.mapper.toCountryDetail
import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail
import com.oguzhandongul.countriesapp.countries.domain.repository.CountriesRepository
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val resourceHelper: ResourceHelper
) :
    CountriesRepository {
    override suspend fun getCountries(): Result<List<String>> {
        return try {
            val stringArray = resourceHelper.getStringArray(R.array.countries_array)
            Result.success(stringArray)
        } catch (exception: Exception) {
            //Handles Network or Backend Errors
            Result.failure(exception)
        }
    }

    override suspend fun getCountryData(name: String): Result<CountryDetail> {
        return try {
            val response = apiService.getCountryDetails(name)[0]
            Result.success(response.toCountryDetail())
        } catch (exception: Exception) {
            //Handles Network or Backend Errors
            Result.failure(exception)
        }
    }
}