package com.kama.kama.ui.page.login.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CommonLocalImage(
    resId: Int,
    allowHardware: Boolean = false,
     modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {

    Image(
        rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current).data(resId).apply(block = fun ImageRequest.Builder.() {
            allowHardware(allowHardware)
        }).build()),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop,
        colorFilter = colorFilter
    )
}