package com.kama.kama.ui.page.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kama.kama.model.HomeData
import com.kama.kama.model.homeList
import kotlinx.coroutines.delay

class HomeSource : PagingSource<Int, HomeData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeData> {
        return try {
            val nextPage = params.key ?: 1
            val movieListResponse = homeList
            if (nextPage > 1) {
                delay(2000)
            }
            LoadResult.Page(
                data = movieListResponse,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, HomeData>): Int? {
        return null
    }
}