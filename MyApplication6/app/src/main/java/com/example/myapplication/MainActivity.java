package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 참조변수
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btnOpenActivity);

        // 버튼 이벤트 처리
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인텐트 생성
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                // EditText의 값을 SecondActivity로 전달
                intent.putExtra("txt", editText.getText().toString());
                startActivityForResult(intent, RESULT_OK);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
