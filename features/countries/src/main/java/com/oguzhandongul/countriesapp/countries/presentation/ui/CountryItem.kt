package com.oguzhandongul.countriesapp.countries.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.oguzhandongul.countriesapp.core.utils.Screen
import com.oguzhandongul.countriesapp.core.ui.theme.CountriesTypography
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

@Composable
fun CountryItem(name: String, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(Dimensions.medium)
            .fillMaxWidth()
            .clickable {
                val route = "${Screen.CountryDetail.route}/${name}"
                navController.navigate(route)
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = Dimensions.medium
        )
    ) {
        Text(
            text = name,
            style = CountriesTypography.titleMedium,
            modifier = Modifier.padding(Dimensions.medium)
        )
    }
}