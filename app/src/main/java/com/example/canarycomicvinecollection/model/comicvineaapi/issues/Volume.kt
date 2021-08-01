package com.example.canarycomicvinecollection.model.data.comicvineaapi.issues

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Volume(
    val api_detail_url: String,
    val id: Int,
    val name: String,
    val site_detail_url: String
): Parcelable