package com.kama.kama.ui.page.login

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.util.cdp
import kotlinx.coroutines.delay

@Composable
fun LoginPage() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9)),
        verticalArrangement =  Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.show3),
            modifier = Modifier
                .padding(top = 20.cdp, bottom = 15.cdp),
            contentDescription =null)

        Text(
            text = stringResource(id = R.string.app_show_content3),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.cdp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )

        Spacer(modifier = Modifier.weight(3.5f))

        /*Text(
            text = stringResource(id = R.string.app_start),
            modifier = Modifier
                .padding(start = 15.cdp, end = 15.cdp, bottom = 10.cdp)
                .background(Color(0xFF0C8A7B), shape = RoundedCornerShape(14.cdp))
                .padding(vertical = 16.cdp, horizontal = 10.cdp)
                .fillMaxWidth()
                .clickable {
                    Log.d("tag", "Start ")
                },
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)*/

        TextButton(
            contentPadding = PaddingValues(0.cdp),
            onClick = {
                Log.d("tag", "TextButton  Start ")
                ARoute.instance.popBackStack()
                ARoute.instance.navigate(RouterUrls.MAIN)
            }) {
            Text(
                text = stringResource(id = R.string.app_start),
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
            modifier = Modifier
                .padding(start = 5.cdp, end = 5.cdp, bottom = 10.cdp)
                .fillMaxWidth()
                .padding(vertical = 16.cdp, horizontal = 16.cdp)
                .background(color = Color.White,shape = RoundedCornerShape(14.cdp)),
            onClick = {
                Log.d("tag", "TextButton Google Sign in ")
                ARoute.instance.popBackStack()
                ARoute.instance.navigate(RouterUrls.MAIN)
                //ARoute.instance.navigate(RouterUrls.WEB)
            }) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                ) {

                Image(
                    painter = painterResource(id = R.mipmap.google_logo),
                    modifier = Modifier
                        .padding(end = 10.cdp, start = 10.cdp)
                        .size(24.cdp)
                        .padding(0.cdp),
                    contentDescription =null)

                Text(
                    text = stringResource(id = R.string.app_sign_in_google),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W900,
                    textAlign = TextAlign.Center)
            }
        }

    }
}