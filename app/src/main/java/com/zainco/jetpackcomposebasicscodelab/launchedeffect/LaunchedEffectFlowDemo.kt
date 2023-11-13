package com.zainco.jetpackcomposebasicscodelab.launchedeffect

import androidx.compose.animation.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

@Composable
fun LaunchedEffectExample(viewModel: LaunchedEffectFlowViewModel) {
    LaunchedEffect(key1 = true /*makes sure that block of coroutines never cancelled and relaunched while recomposition*/) {
        /**
         * Collection takes place just one time only when the composition called for the first time for this method
         */
        viewModel.sharedFlow.collect { event ->
            when (event) {
                is LaunchedEffectFlowViewModel.ScreenEvents.ShowSnackBar -> {}
                is LaunchedEffectFlowViewModel.ScreenEvents.Navigate -> {}
            }
        }
    }
}

@Composable
fun LaunchedEffectExample2(counter: Int /*this is a state whenever changed a user daily calories animation cancelled and relaunched*/) {
    val animatable = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = counter) {
        animatable.animateTo(counter.toFloat()) /*this coroutines block cancelled then relaunched whenever the counter state changed*/
    }
}