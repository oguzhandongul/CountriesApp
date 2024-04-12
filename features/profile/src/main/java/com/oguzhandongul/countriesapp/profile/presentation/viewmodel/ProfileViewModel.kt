package com.oguzhandongul.countriesapp.profile.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzhandongul.countriesapp.core.utils.ResourceHelper
import com.oguzhandongul.countriesapp.profile.R
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
    private val resourceHelper: ResourceHelper,
    private val getProfileDataUseCase: GetProfileDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadProfileData()
    }

    fun loadProfileData() {
        viewModelScope.launch {
            if (_uiState.value is ProfileUiState.Success) {
                val res = (_uiState.value as ProfileUiState.Success).profileData
                loadData(res)
            } else {
                _uiState.value = ProfileUiState.Loading
                val result = getProfileDataUseCase().getOrNull()
                loadData(result)
            }
        }
    }

    private fun loadData(countryDetail: ProfileData?) {
        _uiState.value = if (countryDetail != null) {
            ProfileUiState.Success(countryDetail)
        } else {
            ProfileUiState.Error(resourceHelper.getString(R.string.error_loading_profile))
        }
    }
}