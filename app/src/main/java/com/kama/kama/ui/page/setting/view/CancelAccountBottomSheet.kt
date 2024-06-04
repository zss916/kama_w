package com.kama.kama.ui.page.setting.view

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.util.cdp

///目前是Compose Material 3
///Material 3 目前并没有提供 BottomSheetScaffold
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CancelAccountBottomSheet(){

    BottomSheetScaffold(sheetContent = {

    }, content = {

    })

}


@Composable
fun DialogContent(onDismissRequest: () -> Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.7f)
            .background(color = Color(0xFFFFFFFF))
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
        //verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.mipmap.delete_account_ic ),
            modifier = Modifier.padding(top = 15.dp),
            contentDescription = "delete account icon")

        Text(
            text = stringResource(id = R.string.app_delete_account_title),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp),
            style = TextStyle(
                color = Color.Red,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            ))

        Text(
            text = stringResource(id = R.string.app_delete_account_content1),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp),
            style = TextStyle(
                color = Color(0xFF828A89),
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            ))

        Text(
            text = stringResource(id = R.string.app_delete_account_content2),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 10.dp),
            style = TextStyle(
                color = Color(0xFF828A89),
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            ))

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(
            contentPadding = PaddingValues(0.cdp),
            onClick = {
                onDismissRequest.invoke()

            }) {
            Text(
                text = stringResource(id = R.string.app_cancel),
                modifier = Modifier
                    .padding(start = 15.cdp, end = 15.cdp, bottom = 10.cdp)
                    .background(Color(0xFF0C8A7B), shape = RoundedCornerShape(14.cdp))
                    .padding(vertical = 16.cdp, horizontal = 10.cdp)
                    .fillMaxWidth(),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.W900,
                textAlign = TextAlign.Center)
        }

        TextButton(
            contentPadding = PaddingValues(0.cdp),
            onClick = {
                onDismissRequest.invoke()
                (context as ComponentActivity).finish()

            }) {
            Text(
                text = stringResource(id = R.string.app_sure),
                modifier = Modifier
                    .padding(start = 15.cdp, end = 15.cdp, bottom = 10.cdp)
                    .background(Color(0x000C8A7B), shape = RoundedCornerShape(14.cdp))
                    .padding(vertical = 16.cdp, horizontal = 10.cdp)
                    .fillMaxWidth(),
                color = Color.Red,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.W900,
                textAlign = TextAlign.Center)
        }


        
    }
}


