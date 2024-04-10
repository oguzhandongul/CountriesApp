package com.oguzhandongul.countriesapp.profile.presentation.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.oguzhandongul.countriesapp.core.ui.component.CoilImage
import com.oguzhandongul.countriesapp.core.ui.theme.CountriesTypography
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions
import com.oguzhandongul.countriesapp.profile.data.ProfileData

@Composable
fun ProfileScreen(profileData: ProfileData) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Profile Image
            CoilImage(
                url = profileData.profileImage, modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(Dimensions.medium))

            // Name
            Text(
                text = profileData.name,
                style = CountriesTypography.titleLarge
            )

            Spacer(modifier = Modifier.height(Dimensions.small))

            // Summary
            Text(
                text = profileData.summary,
                style = CountriesTypography.bodyLarge,
                modifier = Modifier.padding(horizontal = Dimensions.medium)
            )

            Spacer(modifier = Modifier.height(Dimensions.medium))
        }

        // Education Section
        item {
            Text(
                "Education",
                style = CountriesTypography.titleLarge,
                modifier = Modifier.padding(Dimensions.medium)
            )
        }
        items(profileData.education) { experience ->
            ExperienceItem(experience)
        }

        // Work Experience Section
        item {
            Text(
                "Work Experience",
                style = CountriesTypography.titleLarge,
                modifier = Modifier.padding(Dimensions.medium)
            )
        }
        items(profileData.experience) { experience ->
            ExperienceItem(experience)
        }
    }
}