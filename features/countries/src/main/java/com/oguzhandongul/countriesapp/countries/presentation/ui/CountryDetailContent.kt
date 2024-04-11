package com.oguzhandongul.countriesapp.countries.presentation.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.oguzhandongul.countriesapp.core.ui.component.CoilImage
import com.oguzhandongul.countriesapp.core.ui.theme.CountriesTypography
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions
import com.oguzhandongul.countriesapp.countries.domain.model.CountryDetail

@Composable
fun CountryDetailContent(countryDetail: CountryDetail) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimensions.medium),
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

        Spacer(modifier = Modifier.height(8.dp))

        // Display other details
        DetailItem(label = "Capital", value = countryDetail.capital ?: "N/A")
        DetailItem(label = "Currency", value = countryDetail.currency ?: "N/A")
        DetailItem(label = "Area", value = countryDetail.area)
        DetailItem(label = "Population", value = countryDetail.population)
        DetailItem(label = "Continents", value = countryDetail.continents)
        DetailItem(label = "Languages", value = countryDetail.languages ?: "N/A")
    }
}

// Reusable component for displaying detail items
@Composable
fun DetailItem(label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "$label: ", fontWeight = FontWeight.Medium)
        Text(text = value)
    }
    Spacer(modifier = Modifier.height(4.dp))
}