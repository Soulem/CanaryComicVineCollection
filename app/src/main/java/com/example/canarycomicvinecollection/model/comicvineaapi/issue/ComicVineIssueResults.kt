package com.example.canarycomicvinecollection.model.comicvineaapi.issue

import android.os.Parcelable
import com.example.canarycomicvinecollection.model.data.comicvineaapi.issue.Issue
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComicVineIssueResults(
    val error: String,
    val limit: Int,
    val number_of_page_results: Int,
    val number_of_total_results: Int,
    val offset: Int,
    val results: List<Issue>,
    val status_code: Int,
    val version: String
): Parcelable