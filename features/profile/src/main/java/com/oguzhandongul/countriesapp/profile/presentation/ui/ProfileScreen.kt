package com.oguzhandongul.countriesapp.profile.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.oguzhandongul.countriesapp.profile.presentation.states.ProfileUiState
import com.oguzhandongul.countriesapp.profile.presentation.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        ProfileUiState.Loading -> {}
        is ProfileUiState.Success -> {
            ProfileContent((uiState as ProfileUiState.Success).profileData)
        }
        is ProfileUiState.Error -> {}
    }
}