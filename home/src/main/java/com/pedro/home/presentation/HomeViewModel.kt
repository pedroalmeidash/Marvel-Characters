package com.pedro.home.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.pedro.core.viewmodel.ViewModel
import com.pedro.home.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel<HomeState, HomeAction>(HomeState()) {

    fun fetchCharacters() {
        viewModelScope.launch {
            getCharactersUseCase()
                .flowOn(dispatcher)
                .catch { Log.e("HomeViewModel", "fetchCharacters: ${it.message}") }
                .collect { Log.d("HomeViewModel", "fetchCharacters: $it") }
        }
    }
}