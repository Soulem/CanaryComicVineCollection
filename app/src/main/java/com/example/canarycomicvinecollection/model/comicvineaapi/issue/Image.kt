package com.example.canarycomicvinecollection.model.data.comicvineaapi.issue

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val icon_url: String,
    val image_tags: String,
    val medium_url: String,
    val original_url: String,
    val screen_large_url: String,
    val screen_url: String,
    val small_url: String,
    val super_url: String,
    val thumb_url: String,
    val tiny_url: String
): Parcelable