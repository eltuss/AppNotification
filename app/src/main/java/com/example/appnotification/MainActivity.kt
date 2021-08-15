package com.example.appnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend = findViewById(R.id.button_send_notification)
        btnSend.setOnClickListener {
            this.showNotification("1234", "bootcamp Android", "Curso Kotlin")
        }
        FirebaseInstallations.getInstance().getToken(true).addOnCompleteListener {
            val token = it.result!!.token
            val msg = "Token -> $token"
            Log.d("Firebase Message", msg)
        }
    }
}