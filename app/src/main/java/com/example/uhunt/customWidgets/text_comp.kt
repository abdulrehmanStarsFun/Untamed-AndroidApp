package com.example.uhunt.jet

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun myText(text:String,
           textColor: androidx.compose.ui.graphics.Color,
           backgroundColor: androidx.compose.ui.graphics.Color,
           h: Dp,
           w: Dp,
           roundedradius: Dp,
           modifier: Modifier,
           maxline:Int,

) {

    Text(
        text=text,
        color = textColor,
        modifier=Modifier.width(w).height(h), maxLines = maxline,
        )
}

