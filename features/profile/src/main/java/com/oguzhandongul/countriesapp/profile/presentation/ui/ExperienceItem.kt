package com.oguzhandongul.countriesapp.profile.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oguzhandongul.countriesapp.core.ui.theme.CountriesTypography
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions
import com.oguzhandongul.countriesapp.profile.data.model.Experience

@Composable
fun ExperienceItem(experience: Experience) {
    Column(modifier = Modifier.padding(Dimensions.medium)) {
        Text(text = experience.title, style = CountriesTypography.titleMedium)
        Text(text = experience.organization, style = CountriesTypography.bodyLarge)
        Text(text = experience.duration, style = CountriesTypography.bodyLarge)
    }
}