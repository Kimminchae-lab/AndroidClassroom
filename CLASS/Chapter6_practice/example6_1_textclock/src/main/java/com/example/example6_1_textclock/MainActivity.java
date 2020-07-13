package com.example.example6_1_textclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 1. 참조변수 생성
    TextClock tc;   TextView text;   Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 참조변수에 객체 연결
        btn = (Button) findViewById(R.id.btn);
        tc = (TextClock) findViewById(R.id.textClock);
        text = (TextView) findViewById(R.id.text);

        // 3. 버튼 클릭 이벤트처리
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView에 TextClock에서 가져온 시간 표시
                text.setText("Time : " + tc.getText());
            }
        });
    }
}
