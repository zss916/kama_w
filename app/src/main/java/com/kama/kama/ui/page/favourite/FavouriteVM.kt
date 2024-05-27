package com.kama.kama.ui.page.favourite

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kama.kama.model.HomeData

import kotlinx.coroutines.flow.Flow

class FavouriteVM : ViewModel() {
    val dataItems: Flow<PagingData<HomeData>> =
        Pager(PagingConfig(pageSize = 10, prefetchDistance = 1)) {
            FavouriteSource()
        }.flow
}