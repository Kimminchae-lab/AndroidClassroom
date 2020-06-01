package com.example.ex05_diy10_3_re;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // MainActivity가 보낸 Intent에서 데이터 꺼내기
        final Intent inIntent = getIntent();
        final int res, op;
        final String str;
        int num;
        String str_sub;
        op = inIntent.getIntExtra("op", 0);

        switch (op) {
            case R.id.rBtnAdd:
                num = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
                str_sub = "덧셈 결과 : ";
                break;
            case R.id.rBtnSub:
                num = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
                str_sub = "뺄셈 결과 : ";
                break;
            case R.id.rBtnMul:
                num = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
                str_sub = "곱셈 결과 : ";
                break;
            case R.id.rBtnDiv:
                num = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);
                str_sub = "나눗셈 결과 : ";
                break;
            default:
                num = 0;
                str_sub = "";
                break;
        }

        res = num;
        str = str_sub;

        // 돌아가기 버튼 클릭 이벤트 처리
        findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Res", res);
                outIntent.putExtra("Str", str);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}