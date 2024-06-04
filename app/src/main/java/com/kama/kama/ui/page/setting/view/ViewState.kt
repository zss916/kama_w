package com.kama.kama.ui.page.setting.view
import androidx.compose.runtime.Stable

@Stable
data class ViewState(
    val visible: Boolean,
    val onShowRequest: () -> Unit,
    val onDismissRequest: () -> Unit
)