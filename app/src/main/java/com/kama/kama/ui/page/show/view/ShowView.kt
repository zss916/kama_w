package com.kama.kama.ui.page.show.view

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.util.cdp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowView(index:Int, onGo: (index:Int) -> Unit, onSkip:() -> Unit) {

    val icons = listOf(
        R.drawable.show1,
        R.drawable.show2,
        R.drawable.show3
    )
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.app_bg_color)),
            verticalArrangement =  Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            //integerArrayResource(R.array.app_show_icon)[index]
            Image(
                painter = painterResource(id = icons[index]),
                modifier = Modifier
                    .padding(top = 20.cdp, bottom = 15.cdp),
                contentDescription =null)

            Text(
                text = stringArrayResource(id = R.array.app_show_array)[index],
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 20.cdp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )

            Spacer(modifier = Modifier.weight(3.5f))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 25.cdp, start = 15.cdp, end = 20.cdp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = stringResource(id = R.string.app_skip),
                color = Color(0xFF828A89),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(vertical = 10.cdp, horizontal = 5.cdp)
                    .clickable {
                        Log.d("tag", "ShowPage: skip")
                        onSkip.invoke()
                    }
            )

            Image(
                painter = painterResource(id = R.mipmap.go),
                contentDescription = null,
                modifier = Modifier
                    .size(56.cdp)
                    .clickable {
                        Log.d("tag", "ShowPage: go $index")
                        onGo.invoke(index)
                    },
            )

        }
    }


}