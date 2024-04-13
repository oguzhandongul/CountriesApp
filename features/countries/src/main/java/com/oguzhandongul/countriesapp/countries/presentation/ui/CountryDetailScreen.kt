package com.oguzhandongul.countriesapp.countries.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.oguzhandongul.countriesapp.core.ui.component.ErrorView
import com.oguzhandongul.countriesapp.core.ui.component.LoadingAnimation
import com.oguzhandongul.countriesapp.countries.presentation.states.CountryDetailUiState
import com.oguzhandongul.countriesapp.countries.presentation.viewmodel.CountryDetailViewModel

@Composable
fun CountryDetailScreen(name: String, viewModel: CountryDetailViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    val onRetryClicked: () -> Unit = { viewModel.loadCountryDetail(name) }

    LaunchedEffect(name) {
        viewModel.loadCountryDetail(name)
    }

    when (uiState) {
        CountryDetailUiState.Loading -> {
            LoadingAnimation()
        }

        is CountryDetailUiState.Success -> {
            CountryDetailContent((uiState as CountryDetailUiState.Success).countryDetail)
        }

        is CountryDetailUiState.Error -> {
            ErrorView(
                exception = Throwable((uiState as CountryDetailUiState.Error).errorMessage),
                onClick = onRetryClicked
            )
        }
    }
}
