package com.example.ex01_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartService.setOnClickListener(this)
        btnStopService.setOnClickListener(this)

        btnStartIntentService.setOnClickListener(this)
        btnForegroundIntentService.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
        when (v?.id) {
            R.id.btnStartService -> {
                val intent = Intent(this, MyService::class.java)
                startService(intent)
            }
            R.id.btnStopService -> {
                val intent = Intent(this, MyService::class.java)
                stopService(intent)
            }
            R.id.btnStartIntentService -> {
                val intent = Intent(this, MyIntentService::class.java)
                startService(intent)
            }
            R.id.btnStartIntentService -> {
                val intent = Intent(this, MyForegroungIntentService::class.java)
                startForegroundService(intent)
            }
        }
    }
}
