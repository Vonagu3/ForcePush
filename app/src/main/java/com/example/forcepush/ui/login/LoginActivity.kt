package com.example.forcepush.ui.login

import android.content.Intent
import android.os.Bundle
import com.example.forcepush.R
import com.example.forcepush.databinding.ActivityLoginBinding
import com.example.forcepush.ui.core.BaseActivity
import com.example.forcepush.ui.main.MainActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = viewModel(LoginViewModel::class.java, this)
        viewModel.observe(this) {
            if (it is LoginUi.Success) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else
                it.map(binding.errorTextView, binding.progressBar, binding.loginButton)
        }
        binding.loginButton.setOnClickListener { viewModel.login(LoginWrapper.Base(this)) }
        viewModel.init()
    }

    companion object {
        private val TAG = "TAG"
    }
}