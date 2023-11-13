package com.zainco.jetpackcomposebasicscodelab.launchedeffect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class LaunchedEffectFlowViewModel : ViewModel() {

    private val _sharedFlow = MutableSharedFlow<ScreenEvents>()
    val sharedFlow = _sharedFlow

    init {
        viewModelScope.launch {
            _sharedFlow.emit(ScreenEvents.ShowSnackBar("Hello snack"))
        }
    }

    sealed class ScreenEvents {
        data class ShowSnackBar(val message: String) : ScreenEvents()
        data class Navigate(val route: String) : ScreenEvents()
    }
}