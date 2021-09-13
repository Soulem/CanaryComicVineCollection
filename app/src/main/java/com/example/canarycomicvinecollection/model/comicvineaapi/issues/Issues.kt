package com.example.canarycomicvinecollection.model.data.comicvineaapi.issues

import android.os.Parcelable
import kotlinx.android.parcel.RawValue
import kotlinx.parcelize.Parcelize

@Parcelize
data class Issues(
    val aliases: @RawValue Any,
    val api_detail_url: String,
    val cover_date: String,
    val date_added: String,
    val date_last_updated: String,
    val deck: String,
    val description: String,
    val has_staff_review: Boolean,
    val id: Int,
    val image: Image,
    val issue_number: String,
    val name: String,
    val site_detail_url: String,
    val store_date: String,
    val volume: Volume
): Parcelable