package com.example.forcepush.data

import android.content.SharedPreferences
import com.example.forcepush.core.Save
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

interface LoginRepository : Save<String> {

    fun user(): Any?

    class Base(private val sharedPreferences: SharedPreferences) : LoginRepository {
        override fun user() = Firebase.auth.currentUser
        override fun save(data: String) {
            sharedPreferences.edit().putString("profile", data).apply()
        }
    }
}