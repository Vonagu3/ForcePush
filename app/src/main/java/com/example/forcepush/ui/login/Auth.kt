package com.example.forcepush.ui.login

import com.example.forcepush.core.TextMapper

interface Auth {

    fun <T> map(mapper: TextMapper<T>): T

    data class Base(private val profile: Map<String, Any>) : Auth {
        override fun <T> map(mapper: TextMapper<T>): T = mapper.map(profile["bio"].toString())
    }

    data class Fail(private val e: Exception) : Auth {
        override fun <T> map(mapper: TextMapper<T>) = mapper.map(e.message.toString())
    }
}