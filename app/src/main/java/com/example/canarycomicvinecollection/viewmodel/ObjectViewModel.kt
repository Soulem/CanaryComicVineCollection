package com.example.canarycomicvinecollection.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.canarycomicvinecollection.model.data.comicvineaapi.issue.Issue
import com.example.canarycomicvinecollection.model.data.comicvineaapi.volume.Volume
import com.example.canarycomicvinecollection.model.data.comicvineaapi.issues.Issues
import com.example.canarycomicvinecollection.model.data.comicvineaapi.volumes.Volumes
import com.example.canarycomicvinecollection.network.ComicVineRetrofit
import com.example.canarycomicvinecollection.utl.api_key_delete
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ObjectViewModel : ViewModel() {
    companion object {
        private lateinit var instance : ObjectViewModel

        fun getInstance() : ObjectViewModel{
            if (!this::instance.isInitialized){
                instance = ObjectViewModel()
            }

            return instance
        }
    }

    val comicVineIssues = MutableLiveData<List<Issues>>()
    val comicVineIssue = MutableLiveData<List<Issue>>()
    val comicVineVolumes = MutableLiveData<List<Volumes>>()
    val comicVineVolume = MutableLiveData<List<Volume>>()

    private val comicVineIssuesMutable = MutableLiveData<MutableList<Issues>>()
    private val comicVineIssueMutable = MutableLiveData<MutableList<Issue>>()
    private val comicVineVolumesMutable = MutableLiveData<MutableList<Volumes>>()
    private val comicVineVolumeMutable = MutableLiveData<MutableList<Volume>>()

    val comicVineRetrofit = ComicVineRetrofit()

    private val compDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compDisposable.clear()
    }

    fun searchIssues(filter : String, offset:String="0", limit:String="100", sort:String="store_date:desc"){
        compDisposable.add(
            comicVineRetrofit.getNewIssues(filter, api_key_delete.KEY, offset, limit, sort)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map{
                    it
                }
                .subscribe({
                    comicVineIssues.postValue(@Suppress("UNCHECKED_CAST") it.results as List<Issues>)
                    comicVineIssuesMutable.postValue(@Suppress("UNCHECKED_CAST") it.results as MutableList<Issues>)
                    Log.d("TAG_X", "results: ${comicVineIssues}" )

                }, {throwable ->
                    Log.d("TAG_X", "Oops: ${throwable.localizedMessage}")

                })
        )
    }
    fun searchIssue(endPoint : String, filter : String){

    }
    fun searchVolume(filter : String){

    }
    fun searchVolumes(endPoint : String, filter : String){

    }
}