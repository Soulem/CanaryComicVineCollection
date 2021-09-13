package com.example.canarycomicvinecollection.viewmodel

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
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

    private val comicVineIssuesMutable = MutableLiveData<List<Issues>>()
    private val comicVineIssueMutable = MutableLiveData<List<Issue>>()
    private val comicVineVolumesMutable = MutableLiveData<List<Volumes>>()
    private val comicVineVolumeMutable = MutableLiveData<List<Volume>>()

    val comicVineIssues : LiveData<List<Issues>> = comicVineIssuesMutable
    val comicVineIssue : LiveData<List<Issue>> = comicVineIssueMutable
    val comicVineVolumes : LiveData<List<Volumes>> = comicVineVolumesMutable
    val comicVineVolume : LiveData<List<Volume>> = comicVineVolumeMutable

    val comicVineRetrofit = ComicVineRetrofit()

    private val compDisposable = CompositeDisposable()

    fun onIssuesListChange(newIssues: List<Issues>){
        comicVineIssuesMutable.value = newIssues
    }

    fun onIssueListChange(newIssue: List<Issue>){
        comicVineIssueMutable.value = newIssue
    }

    fun onVolumesListChange(newVolumes: List<Volumes>){
        comicVineVolumesMutable.value = newVolumes
    }

    fun onVolumeListChange(newVolume: List<Volume>){
        comicVineVolumeMutable.value = newVolume
    }

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
                    //comicVineIssues.postValue(@Suppress("UNCHECKED_CAST") it.results as List<Issues>)
                    comicVineIssuesMutable.postValue(it.results)
                    Log.d("TAG_X", "results: ${comicVineIssues}" )
                    Log.d("TAG_X", "Mutable results: ${comicVineIssues}" )

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

