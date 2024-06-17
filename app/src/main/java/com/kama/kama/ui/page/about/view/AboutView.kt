package com.kama.kama.ui.page.about.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.AppConfig
import com.kama.kama.core.KamaApplication
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterKV
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.ui.page.profile.view.CommonItemButton
import com.kama.kama.util.cdp


@Composable
fun AboutView(padding: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize().padding(padding)
            .background(color = Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(top = 10.cdp))

        Image(
            painter = painterResource(id = R.mipmap.app_logo),
            modifier = Modifier
                .size(130.cdp),
            contentDescription = "avatar")

        Spacer(modifier = Modifier.padding(top = 12.cdp))

        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black)

        Spacer(modifier = Modifier.padding(top = 5.cdp))

        Text(
            text = "version:1.0.2",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFFA0A0A0))

        Spacer(modifier = Modifier.padding(top = 20.cdp))

        TextItemButton(strId = R.string.app_policy){
            Log.d("app_policy","app_policy")
            val title = KamaApplication.context.getString(R.string.app_policy)
            ARoute.instance.navigate("${RouterUrls.WEB}/${title}")
        }

        TextItemButton(strId = R.string.app_terms){
            val title = KamaApplication.context.getString(R.string.app_terms)
            ARoute.instance.navigate("${RouterUrls.WEB}/${title}")
        }

    }

}

//https://juejin.cn/post/6992169168938205191

//https://juejin.cn/post/7011895995722121247
//https://github.com/shenzhen2017/wanandroid-compose


//https://github.com/huanglinqing123/TravelPreventionCompose.git
//项目
//https://juejin.cn/post/7145391922285117453?searchId=20240522232951134FD1BE275F5CB39842


