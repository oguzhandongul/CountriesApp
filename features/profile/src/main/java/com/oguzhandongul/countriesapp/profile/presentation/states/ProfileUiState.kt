package com.oguzhandongul.countriesapp.profile.presentation.states

import com.oguzhandongul.countriesapp.profile.data.model.ProfileData


sealed class ProfileUiState {
    object Loading : ProfileUiState()
    data class Success(val profileData: ProfileData) : ProfileUiState()
    data class Error(val errorMessage: String) : ProfileUiState()
}