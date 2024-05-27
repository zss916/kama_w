package com.kama.kama.ui.page.splash

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.AppGlobalData
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.util.cdp
import kotlinx.coroutines.delay


@Composable
fun SplashPage() {

    LaunchedEffect(Unit) {
        delay(1000)
        ARoute.instance.popBackStack()
        val isLogin = AppGlobalData.sLoginResult?.isLogin
        ARoute.instance.navigate(RouterUrls.SHOW)
       // ARoute.instance.navigate(if (isLogin == true) RouterUrls.LOGIN else RouterUrls.MAIN)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C8A7B)),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.mipmap.logo),
            modifier = Modifier
                .padding(top = 0.cdp, bottom = 15.cdp)
                // .align(Alignment.Center)
                .size(width = 112.cdp, height = 100.cdp),
            contentDescription =null)

        Text(
            text = "KAMA",
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
    }
}