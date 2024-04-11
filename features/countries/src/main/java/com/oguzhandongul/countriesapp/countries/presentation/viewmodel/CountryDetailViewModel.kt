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
            _uiState.value = CountryDetailUiState.Loading
            val result = getCountryDetailUseCase(name).getOrNull()
            if (result != null) {
                _uiState.value = CountryDetailUiState.Success(result)
            } else {
                _uiState.value = CountryDetailUiState.Error("Failed to load country detail")
            }
        }
    }

}