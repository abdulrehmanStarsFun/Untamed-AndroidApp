package com.example.uhunt.jetpackClassess.RowItems

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.R
import com.example.uhunt.SharedPref.Utilities

import com.example.uhunt.jet.VideoProfileScreen
import com.example.uhunt.jet.user_profile
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.components.Material3Card
import com.example.uhunt.jetpackClassess.model.Item
import com.example.uhunt.jetpackClassess.utils.TestTags
import com.example.uhunt.landingActivities.homePlaytube.ListItemDivider
import com.example.uhunt.landingActivities.homePlaytube.SetTextStyling
import com.example.uhunt.models.Featured
import com.example.uhunt.models.ShortsVideoModel
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun HomeBottomListItems(
    item: Featured,
    modifier: Modifier = Modifier
) {

    val context= LocalContext.current
    Material3Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.wrapContentHeight()
            .padding(horizontal = 3.dp), elevation = 6.dp,
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .background(
                    color = MaterialTheme.colors.background,
                )
                .clickable(onClick = {
                    val intent= Intent(context, VideoProfileScreen::class.java)
                    Utilities.saveString(context,"videoId",item.video_id)
                    Utilities.saveString(context,"videoUrl",item.hls_url)
                    context.startActivity(intent)

                })
        ) {

                Row(
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()


                ) {

                    Image(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                            .clip(CircleShape)
                            .clickable {
                                val intent = Intent(context, user_profile::class.java)
                                context.startActivity(intent)
                                       },
                        painter = rememberCoilPainter(
                            request = item.thumbnail
                        ),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 0.dp)

                    ) {
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth(),

                            text =item.title,
                            style = TextStyle(
                                fontSize = 14.sp,
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
                            text =item.description,
                            style = TextStyle(
                                fontSize = 12.sp,

                                ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.bodyMedium
                        )

                    }

                }

//                Image(
//                    painter = painterResource(id = item.thumbnail),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                )
            MovieImageBanner1(item.org_thumbnail,200,170)

            Row(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                Text(
                    "SUBSCRIBE",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        color = Color.White,
                    ), modifier = Modifier
                        .background(
                            color = Color.Red,
                            shape = RoundedCornerShape(10.dp)
                        )
                     .weight(0.8f).padding(start = 4.dp)


                )
                Spacer(modifier = Modifier.width(10.dp))
                Row(
                    modifier = Modifier.weight(0.7f)


                ) {
                    Image(
                        painter = painterResource(id = R.drawable.like_ic),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = androidx.compose.material.MaterialTheme.colors.onBackground)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = " 1,568",
                        style = TextStyle(
                            fontSize = 10.sp,
//                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.roboto_regular))
                        )
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Row(
                    modifier = Modifier
                        .weight(0.5f)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.comment),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = androidx.compose.material.MaterialTheme.colors.onBackground)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = " 845",
                        style = TextStyle(
                            fontSize = 10.sp,
//                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.roboto_regular))
                        ),modifier=Modifier.padding(bottom = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Row(
                    modifier = Modifier
                        .weight(0.7f)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.share_ic),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = androidx.compose.material.MaterialTheme.colors.onBackground)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = " 987",
                        style = TextStyle(
                            fontSize = 10.sp,
//                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.roboto_regular))
                        ),modifier=Modifier.padding(bottom = 2.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .weight(1.4f)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = androidx.compose.material.MaterialTheme.colors.onBackground)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = " 4,058",
                        style = TextStyle(
                            fontSize = 10.sp,
//                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.roboto_regular))
                        )
                    )
                }

            }

                ListItemDivider(10)


        }
    }
}
@Composable
fun MovieImageBanner1(imagePath: String, width: Int, height: Int) {
    Image(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp)).height(height.dp),
        painter = rememberCoilPainter(
            request = imagePath
        ),
        contentDescription = "",
        contentScale = ContentScale.Crop// Adjust this according to your needs
    )
}


@Preview
@Composable
fun PreviewHorizontalListItem3() {
    val item = DemoDataProvider.item
    UhuntTheme {
//        HomeBottomListItems(item = item)
    }
}