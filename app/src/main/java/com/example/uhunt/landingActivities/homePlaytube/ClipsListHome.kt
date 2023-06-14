package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.RowItems.ClipRowItems
import com.example.uhunt.jetpackClassess.RowItems.ClipRowItemsProfile


@Composable
fun ClipsListHome() {
    val list = remember { DemoDataProvider.itemList }
    val profiles = remember { DemoDataProvider.tweetList }
    Column() {

        LazyRow(
            modifier = Modifier.padding(end = 10.dp)
        ) {
            items(
                items = list,
                itemContent = {
                    ClipRowItemsProfile(
                        it,
                        Modifier.padding(start = 5.dp, bottom = 1.dp)
                    )
                })
        }
        ListItemDivider(10)

    }
}