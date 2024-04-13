package com.oguzhandongul.countriesapp.countries.data.repository

import com.oguzhandongul.countriesapp.core.utils.ResourceHelper
import com.oguzhandongul.countriesapp.core.utils.extensions.fixSpecials
import com.oguzhandongul.countriesapp.countries.R
import com.oguzhandongul.countriesapp.countries.data.remote.ApiService
import com.oguzhandongul.countriesapp.countries.domain.mapper.toCountryDetail
import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail
import com.oguzhandongul.countriesapp.countries.domain.repository.CountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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
            withContext(Dispatchers.IO) {
                val response = apiService.getCountryDetails(name.fixSpecials())[0]
                Result.success(response.toCountryDetail())
            }
        } catch (exception: Exception) {
            //Handles Network or Backend Errors
            Result.failure(exception)
        }
    }
}