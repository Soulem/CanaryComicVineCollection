package com.example.canarycomicvinecollection.model.data.comicvineaapi

import android.os.Parcelable
import com.example.canarycomicvinecollection.model.data.comicvineaapi.issues.Issues
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicVineResults(
    val error: String,
    val limit: Int,
    val number_of_page_results: Int,
    val number_of_total_results: Int,
    val offset: Int,
    val results: List<Result>,
    val status_code: Int,
    val version: String
): Parcelable