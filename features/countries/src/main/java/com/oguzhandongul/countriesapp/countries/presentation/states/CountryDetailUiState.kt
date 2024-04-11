package com.oguzhandongul.countriesapp.countries.presentation.states

import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail


sealed class CountryDetailUiState {
    object Loading : CountryDetailUiState()
    data class Success(val countryDetail: CountryDetail) : CountryDetailUiState()
    data class Error(val errorMessage: String) : CountryDetailUiState()
}