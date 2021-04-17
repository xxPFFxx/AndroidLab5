package com.xxpffxx.lab5.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Android(
    val title: String,
    @DrawableRes val imageAndroid: Int
) : Parcelable
