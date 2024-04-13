package com.oguzhandongul.countriesapp.countries.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzhandongul.countriesapp.core.utils.ResourceHelper
import com.oguzhandongul.countriesapp.countries.R
import com.oguzhandongul.countriesapp.countries.domain.usecase.GetCountriesUseCase
import com.oguzhandongul.countriesapp.countries.presentation.states.CountriesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val resourceHelper: ResourceHelper,
    private val getCountriesUseCase: GetCountriesUseCase
) :
    ViewModel() {


    private val _uiState = MutableStateFlow<CountriesUiState>(CountriesUiState.Loading)
    val uiState: StateFlow<CountriesUiState> = _uiState.asStateFlow()

    init {
        loadCountriesData()
    }

    fun loadCountriesData() {
        viewModelScope.launch {
            _uiState.value = CountriesUiState.Loading
            val result = getCountriesUseCase().getOrNull()
            if (result != null) {
                _uiState.value = CountriesUiState.Success(result)
            } else {
                _uiState.value =
                    CountriesUiState.Error(resourceHelper.getString(R.string.error_loading_list))
            }
        }
    }

}