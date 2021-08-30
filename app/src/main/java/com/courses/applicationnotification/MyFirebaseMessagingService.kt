package com.courses.applicationnotification

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage



class MyFirebaseMessagingService : FirebaseMessagingService() {

  private val tag = "FirebaseMessagingServ"
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.i(tag, remoteMessage.from.toString())

        if(remoteMessage.notification != null){
            this.showNotification("1234", "Bootcamp Android", "Curso Kotlin Android")
            remoteMessage.notification?.title.toString()
            remoteMessage.notification?.body.toString()
        }
    }
}