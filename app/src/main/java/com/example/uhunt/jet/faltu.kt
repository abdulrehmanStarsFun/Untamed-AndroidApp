import android.content.Intent
import android.graphics.Color
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.Clist
import com.example.uhunt.R
import com.example.uhunt.jet.VideoProfileScreen
import com.example.uhunt.jet.massenger
import com.example.uhunt.jet.user_profile
import com.example.uhunt.jet.video_profile
import com.example.uhunt.jetpackClassess.components.Material3Card
import com.example.uhunt.jetpackClassess.model.Item
import com.example.uhunt.jetpackClassess.utils.TestTags
import com.example.uhunt.landingActivities.homePlaytube.ListItemDivider

@Composable
fun vpl(

) {

    lateinit var courselist: List<Clist>
    courselist = ArrayList<Clist>()
    courselist = (courselist + Clist("1.5k", R.drawable.home_demo2)) as ArrayList<Clist>
    courselist = (courselist + Clist("Share", R.drawable.home_demo2)) as ArrayList<Clist>
    courselist =
        (courselist + Clist("Download", R.drawable.home_demo2)) as ArrayList<Clist>
    courselist = (courselist + Clist("Save", R.drawable.home_demo2)) as ArrayList<Clist>
    courselist =
        (courselist + Clist("Trailer", R.drawable.home_demo2)) as ArrayList<Clist>
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
                    context.startActivity(intent)

                })
        ) {
            courselist.forEach { courselist ->
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()


            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_ic),
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp, 35.dp)
                        .align(Alignment.CenterVertically).clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                val intent=Intent(context, user_profile::class.java)
                                context.startActivity(intent)
                            }
                        ),

                    )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp)

                ) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                        ,

                        text = "Big Boars Caught in Australia",
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
                        text = "Bradley Owens",
                        style = TextStyle(
                            fontSize = 12.sp,

                            ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.bodyMedium
                    )

                }

            }

            Image(
                painter = painterResource(id = courselist.languageimage),
                contentScale = ContentScale.Fit,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )

            ListItemDivider(10)

        }
    }
}
}
