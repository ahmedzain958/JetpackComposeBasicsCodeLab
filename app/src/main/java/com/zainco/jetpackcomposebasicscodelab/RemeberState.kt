package com.zainco.jetpackcomposebasicscodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

/**
 * Note: When state changes (view changes), a re-composition happens
 */
@Composable
fun stateExample(modifier: Modifier = Modifier) {
    /**
     * mutable state of variables: associated to compiler whenever changed, a recomposition happens
     * Remember: keeps variable last value while recomposition
     */
    val color = remember { mutableStateOf(Color.Yellow) }
    /**
     * when this box is recomposed, we don't want to reset this color value to yellow again
     */
    Box(modifier = modifier
        .background(color = color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }) {
    }
}
@Composable
fun stateClickChangesBGOFAnotherBoxExample() {
    Column(Modifier.fillMaxSize()) {
        val color = remember { mutableStateOf(Color.Yellow) }
        ColorBox (Modifier.weight(1f).fillMaxSize()){
            color.value = it
        }
        Box(modifier = Modifier
            .background(color = color.value)
            .weight(1f)
            .fillMaxSize() ) {
        }
    }

}

@Composable
fun ColorBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(modifier = modifier
        .background(color = Color.Red)
        .clickable {
            updateColor(Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            ))
        }) {
    }
}
