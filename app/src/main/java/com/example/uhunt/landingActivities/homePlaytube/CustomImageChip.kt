package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomImageChip(
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
