package com.oguzhandongul.countriesapp.profile.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzhandongul.countriesapp.profile.data.model.ProfileData
import com.oguzhandongul.countriesapp.profile.domain.usecase.GetProfileDataUseCase
import com.oguzhandongul.countriesapp.profile.presentation.states.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileDataUseCase: GetProfileDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadProfileData()
    }

    private fun loadProfileData() {
        viewModelScope.launch {
            try {
                val profileDataResult = getProfileDataUseCase()
                _uiState.value = ProfileUiState.Success(profileDataResult)
            } catch (exception: Exception) {
                _uiState.value = ProfileUiState.Error("Failed to load profile")
            }
        }
    }
}