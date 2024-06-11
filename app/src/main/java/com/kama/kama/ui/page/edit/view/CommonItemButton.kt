package com.kama.kama.ui.page.edit.view

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.util.cdp


@Composable
fun CommonEditButton(@StringRes strId: Int? = null, content:String? = null, onClick: () -> Unit = {}){

    TextButton(
        contentPadding = PaddingValues(0.cdp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.cdp, end = 20.cdp, bottom = 8.cdp, top = 8.cdp)
            .padding(0.dp)
            .background(color = Color.White,shape = RoundedCornerShape(14.cdp)),
        onClick = {
            Log.d("tag", "TextButton")
            onClick.invoke();
        }) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {

           if(strId != null) Text(
                text = stringResource(id = strId),
                //modifier = Modifier.padding(top = 10.cdp, bottom = 10.cdp),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center)


           if(content != null)  Text(
               text = content,
               //modifier = Modifier.padding(top = 10.cdp, bottom = 10.cdp),
               color = Color(0x80101817),
               fontSize = 16.sp,
               fontWeight = FontWeight.Black,
               textAlign = TextAlign.Center)

        }
    }


}