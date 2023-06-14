package com.example.uhunt.jetpackClassess.RowItems

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.R
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.components.Material3Card
import com.example.uhunt.jetpackClassess.model.Item
import com.example.uhunt.jetpackClassess.utils.TestTags
import com.example.uhunt.landingActivities.homePlaytube.SetTextStyling
import com.example.uhunt.landingActivities.tikTok.TiktokActivity
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme

@Composable
fun ClipRowItemsProfile(
    item: Item,
    modifier: Modifier = Modifier
) {

    Material3Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(horizontal = 3.dp)
            .wrapContentHeight()

            .testTag("${TestTags.HOME_SCREEN_LIST_ITEM}-${item.id}"),
        elevation = 6.dp,
    ) {
        val context = LocalContext.current
        Box(modifier = Modifier
            .height(150.dp)
            .wrapContentHeight()

            .background(MaterialTheme.colors.background)
            .clickable(onClick = {
                val intent = Intent(context, TiktokActivity::class.java)
                context.startActivity(intent)
            })
        ) {

            val image = painterResource(id = R.drawable.demo_home3)
            Image(painter = image, contentDescription = null)
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()

                    .align(Alignment.BottomStart),


                ) {
                Image(
                    painter = painterResource(id = R.drawable.ed2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp, 25.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(30.dp))

                )
                Text(
                    text = "Laura Quinn",
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 9.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                )

            }

        }
    }
}

@Preview
@Composable
fun PreviewHorizontalListItem() {
    val item = DemoDataProvider.item
    UhuntTheme {
        ClipRowItemsProfile(item = item)
    }
}