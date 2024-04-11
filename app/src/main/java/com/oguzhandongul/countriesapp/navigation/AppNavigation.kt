package com.oguzhandongul.countriesapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oguzhandongul.countriesapp.core.Screen
import com.oguzhandongul.countriesapp.countries.presentation.ui.CountryDetailScreen
import com.oguzhandongul.countriesapp.presentation.MainViewModel
import com.oguzhandongul.countriesapp.countries.presentation.ui.CountrySelectionScreen
import com.oguzhandongul.countriesapp.profile.presentation.ui.ProfileScreen

@Composable
fun AppNavigation() {
    val mainViewModel = viewModel<MainViewModel>()
    val navController = rememberNavController()
    val items = listOf(Screen.Countries, Screen.Profile)
    mainViewModel.currentScreen.collectAsState().value // Track selected screen

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { _, screen ->
                    NavigationBarItem(
                        icon = { when (screen) {
                            Screen.Countries, Screen.CountryDetail -> Icon(Icons.Filled.LocationOn, contentDescription = "Countries")
                            Screen.Profile   -> Icon(Icons.Filled.Person, contentDescription = "Profile")
                        }},
                        label = { Text(screen.route) },
                        selected = mainViewModel.currentScreen.value == screen, // Read from ViewModel
                        onClick = {
                            mainViewModel.selectScreen(screen) // Update ViewModel state
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.id)
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Countries.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.Countries.route) { CountrySelectionScreen(navController) } // Use ViewModel
            composable(Screen.Profile.route) { ProfileScreen(navController) }       // Use ViewModel
            composable(  "${Screen.CountryDetail.route}/{name}"){ backStackEntry ->
                val name = backStackEntry.arguments?.getString("name")
                if (name != null) {
                    CountryDetailScreen(name = name)
                }
            }
        }
    }
}