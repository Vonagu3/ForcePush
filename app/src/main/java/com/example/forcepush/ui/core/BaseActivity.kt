package com.example.forcepush.ui.core

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.example.forcepush.sl.core.FPApp

abstract class BaseActivity : AppCompatActivity() {

    protected fun <T : ViewModel> viewModel(model: Class<T>, owner: ViewModelStoreOwner) =
        (application as FPApp).viewModel(model, owner)
}