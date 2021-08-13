package com.example.canarycomicvinecollection.model.db

import com.example.canarycomicvinecollection.model.data.comicvineaapi.ComicVineResults
import com.example.canarycomicvinecollection.network.ComicVineRetrofit
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicVineRepository @Inject constructor(private val comicVineRetrofit : ComicVineRetrofit){
    fun readIssuesFromRemoteSource(filter : String) : Single<ComicVineResults> = comicVineRetrofit.getNewIssues(filter)
}