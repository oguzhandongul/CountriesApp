package com.oguzhandongul.countriesapp.countries.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzhandongul.countriesapp.countries.domain.usecase.GetCountryDetailUseCase
import com.oguzhandongul.countriesapp.countries.presentation.states.CountryDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(private val getCountryDetailUseCase: GetCountryDetailUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow<CountryDetailUiState>(CountryDetailUiState.Loading)
    val uiState: StateFlow<CountryDetailUiState> = _uiState.asStateFlow()

    fun loadCountryDetail(name: String) {
        viewModelScope.launch {
            // Check if the current state is already success and we have the data
            if (uiState.value is CountryDetailUiState.Success) {
                val res = (_uiState.value as CountryDetailUiState.Success).countryDetail
                CountryDetailUiState.Success(res)
            } else {
                // else start with loading and handle the states
                _uiState.value = CountryDetailUiState.Loading
                val result = getCountryDetailUseCase(name).getOrNull()
                _uiState.value = if (result != null) {
                    CountryDetailUiState.Success(result)
                } else {
                    CountryDetailUiState.Error("Failed to load country detail")
                }
            }
        }
    }

}