package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


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
