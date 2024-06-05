package com.kama.kama.core.nav


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
/*import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable*/
import com.google.gson.Gson
import com.kama.kama.R
import com.kama.kama.core.AppConfig
import com.kama.kama.core.KamaApplication
import com.kama.kama.model.HomeData
import com.kama.kama.ui.page.about.AboutPage
import com.kama.kama.ui.page.detail.DetailPage
import com.kama.kama.ui.page.edit.EditProfilePage
import com.kama.kama.ui.page.login.LoginPage
import com.kama.kama.ui.page.main.MainPage
import com.kama.kama.ui.page.setting.SettingPage
import com.kama.kama.ui.page.show.ShowPage
import com.kama.kama.ui.page.splash.SplashPage
import com.kama.kama.ui.page.test.TestPage
import com.kama.kama.ui.page.web.WebPage


object ARoute {
    @SuppressLint("StaticFieldLeak")
    lateinit var instance: NavHostController

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NCNavGraph(
    navController: NavHostController,
    startDestination: String = RouterUrls.SPLASH,
    onFinish: () -> Unit = { }
) {
    ARoute.instance = navController
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(RouterUrls.TEST) {
            //Log.d("tag","splash page")
            TestPage()
        }
        composable(RouterUrls.SPLASH) {
            Log.d("tag","splash page")
            SplashPage()
        }
        composable(RouterUrls.SHOW) {
            ShowPage()
        }
        composable(RouterUrls.LOGIN) {
            LoginPage()
        }
        composable(RouterUrls.MAIN) {
            MainPage(){ onFinish() }
        }
        composable(RouterUrls.ABOUT) {
            AboutPage()
        }
        composable(RouterUrls.SETTING) {
            SettingPage()
        }
        composable("${RouterUrls.DETAIL}/{${RouterKV.DETAILS_DATA}}") {
            val playlistBeanJson = it.arguments?.getString(RouterKV.DETAILS_DATA)!!
            val homeData = Gson().fromJson(playlistBeanJson, HomeData::class.java)
            DetailPage(data = homeData)
        }
        composable("${RouterUrls.WEB}/{${RouterKV.WEB_TITLE}}"){
            val title = it.arguments?.getString(RouterKV.WEB_TITLE)!!
           when(title){
               KamaApplication.context.getString(R.string.app_policy) -> WebPage(title = title,url = AppConfig.APP_POLICY)
               KamaApplication.context.getString(R.string.app_terms) -> WebPage(title = title,url = AppConfig.APP_TERMS)
            }
        }
        composable(RouterUrls.EDIT_PROFILE) {
            EditProfilePage()
        }



    }
}

