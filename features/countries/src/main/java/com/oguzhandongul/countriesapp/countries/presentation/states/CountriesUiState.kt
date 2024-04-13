package com.oguzhandongul.countriesapp.countries.presentation.states


sealed class CountriesUiState {
    object Loading : CountriesUiState()
    data class Success(val countryList: List<String>) : CountriesUiState()
    data class Error(val errorMessage: String) : CountriesUiState()
}