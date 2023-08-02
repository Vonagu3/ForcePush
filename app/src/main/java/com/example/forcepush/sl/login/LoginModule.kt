package com.example.forcepush.sl.login

import com.example.forcepush.data.LoginRepository
import com.example.forcepush.domain.login.LoginInteractor
import com.example.forcepush.sl.core.BaseModule
import com.example.forcepush.sl.core.CoreModule
import com.example.forcepush.ui.login.LoginCommunication
import com.example.forcepush.ui.login.LoginViewModel

class LoginModule(private val coreModule: CoreModule) : BaseModule<LoginViewModel> {

    override fun viewModel() = LoginViewModel(
        LoginCommunication.Base(),
        LoginInteractor.Base(
            LoginRepository.Base(coreModule.provideSharedPreferences())
        )
    )
}