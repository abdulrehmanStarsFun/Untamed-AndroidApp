package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.RowItems.ClipRowItems
import com.example.uhunt.jetpackClassess.lists.VideoPlayListItem


@Composable
fun VideoPlayListHome() {
    val list = remember { DemoDataProvider.itemList }
    val profiles = remember { DemoDataProvider.tweetList }
    Column() {
        LazyColumn(
            modifier = Modifier.padding(end = 10.dp)
        ) {
            items(
                items = list,
                itemContent = {
                    VideoPlayListItem(
                        it,
                        Modifier.padding(start = 5.dp, bottom = 1.dp)
                    )
                })
        }

//        LazyColumn(
//            modifier = Modifier.padding(end = 10.dp)
//        ) {
//            items(
//                items = list,
//                itemContent = {
//                    VideoPlayListItem(
//                        it,
//                        Modifier.padding(start = 5.dp, bottom = 1.dp)
//                    )
//                })
//        }
        ListItemDivider(10)

    }
}