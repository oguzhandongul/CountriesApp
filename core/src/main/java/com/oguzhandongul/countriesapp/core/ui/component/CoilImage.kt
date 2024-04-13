package com.oguzhandongul.countriesapp.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.oguzhandongul.countriesapp.core.R
import com.oguzhandongul.countriesapp.core.utils.ANIM_DURATION_CROSS_FADE

@Composable
fun CoilImage(url: String, modifier: Modifier = Modifier) {
    val request = ImageRequest.Builder(LocalContext.current)
        .data(url)
        .crossfade(ANIM_DURATION_CROSS_FADE)
        .placeholder(R.drawable.placeholder_image_24)
        .error(R.drawable.placeholder_image_24)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .memoryCacheKey(url)
        .build()

    val painter = rememberAsyncImagePainter(request)

    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
    )
}