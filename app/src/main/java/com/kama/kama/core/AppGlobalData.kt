package com.kama.kama.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.kama.kama.model.HomeData
import com.kama.kama.model.LoginResult
import com.kama.kama.util.kvCacheParcelable


object AppGlobalData {

    var sLoginRefreshFlag by mutableStateOf(false)
    var sLoginResult by kvCacheParcelable(LoginResult::class.java)

   // var favouriteData by kvCacheParcelable(HomeData::class.java)

    ///全局数据
    var favouriteData = mutableListOf<HomeData>()
}