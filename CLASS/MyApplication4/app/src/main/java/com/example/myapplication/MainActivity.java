package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGroup;
    RadioButton second, third;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        button = findViewById(R.id.button);
        rGroup = findViewById(R.id.rGroup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.second:
                        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.third:
                        Intent intent1 = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(intent1);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "액티비티를 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
