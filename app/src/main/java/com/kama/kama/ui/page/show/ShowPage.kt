package com.kama.kama.ui.page.show

import android.util.Log
import android.widget.Space
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
/*import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState*/
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.ui.page.home.HomeView
import com.kama.kama.ui.page.login.LoginPage
import com.kama.kama.ui.page.profile.ProfileView
import com.kama.kama.ui.page.show.view.ShowView
import com.kama.kama.util.cdp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Logger

@Preview(showBackground = true)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowPage() {

    val pagerState = rememberPagerState(pageCount = {3})
    val scope = rememberCoroutineScope()

    HorizontalPager(
        userScrollEnabled = true,
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.app_bg_color))) { pageIndex ->
        when (pageIndex) {
            0 -> ShowPageView(index = pageIndex,pagerState = pagerState,scope = scope)
            1 -> ShowPageView(index = pageIndex,pagerState = pagerState,scope = scope)
            2 -> LoginPage()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowPageView(index: Int, pagerState: PagerState, scope: CoroutineScope){
    ShowView(
        index = index,
        onGo = {i->
                 Log.d("tag","index:$i")
                 scope.launch {
                     pagerState.scrollToPage(page = (index+1))
                 }
               },
        onSkip = {
            scope.launch {
                pagerState.scrollToPage(page = 3)
            }
        })
}


