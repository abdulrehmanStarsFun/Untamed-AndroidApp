package com.example.uhunt.jetpackClassess.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.model.Item
import com.example.uhunt.jetpackClassess.utils.TestTags
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme

@Composable
fun VerticalListItem(item: Item, modifier: Modifier = Modifier) {
    val typography = MaterialTheme.typography
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .testTag("${TestTags.HOME_SCREEN_LIST_ITEM}-${item.id}")
    ) {

        val imageModifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .clip(shape = androidx.compose.material.MaterialTheme.shapes.medium)

        Image(
            painter = painterResource(item.imageId),
            modifier = imageModifier,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = item.title,
//            style = typography.titleLarge
        )
        Text(
            text = item.subtitle,
//            style = typography.bodyMedium
        )

        Text(
            text = item.source,
//            style = typography.titleSmall
        )
    }
}

@Preview
@Composable
fun PreviewVerticalListItem() {
    val item = DemoDataProvider.item
    UhuntTheme() {
        VerticalListItem(item = item)
    }
}