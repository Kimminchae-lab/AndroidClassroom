package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cal = Calendar.getInstance()

        cal.time = Date()

        var df:DateFormat = SimpleDateFormat("yyyy-MM-dd")
        println("current: ${df.format(cal.time)}")

        cal.add(Calendar.MONTH, 2)
        cal.add(Calendar.DATE, -3)
        println("after: ${df.format(cal.time)}")

        button.visibility = View.VISIBLE
    }
}
