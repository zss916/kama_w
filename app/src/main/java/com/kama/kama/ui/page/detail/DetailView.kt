package com.kama.kama.ui.page.detail

import android.graphics.Paint.Align
import android.util.Log
import android.widget.ScrollView
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.AppConfig
import com.kama.kama.core.KamaApplication
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterKV
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.model.HomeData
import com.kama.kama.ui.page.about.view.AboutView
import com.kama.kama.ui.page.about.view.BaseAppBar
import com.kama.kama.ui.page.profile.view.CommonItemButton
import com.kama.kama.ui.page.web.view.BaseTitleAppBar
import com.kama.kama.util.cdp



@Composable
fun DetailPage(data: HomeData){
    Scaffold (
        Modifier.fillMaxSize(),
        containerColor= Color(0xFFF9F9F9),
        contentColor = Color(0xFFF9F9F9),
        topBar = { BaseTitleAppBar(title = "") }
    ){ padding -> DetailView(padding = padding,data = data) }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailView(padding: PaddingValues,data: HomeData) {

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.cdp, end = 24.cdp, top = 10.cdp)
                .padding(padding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {

            item {
                Image(
                    painter = painterResource(id = data.icon),
                    modifier = Modifier
                        .size(250.cdp)
                        .background(color = Color.Transparent),
                    contentDescription = "detail_image")
            }

            item {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.cdp, bottom = 20.cdp),
                    verticalAlignment = Alignment.CenterVertically){

                    Text(
                        text = data.title,
                        modifier = Modifier
                            .weight(1f)
                            .background(color = Color.Transparent),
                        style = TextStyle(color = Color.Black, fontSize =  24.sp, fontWeight = FontWeight.Black))

                    Spacer(modifier = Modifier.padding(start = 5.cdp))

                    Text(text = data.price,
                        modifier = Modifier.background(color = Color.Transparent),
                        style = TextStyle(
                            color = Color(0xFFF2A666),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Black))

                }

            }

            item() {

                FlowRow (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ){

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(color = Color.Transparent)
                            .padding(end = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.see_icon),
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 5.dp)
                                .padding(0.dp),
                            contentDescription = "see")

                        Text(text = stringResource(id = R.string.app_seen,"${data.seen}"),
                            style = TextStyle(
                                color = Color(0xFF828A89),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W500
                            ))
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(color = Color.Transparent)
                            .padding(end = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.like_icon),
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 5.dp)
                                .padding(0.dp),
                            contentDescription = "like_icon")

                        Text(text = stringResource(id = R.string.app_liked,"${data.liked}"),
                            style = TextStyle(
                                color = Color(0xFF828A89),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W500
                            ))
                    }
                }
            }

            item() {
                Row {
                    Image(
                        painter = painterResource(id = R.mipmap.star),
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .padding(0.dp),
                        contentDescription = "star")

                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            item {
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 300.cdp)){
                    Text(
                        text = stringResource(id = R.string.app_description),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black))

                    Spacer(modifier = Modifier.padding(top = 10.cdp))

                    Text(
                        text = data.introduce,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            color = Color(0xFF828A89),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black
                        )
                    )
                }
            }
        }



        Column (modifier = Modifier.fillMaxSize()){

            Spacer(modifier = Modifier.weight(1f))

            Box(
                Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        RoundedCornerShape(topStart = 24.cdp, topEnd = 24.cdp)
                    )
                    .padding(top = 24.cdp)
            ){

                TextButton(
                    contentPadding = PaddingValues(0.cdp),
                    onClick = {
                        Log.d("tag", "TextButton add follow ")
                        ARoute.instance.popBackStack()
                        //ARoute.instance.navigate(RouterUrls.MAIN)
                    }) {
                    Text(
                        text = stringResource(id = R.string.app_add_follow),
                        modifier = Modifier
                            .padding(start = 15.cdp, end = 15.cdp, bottom = 10.cdp)
                            .background(Color(0xFF0C8A7B), shape = RoundedCornerShape(14.cdp))
                            .padding(vertical = 16.cdp, horizontal = 10.cdp)
                            .fillMaxWidth(),
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W900,
                        textAlign = TextAlign.Center)
                }

            }
        }



    }




}



