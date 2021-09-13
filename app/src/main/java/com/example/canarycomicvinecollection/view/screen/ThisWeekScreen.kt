package com.example.canarycomicvinecollection.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.example.canarycomicvinecollection.model.data.comicvineaapi.issues.Issues

@Composable
fun thisWeekScreen(issues: List<Issues>){
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items = issues,
            itemContent = {
                thisWeekListItem(issue = it)
            }
        )
    }
}

@Composable
fun thisWeekListItem(issue : Issues) {
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            thisWeekListItemImage(issue)
            Column {

            }
        }
    }
}

@Composable
private fun thisWeekListItemImage(issue: Issues){
    Image(
        painter = rememberImagePainter(
            data = issue.image.original_url,
            builder = {
                transformations(RoundedCornersTransformation())
            }
        ),
        contentDescription = null,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}