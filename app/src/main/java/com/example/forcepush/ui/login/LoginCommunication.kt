package com.example.forcepush.ui.login

import com.example.forcepush.ui.core.Communication

interface LoginCommunication : Communication<LoginUi> {

    class Base : Communication.Base<LoginUi>(), LoginCommunication
}