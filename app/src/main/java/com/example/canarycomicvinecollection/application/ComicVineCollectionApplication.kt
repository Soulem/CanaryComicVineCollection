package com.example.canarycomicvinecollection.application
import androidx.multidex.MultiDexApplication
import com.example.canarycomicvinecollection.utl.ComponentCollection

class ComicVineCollectionApplication : MultiDexApplication() {
    override fun onCreate(){
        super.onCreate()
        //ComponentCollection.comicVineAPIComponent = DaggerComicVineAPIComponent.Create()
    }
}