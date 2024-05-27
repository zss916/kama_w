package com.kama.kama.ui.page.web
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kama.kama.R
import com.kama.kama.core.nav.ARoute
import com.kama.kama.ui.page.about.view.BaseAppBar
import com.kama.kama.ui.page.web.view.BaseTitleAppBar
import com.kama.kama.ui.page.web.view.CustomWebView

@Composable
fun WebPage(title:String,url:String){
    Scaffold (
        Modifier.fillMaxSize(),
        containerColor= Color(0xFFF9F9F9),
        contentColor = Color(0xFFF9F9F9),
        topBar = { BaseTitleAppBar(title = title) }){
        it -> ContentView(padding = it,url = url)
    }
}

@Composable
fun ContentView(padding: PaddingValues,url:String){
    Box (modifier = Modifier.fillMaxSize().padding(paddingValues = padding)){
        CustomWebView(url = url, onBack = {ARoute.instance.popBackStack()})
    }
}