package com.oguzhandongul.countriesapp.countries.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions

// Reusable component for displaying detail items
@Composable
fun DetailItem(label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "$label: ", fontWeight = FontWeight.Medium)
        Text(text = value)
    }
    Spacer(modifier = Modifier.height(Dimensions.small))
}