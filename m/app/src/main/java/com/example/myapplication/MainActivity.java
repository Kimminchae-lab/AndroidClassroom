package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView selectedListItem;
    ListView listView;
    Button btnAdd, btnEdit, btnDel;
    int selNum; // 추가, 변경, 삭제 등의 작업 시 항목 지정에 필요한 변수.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedListItem = findViewById(R.id.selectedListItem);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.addBtn);
        btnEdit = findViewById(R.id.editBtn);
        btnDel = findViewById(R.id.delBtn);

        // 리스트 생성(자료형: String)후 항목 5개 추가
        final ArrayList<String> dataSet = new ArrayList<>();
        dataSet.add("리스트 데이터1"); dataSet.add("리스트 데이터2");
        dataSet.add("리스트 데이터3"); dataSet.add("리스트 데이터4");
        dataSet.add("리스트 데이터5");

        // listView와 dataSet을 연결해주기 위해 ArrayAdapter 생성
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_single_choice, // TextView와 RadioButton으로 구성
                dataSet);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // 단일 선택
        listView.setAdapter(adapter); // Adapter 설정

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selNum = position;
                selectedListItem.setText(dataSet.get(position));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.add("리스트 데이터" + dataSet.size() + 1);
                adapter.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("리스트 데이터 수정");
                dlg.setMessage(dataSet.get(selNum));
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final EditText et = new EditText(getApplicationContext());
                dlg.setView(et);
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataSet.set(selNum, et.getText().toString());
                        selectedListItem.setText(dataSet.get(selNum));
                        adapter.notifyDataSetChanged();
                    }
                });
                dlg.show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.remove(selNum);
                selectedListItem.setText(dataSet.get(selNum));
                adapter.notifyDataSetChanged();
            }
        });
    }
}
