package com.kama.kama.ui.page.about.view

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.util.cdp


@Composable
fun TextItemButton(@StringRes strId: Int, onClick:  () -> Unit){

    TextButton(
        contentPadding = PaddingValues(0.cdp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.cdp, end = 20.cdp, bottom = 8.cdp, top = 8.cdp)
            .padding(start = 0.cdp)
            .background(color = Color.White,shape = RoundedCornerShape(14.cdp)),
        onClick = {
            Log.d("tag", "TextButton")
            onClick.invoke();
        }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = stringResource(id = strId),
                modifier = Modifier.padding(start = 16.cdp, end = 16.cdp, top = 10.cdp, bottom = 10.cdp),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center)
        }
    }


}