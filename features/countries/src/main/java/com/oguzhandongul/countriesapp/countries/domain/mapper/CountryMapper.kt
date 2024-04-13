package com.oguzhandongul.countriesapp.countries.domain.mapper

import com.oguzhandongul.countriesapp.core.utils.NO_DATA
import com.oguzhandongul.countriesapp.countries.data.remote.models.CountryResponse
import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail


fun CountryResponse.toCountryDetail(): CountryDetail {
    val builder = StringBuilder()
    return CountryDetail(
        name = name.common,
        region = region ?: NO_DATA,
        subregion = subregion ?: NO_DATA,
        capital = capital?.firstOrNull() ?: NO_DATA,
        currency = currencies?.values?.firstOrNull()
            ?.let { builder.append(it.name).append(" (").append(it.symbol).append(')').toString() }
            ?: NO_DATA,
        area = "${area.toInt()} sq km",
        population = population.toString(),
        flagUrl = flags.png,
        continents = continents.joinToString(", "),
        languages = languages?.values?.joinToString(", ").orEmpty()
    )
}