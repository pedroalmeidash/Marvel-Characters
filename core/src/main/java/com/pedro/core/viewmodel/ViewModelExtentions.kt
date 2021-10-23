package com.pedro.core.viewmodel

import androidx.appcompat.app.AppCompatActivity

fun <State : UIState, Action : UIAction> AppCompatActivity.subscribeState(
    viewModel: ViewModel<State, Action>,
    onStateChange: (State) -> Unit
) {
    viewModel.state.observe(this) { onStateChange(it) }
}

fun <State : UIState, Action : UIAction> AppCompatActivity.subscribeAction(
    viewModel: ViewModel<State, Action>,
    onActionSent: (Action) -> Unit
) {
    viewModel.action.observe(this) { onActionSent(it) }
}