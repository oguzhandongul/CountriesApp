package com.oguzhandongul.countriesapp.countries.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzhandongul.countriesapp.core.utils.ResourceHelper
import com.oguzhandongul.countriesapp.countries.R
import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail
import com.oguzhandongul.countriesapp.countries.domain.usecase.GetCountryDetailUseCase
import com.oguzhandongul.countriesapp.countries.presentation.states.CountryDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val resourceHelper: ResourceHelper,
    private val getCountryDetailUseCase: GetCountryDetailUseCase
) :
    ViewModel() {

    private val _uiState = MutableStateFlow<CountryDetailUiState>(CountryDetailUiState.Loading)
    val uiState: StateFlow<CountryDetailUiState> = _uiState.asStateFlow()

    fun loadCountryDetail(name: String) {
        viewModelScope.launch {
            // Check if the current state is already success and we have the data
            if (uiState.value is CountryDetailUiState.Success) {
                val res = (_uiState.value as CountryDetailUiState.Success).countryDetail
                loadData(res)
            } else {
                // else start with loading and handle the states
                _uiState.value = CountryDetailUiState.Loading
                val result = getCountryDetailUseCase(name).getOrNull()
                loadData(result)
            }
        }
    }

    private fun loadData(countryDetail: CountryDetail?) {
        _uiState.value = if (countryDetail != null) {
            CountryDetailUiState.Success(countryDetail)
        } else {
            CountryDetailUiState.Error(resourceHelper.getString(R.string.error_loading_detail))
        }
    }

}