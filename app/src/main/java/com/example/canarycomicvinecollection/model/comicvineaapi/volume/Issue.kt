package com.example.canarycomicvinecollection.model.data.comicvineaapi.volume

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Issue(
    val api_detail_url: String,
    val id: Int,
    val issue_number: String,
    val name: String,
    val site_detail_url: String
): Parcelable