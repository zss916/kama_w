package com.kama.kama.ui.page.test.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.text.TextStyle

@Composable
fun LinearGradientText(){

    val gradientColors = listOf(Color.Red,Color.Blue,Color.Cyan)

    Text(text = "test", style = TextStyle(
        brush = Brush.linearGradient(
            colors = gradientColors
        ),
        alpha = 1f
    ))

}