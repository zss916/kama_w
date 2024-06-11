package com.kama.kama

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowInsetsControllerCompat
//import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kama.kama.core.nav.ARoute
//import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.kama.kama.core.nav.NCNavGraph
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.ui.page.home.HomeView
import com.kama.kama.ui.page.profile.ProfileView
import com.kama.kama.ui.theme.SelectedItemColor
import com.kama.kama.ui.theme.UnselectedItemColor
import kotlinx.coroutines.launch
//import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transparentStatusBar()

        window.statusBarColor = android.graphics.Color.TRANSPARENT
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = true
        }
        setContent {
            val navCtr = rememberNavController()


            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)

            ) {
                NCNavGraph(navCtr) {
                    finish()
                }

                FixSystemBarsColor()
            }
        }


    }





}


/**
 * 设置为沉浸式状态栏
 */
fun Activity.transparentStatusBar() {
    WindowCompat.setDecorFitsSystemWindows(window, false)
}


@Composable
fun FixSystemBarsColor() {
    val sysUiController = rememberSystemUiController()

    val curRouteName = ARoute.instance.currentBackStackEntryAsState().value?.destination?.route
    if (curRouteName == RouterUrls.SPLASH) {  // 闪屏页，状态栏透明，图标白色
        sysUiController.setSystemBarsColor(Color(0xFF0C8A7B), true)
    } else {
        sysUiController.setSystemBarsColor(Color.Transparent, true)
    }


    //sysUiController.setNavigationBarColor(AppColorsProvider.current.background)
}
