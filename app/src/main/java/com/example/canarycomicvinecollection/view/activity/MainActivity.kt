package com.example.canarycomicvinecollection.view.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.canarycomicvinecollection.model.data.comicvineaapi.issues.Issues
import com.example.canarycomicvinecollection.ui.theme.CanaryComicVineCollectionTheme
import com.example.canarycomicvinecollection.viewmodel.ObjectViewModel
import io.reactivex.disposables.CompositeDisposable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.canarycomicvinecollection.view.screen.thisWeekScreen

class MainActivity : AppCompatActivity() {
    private val compDisposable = CompositeDisposable()
    private val objectViewModel = ObjectViewModel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        objectViewModel.searchIssues("store_date:2021-09-08|2021-09-15",);


        setContent {
            CanaryComicVineCollectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    displayNewReleases(objectViewModel)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compDisposable.clear()
    }
}
@Composable
fun setNavigation(){
    val navController = rememberNavController();
    NavHost(navController, "this_week"){
        composable("this_week"){ displayNewReleases(ObjectViewModel.getInstance()) }
    }
}

@Composable
fun greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun defaultPreview() {
    CanaryComicVineCollectionTheme {
        displayNewReleases(ObjectViewModel.getInstance())
    }
}

@Composable
fun displayNewReleases(objectViewModel: ObjectViewModel){
    val issues: List<Issues> by objectViewModel.comicVineIssues.observeAsState(listOf())
    thisWeekScreen(issues)
}