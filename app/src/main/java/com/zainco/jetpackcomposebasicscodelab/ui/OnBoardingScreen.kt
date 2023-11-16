package com.zainco.jetpackcomposebasicscodelab.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
/*

@Composable
fun OnBoardingScreen() {
    var shouldShowOnboarding by remember{
        mutableStateOf(true)
    }
    Surface (Modifier.fillMaxSize()){
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Text(text = "Welcome to basics code")
            Button(onClick = {
                shouldShowOnboarding = !shouldShowOnboarding
            },
                modifier = Modifier.padding(vertical = 24.dp)) {
                Text(text = "Continue")
            }
        }
    }
}
@Preview
@Composable
fun OnBoardingPreview(){
    OnBoardingScreen()
}*/
