package com.oguzhandongul.countriesapp.countries.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.oguzhandongul.countriesapp.core.ui.component.ErrorView
import com.oguzhandongul.countriesapp.core.ui.component.LoadingAnimation
import com.oguzhandongul.countriesapp.countries.presentation.states.CountriesUiState
import com.oguzhandongul.countriesapp.countries.presentation.viewmodel.CountriesViewModel

@Composable
fun CountrySelectionScreen(
    navController: NavHostController,
    viewModel: CountriesViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val onRetryClicked: () -> Unit = { viewModel.loadCountriesData() }

    when (uiState) {
        CountriesUiState.Loading -> {
            LoadingAnimation()
        }

        is CountriesUiState.Success -> {
            CountriesListContent(
                countryList = (uiState as CountriesUiState.Success).countryList,
                navController = navController
            )
        }

        is CountriesUiState.Error -> {
            ErrorView(
                exception = Throwable((uiState as CountriesUiState.Error).errorMessage),
                onClick = onRetryClicked
            )
        }
    }
}