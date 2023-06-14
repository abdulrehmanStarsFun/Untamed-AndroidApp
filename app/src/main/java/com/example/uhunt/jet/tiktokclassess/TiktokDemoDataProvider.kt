package com.example.uhunt.jet.tiktokclassess

import androidx.compose.ui.graphics.Color
import com.example.uhunt.jet.TikTokScreen

object TiktokDemoDataProvider {
    val bottomBarList = listOf(
        TikTokScreen.Home,
        TikTokScreen.Discover,
        TikTokScreen.Create,
        TikTokScreen.Inbox,
        TikTokScreen.Me
    )

    val lanes =
        listOf(
            "OhHO ohNO",
            "FunFacts",
            "HappyDeepavli",
            "HalloweenIsHere",
            "BoomBoom",
            "No no no no"
        )

    val customGray = Color.LightGray.copy(alpha = 0.5f)

    val videos = listOf(" https://d12wboyscx16xj.cloudfront.net/df02a9de-b984-49c9-afc8-c650d3775662/hls/K8MyK4rNdHjQpLGqmJdw_03_42bb121d9fb4f5f3090d9f648ab5d7a1_video.m3u8", "t2.mp4", "t3.mp4")
}