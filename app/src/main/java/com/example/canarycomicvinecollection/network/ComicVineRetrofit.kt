package com.example.canarycomicvinecollection.network

import com.example.canarycomicvinecollection.model.comicvineaapi.issue.ComicVineIssueResults
import com.example.canarycomicvinecollection.model.comicvineaapi.issues.ComicVineIssuesResults
import com.example.canarycomicvinecollection.model.comicvineaapi.volume.ComicVineVolumeResults
import com.example.canarycomicvinecollection.model.comicvineaapi.volumes.ComicVineVolumesResults
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_FILTER
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_FORMAT
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_KEY
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_LIMIT
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_OFFSET
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_API_SORT
import com.example.canarycomicvinecollection.utl.Constants.Companion.COMIC_VINE_BASE_URL
import com.example.canarycomicvinecollection.utl.Constants.Companion.ISSUES_END_POINT
import com.example.canarycomicvinecollection.utl.Constants.Companion.VOLUMES_END_POINT
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class ComicVineRetrofit () {
    interface ComicVineAPIService{
        @GET(ISSUES_END_POINT)
        fun getNewIssues(@Query(COMIC_VINE_API_FILTER) filter : String,
                         @Query(COMIC_VINE_API_KEY) apikey : String,
                         @Query(COMIC_VINE_API_FORMAT) format : String,
                         @Query(COMIC_VINE_API_SORT) sort : String,
                         @Query(COMIC_VINE_API_OFFSET) offset : String,
                         @Query(COMIC_VINE_API_LIMIT) limit : String) : Single<ComicVineIssuesResults>
        @GET("{endPoint}")
        fun getNewIssue(@Path("endPoint") endPoint : String,
                         @Query(COMIC_VINE_API_FILTER) filter : String,
                         @Query(COMIC_VINE_API_KEY) apikey : String,
                         @Query(COMIC_VINE_API_FORMAT) format : String,
                         @Query(COMIC_VINE_API_SORT) sort : String,
                         @Query(COMIC_VINE_API_OFFSET) offset : String,
                         @Query(COMIC_VINE_API_LIMIT) limit : String) : Single<ComicVineIssueResults>
        @GET(VOLUMES_END_POINT)
        fun getNewVolumes(@Query(COMIC_VINE_API_FILTER) filter : String,
                         @Query(COMIC_VINE_API_KEY) apikey : String,
                         @Query(COMIC_VINE_API_FORMAT) format : String,
                         @Query(COMIC_VINE_API_SORT) sort : String,
                         @Query(COMIC_VINE_API_OFFSET) offset : String,
                         @Query(COMIC_VINE_API_LIMIT) limit : String) : Single<ComicVineVolumesResults>
        @GET("{endPoint}")
        fun getNewVolume(@Path("endPoint") endPoint : String,
                         @Query(COMIC_VINE_API_FILTER) filter : String,
                         @Query(COMIC_VINE_API_KEY) apikey : String,
                         @Query(COMIC_VINE_API_FORMAT) format : String,
                         @Query(COMIC_VINE_API_SORT) sort : String,
                         @Query(COMIC_VINE_API_OFFSET) offset : String,
                         @Query(COMIC_VINE_API_LIMIT) limit : String) : Single<ComicVineVolumeResults>
    }

    companion object {
        private lateinit var instance : ComicVineRetrofit

        fun getInstance() : ComicVineRetrofit {
            if (!this::instance.isInitialized){
                instance = ComicVineRetrofit()
            }

            return instance
        }
    }

    private val cvAPIService: ComicVineAPIService = Retrofit.Builder()
        .baseUrl(COMIC_VINE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ComicVineAPIService::class.java)

    fun getNewIssues(filter: String, apiKey: String, offset:String="0", limit:String="100", sort:String="store_date:desc"):Single<ComicVineIssuesResults> = cvAPIService.getNewIssues(filter, apiKey, "json", sort, offset, limit)
    fun getNewIssue(endPoint:String, filter: String, apiKey: String, offset:String="0", limit:String="100", sort:String="store_date:desc"):Single<ComicVineIssueResults> = cvAPIService.getNewIssue(endPoint, filter, apiKey, "json", sort, offset, limit)
    fun getNewVolumes(filter: String, apiKey: String, offset:String="0", limit:String="100", sort:String="store_date:desc"):Single<ComicVineVolumesResults> = cvAPIService.getNewVolumes(filter, apiKey, "json", sort, offset, limit)
    fun getNewVolume(endPoint:String, apiKey: String, filter: String, offset:String="0", limit:String="100", sort:String="store_date:desc"):Single<ComicVineVolumeResults> = cvAPIService.getNewVolume(endPoint, filter, apiKey, "json", sort, offset, limit)

}