package com.example.uhunt.landingActivities.tvActivities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import com.example.uhunt.R
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.RowItems.ClipRowItems
import com.example.uhunt.jetpackClassess.RowItems.ClipRowItemsProfile
import com.example.uhunt.jetpackClassess.dialogs.DialogState
import com.example.uhunt.jetpackClassess.dialogs.DialogType
import com.example.uhunt.jetpackClassess.lists.HorizontalListItem
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker

class TvActviity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                Surface(
                    modifier = Modifier.background(Color(0xFF000000))
                )
                {
                    ImageClickableActivity(onBackPressedDispatcher)
                    logscreen()
                }
            }
        }
    }
}


@Composable
fun logscreen(

) {
    var dialogState by remember { mutableStateOf(DialogState(false, DialogType.SIMPLE)) }

    if (dialogState.showDialog) {
        //if state of show dialog changes to true it shows dialog passing state as false for dismiss
        ShowDialog(dialogState.dialogType) { dialogState = dialogState.copy(showDialog = false) }
    }
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
    ) {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 10.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically


            ) {
                SetTextStyling(
                    "Uhunt",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.helpchat),
                    contentDescription = null,
                    modifier = Modifier.size(21.dp, 17.dp)

                )
            }
            ScrollableListOfTabs()
            val username = remember { mutableStateOf(TextFieldValue()) }
            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxSize(),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .align(Alignment.BottomCenter),
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
//            horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        BottomNavigationWithLabelComponent()

                    }

                }
            }

        }

    }


}

@Composable
fun ShowDialog(type: DialogType, onDismiss: () -> Unit) {
    val item = remember { DemoDataProvider.item }
    var dialogState by remember { mutableStateOf(DialogState(false, DialogType.SIMPLE)) }

    if (dialogState.showDialog) {
        //if state of show dialog changes to true it shows dialog passing state as false for dismiss
        ShowDialog(dialogState.dialogType) { dialogState = dialogState.copy(showDialog = false) }
    }
    when (type) {
        DialogType.SIMPLE ->
            AlertDialog(
                text = {
                    Text(item.subtitle)
                },
                confirmButton = {
                    TextButton(
                        onClick = onDismiss,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Ok")
                    }
                },
                onDismissRequest = onDismiss
            )
        DialogType.TITLE ->
            AlertDialog(
                title = { Text(text = item.title, style = typography.h6) },
                text = {
                    Text(item.subtitle)
                },
                confirmButton = {
                    Row(modifier = Modifier) {
                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Text(text = "Cancel", color = Color.Gray)
                        }
                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Text(text = "Ok")
                        }
                    }
                },
                onDismissRequest = onDismiss
            )
        DialogType.VERTICALBUTTON ->
            AlertDialog(
                title = { Text(text = item.title, style = typography.h6) },
                text = {
                    Text(item.subtitle)
                },
                confirmButton = {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = onDismiss,
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                    ) {
                        Text(text = "Ok")
                    }
                },
                onDismissRequest = onDismiss
            )
        DialogType.IMAGE ->
            AlertDialog(
                title = { Text(text = item.title, style = typography.h6) },
                text = {
                    Text(item.subtitle, modifier = Modifier.padding(bottom = 8.dp))
                    Image(
                        painter = painterResource(DemoDataProvider.item.imageId),
                        contentDescription = null
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = onDismiss,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Ok")
                    }
                },
                onDismissRequest = onDismiss
            )
        DialogType.LONGDIALOG ->
            AlertDialog(
                title = { Text(text = "", style = typography.h6) },
                text = {
                    Column(
                        modifier = Modifier
                            .wrapContentHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("", modifier = Modifier.padding(bottom = 0.dp))
                        Image(
                            painter = painterResource(id = R.drawable.conratulation_ic),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
//                                .padding(top = 10.dp)
                        )
                        Text(
                            text = "Congratulations! ",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.Black, fontFamily = FontFamily.Serif,
                            ),
                            modifier = Modifier
                                .wrapContentHeight()
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center


                        )
                        Text(
                            text = "Your account is ready to use. You will be redirected to the Home page in a few seconds..",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.Gray, fontFamily = FontFamily.Serif
                            ),
                            modifier = Modifier
                                .wrapContentHeight()
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center


                        )
//                        Spacer(modifier = Modifier.height(10.dp))

                        Image(
                            painter = painterResource(id = R.drawable.progress_dialog),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
                                .padding(top = 10.dp)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
//                        Button(
//
//                            modifier = Modifier
////                                .padding(10.dp)
//                                .fillMaxWidth()
//                                .height(45.dp)
//                                .padding(horizontal = 25.dp)
//                                .align(alignment = Alignment.CenterHorizontally),
//
//
//                            onClick = {
//                                dialogState = dialogState.copy(showDialog = false)
//                            },
//                            colors = ButtonDefaults.buttonColors(
//                                backgroundColor = Color.Black,
//                                contentColor = Color.White
//                            ),
//                            shape = RoundedCornerShape(20.dp),
//
//                            ) {
//                            Text(
//                                text = "OK",
//                                fontSize = 16.sp,
//                                fontWeight = FontWeight.Bold,
//                                fontFamily = FontFamily.Serif
//                            )
//                        }

                    }
                },

                confirmButton = {
//                    TextButton(
//                        onClick = onDismiss,
//                        modifier = Modifier.padding(8.dp)
//                    ) {
//                        Text(text = "Ok")
//                    }
                },
                onDismissRequest = onDismiss,
                shape = RoundedCornerShape(25.dp)
            )
        DialogType.ROUNDED ->
            AlertDialog(
                title = { Text(text = item.title, style = typography.h6) },
                text = {
                    Column {
                        Text(item.subtitle, modifier = Modifier.padding(bottom = 8.dp))
                        Image(
                            painter = painterResource(DemoDataProvider.item.imageId),
                            contentDescription = null,
                            modifier = Modifier.clip(RoundedCornerShape(16.dp))
                        )
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = onDismiss,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Ok")
                    }
                },
                onDismissRequest = onDismiss,
                shape = RoundedCornerShape(16.dp)
            )
        DialogType.DATEPICKER -> {
            val context = LocalContext.current
            (context as? FragmentActivity)?.supportFragmentManager?.let { manager ->

                val builder = MaterialDatePicker.Builder.datePicker()
                    .build()

                builder.addOnPositiveButtonClickListener { selectedDate ->

                }
                builder.addOnDismissListener {
                    onDismiss()
                }
                builder.show(manager, "DatePicker")
            }
        }

        DialogType.TIMEPICKER -> {
            val context = LocalContext.current
            (context as? FragmentActivity)?.supportFragmentManager?.let { manager ->
                val builder = MaterialTimePicker.Builder()
                    .build()
                builder.addOnPositiveButtonClickListener {

                }
                builder.addOnDismissListener {
                    onDismiss.invoke()
                }
                builder.show(manager, "TimePicker")
            }
        }

    }

}

private val noIndicator: @Composable (List<TabPosition>) -> Unit = {}
@Composable
fun MyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = myAppColors,
        typography = myAppTypography,
        content = content
    )
}

private val myAppColors = lightColors(
    primary = Color.Gray, // Change this to your desired primary color
    secondary = Color.Green // Change this to your desired secondary color
)

private val myAppTypography = Typography()
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {



    MyTheme {
        logscreen()
    }
}

@Composable
fun SetTextStyling(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    // style is used to put some styling to Compose UI elements. Here Default TextStyle is used.
    // overflow is used when the content of the Text crosses the limit. For example, if the maximum
    // allowed lines is one and the total number of lines is two then after 1st line, ellipsis(...)
    // will be shown
    Text(
        text = displayText,
        modifier = Modifier.padding(5.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )

    // There are many other styling that can be done on text. For example, textAlign, lineHeight,
    // letterSpacing, textDecoration, color, background, fontFamily, fontSize, fontStyle, fontWeight, etc
}

@Composable
fun ImageClickableActivity(backDispatcher: OnBackPressedDispatcher) {

    Image(
        painter = painterResource(id = R.drawable.logo_ic),
        contentDescription = "Back Button",
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = { backDispatcher.onBackPressed() }),
        contentScale = ContentScale.Crop,
    )
}


@Composable
fun BottomNavigationWithLabelComponent() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Shop", "TV", "Menu")
    // BottomNavigation is a Composable that is used to give easy access to some items
    // and are placed at the bottom of the screen so that the user can easily navigate
    // by clicking the items of the BottomNavigation
    BottomNavigation(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(),
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
//        items.forEachIndexed { index, item ->
        // BottomNavigationItem is used to add items to a BottomNavigation and since the
        // BottomNavigation is having a RowScope, so the BottomNavigationItems will be
        // placed horizontally.
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null
                )


            }, label = { Text("Home") },
            selected = false,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.shop_menu),
                    contentDescription = null
                )


            }, label = { Text("Shop") },
            selected = false,
            onClick = { /*TODO*/ }
        )

        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.television_black),
                    contentDescription = null
                )


            }, label = { Text("TV") },
            selected = false,
            onClick = {

            })
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.menu_bottom),
                    contentDescription = null
                )


            }, label = { Text("Menu") },
            selected = false,
            onClick = {})

//        }
    }
}

//Inspired from jetcaster sample. I hope compose can add simple Chip UI element that can
// support images or icons with multiple states.
@Composable
private fun CustomImageChip(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        color = when {
            selected -> MaterialTheme.colors.primary
            else -> Color.Transparent
        },
        contentColor = when {
            selected -> MaterialTheme.colors.onPrimary
            else -> Color.LightGray
        },
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = when {
                selected -> MaterialTheme.colors.primary
                else -> Color.LightGray
            }
        ),
        modifier = modifier
    ) {
        Row(modifier = Modifier) {
//            Image(
////                painter = painterResource(imageId),
//                contentDescription = null,
//                modifier = Modifier
//                    .padding(8.dp)
//                    .size(20.dp)
//                    .clip(CircleShape)
//            )
            Text(
                text = text,
//                style = TypographyTokens.LabelMedium,
                modifier = Modifier.padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 15.dp)
            )
        }
    }
}

@Composable
fun ScrollableListOfTabs() {
    val tweets = remember { DemoDataProvider.tweetList.filter { it.tweetImageId > 0 } }
    val selectedIndex = remember { mutableStateOf(0) }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ScrollableTabRow(
            selectedTabIndex = selectedIndex.value,
            divider = {}, /* Disable the built-in divider */
            edgePadding = 0.dp,
            indicator = noIndicator,
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
    }
    HorizontalListView("Continue Watching")

    HorizontalListView1("Clips")
    Image(
        painter = painterResource(id = R.drawable.home_demo2),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 3.dp)
            .height(130.dp)

    )
}

@Composable
fun HorizontalListView(textttt: String) {
    val list = remember { DemoDataProvider.itemList }
    val profiles = remember { DemoDataProvider.tweetList }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically


        ) {
            Image(
                painter = painterResource(id = R.drawable.video_play_ic),
                contentDescription = null,
                modifier = Modifier.size(21.dp, 17.dp)

            )
            SetTextStyling(
                textttt,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )

        }

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
        ListItemDivider()
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
    }
}

@Composable
fun HorizontalListView1(textttt: String) {
    val list = remember { DemoDataProvider.itemList }
    val profiles = remember { DemoDataProvider.tweetList }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically


        ) {
            Image(
                painter = painterResource(id = R.drawable.video_play_ic),
                contentDescription = null,
                modifier = Modifier.size(21.dp, 17.dp)

            )
            SetTextStyling(
                textttt,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )

        }

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
        ListItemDivider()
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
    }
}

@Composable
private fun ListItemDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}

