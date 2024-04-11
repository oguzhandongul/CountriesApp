package com.oguzhandongul.countriesapp.countries.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CountriesListContent(countryList: List<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(countryList) { countryName ->
            CountryItem(countryName)
        }
    }
}