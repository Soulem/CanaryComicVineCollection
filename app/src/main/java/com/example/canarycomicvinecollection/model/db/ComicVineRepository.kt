package com.example.canarycomicvinecollection.model.db

import com.example.canarycomicvinecollection.model.comicvineaapi.issues.ComicVineIssuesResults
import com.example.canarycomicvinecollection.network.ComicVineRetrofit
import io.reactivex.Single

class ComicVineRepository (){
    fun readIssuesFromRemoteSource(filter: String, apiKey: String, offset:String="0", limit:String="100", sort:String="store_date:desc") : Single<ComicVineIssuesResults> = ComicVineRetrofit.getInstance().getNewIssues(filter, apiKey, offset, limit, sort)
}