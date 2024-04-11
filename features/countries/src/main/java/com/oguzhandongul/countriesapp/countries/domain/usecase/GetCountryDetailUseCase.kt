package com.oguzhandongul.countriesapp.countries.domain.usecase

import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail
import com.oguzhandongul.countriesapp.countries.domain.repository.CountriesRepository
import javax.inject.Inject

class GetCountryDetailUseCase @Inject constructor(private val countriesRepository: CountriesRepository) {

    suspend operator fun invoke(name: String): Result<CountryDetail> = countriesRepository.getCountryData(name)
}