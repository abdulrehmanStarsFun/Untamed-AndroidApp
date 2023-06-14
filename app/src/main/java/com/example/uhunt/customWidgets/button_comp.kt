package com.example.uhunt.customWidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.uhunt.customWidgets.ui.theme.UhuntTheme


@Composable
fun myButton(
    text:String,
    textColor: androidx.compose.ui.graphics.Color,
    backgroundColor: androidx.compose.ui.graphics.Color,
    h:Dp,
    w:Dp,
    roundedradius:Dp,
    onClick: () -> Unit,
    modifier: Modifier
) {

    Button(onClick = onClick,
        modifier = modifier.background(color = backgroundColor,
            shape = RoundedCornerShape(roundedradius)
        ).width(w).height(h)
    ) {

        Text(text =text,
            color = textColor,

            )
    }

}