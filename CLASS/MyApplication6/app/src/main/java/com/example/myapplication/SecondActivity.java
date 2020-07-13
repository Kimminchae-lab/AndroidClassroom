package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // region 위젯 선언
    TextView textView;
    RadioGroup rGroup;
    RadioButton rBtnCall, rBtnCam;
    Button button;
    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // region 연결
        textView = findViewById(R.id.textView);
        rGroup = findViewById(R.id.rGroup);
        rBtnCall = findViewById(R.id.rBtnCall);
        rBtnCam = findViewById(R.id.rBtnCam);
        // endregion

        Intent intent = getIntent();
        String str = intent.getStringExtra("txt");
        textView.setText(str);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
