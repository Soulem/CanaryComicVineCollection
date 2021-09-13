package com.example.canarycomicvinecollection.model.data.comicvineaapi.volume

import android.os.Parcelable
import kotlinx.android.parcel.RawValue
import kotlinx.parcelize.Parcelize

@Parcelize
data class Volume(
    val aliases: String,
    val api_detail_url: String,
    val characters: List<Character>,
    val concepts: List<Concept>,
    val count_of_issues: Int,
    val date_added: String,
    val date_last_updated: String,
    val deck: @RawValue Any,
    val description: String,
    val first_issue: FirstIssue,
    val id: Int,
    val image: Image,
    val issues: List<Issue>,
    val last_issue: LastIssue,
    val name: String,
    val objects: List<Object>,
    val people: List<People>,
    val publisher: Publisher,
    val site_detail_url: String,
    val start_year: String
): Parcelable