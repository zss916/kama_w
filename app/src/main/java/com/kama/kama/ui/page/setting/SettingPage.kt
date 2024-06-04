package com.kama.kama.ui.page.setting

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.AppConfig
import com.kama.kama.core.KamaApplication
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterKV
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.ui.page.about.view.AboutView
import com.kama.kama.ui.page.about.view.BaseAppBar
import com.kama.kama.ui.page.about.view.TextItemButton
import com.kama.kama.ui.page.favourite.FavouriteVM
import com.kama.kama.ui.page.profile.view.CommonItemButton
import com.kama.kama.ui.page.setting.view.BottomSheetDialog
import com.kama.kama.ui.page.setting.view.DialogContent
import com.kama.kama.util.cdp


@Composable
fun SettingPage(vm: SettingVM = SettingVM()) {
    Scaffold (
        Modifier.fillMaxSize(),
        containerColor= Color(0xFFF9F9F9),
        contentColor = Color(0xFFF9F9F9),
        topBar = { BaseAppBar(strId = R.string.app_setting) }
    ){ padding -> ContentView(padding = padding,vm = vm) }
}

@Composable
fun ContentView(padding: PaddingValues,vm: SettingVM ){
    val context = LocalContext.current
    val viewState = vm.viewState

   // private val mainViewModel by viewModels<MainViewModel>()

    ///调用 onClick = { onMyClick.invoke() }
    val onMyClick = {
       Log.d("tag","lambda fun click")
    }

    ///调用 onClick = { onMyFunClick() }
    fun onMyFunClick(){
        Log.d("tag","fun click")
    }

    Box (modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = padding)){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CommonItemButton(
                strId = R.string.app_delete_account,
                onClick = viewState.onShowRequest
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(
                contentPadding = PaddingValues(0.cdp),
                onClick = {
                    Log.d("tag", "TextButton log out ")
                    (context as ComponentActivity).finish()
                }) {
                Text(
                    text = stringResource(id = R.string.app_log_out),
                    modifier = Modifier
                        .padding(start = 15.cdp, end = 15.cdp, bottom = 30.cdp)
                        .background(Color.White, shape = RoundedCornerShape(14.cdp))
                        .padding(vertical = 16.cdp, horizontal = 10.cdp)
                        .fillMaxWidth(),
                    color = Color.Red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center)
            }
        }

        BottomSheetDialog(
            modifier = Modifier,
            visible = viewState.visible,
            cancelable = false,
            canceledOnTouchOutside = false,
            onDismissRequest = viewState.onDismissRequest
        ) {
            DialogContent(onDismissRequest = viewState.onDismissRequest)
        }
    }




}
