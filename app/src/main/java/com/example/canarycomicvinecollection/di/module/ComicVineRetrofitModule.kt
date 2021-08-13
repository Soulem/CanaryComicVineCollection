package com.example.canarycomicvinecollection.di.module

import com.example.canarycomicvinecollection.network.ComicVineRetrofit
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ComicVineRetrofitModule(private val key : String) {
    @Singleton
    @Provides
    fun providesKey() : ComicVineRetrofit = ComicVineRetrofit(key)
}