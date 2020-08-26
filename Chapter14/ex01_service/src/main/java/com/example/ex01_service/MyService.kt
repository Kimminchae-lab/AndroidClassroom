package com.example.ex01_service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.widget.Toast

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("test", "서비스 시작")
        Toast.makeText(this, "서비스 시작", Toast.LENGTH_SHORT).show()

        // 사용자 정의 스레드 시작
        val thread = ThreadClass()
        thread.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "서비스 종료")
        Toast.makeText(this, "서비스 종료", Toast.LENGTH_SHORT).show()
    }

    // Define Thread Class
    class ThreadClass : Thread() {
        @Override
        override fun run() {
            for(i in 1..10) {
                SystemClock.sleep(1000)
                val time = System.currentTimeMillis();
                Log.d("test", "Service Running...." + time)
            }
        }
    }
}
