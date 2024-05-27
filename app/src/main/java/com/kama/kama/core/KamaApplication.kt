package com.kama.kama.core

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.kama.kama.util.KVCache
//import dagger.hilt.android.HiltAndroidApp



//@HiltAndroidApp
class KamaApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        KVCache.init(this)
    }
}