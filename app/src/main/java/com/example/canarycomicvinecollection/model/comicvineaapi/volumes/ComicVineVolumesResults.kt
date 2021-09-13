package com.example.canarycomicvinecollection.model.comicvineaapi.volumes

import android.os.Parcelable
import com.example.canarycomicvinecollection.model.data.comicvineaapi.volumes.Volumes
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComicVineVolumesResults(
    val error: String,
    val limit: Int,
    val number_of_page_results: Int,
    val number_of_total_results: Int,
    val offset: Int,
    val results: List<Volumes>,
    val status_code: Int,
    val version: String
): Parcelable