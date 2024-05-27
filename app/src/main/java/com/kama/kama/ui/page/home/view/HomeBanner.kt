package com.kama.kama.ui.page.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kama.kama.R

@Composable
fun HomeBanner(){

    Box (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .padding(start = 15.dp, end = 15.dp, top = 0.dp, bottom = 0.dp)){

        Image(
            painter = painterResource(id = R.drawable.banner),
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(color = Color.Transparent),
            contentScale = ContentScale.FillBounds,
            contentDescription = "banner")

        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = "35% Discount",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "For a cozy yellow set!",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W600
                )
            )
        }
    }
}