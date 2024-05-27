package com.kama.kama.ui.page.home.view

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kama.kama.util.cdp

@Composable
fun HomeTitle(@StringRes strId: Int){

    Text(text = stringResource(id = strId),
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 24.cdp, vertical = 0.cdp),
        style = TextStyle(
            color = Color.Black,
            fontSize =  16.sp,
            fontWeight = FontWeight.Black
        )
    )

}