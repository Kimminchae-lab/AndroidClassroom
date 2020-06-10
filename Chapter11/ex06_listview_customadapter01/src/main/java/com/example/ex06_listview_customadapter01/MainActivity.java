package com.example.ex06_listview_customadapter01;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnAdd;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        // 리스트뷰에 출력할 데이터
        final ArrayList<String> dataList = getArrayListData(5);

        // 리스트뷰에 데이터와 항목별 뷰를 설정하는 어댑터 객체 생성
        final CustomAdapter adapter = new CustomAdapter(this, R.layout.row, dataList);

        // 리스트뷰에 어댑터 연결
        listView.setAdapter(adapter);

        // 추가 버튼 이벤트 정의
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "먼저 문자열을 입력하세요.",Toast.LENGTH_SHORT).show();
                }

                dataList.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }

    private ArrayList<String> getArrayListData(int count) {
        ArrayList<String> arrayList = new ArrayList<String >();
        for (int i = 1; i <= count; i++) {
            arrayList.add("리스트 아이템 " + i);
        }
        return arrayList;
    }


}
