package com.oguzhandongul.countriesapp.countries.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import com.oguzhandongul.countriesapp.countries.R

@Composable
fun CountryItem(name: String, navController: NavController) {
    val imagePainter = painterResource(id = R.drawable.ic_arrow_right_24)

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
        Row(
            modifier = Modifier
                .padding(Dimensions.medium)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = name, style = CountriesTypography.titleMedium)
            Icon(painter = imagePainter, contentDescription = "Navigate to details") // Add the icon
        }
    }
}