package com.kama.kama.ui.page.test.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

///水平滑动
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerExample() {
    val pagerState = rememberPagerState(){5}

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Page: $page",
                //style = MaterialTheme.typography.h4,
                color = Color.White,
                modifier = Modifier.background(Color.Gray)
            )
        }
    }
}