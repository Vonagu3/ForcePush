package com.example.forcepush.ui.login

import androidx.lifecycle.viewModelScope
import com.example.forcepush.core.TextMapper
import com.example.forcepush.domain.login.LoginInteractor
import com.example.forcepush.ui.core.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    communication: LoginCommunication,
    private val interactor: LoginInteractor,
    private val dispatchersIO: CoroutineDispatcher = Dispatchers.IO,
    private val dispatchersMain: CoroutineDispatcher = Dispatchers.Main,
) : BaseViewModel<LoginCommunication, LoginUi>(communication) {

    fun login(login: LoginWrapper) {
        communication.map(LoginUi.Progress())
        viewModelScope.launch(dispatchersIO) {
            val result = interactor.login(login)
            val resultUi = if (result is Auth.Fail)
                result.map(LoginUiFailed())
            else
                LoginUi.Success
            withContext(dispatchersMain) { communication.map(resultUi) }
        }
    }

    fun init() {
        val initialState = if (interactor.authorized()) LoginUi.Success else LoginUi.Initial()
        communication.map(initialState)
    }

    private inner class LoginUiFailed : TextMapper<LoginUi.Failed> {
        override fun map(data: String) = LoginUi.Failed(data)
    }
}