package com.oguzhandongul.countriesapp.core

sealed class Screen(val route: String) {
    object Countries : Screen("Countries")
    object Profile : Screen("Profile")
    object CountryDetail : Screen("CountryDetail")
}