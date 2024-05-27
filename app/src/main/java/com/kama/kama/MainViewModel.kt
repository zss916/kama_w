package com.kama.kama

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kama.kama.ui.page.main.TabItem

class MainViewModel : ViewModel() {

    val tabs =
        mutableStateOf(listOf(
            TabItem(R.string.app_home, R.mipmap.home_ic_n, R.mipmap.home_ic_s),
            TabItem(R.string.app_favourite, R.mipmap.favourite_ic_n, R.mipmap.favourite_ic_s),
            TabItem(R.string.app_profile, R.mipmap.profile_ic_n, R.mipmap.profile_ic_s),
        ))

    var selectTabIndex = mutableIntStateOf(0)


}