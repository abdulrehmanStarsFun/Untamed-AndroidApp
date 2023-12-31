package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ListItemDivider(padd:Int) {
    Divider(
        modifier = Modifier.padding(padd.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}