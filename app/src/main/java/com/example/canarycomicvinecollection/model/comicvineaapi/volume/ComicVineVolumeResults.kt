package com.example.canarycomicvinecollection.model.comicvineaapi.volume

import android.os.Parcelable
import com.example.canarycomicvinecollection.model.data.comicvineaapi.issues.Volume
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComicVineVolumeResults(
    val error: String,
    val limit: Int,
    val number_of_page_results: Int,
    val number_of_total_results: Int,
    val offset: Int,
    val results: List<Volume>,
    val status_code: Int,
    val version: String
): Parcelable