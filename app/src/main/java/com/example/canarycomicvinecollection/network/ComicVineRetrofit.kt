package com.example.canarycomicvinecollection.network

import com.example.canarycomicvinecollection.model.data.comicvineaapi.ComicVineResults
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_FILTER
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_FORMAT
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_KEY
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_LIMIT
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_OFFSET
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_SORT
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_BASE_URL
import com.example.canarycomicvinecollection.utl.Constants.Companion.ISSUES_END_POINT
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class ComicVineRetrofit(private val apiKey : String) {
    interface ComicVineAPIService{
        @GET(ISSUES_END_POINT)
        fun getNewIssues(@Query(COMIC_VINE_API_FILTER) filter : String,
                         @Query(COMIC_VINE_API_KEY) apikey : String,
                         @Query(COMIC_VINE_API_FORMAT) format : String,
                         @Query(COMIC_VINE_API_SORT) sort : String,
                         @Query(COMIC_VINE_API_OFFSET) offset : String,
                         @Query(COMIC_VINE_API_LIMIT) limit : String) : Single<ComicVineResults>
    }

    private val cvAPIService: ComicVineAPIService = Retrofit.Builder()
        .baseUrl(COMIC_VINE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ComicVineAPIService::class.java)

    fun getNewIssues(filter: String, offset:String="0", limit:String="100", sort:String="store_date:desc"):Single<ComicVineResults> = cvAPIService.getNewIssues(filter, apiKey, "json", sort, offset, limit)
}