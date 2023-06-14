package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uhunt.jetpackClassess.DemoDataProvider

@Composable
fun ScrollableListOfTabs() {
    val tweets = remember { DemoDataProvider.tweetList.filter { it.tweetImageId > 0 } }
    val selectedIndex = remember { mutableStateOf(0) }
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
    ScrollableTabRow(
        selectedTabIndex = selectedIndex.value,
        divider = {}, /* Disable the built-in divider */
        edgePadding = 0.dp,
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        tweets.forEachIndexed { index, tweet ->
            Tab(
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                }
            ) {
                CustomImageChip(
                    text = tweet.author,
//                        imageId = tweet.authorImageId,
                    selected = index == selectedIndex.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 1.dp, vertical = 10.dp)
                )
            }
        }
    }

//        PostItem(
//            post = tweets[selectedIndex.value],
//            isLiked = Random.nextBoolean(),
//            onLikeClicked = {},
//            onCommentsClicked = {},
//            onSendClicked = {}
//        )
//    }
}