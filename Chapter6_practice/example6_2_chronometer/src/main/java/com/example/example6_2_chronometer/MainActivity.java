package com.example.example6_2_chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    // 위젯 생성
    Chronometer chrono;
    Button btnStart, btnPause, btnReset;
    long timeNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 참조변수에 연결
        chrono = (Chronometer) findViewById(R.id.chrono);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnReset = (Button) findViewById(R.id.btnReset);

        // 3. 버튼 클릭 이벤트 처리

        //region
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime() + timeNum);
                chrono.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeNum = chrono.getBase() - SystemClock.elapsedRealtime();
                chrono.stop();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.stop();
                timeNum = 0;
            }
        });
        //endregion

        chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                Log.d("realTime", String.valueOf(SystemClock.elapsedRealtime()));
            }
        });

    }

}
