package com.example.canarycomicvinecollection.model.data.comicvineaapi.volume

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Concept(
    val api_detail_url: String,
    val count: String,
    val id: Int,
    val name: String,
    val site_detail_url: String
): Parcelable