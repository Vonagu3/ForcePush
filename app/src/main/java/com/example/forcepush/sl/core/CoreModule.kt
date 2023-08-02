package com.example.forcepush.sl.core

import android.content.Context
import android.content.SharedPreferences

interface CoreModule {

    fun provideSharedPreferences(): SharedPreferences

    class Base(private val context: Context) : CoreModule {
        override fun provideSharedPreferences(): SharedPreferences =
            context.getSharedPreferences("ForceAppSharedPref", Context.MODE_PRIVATE)
    }
}