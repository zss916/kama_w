package com.kama.kama.ui.page.about.view

import androidx.activity.ComponentActivity
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.nav.ARoute
import com.kama.kama.util.cdp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseAppBar(@StringRes strId: Int){
    val context = LocalContext.current

    TopAppBar(
        modifier = Modifier.background(color = Color(0xFFF9F9F9)),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF9F9F9)),
        title = {
            Text(
                stringResource(id = strId),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black)
        },

        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .size(48.cdp)
                    .shadow(elevation = 0.5.cdp, shape = CircleShape)
                    .background(Color.White, shape = CircleShape),
                onClick = {
                    //(context as ComponentActivity).finish()
                    //ARoute.instance.popBackStack()
                    ARoute.instance.navigateUp()
                }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
            }
        },

        actions = {
            Box(modifier = Modifier.size(48.cdp).background(color = Color.Transparent))
        }
    )
}