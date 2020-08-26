package com.example.ex01_service

import android.app.IntentService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.Context
import android.graphics.Color
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat

class MyForegroungIntentService : IntentService("MyIntentService") {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("test", "인텐트 서비스 시작")

        // Show Notification
        val manager: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel("test", "Service", NotificationManager.IMPORTANCE_HIGH)
        channel.enableLights(true)
        channel.lightColor
        channel.enableVibration(true)
        manager.createNotificationChannel(channel)

        val builder = NotificationCompat.Builder(this, "test")
        builder.setSmallIcon(android.R.drawable.ic_menu_search)
        builder.setContentTitle("서비스 가동")
        builder.setContentText("서비스 가동 중입니다.")
        builder.setAutoCancel(true)
        // val notification =

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "인텐트 서비스 종료")
    }

    override fun onHandleIntent(intent: Intent?) {
        for(i in 1..10) {
            SystemClock.sleep(1000)
            val time = System.currentTimeMillis();
            Log.d("test", "Service Running...." + time)
        }

        // Delete Notification Message when Thread completed
        stopForeground(STOP_FOREGROUND_REMOVE)
        val manager: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(100)
    }

}
