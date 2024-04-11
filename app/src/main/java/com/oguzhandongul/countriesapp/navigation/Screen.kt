package com.oguzhandongul.countriesapp.navigation

sealed class Screen(val route: String) {
    object Countries : Screen("Countries")
    object Profile : Screen("Profile")
}