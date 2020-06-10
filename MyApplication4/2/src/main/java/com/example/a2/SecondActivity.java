package com.example.a2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = findViewById(R.id.textView1);
        editText = findViewById(R.id.edTxt);
        button = findViewById(R.id.btnReturn);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("txt"));
        textView.setVisibility(View.VISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("to", editText.getText());
                setResult(RESULT_OK, intent);
                startActivity(intent);
            }
        });

    }
}
