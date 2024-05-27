package com.kama.kama.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize




@Keep
@Parcelize
data class LoginResult(
    val account: String,
    val isLogin: Boolean
): Parcelable


