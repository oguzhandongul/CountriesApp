package com.oguzhandongul.countriesapp.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.oguzhandongul.countriesapp.core.R

@Composable
fun CoilImage(url: String, modifier: Modifier = Modifier) {
    val request = ImageRequest.Builder(LocalContext.current)
        .data(url)
        .crossfade(true)
        .placeholder(R.drawable.placeholder_image_24)
        .error(R.drawable.placeholder_image_24)
        .build()

    val painter = rememberAsyncImagePainter(request)

    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
    )
}