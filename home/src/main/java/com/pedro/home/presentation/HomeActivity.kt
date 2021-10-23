package com.pedro.home.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pedro.core.viewmodel.subscribeAction
import com.pedro.core.viewmodel.subscribeState
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        subscribeState(viewModel, ::handleStateUpdate)
        subscribeAction(viewModel, ::handleActionSent)
    }

    private fun handleStateUpdate(state: HomeState) {
        TODO("Implementation")
    }

    private fun handleActionSent(action: HomeAction) {
        TODO("Implementation")
    }
}