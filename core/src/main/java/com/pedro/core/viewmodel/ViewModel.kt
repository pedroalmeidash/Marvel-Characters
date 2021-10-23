package com.pedro.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class ViewModel<State : UIState, Action : UIAction>(initialState: State) : ViewModel() {

    private val _state = MutableLiveData(initialState)
    val state: LiveData<State> = _state

    private val _action = MutableLiveData<Action>()
    val action: LiveData<Action> = _action

    protected fun changeState(newState: (State?) -> State) {
        _state.value = newState(_state.value)
    }

    protected fun sendAction(action: () -> Action) {
        _action.value = action()
    }
}