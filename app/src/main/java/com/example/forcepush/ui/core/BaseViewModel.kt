package com.example.forcepush.ui.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.forcepush.core.Abstract

abstract class BaseViewModel<E : Communication<T>, T : Abstract.UiObject>(protected val communication: E) :
    ViewModel(), Observe<T> {

    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
        communication.observe(owner, observer)
    }
}