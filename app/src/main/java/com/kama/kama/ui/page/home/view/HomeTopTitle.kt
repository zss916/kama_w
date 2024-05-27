package com.kama.kama.ui.page.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kama.kama.R

@Composable
fun HomeTopTitle(){

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 24.dp)){

        Image(
            painter = painterResource(id = R.mipmap.app_logo),
            modifier = Modifier.size(48.dp),
            contentDescription = "home_image")

        Spacer(modifier = Modifier.width(12.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            verticalArrangement = Arrangement.SpaceAround){

            Text(text = stringResource(id = R.string.app_welcome),
                style = TextStyle(
                    color = Color(0xFF828A89),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W600
                )
            )

            Text(text = "Kama",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black
                )
            )

        }
    }

}