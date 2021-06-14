package com.iug.qudsiapp.services

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.iug.qudsiapp.ui.activities.SplashActivity

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private lateinit var myNotificationManager: MyNotificationManager

    override fun onNewToken(token: String) {}

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.e("TAG", "onMessageReceived")

        myNotificationManager = MyNotificationManager(this)
        myNotificationManager.showNotification(
            1, remoteMessage.notification!!.title!!, remoteMessage.notification!!.body!!,
            Intent(
                applicationContext,
                SplashActivity::class.java
            )
        )

    }

}