package com.example.forcepush.domain.login

import com.example.forcepush.core.SaveText
import com.example.forcepush.data.LoginRepository
import com.example.forcepush.ui.login.Auth
import com.example.forcepush.ui.login.LoginWrapper

interface LoginInteractor {

    fun authorized(): Boolean

    suspend fun login(loginWrapper: LoginWrapper): Auth

    class Base(private val repository: LoginRepository) : LoginInteractor {

        override suspend fun login(loginWrapper: LoginWrapper): Auth {
            val result = loginWrapper.login()
            if (result is Auth.Base)
                result.map(SaveText(repository))
            return result
        }

        override fun authorized() = repository.user() != null
    }
}