package com.oguzhandongul.countriesapp.countries.data.remote

import com.oguzhandongul.countriesapp.countries.data.remote.models.CountryResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v3.1/name/{countryName}")
    suspend fun getCountryDetails(@Path("countryName") countryName: String): List<CountryResponse>

}