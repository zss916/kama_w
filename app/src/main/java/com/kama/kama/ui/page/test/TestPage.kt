package com.kama.kama.ui.page.test

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.KamaApplication
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.ui.page.about.view.AboutView
import com.kama.kama.ui.page.about.view.BaseAppBar
import com.kama.kama.ui.page.about.view.TextItemButton
import com.kama.kama.util.cdp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.kama.kama.ui.page.test.view.Filters
import com.kama.kama.ui.page.test.view.HorizontalPagerExample
import com.kama.kama.ui.page.test.view.LinearGradientText
import com.kama.kama.ui.page.test.view.MultipleStylesInText
import com.kama.kama.ui.page.test.view.VerticalPagerExample

@Composable
fun TestPage( onClick: (() -> Unit)? = null) {

    Scaffold (
        Modifier.fillMaxSize(),
        containerColor= Color(0xFFF9F9F9),
        contentColor = Color(0xFFF9F9F9),
        topBar = { BaseAppBar(strId = R.string.app_test) }
    ){ padding -> ContentView(padding = padding) }

}


@Composable
fun ContentView(padding: PaddingValues) {

   // HorizontalPagerExample()
   // VerticalPagerExample()
   // Filters()

    //TextField(value = , onValueChange = )

    Column(modifier = Modifier.fillMaxSize().padding(padding)) {

        Spacer(modifier = Modifier.height(100.dp))

        MultipleStylesInText()

        Spacer(modifier = Modifier.height(50.dp))

        LinearGradientText()
    }


}







