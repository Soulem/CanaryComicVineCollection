package com.example.canarycomicvinecollection.di.component

import com.example.canarycomicvinecollection.di.module.ComicVineRetrofitModule
import com.example.canarycomicvinecollection.model.db.ComicVineRepository
import com.example.canarycomicvinecollection.utl.api_key_delete
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [ComicVineRetrofitModule::class])
interface ComicVineAPIComponent {
    fun getComponentRepository(apiKey : String = api_key_delete.KEY): ComicVineRepository
}