package com.zainco.jetpackcomposebasicscodelab.launchedeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

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