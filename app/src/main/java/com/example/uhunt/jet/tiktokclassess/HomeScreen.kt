package com.example.uhunt.jet.tiktokclassess

import androidx.activity.viewModels
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter.State.Empty.painter
import com.example.uhunt.R
import com.example.uhunt.jet.tiktokclassess.carousalClassess.Pager
import com.example.uhunt.jet.tiktokclassess.carousalClassess.PagerState
import com.example.uhunt.jetpackClassess.DemoDataProvider.item
import com.example.uhunt.jetpackClassess.colorsThemes.tiktokRed
import com.example.uhunt.jetpackClassess.lists.ContinueVideoHorizListView
import com.example.uhunt.jetpackClassess.model.Album
import com.example.uhunt.jetpackClassess.model.AlbumsDataProvider
import com.example.uhunt.models.ShortsVideoModel
import com.example.uhunt.utils.Utilities
import com.example.uhunt.viewmodel.MainViewModel
import com.example.uhunt.viewmodel.ShortVdieoViewModel
import com.example.uhunt.viewmodel.VideoViewModel
import com.google.accompanist.coil.rememberCoilPainter


@Composable
fun HomeScreen(
    tiktokInteractionEvents: (TiktokHomeInteractionEvents) -> Unit,
    mainViewModel: ShortVdieoViewModel
) {
//    val movies = AlbumsDataProvider.albums
    val movies = mainViewModel.shortsVideoModel
    val context = LocalContext.current
    var intPost: Int = 0
    val videoPosition = Utilities.getInt(context, "videoPosition")
    if (mainViewModel.shortsVideoModel.isNotEmpty()) {
        val bottomBarHeight = 50.dp
        val pagerState: PagerState = run {
            remember {
                PagerState(0, 0, movies.size - 1)
            }
        }
        Pager(
            state = pagerState,
            orientation = Orientation.Vertical,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = bottomBarHeight)
        ) {
            intPost++
            val movie:ShortsVideoModel
            if (intPost == 1) {
                movie = movies[videoPosition]

            } else {
                 movie = movies[commingPage]
            }
            val isSelected = pagerState.currentPage == commingPage
            PagerItem(movie, isSelected, tiktokInteractionEvents)
        }
    }


}

@Composable
fun PagerItem(
    album: ShortsVideoModel,
    selected: Boolean,
    tiktokInteractionEvents: (TiktokHomeInteractionEvents) -> Unit
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(4.dp))
    ) {
        val videoUrl = Utilities.getString(LocalContext.current, "videoUrl")
        TikTokPlayer(context, album.hls_url, selected)
//        TikTokPlayer(context, TiktokDemoDataProvider.videos[album.id % 3], selected)
        VideoOverLayUI(album, tiktokInteractionEvents)
    }
}

@Composable
fun VideoOverLayUI(
    album: ShortsVideoModel,
    tiktokInteractionEvents: (TiktokHomeInteractionEvents) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        VideoInfoSection(Modifier.weight(1f), album)
        VideoIconsSection(album, tiktokInteractionEvents)
    }
}

@Composable
fun VideoIconsSection(
    album: ShortsVideoModel,
    tiktokInteractionEvents: (TiktokHomeInteractionEvents) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ProfileImageWithFollow(
            modifier = Modifier
                .size(64.dp)
                .clickable(onClick = {
                    tiktokInteractionEvents(
                        TiktokHomeInteractionEvents.OpenProfile(album)
                    )
                }),
            true,
            album.thumbnail
        )
        Spacer(modifier = Modifier.height(20.dp))
        LikeIcon(album.id)
        Text(
            text = "256.4k",
            style = MaterialTheme.typography.body2.copy(fontSize = 12.sp),
            modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_comment_dots_solid),
            contentDescription = null

        )
        Text(
            text = "1223",
            style = MaterialTheme.typography.body2.copy(fontSize = 12.sp),
            modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
        )
        Icon(painter = painterResource(id = R.drawable.ic_share_solid), contentDescription = null)
        Text(
            text = "238",
            style = MaterialTheme.typography.body2.copy(fontSize = 12.sp),
            modifier = Modifier.padding(top = 4.dp, bottom = 32.dp)
        )
        val rotation = remember { Animatable(0f) }
        LaunchedEffect(Unit) {
            rotation.animateTo(
                targetValue = 360f,
                animationSpec = repeatable(
                    iterations = 10000,
                    animation = tween(durationMillis = 3500, easing = LinearEasing),
                ),
            )
        }
//        Image(
//            modifier = Modifier
//                .size(64.dp)
//                .clip(CircleShape), painter = rememberCoilPainter(
//                request = album.thumbnail
//            ),
//            contentDescription = ""
//        )
        Image(
            modifier = Modifier
                .padding(8.dp)
                .size(64.dp)
                .graphicsLayer(rotationZ = rotation.value)
                .clip(CircleShape),
            painter = rememberCoilPainter(
                request = album.thumbnail
            ),
            contentDescription = "",
            contentScale = ContentScale.Crop // Adjust this according to your needs
        )
//        ProfileImageWithFollow(
//            modifier = Modifier
//                .size(64.dp)
//                .graphicsLayer(rotationZ = rotation.value),
//            false,
//            album.imageId
//        )
    }
}

@Composable
fun LikeIcon(id: Int) {
    var fav by remember(id) { mutableStateOf(false) }
    val animatedProgress = remember { Animatable(0f) }
    if (!fav) {
        LaunchedEffect(fav) {
            animatedProgress.animateTo(
                targetValue = 1.3f,
                animationSpec = tween(600),
            )
        }
    }
    Icon(
        painter = painterResource(id = R.drawable.ic_heart_solid),
        contentDescription = null,
        modifier = Modifier
            .clickable(onClick = { fav = !fav })
            .graphicsLayer(scaleX = animatedProgress.value, scaleY = animatedProgress.value),
        tint = animateColorAsState(if (fav) tiktokRed else Color.White).value
    )
}

@Composable
fun VideoInfoSection(modifier: Modifier, album: ShortsVideoModel) {
    Column(modifier = modifier.padding(8.dp)) {
        FilterTag(text = album.title, modifier = Modifier)
        Text(
            text = "@${album.title}",
            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.ExtraBold),
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(text = album.title, style = MaterialTheme.typography.body2)
        Text(
            text = "#${album.title} #cool #tiktok #videos",
            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
fun FilterTag(text: String, modifier: Modifier) {
    val tagModifier = modifier
        .clickable(onClick = {})
        .clip(RoundedCornerShape(4.dp))
        .alpha(0.4f)
        .background(Color.Black)
        .padding(horizontal = 8.dp, vertical = 4.dp)

    Text(
        text = text,
        color = Color.White,
        modifier = tagModifier,
        style = typography.body2.copy(fontWeight = FontWeight.Bold)
    )
}

@Composable
fun ProfileImageWithFollow(modifier: Modifier, showFollow: Boolean, imageId: String) {
    if (showFollow) {
        Box(modifier = modifier) {
            ImageWithBorder(imageId, modifier = modifier)
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(tiktokRed)
                    .align(Alignment.BottomCenter)
            )
        }
    } else {
        ImageWithBorder(imageId, modifier = modifier)
    }
}

@Composable
fun ImageWithBorder(imagePath: String, modifier: Modifier) {
//    Image(
//        painter = painterResource(id = imageId),
//        contentDescription = null,
//        modifier = modifier
//            .padding(8.dp)
//            .clip(CircleShape)
//            .border(
//                shape = CircleShape,
//                border = BorderStroke(
//                    1.dp,
//                    color = Color.White
//                )
//            )
//    )
    Image(
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape)
            .border(
                shape = CircleShape,
                border = BorderStroke(
                    1.dp,
                    color = Color.White
                )
            ),
        painter = rememberCoilPainter(
            request = imagePath
        ),
        contentDescription = "",
        contentScale = ContentScale.Crop // Adjust this according to your needs
    )
}
