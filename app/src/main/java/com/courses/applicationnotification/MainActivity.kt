package com.courses.applicationnotification

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp.getInstance
import com.google.firebase.messaging.FirebaseMessaging
import java.util.Calendar.getInstance

class MainActivity : AppCompatActivity() {

    lateinit var btnSend: Button



    @SuppressLint("StringFormatInvalid")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend = findViewById(R.id.button_send_notification)
        btnSend.setOnClickListener{
            this.showNotification("1234", "Bootcamp Android", "Curso Kotlin Android ")

        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            val msg = getString(R.string.msg_token_fmt, token)
            Log.d(TAG, msg)
            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
        })

    }
}