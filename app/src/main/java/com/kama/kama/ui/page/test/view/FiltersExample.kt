package com.kama.kama.ui.page.test.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Filters() {
    val filters = listOf(
    "Washer/Dryer", "Ramp access", "Garden", "Cats OK", "Dogs OK", "Smoke-free")

    FlowRow(
      modifier = Modifier.fillMaxWidth().padding(top = 50.dp, start = 10.dp, end = 10.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        filters.forEach { title ->
        var selected by remember { mutableStateOf(false) }
        val leadingIcon: @Composable () -> Unit = { Icon(imageVector = Icons.Default.Check, contentDescription = null) }
        FilterChip(
        selected,
        onClick = { selected = !selected },
        label = { Text(text = title) },
        leadingIcon = if (selected) leadingIcon else null)
        }
    }
}
