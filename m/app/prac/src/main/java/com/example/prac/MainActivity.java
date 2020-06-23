package com.example.prac;

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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // region 선언
    TextView selectedListItem;
    ListView listView;
    Button btnAdd, btnEdit, btnDel;
    int num;
    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region 연결
        selectedListItem = findViewById(R.id.selectedListItem);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnDel = findViewById(R.id.btnDel);
        // endregion

        // 순서


        // region 1. ArrayList 만든 후 데이터 5개 추가
        final ArrayList<String> dataSet = new ArrayList<>();
        dataSet.add("리스트 데이터1"); dataSet.add("리스트 데이터2");
        dataSet.add("리스트 데이터3"); dataSet.add("리스트 데이터4");
        dataSet.add("리스트 데이터5");
        // endregion

        // region 2. ArrayAdapter 만들어 ListView와 ArrayList 연결
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                dataSet);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        // endregion

        // region 3. listView Listener 만들기
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                num = position;
                selectedListItem.setText(dataSet.get(num));
            }
        });
        // endregion

        // region btnAdd에 Listener 만들기
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.add("리스트 데이터" + (dataSet.size() + 1));
                adapter.notifyDataSetChanged();
            }
        });
        // endregion

        // region btnEdit에 Listener 만들기
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setIcon(R.drawable.ic_launcher_background);
                dlg.setTitle("리스트 아이템 수정");
                dlg.setMessage("현재 데이터: " + dataSet.get(num));
                final EditText editText = new EditText(getApplicationContext());
                dlg.setView(editText);
                dlg.setNegativeButton("취소",null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataSet.set(num, editText.getText().toString());
                        selectedListItem.setText(dataSet.get(num));
                        adapter.notifyDataSetChanged();

                    }
                });
                dlg.show();
            }
        });
        // endregion

        // region btnDel에 Listener 만들기
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataSet.size() > 0) {
                    dataSet.remove(num);
                    if(dataSet.size() > 0)
                        selectedListItem.setText(dataSet.get(num));
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getApplicationContext(), "데이터가 존재하지 않습니다", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        // endregion

    }
}
