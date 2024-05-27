package com.kama.kama.ui.page.home.view

import android.net.Uri
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.kama.kama.R
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.model.HomeData
import com.kama.kama.model.HomeTab
import com.kama.kama.model.cabinetList
import com.kama.kama.model.chairList
import com.kama.kama.model.sofaList
import com.kama.kama.model.tablewareList
import com.kama.kama.ui.page.home.HomeVM
import com.kama.kama.util.cdp
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeCategory(data:List<HomeTab>){
    val pagerState = rememberPagerState(){4}
    val coroutineScope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = Color.Transparent,
        divider = {},
        edgePadding = 8.dp,
        indicator = emptyTabIndicator,
        modifier = Modifier.fillMaxWidth()
    ) {
        data.forEachIndexed { index, homeTab ->
            val isSelected = pagerState.currentPage == index
            Tab(
                selected = isSelected,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    val textStyle =
                        if (isSelected) MaterialTheme.typography.titleMedium.merge(
                            TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                fontSize = 13.sp,)
                        )
                        else TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp,
                            color = Color(0xFF828A89)
                        )

                    val icon =  if (isSelected) homeTab.icon else  homeTab.iconSelect

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 12.cdp, horizontal = 0.cdp)
                            .background(
                                color = when {
                                    isSelected -> Color(0xFF0C8A7B)
                                    else -> Color.White
                                },
                                shape = RoundedCornerShape(10.cdp),
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = icon),
                            modifier = Modifier
                                .padding(end = 6.cdp, start = 6.cdp)
                                .size(20.cdp)
                                .padding(0.cdp),
                            contentDescription =null)

                        Text(text = homeTab.title, style = textStyle)

                        Spacer(modifier = Modifier.width(6.dp))
                    }
                })
        }
    }

    HomeTitle(strId = R.string.app_most_interested)

    Spacer(modifier = Modifier.height(15.dp))

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth(),
        userScrollEnabled = false,
    ) {
        when (it) {
            0 -> CategoryList(data = chairList)

            1 -> CategoryList(data = sofaList)

            2 -> CategoryList(data = cabinetList)

            3 -> CategoryList(data = tablewareList)
        }
    }
}


@Composable
fun CategoryList(data :List<HomeData>){
    val scrollState = rememberLazyListState()

    LazyRow( state = scrollState,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
            .background(Color(0xFFF9F9F9))) {

        itemsIndexed(data){index , it->
            it.let {
                CategoryItem(item = it)
            }
        }
    }

}


@Composable
fun CategoryItem(item:HomeData){

    Card(modifier = Modifier
        .width(280.cdp)
        .height(250.dp)
        .padding(horizontal = 16.dp)
        .clickable {
            Log.d("tag", "item click")
            val json = Uri.encode(Gson().toJson(item))
             ARoute.instance.navigate("${RouterUrls.DETAIL}/$json")
        },
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            Image(
                painter = painterResource(id = item.icon),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .background(color = Color.Transparent),
                contentDescription = null)

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = item.title,
                    modifier = Modifier.weight(1f),
                    style = TextStyle(color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black
                    ))

                Spacer(modifier = Modifier.width(15.dp))

                Image(
                    painter = painterResource(id = R.mipmap.like),
                    modifier = Modifier.size(32.dp),
                    contentDescription = null)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = item.price,
                modifier = Modifier.fillMaxWidth().align(alignment = Alignment.Start),
                style = TextStyle(color = Color(0xFFF2A666),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black
                ))

        }

    }

}

private val emptyTabIndicator: @Composable (List<TabPosition>) -> Unit = {}
