package com.example.forcepush.ui.core

interface AbstractView {

    fun show()
    fun hide()

    interface Text : AbstractView {

        fun show(text: String)
    }
}