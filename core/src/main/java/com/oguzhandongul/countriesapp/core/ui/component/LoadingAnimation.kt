package com.oguzhandongul.countriesapp.core.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oguzhandongul.countriesapp.core.ui.theme.Dimensions

@Composable
fun LoadingAnimation() {
    CircularProgressIndicator(
        color = Color.Blue,
        strokeWidth = 2.dp,
        modifier = Modifier
            .size(Dimensions.xlarge)
    )
}