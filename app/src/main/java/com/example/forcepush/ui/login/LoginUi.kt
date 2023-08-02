package com.example.forcepush.ui.login

import com.example.forcepush.core.Abstract
import com.example.forcepush.ui.core.AbstractView

interface LoginUi : Abstract.UiObject {

    fun map(error: AbstractView.Text, progress: AbstractView, button: AbstractView) = Unit

    object Success : LoginUi

    class Initial : LoginUi {
        override fun map(error: AbstractView.Text, progress: AbstractView, button: AbstractView) {
            error.hide()
            progress.hide()
            button.show()
        }
    }

    class Progress : LoginUi {
        override fun map(error: AbstractView.Text, progress: AbstractView, button: AbstractView) {
            error.hide()
            progress.show()
            button.hide()
        }
    }

    data class Failed(private val message: String) : LoginUi {
        override fun map(error: AbstractView.Text, progress: AbstractView, button: AbstractView) {
            error.show(message)
            progress.hide()
            button.show()
        }
    }
}