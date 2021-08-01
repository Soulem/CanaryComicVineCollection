package com.example.canarycomicvinecollection.model.data.comicvineaapi.issue

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonCredit(
    val api_detail_url: String,
    val id: Int,
    val name: String,
    val role: String,
    val site_detail_url: String
): Parcelable