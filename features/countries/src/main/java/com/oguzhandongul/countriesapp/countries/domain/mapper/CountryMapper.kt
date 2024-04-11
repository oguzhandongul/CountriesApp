package com.oguzhandongul.countriesapp.countries.domain.mapper

import com.oguzhandongul.countriesapp.countries.data.remote.models.CountryResponse
import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail


fun CountryResponse.toCountryDetail(): CountryDetail {
    return CountryDetail(
        name = name.common,
        region = region ?: "N/A",
        subregion = subregion ?: "N/A",
        capital = capital?.firstOrNull() ?: "N/A",
        currency = currencies?.values?.firstOrNull()?.let { "${it.name} (${it.symbol})" } ?: "N/A",
        area = "${area.toInt()} sq km", // Add formatting if needed
        population = population.toString(), // Add formatting if needed
        flagUrl = flags.png,
        continents = continents.joinToString(", "),
        languages = languages?.values?.joinToString(", ").orEmpty()
    )
}