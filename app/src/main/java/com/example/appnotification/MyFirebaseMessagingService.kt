package com.example.appnotification


import android.annotation.SuppressLint
import android.nfc.Tag
import android.util.Log
import android.util.Log.d
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyFirebaseMessagingService : FirebaseMessagingService() {

    val tag = "Firebase Message"

    override fun onNewToken(token: String) {
        Log.i("NEW_TOKEN", token)

    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.i(tag, message.from.toString())

        if (message.notification != null){
            this.showNotification("1234",
                message.notification?.title.toString(),
                message.notification?.body.toString())
        }
    }
}