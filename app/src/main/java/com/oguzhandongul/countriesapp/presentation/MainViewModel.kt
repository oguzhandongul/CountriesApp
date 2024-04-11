package com.oguzhandongul.countriesapp.presentation

import androidx.lifecycle.ViewModel
import com.oguzhandongul.countriesapp.core.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _currentScreen = MutableStateFlow<Screen>(Screen.Countries) // Track selected screen
    val currentScreen = _currentScreen.asStateFlow()

    fun selectScreen(screen: Screen) {
        _currentScreen.value = screen
    }
}