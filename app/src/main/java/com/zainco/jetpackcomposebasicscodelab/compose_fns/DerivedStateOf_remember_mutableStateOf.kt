package com.zainco.jetpackcomposebasicscodelab.compose_fns

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RememberStateOFExampleScreen() {
    /**
     * remember for stateOf instead of declaring variable
     * var count = 0 and whenever a recomposition, it's value reset to default = 0
     */
    var countWithRemember: Int by remember {
        mutableStateOf(0)
    }
    Log.d("zain", "before clicking countWithRemember=" + countWithRemember.toString())
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            countWithRemember++
            Log.d("zain", "after clicking countWithRemember=" + countWithRemember.toString())
            Log.d("zain", "-------------------------------------")
        }) {
        }
    }
}

@Composable
fun DerivedStateExampleScreen() {
    /**
     * remember for stateOf instead of declaring variable
     * var count = 0 and whenever a recomposition, it's value reset to default = 0
     */
    var countWithRemember: Int by remember {
        mutableStateOf(0)
    }
    Log.d("zain", "before clicking countWithRemember=" + countWithRemember.toString())
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            countWithRemember++
            Log.d("zain", "after clicking countWithRemember=" + countWithRemember.toString())
            Log.d("zain", "-------------------------------------")
        }) {
        }
    }
}