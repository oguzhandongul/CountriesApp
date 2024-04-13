package com.oguzhandongul.countriesapp.countries.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.oguzhandongul.countriesapp.core.ui.theme.CountriesTypography
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions
import com.oguzhandongul.countriesapp.countries.R

@Composable
fun CountriesListContent(navController: NavController, countryList: List<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = stringResource(R.string.choose_country_title),
                modifier = Modifier.fillMaxWidth().padding(Dimensions.xlarge),
                style = CountriesTypography.headlineMedium
            )
        }
        items(countryList) { countryName ->
            CountryItem(name = countryName, navController = navController)
        }
    }
}