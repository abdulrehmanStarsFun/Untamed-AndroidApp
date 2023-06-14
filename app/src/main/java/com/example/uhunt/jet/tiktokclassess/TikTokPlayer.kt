package com.example.uhunt.jet.tiktokclassess
import android.content.Context
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

@Composable
fun TikTokPlayer(context: Context, url: String, selected: Boolean) {
    val tiktokPlayer = remember {
        SimpleExoPlayer.Builder(context)
            .build()
            .apply {
                val userAgent = Util.getUserAgent(context, "YourApplicationName")
                val mediaSource = HlsMediaSource.Factory(DefaultDataSourceFactory(context, userAgent))
                    .createMediaSource(MediaItem.fromUri(Uri.parse(url)))

                this.setMediaSource(mediaSource)
                this.prepare()
            }
    }
    tiktokPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
    tiktokPlayer.repeatMode = Player.REPEAT_MODE_ONE
    AndroidView(
        factory = { context ->
            PlayerView(context).apply {
                useController = false
                player = tiktokPlayer
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            }
        },
        update = { view ->
            view.player = tiktokPlayer
        }
    )

    tiktokPlayer.playWhenReady = selected

    DisposableEffect(key1 = url) {
        onDispose {
            tiktokPlayer.release()
        }
    }
}
