package com.pedro.home.presentation

import com.pedro.core.viewmodel.UIState

internal data class HomeState(
    val isLoading: Boolean = false
) : UIState