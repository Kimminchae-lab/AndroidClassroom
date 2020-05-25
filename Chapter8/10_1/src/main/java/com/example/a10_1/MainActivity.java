package com.example.a10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RadioButton ac2, ac3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac2 = findViewById(R.id.act2);
        ac3 = findViewById(R.id.act3);
        btn = findViewById(R.id.move_act);
        ac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ac3.isChecked()){
                    ac3.setChecked(false);
                }
            }
        });
        ac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ac2.isChecked()){
                    ac2.setChecked(false);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(ac2.isChecked()){
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                } else if (ac3.isChecked()){
                    intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"액티비티를 골라주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
