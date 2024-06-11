package com.kama.kama.ui.page.test.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun MultipleStylesInText() {

    Text(text = buildAnnotatedString {
        append("sssssss")

        withStyle(style = SpanStyle(color = Color.Blue)){
            append("dddddd")
        }

        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
            append("W")
        }


        append("orld")

    }, style = TextStyle(color = Color.Black))

}