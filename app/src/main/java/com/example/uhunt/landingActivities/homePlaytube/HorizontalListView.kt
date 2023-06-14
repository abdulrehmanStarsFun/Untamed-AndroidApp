package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.lists.HorizontalListItem

@Composable
fun HorizontalListView(textttt: String) {
    val list = remember { DemoDataProvider.itemList }
    val profiles = remember { DemoDataProvider.tweetList }


//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


    LazyRow(
        modifier = Modifier.padding(end = 10.dp)
    ) {
        items(
            items = list,
            itemContent = {
                HorizontalListItem(
                    it,
                    Modifier.padding(start = 5.dp, bottom = 1.dp)
                )
            })
    }
    ListItemDivider(10)
//        Text(
//            modifier = Modifier.padding(16.dp),
//            text = "Clips",
//            style = TextStyle(
//                fontSize = 15.sp,
//                color = Color.White,
//
//                ),
////            style = MaterialTheme.typography.labelMedium
//        )
//        StoryList(
//            profiles = profiles,
//            onProfileClicked = {}
//        )
//    }
}