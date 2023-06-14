package com.example.uhunt.jetpackClassess.lists

import android.content.Intent
import android.provider.SyncStateContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.example.uhunt.SharedPref.Utilities

import com.example.uhunt.jet.VideoProfileScreen
import com.example.uhunt.jet.video_profile
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.components.Material3Card
import com.example.uhunt.jetpackClassess.model.Item
import com.example.uhunt.jetpackClassess.utils.TestTags
import com.example.uhunt.models.Featured
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ContinueVideoHorizListView(
    item: Featured,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Material3Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .wrapContentHeight().wrapContentWidth()
            .padding(horizontal = 3.dp)
            .testTag("${TestTags.HOME_SCREEN_LIST_ITEM}-${item.id}"),
        elevation = 6.dp,
    ) {
        Column(modifier = Modifier
            .wrapContentHeight().wrapContentWidth()
            .background(
                color = Color(android.graphics.Color.parseColor("#505050")),
            )
            .clickable(onClick = {
//                val intent = Intent(context, video_profile::class.java)
//                context.startActivity(intent)
                val intent = Intent(context, VideoProfileScreen::class.java)
                Utilities.saveString(context,"videoId",item.video_id)
                Utilities.saveString(context,"videoUrl",item.hls_url)
                context.startActivity(intent)
            })
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.home_demo2),
//                contentScale = ContentScale.Fit,
//                contentDescription = null,
//                modifier = Modifier
//                    .size(170.dp, 90.dp)
//            )
            MovieImageBanner(imagePath = item.thumbnail)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#505050")),
                    )
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                        .padding(top = 7.dp),

                    text =  item.title,
                    style = TextStyle(
                        fontSize = 11.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold

                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                        .padding(horizontal = 10.dp),
                    text = item.description,
                    style = TextStyle(
                        fontSize = 10.sp,
                        color = Color.White,

                        ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.bodyMedium
                )

            }
        }
    }
}

@Composable
fun MovieImageBanner(imagePath: String) {

    Image(
        modifier = Modifier
            .width(170.dp)
            .height(90.dp), painter = rememberCoilPainter(
            request =imagePath
        ),
        contentDescription = "",
        contentScale = ContentScale.Crop
    )

}
@Preview
@Composable
fun ContinueVideoHorizListView() {
    val item = DemoDataProvider.item
    UhuntTheme {
        HorizontalListItem(item = item)
    }
}