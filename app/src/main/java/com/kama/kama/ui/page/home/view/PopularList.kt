package com.kama.kama.ui.page.home.view

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.model.HomeData
import com.kama.kama.util.cdp

@Composable
fun PopularList(data :List<HomeData>){
    val scrollState = rememberLazyListState()

    LazyRow( state = scrollState,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
            .background(Color(0xFFF9F9F9))) {

        itemsIndexed(data){index , it->
            it.let {
                Card(modifier = Modifier
                    .width(250.dp)
                    .padding(start = 8.cdp, end = 8.cdp, top = 16.dp, bottom = 16.dp)
                    .clickable {
                        Log.d("tag", "item click")
                        val json = Uri.encode(Gson().toJson(it))
                        ARoute.instance.navigate("${RouterUrls.DETAIL}/$json")
                    },
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row (){
                        Surface (
                            color = Color(0xFFF0F0F2),
                            shape = RoundedCornerShape(12.0.dp),
                            modifier = Modifier.padding(12.dp)
                        ){
                            Image(
                                painter = painterResource(id = it.icon),
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(72.cdp),
                                contentDescription = "goods")
                        }

                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp)) {
                            Text(it.title,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 10.cdp,
                                        end = 10.cdp,
                                        top = 5.cdp,
                                        bottom = 5.cdp
                                    ),
                                style = TextStyle(color = Color.Black,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 16.sp)
                            )

                            Text(it.price,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 10.cdp,
                                        end = 10.cdp,
                                        top = 5.cdp,
                                        bottom = 5.cdp
                                    ),
                                style = TextStyle(color = Color(0xFFF2A666),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 16.sp)
                            )

                        }

                    }
                }
            }
        }
    }

}