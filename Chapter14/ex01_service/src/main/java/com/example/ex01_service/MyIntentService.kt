package com.example.ex01_service

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.SystemClock
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("test", "인텐트 서비스 시작")
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
    }

}
