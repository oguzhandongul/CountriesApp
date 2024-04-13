package com.oguzhandongul.countriesapp.countries.domain.usecase

import com.oguzhandongul.countriesapp.countries.domain.repository.CountriesRepository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(private val countriesRepository: CountriesRepository) {

    suspend operator fun invoke(): Result<List<String>> = countriesRepository.getCountries()
}