package com.oguzhandongul.countriesapp.countries.presentation.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.oguzhandongul.countriesapp.core.ui.component.CoilImage
import com.oguzhandongul.countriesapp.core.ui.theme.CountriesTypography
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions
import com.oguzhandongul.countriesapp.countries.R
import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail

@Composable
fun CountryDetailContent(countryDetail: CountryDetail) {
    val scrollState = rememberScrollState() // Remember scroll position

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimensions.medium).verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally // Optional: center content horizontally
    ) {
        CoilImage(
            url = countryDetail.flagUrl, modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(Dimensions.medium))

        Text(
            text = countryDetail.name,
            style = CountriesTypography.titleLarge
        )

        Spacer(modifier = Modifier.height(Dimensions.small))

        // Display other details
        DetailItem(
            label = stringResource(id = R.string.content_capital_title),
            value = countryDetail.capital
        )
        DetailItem(
            label = stringResource(id = R.string.content_currency_title),
            value = countryDetail.currency
        )
        DetailItem(
            label = stringResource(id = R.string.content_area_title),
            value = countryDetail.area
        )
        DetailItem(
            label = stringResource(id = R.string.content_population_title),
            value = countryDetail.population
        )
        DetailItem(
            label = stringResource(id = R.string.content_continents_title),
            value = countryDetail.continents
        )
        DetailItem(
            label = stringResource(id = R.string.content_languages_title),
            value = countryDetail.languages
        )
    }
}

