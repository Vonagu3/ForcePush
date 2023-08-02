package com.example.forcepush.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.forcepush.R
import com.example.forcepush.ui.login.LoginActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val avatar = findViewById<ImageView>(R.id.avatarImageView)

        val sharedPreferences = getSharedPreferences("ForceAppSharedPref", Context.MODE_PRIVATE)
        val profile = sharedPreferences.getString("profile", "")
        Firebase.auth.currentUser?.let {
            val text = it.displayName + "\n" + profile
            findViewById<TextView>(R.id.textView).text = text
            Picasso.get().load(it.photoUrl).into(avatar)
        }

        findViewById<View>(R.id.signOutButton).setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}