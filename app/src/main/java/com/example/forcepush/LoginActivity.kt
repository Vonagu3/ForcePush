package com.example.forcepush

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private val auth = Firebase.auth
    private val provider: OAuthProvider.Builder = OAuthProvider.newBuilder("github.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button = findViewById<View>(R.id.loginButton)

        button.setOnClickListener {

            val result = auth.pendingAuthResult

            if (result == null) {
                auth.startActivityForSignInWithProvider(this, provider.build())
                    .addOnSuccessListener {
                        Log.d(TAG, "!success ${it.credential.toString()} ${it.additionalUserInfo?.profile}")
                    }.addOnFailureListener {
                        Log.d(TAG, "!failure ${it.message}")
                    }
            } else {
                result.addOnSuccessListener {
                    Log.d(TAG, "success ${it.user} ${it.additionalUserInfo?.profile}")
                }.addOnFailureListener {
                    Log.d(TAG, "failure ${it.message}")
                }
            }
        }
    }

    companion object {
        private val TAG = javaClass.simpleName
    }
}