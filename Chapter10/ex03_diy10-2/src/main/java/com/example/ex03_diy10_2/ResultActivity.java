package com.example.ex03_diy10_2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    Button btnReturn;
    ImageView img;
    String str;
    int cnt;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnReturn = findViewById(R.id.btnReturn);
        cnt = 0;
        str = "";
        txt = findViewById(R.id.textView);

        // region MainActivity에서 보낸 인텐트 객체 받기
        Intent intent = getIntent();
        String[] imageNames = intent.getStringArrayExtra("nameData");
        int[] voteResult = intent.getIntArrayExtra("voteData");
        int[] imgLogs = intent.getIntArrayExtra("imgName");

        // 뷰를 담을 참조변수 배열
        TextView[] textViews = new TextView[imageNames.length];
        RatingBar[] ratingBars = new RatingBar[voteResult.length];

        int[] textViewsId = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        int[] ratingBarId = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        // 참조변수에 View 객체 연결
        for (int i = 0; i < textViews.length; i++) {
            textViews[i] = findViewById(textViewsId[i]);
            ratingBars[i] = findViewById(ratingBarId[i]);
        }
        // endregion

        // 이미지 이름, 투표 결과
        for (int i = 0; i < voteResult.length; i++) {
            textViews[i].setText(imageNames[i]);
            ratingBars[i].setRating(voteResult[i]);
        }

        for (int i = 0; i < voteResult.length; i++) {
            if (voteResult[i] > cnt) {
                cnt = i;
            }
        }


        txt.setText(imageNames[cnt]);
        img = findViewById(R.id.imageView);
        img.setImageResource(imgLogs[cnt]);

        // 돌아가기 버튼 이벤트 처리
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
