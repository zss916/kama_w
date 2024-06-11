package com.kama.kama.ui.page.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.ui.page.about.AboutActivity
import com.kama.kama.ui.page.profile.view.CommonItemButton
import com.kama.kama.util.cdp

@Composable
fun ProfileView() {
    val context = LocalContext.current
    var show by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(color = Color(0xFFF9F9F9)),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            text = stringResource(id = R.string.app_profile),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 0.cdp))

        Spacer(modifier = Modifier.padding(top = 24.cdp))

        Image(
            painter = painterResource(id = R.mipmap.app_logo),
            modifier = Modifier
                .size(60.cdp),
            contentDescription = "avatar")

        Spacer(modifier = Modifier.padding(top = 12.cdp))

        Text(
            text = "KAMA",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black)

        Spacer(modifier = Modifier.padding(top = 20.cdp))

        /*CommonItemButton(iconId = R.mipmap.user, strId = R.string.app_profile){
            ARoute.instance.navigate(RouterUrls.EDIT_PROFILE)
        }*/

        CommonItemButton(iconId = R.mipmap.about, strId = R.string.app_about_us){
            //AboutActivity.start(context)
            ARoute.instance.navigate(RouterUrls.ABOUT)
        }

        CommonItemButton(iconId = R.mipmap.setting, strId = R.string.app_setting){
            ARoute.instance.navigate(RouterUrls.SETTING)
        }

    }

}