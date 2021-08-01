package com.example.canarycomicvinecollection.model.data.comicvineaapi.volumes

import com.example.canarycomicvinecollection.model.data.comicvineaapi.Result
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class Volumes(
    val aliases: String,
    val api_detail_url: String,
    val count_of_issues: Int,
    val date_added: String,
    val date_last_updated: String,
    val deck: @RawValue Any,
    val description: String,
    val first_issue: FirstIssue,
    val id: Int,
    val image: Image,
    val last_issue: LastIssue,
    val name: String,
    val publisher: Publisher,
    val site_detail_url: String,
    val start_year: String
):Result()