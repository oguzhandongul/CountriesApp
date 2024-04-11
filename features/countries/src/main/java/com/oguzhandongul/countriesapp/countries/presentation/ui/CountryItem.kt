package com.oguzhandongul.countriesapp.countries.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.oguzhandongul.countriesapp.core.Screen
import com.oguzhandongul.countriesapp.core.ui.theme.CountriesTypography
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions

@Composable
fun CountryItem(name: String, navController: NavController) {
    Button(onClick = {
        val route = "${Screen.CountryDetail.route}/${name}"
        navController.navigate(route)
    }, modifier = Modifier.padding(Dimensions.medium)) {
        Text(text = name, style = CountriesTypography.titleMedium)
    }
}