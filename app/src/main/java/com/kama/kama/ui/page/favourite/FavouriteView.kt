package com.kama.kama.ui.page.favourite


import android.net.Uri
import android.util.Log
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.gson.Gson
import com.kama.kama.R
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.ui.page.about.AboutActivity
import com.kama.kama.ui.page.favourite.view.Empty
import com.kama.kama.ui.page.home.HomeVM
import com.kama.kama.ui.page.profile.view.CommonItemButton
import com.kama.kama.util.cdp

@Composable
fun FavouriteView(vm: FavouriteVM = FavouriteVM()) {
    val context = LocalContext.current
    val lazyItems = vm.dataItems.collectAsLazyPagingItems().itemSnapshotList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(color = Color(0xFFF9F9F9)),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            text = stringResource(id = R.string.app_favourite),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 10.cdp, bottom = 20.cdp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)){

          if(lazyItems.isEmpty())

            Empty()

            else

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                //horizontalArrangement =  Arrangement.Center,
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                contentPadding = PaddingValues(10.dp),
                ) {

                items(lazyItems){
                    it?.let {

                       Column {
                           Box (contentAlignment  = Alignment.TopEnd){
                               Card(modifier = Modifier
                                   .fillMaxWidth()
                                   .align(alignment = Alignment.Center)
                                   .clickable {
                                       Log.d("tag", "item click")
                                       val json = Uri.encode(Gson().toJson(it))
                                       ARoute.instance.navigate("${RouterUrls.DETAIL}/$json")
                                   },
                                   colors = CardDefaults.cardColors(containerColor = Color.White)
                               ) {

                                   Image(
                                       painter = painterResource(id = it.icon ),
                                       modifier = Modifier
                                           .size(width = 156.dp, height = 160.dp)
                                           .align(alignment = Alignment.CenterHorizontally),
                                       contentDescription = "favourite_image")
                               }

                               Box(modifier = Modifier.padding(10.dp)) {
                                   Image(
                                       painter = painterResource(id = R.mipmap.like ),
                                       modifier = Modifier
                                           .size(width = 24.dp, height = 24.dp),
                                       contentDescription = "like")
                               }
                           }

                           Spacer(modifier = Modifier.padding(top = 10.dp))
                           
                           Text(
                               text = it.title,
                               modifier = Modifier.fillMaxWidth(),
                               style = TextStyle(
                                   color = Color.Black,
                                   fontSize = 16.sp,
                                   fontWeight = FontWeight.Black))

                           Spacer(modifier = Modifier.padding(top = 5.dp))

                           Text(
                               text = it.price,
                               modifier = Modifier.fillMaxWidth(),
                               style = TextStyle(
                                   color = Color(0xFFF2A666),
                                   fontSize = 16.sp,
                                   fontWeight = FontWeight.W600))
                       }

                    }
                }
            }

        }
    }

}


