package com.example.calculator_event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator_event.R;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    Button btnadd, btnsub, btnmul, btndiv;
    TextView textView;
    double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Calculator");

        editText1 = (EditText) findViewById(R.id.edit1);
        editText2 = (EditText) findViewById(R.id.edit2);

        btnadd = (Button) findViewById(R.id.btnAdd);
        btnsub = (Button) findViewById(R.id.btnSub);
        btnmul = (Button) findViewById(R.id.btnMul);
        btndiv = (Button) findViewById(R.id.btnDiv);

        textView = (TextView) findViewById(R.id.text);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = "계산 결과 : ";
                int txt1 = Integer.parseInt(String.valueOf(editText1.getText()));
                int txt2 = Integer.parseInt(String.valueOf(editText2.getText()));

                switch (v.getId()) {
                    case R.id.btnAdd: textView.setText("덧셈 " + txt + String.valueOf(txt1 + txt2));    break;
                    case R.id.btnSub: textView.setText("뺄셈 " + txt + String.valueOf(txt1 - txt2));    break;
                    case R.id.btnMul: textView.setText("곱셈 " + txt + String.valueOf(txt1 * txt2));    break;
                    case R.id.btnDiv: textView.setText("나눗셈 " + txt + String.valueOf(txt1 / txt2));    break;
                }
            }
        };

        btnadd.setOnClickListener(listener);
        btnsub.setOnClickListener(listener);
        btnmul.setOnClickListener(listener);
        btndiv.setOnClickListener(listener);
    }
}
