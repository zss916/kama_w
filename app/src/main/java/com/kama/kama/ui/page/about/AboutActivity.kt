package com.kama.kama.ui.page.about

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowInsetsControllerCompat
import com.kama.kama.R
import com.kama.kama.ui.page.about.view.AboutView
import com.kama.kama.ui.page.about.view.BaseAppBar

class AboutActivity : ComponentActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AboutActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = android.graphics.Color.WHITE
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = true
        }
        setContent {
            AboutPage()
        }
    }
}

@Composable
fun AboutPage(){
    Scaffold (
        Modifier.fillMaxSize(),
        containerColor= Color(0xFFF9F9F9),
        contentColor = Color(0xFFF9F9F9),
        topBar = { BaseAppBar(strId = R.string.app_about_us) }
    ){ padding -> AboutView(padding = padding) }
}