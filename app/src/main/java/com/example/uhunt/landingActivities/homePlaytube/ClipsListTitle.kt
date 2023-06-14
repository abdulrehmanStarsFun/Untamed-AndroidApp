package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.R
import com.example.uhunt.jetpackClassess.colorsThemes.purple
import com.example.uhunt.jetpackClassess.colorsThemes.purple200

@Composable
fun ClipsListRow() {
//    Text(text = "Buttons", style = typography.h5, modifier = Modifier.padding(8.dp))

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 10.dp),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically


        ) {
            Image(
                painter = painterResource(id = R.drawable.video_play_ic),
                contentDescription = null,
                modifier = Modifier.size(21.dp, 17.dp),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)


            )
            SetTextStyling(
                "Clips",
                style = TextStyle(
                    fontSize = 16.sp
                )
            )

        }
    }
}