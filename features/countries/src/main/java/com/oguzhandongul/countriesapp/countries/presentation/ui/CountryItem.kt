package com.oguzhandongul.countriesapp.countries.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oguzhandongul.countriesapp.core.ui.theme.CountriesTypography
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions

@Composable
fun CountryItem(name: String) {
    Button(onClick = {}, modifier = Modifier.padding(Dimensions.medium)) {
        Text(text = name, style = CountriesTypography.titleMedium)
    }
}