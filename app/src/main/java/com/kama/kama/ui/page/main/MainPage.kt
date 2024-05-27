package com.kama.kama.ui.page.main

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kama.kama.MainViewModel
import com.kama.kama.ui.page.favourite.FavouriteView
import com.kama.kama.ui.page.home.HomeView
import com.kama.kama.ui.page.profile.ProfileView
import com.kama.kama.ui.theme.SelectedItemColor
import com.kama.kama.ui.theme.UnselectedItemColor
import kotlinx.coroutines.launch
import com.kama.kama.util.TwoBackFinish


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPage(onFinish: () -> Unit = { }) {

    ///组件对back 键的拦截
    BackHandler {
        TwoBackFinish().execute(onFinish)
    }

    val pagerState = rememberPagerState(pageCount = {3})
    Scaffold(
        containerColor= Color(0xFFF9F9F9),
        bottomBar = {
            BottomNavigationBar(pagerState)
        }) { padding ->
        ContentScreen(padding, pagerState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentScreen(padding: PaddingValues, pagerState: PagerState) {
    HorizontalPager(
        userScrollEnabled = false,
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
            .padding(padding)) { pageIndex ->
        when (pageIndex) {
            0 -> HomeView()
            1 -> FavouriteView()
            2 -> ProfileView()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNavigationBar(pagerState: PagerState) {
    val viewModel: MainViewModel = viewModel()
    val scope = rememberCoroutineScope()
    NavigationBar(containerColor = Color.White) {
        viewModel.tabs.value.forEachIndexed { index, tabItem ->
            NavigationBarItem(selected = viewModel.selectTabIndex.intValue == index,
                onClick = {
                    viewModel.selectTabIndex.intValue = index
                    scope.launch {
                        pagerState.scrollToPage(index)
                    }
                }, label = {
                    Text(text = stringResource(id = tabItem.title),
                        color = if (viewModel.selectTabIndex.intValue == index) SelectedItemColor else UnselectedItemColor
                    )
                }, icon = {
                    Image(painter = painterResource(id = if (viewModel.selectTabIndex.intValue == index) tabItem.selectIcon else tabItem.normalIcon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp))
                })
        }
    }
}

data class TabItem(
    @StringRes val title: Int,
    @DrawableRes val normalIcon: Int,
    @DrawableRes val selectIcon: Int,
)