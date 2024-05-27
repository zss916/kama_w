package com.kama.kama.ui.page.home

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kama.kama.R
import com.kama.kama.model.HomeData
import com.kama.kama.model.HomeTab
import com.kama.kama.model.cabinetList
import com.kama.kama.model.chairList

import kotlinx.coroutines.flow.Flow
import com.kama.kama.model.homeList
import com.kama.kama.model.sofaList
import com.kama.kama.model.tablewareList

class HomeVM : ViewModel() {
    val homeItems: Flow<PagingData<HomeData>> =
        Pager(PagingConfig(pageSize = 10, prefetchDistance = 1)) {
            HomeSource()
        }.flow

    val tabItems = arrayListOf(
        HomeTab(icon = R.mipmap.chair_icon, iconSelect = R.mipmap.chair_s, title = "Armchair"),
        HomeTab(icon = R.mipmap.sofa_icon,iconSelect = R.mipmap.sofa_s,title = "Sofa"),
        HomeTab(icon = R.mipmap.cabinet_icon,iconSelect = R.mipmap.cabinet_s,title = "Cabinet"),
        HomeTab(icon = R.mipmap.tableware_icon,iconSelect = R.mipmap.tableware_s,title = "Tableware"),
        )

    //val chairData = mutableListOf().
    //val sofaData = mutableListOf(sofaList)
    //val cabinetData = mutableListOf(cabinetList)
    //val tablewareData = mutableListOf(tablewareList)
}