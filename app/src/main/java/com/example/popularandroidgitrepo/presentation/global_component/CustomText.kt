package com.example.popularandroidgitrepo.presentation.global_component

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

// Custom Text composable to display the text with custom styling
@Composable
fun CustomText(
    text: String = "",
    color: Color = Color.White,
    lineHeight: TextUnit = 16.sp,
    textAlign: TextAlign = TextAlign.Start,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 14.sp,
    maxLines: Int = Int.MAX_VALUE,
    overFlow: TextOverflow = TextOverflow.Clip,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = color,
        fontWeight = fontWeight,
        fontSize = fontSize,
        textAlign = textAlign,
        lineHeight = lineHeight,
        maxLines = maxLines,
        overflow = overFlow,
        modifier = modifier,
    )
}