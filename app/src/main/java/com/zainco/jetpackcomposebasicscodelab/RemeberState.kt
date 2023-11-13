package com.zainco.jetpackcomposebasicscodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Preview
@Composable
fun stateExample() {
    val color = remember { mutableStateOf(Color.Yellow) }
    /**
     * when this box is recomposed, we don't want to reset this color value
     */
    Box(modifier = Modifier
        .background(color = color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }) {
        Button(onClick = { }) {

        }
    }
}