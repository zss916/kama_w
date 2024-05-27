package com.kama.kama.ui.page.home

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.gson.Gson
import com.kama.kama.R
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.ui.page.home.view.HomeBanner
import com.kama.kama.ui.page.home.view.HomeCategory
import com.kama.kama.ui.page.home.view.HomeTitle
import com.kama.kama.ui.page.home.view.HomeTopTitle
import com.kama.kama.ui.page.home.view.PopularList
import com.kama.kama.util.cdp
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeView(vm: HomeVM = HomeVM()) {
    val lazyHomeItems = vm.homeItems.collectAsLazyPagingItems().itemSnapshotList

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()) {

        item {
            HomeTopTitle()
        }

        item {
            HomeTitle(strId = R.string.app_discount)
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
          HomeBanner()
        }

        item {
            Spacer(modifier = Modifier.height(15.dp))
        }

        item {
            HomeCategory(data = vm.tabItems)
        }

        item {
            Spacer(modifier = Modifier.height(15.dp))
        }

        item {
            HomeTitle(strId = R.string.app_popular)
        }

        item {
            PopularList(data = lazyHomeItems.items)
        }


        /*LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 0.cdp)
                .background(Color(0xFFF9F9F9))){

            itemsIndexed(lazyHomeItems){index , it->
                it?.let {
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.cdp, end = 24.cdp)
                        .padding(top = 10.cdp, bottom = 0.cdp)
                        .clickable {
                            Log.d("tag", "item click")
                            val json = Uri.encode(Gson().toJson(it))
                            ARoute.instance.navigate("${RouterUrls.DETAIL}/$json")
                        },
                        colors = cardColors(containerColor = Color.White)
                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = it.icon),
                                modifier = Modifier
                                    .size(120.cdp)
                                    .padding(10.cdp),
                                contentDescription = "goods")

                            Column(modifier = Modifier
                                .fillMaxSize()
                                .padding(10.cdp)) {
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
                                        fontSize = 16.sp))

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
                                        fontSize = 16.sp))

                            }

                        }
                    }
                }
            }
        }*/
    }

}

