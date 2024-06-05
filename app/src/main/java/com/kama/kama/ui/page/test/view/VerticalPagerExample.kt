package com.kama.kama.ui.page.test.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

///垂直滑动
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalPagerExample() {
    val pagerState = rememberPagerState(){5}

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Page: $page",
                color = Color.White,
                fontWeight = FontWeight.Black,
                //modifier = Modifier.background(Color.White)
            )
        }
    }
}