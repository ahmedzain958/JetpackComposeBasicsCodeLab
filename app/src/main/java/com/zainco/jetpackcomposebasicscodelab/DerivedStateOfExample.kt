package com.zainco.jetpackcomposebasicscodelab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun ExampleDerivedStateOf(numbers: List<Int> = List(80) { it }) {
    val scrollState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val isButtonShown by remember { derivedStateOf { scrollState.firstVisibleItemIndex > 0 } }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyColumn(state = scrollState) {
            items(items = numbers) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = "Value is $it", fontSize = 20.sp
                )
            }
        }

        /*AnimatedVisibility(
            visible = isButtonShown,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            FloatingActionButton(onClick = {
                scope.launch {
                    scrollState.scrollToItem(0)
                }
            }) {
                Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
            }
        }*/
    }
}