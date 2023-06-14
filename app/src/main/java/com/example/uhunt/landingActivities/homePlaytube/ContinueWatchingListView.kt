package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.lists.ContinueVideoHorizListView
import com.example.uhunt.models.Featured

@Composable
fun ContinueWatchingListView(videoItems:Featured) {
    val list = remember { DemoDataProvider.itemList }


    val profiles = remember { DemoDataProvider.tweetList }
    LazyRow(
        modifier = Modifier.padding(end = 10.dp)
    ) {
        items(
            items = list,
            itemContent = {
                ContinueVideoHorizListView(
                    videoItems,
                    Modifier.padding(start = 5.dp, bottom = 1.dp).size(170.dp)
                )
            })
    }
    ListItemDivider(10)
}