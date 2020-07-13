package com.example.ex05_diy10_3_re;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum1, editTextNum2;
    RadioGroup radioGroup;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1",Integer.parseInt(editTextNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(editTextNum2.getText().toString()));
                intent.putExtra("op", radioGroup.getCheckedRadioButtonId());    // RadioGroup에서 선택한 RadioButton의 ID 전달
                startActivityForResult(intent, 0);
            }
        });
    }

    // startActivityForResult()의 응답이 돌아오면 자동 실행되는 메소드

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == RESULT_OK){
            int res = data.getIntExtra("Res", 0);

            // 선택한 연산에 따른 토스트 메시지 변경
            String str = data.getStringExtra("Str");
            Toast.makeText(this, str + res, Toast.LENGTH_SHORT).show();
        }
    }
}