package com.example.canarycomicvinecollection.model.data.comicvineaapi.volumes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Publisher(
    val api_detail_url: String,
    val id: Int,
    val name: String
): Parcelable