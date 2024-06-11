package com.kama.kama.ui.page.edit

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kama.kama.R
import com.kama.kama.core.KamaApplication
import com.kama.kama.core.nav.ARoute
import com.kama.kama.core.nav.RouterUrls
import com.kama.kama.ui.page.about.view.AboutView
import com.kama.kama.ui.page.about.view.BaseAppBar
import com.kama.kama.ui.page.about.view.TextItemButton
import com.kama.kama.util.cdp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import com.kama.kama.ui.page.edit.view.CommonEditButton
import com.kama.kama.ui.page.edit.view.rememberDatePickerState
import com.kama.kama.ui.page.profile.view.CommonItemButton
import java.time.LocalDate
import java.time.format.DateTimeFormatter

const val DefaultDateFormatter = "yyyy-MM-dd"

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditProfilePage() {

    Scaffold (
        Modifier.fillMaxSize(),
        containerColor= Color(0xFFF9F9F9),
        contentColor = Color(0xFFF9F9F9),
        topBar = { BaseAppBar(strId = R.string.app_profile) }
    ){ padding -> ContentView(padding = padding) }

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContentView(padding: PaddingValues) {

    var textSearchName by remember { mutableStateOf("") }

    val state = rememberDatePickerState()
    var value by remember { mutableStateOf(LocalDate.now()) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally){

        Spacer(modifier = Modifier.height(80.dp))

        CommonEditButton(strId = R.string.app_nick_name, content = "kamaa"){

        }

        CommonEditButton(strId = R.string.app_gender, content = "Female"){

        }

        CommonEditButton(strId = R.string.app_birthdate, content = value.format(DateTimeFormatter.ofPattern(DefaultDateFormatter))){
            state.show(value) {
                value = it
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center){
            BasicTextField(value = textSearchName,
                onValueChange = {
                    textSearchName = it
                },
                decorationBox = { innerTextField ->
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp)) {

                        Icon(imageVector = Icons.Filled.Search,contentDescription = null)

                        Box(modifier = Modifier.padding(horizontal = 10.dp),
                            contentAlignment = Alignment.CenterStart) {
                            if (textSearchName.isEmpty()) {
                                Text(text = "请输入查找的内容",
                                    style = TextStyle(
                                        color = Color(0,0,0,128)
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                            innerTextField()
                        }
                        if(textSearchName.isNotEmpty()){
                            IconButton(onClick = { textSearchName = "" },
                                modifier = Modifier.size(16.dp)) {
                                Icon(imageVector =Icons.Filled.Close,
                                    contentDescription = null)
                            }
                        }
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .background(Color.Gray, CircleShape)
                    .height(40.dp)
                    .fillMaxWidth())
        }

    }


}






