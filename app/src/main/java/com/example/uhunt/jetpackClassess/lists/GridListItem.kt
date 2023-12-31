package com.example.uhunt.jetpackClassess.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.components.Material3Card
import com.example.uhunt.jetpackClassess.model.Item
import com.example.uhunt.jetpackClassess.utils.TestTags
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme

@Composable
fun GridListItem(
    item: Item,
    modifier: Modifier = Modifier
) {
    Material3Card(
        shape = androidx.compose.material.MaterialTheme.shapes.medium,
        modifier = modifier
            .width(190.dp)
            .height(220.dp)
            .padding(8.dp)
            .testTag("${TestTags.HOME_SCREEN_LIST_ITEM}-${item.id}")

    ) {
        Column(modifier = Modifier.clickable(onClick = { })) {
            Image(
                painter = painterResource(item.imageId),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = item.title,
//                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.subtitle,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = item.source,
//                    style = MaterialTheme.typography.titleSmall
                )

            }
        }
    }
}

@Preview
@Composable
fun PreviewGridListItem() {
    val item = DemoDataProvider.item
    UhuntTheme {
        GridListItem(item = item)
    }
}