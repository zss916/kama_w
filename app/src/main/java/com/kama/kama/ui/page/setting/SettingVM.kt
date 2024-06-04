package com.kama.kama.ui.page.setting

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kama.kama.model.HomeData
import com.kama.kama.ui.page.setting.view.ViewState

import kotlinx.coroutines.flow.Flow

class SettingVM : ViewModel() {


    var viewState by mutableStateOf(
        value = ViewState(
            visible = false,
            onShowRequest = ::onShowRequest,
            onDismissRequest = ::onDismissRequest
        )
    )
        private set

    private fun onShowRequest() {
        viewState = viewState.copy(visible = true)
    }

    private fun onDismissRequest() {
        viewState = viewState.copy(visible = false)
    }



}