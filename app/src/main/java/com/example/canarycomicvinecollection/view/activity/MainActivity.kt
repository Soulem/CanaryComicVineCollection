package com.example.canarycomicvinecollection.view.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.canarycomicvinecollection.network.ComicVineRetrofit
import com.example.canarycomicvinecollection.ui.theme.CanaryComicVineCollectionTheme
import com.example.canarycomicvinecollection.utl.api_key_delete.Companion.KEY
import io.reactivex.schedulers.Schedulers
import io.reactivex.disposables.CompositeDisposable

class MainActivity : ComponentActivity() {
    private val compDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanaryComicVineCollectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Alexis")
                }
            }
        }

        val comicVineRetrofit = ComicVineRetrofit(KEY)
        compDisposable.add(
            comicVineRetrofit.getNewIssues("store_date:2021-07-21|2021-07-28")
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map{
                    it
                }
                .subscribe({
                    Log.d("TAG_X", "results: ${it}" )

                }, {throwable ->
                    Log.d("TAG_X", "Oops: ${throwable.localizedMessage}")

                })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        compDisposable.clear()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CanaryComicVineCollectionTheme {
        Greeting("Android")
    }
}