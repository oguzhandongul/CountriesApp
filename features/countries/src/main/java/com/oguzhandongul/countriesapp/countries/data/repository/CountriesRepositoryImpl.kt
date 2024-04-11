package com.oguzhandongul.countriesapp.countries.data.repository

import android.content.Context
import com.oguzhandongul.countriesapp.countries.R
import com.oguzhandongul.countriesapp.countries.domain.repository.CountriesRepository
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(private val context: Context) :
    CountriesRepository {
    override suspend fun getCountries(): Result<List<String>> {
        val stringArray = context.resources.getStringArray(R.array.countries_array)
        return Result.success(stringArray.asList())
    }
}