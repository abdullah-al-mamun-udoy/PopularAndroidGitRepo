package com.example.popularandroidgitrepo.presentation.global_component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

// Custom Image composable to load images from drawable resources
@Composable
fun CustomImage(
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null
) {
    Image(
        painterResource(id = imageId),
        modifier = modifier,
        contentScale = contentScale,
        contentDescription = contentDescription
    )
}