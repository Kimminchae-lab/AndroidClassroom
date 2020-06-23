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

    // region
    TextView textView;
    ListView listView;
    Button btnAdd, btnEdit, btnDel;
    int selNum = 0;
    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region
        textView = findViewById(R.id.selectedItem);
        listView = findViewById(R.id.listView);
        btnDel = findViewById(R.id.btnDel);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        // endregion

        // 순서

        final ArrayList<String> dataSet = new ArrayList<>();
        dataSet.add("리스트 데이터 1"); dataSet.add("리스트 데이터 2");
        dataSet.add("리스트 데이터 3"); dataSet.add("리스트 데이터 4");
        dataSet.add("리스트 데이터 5");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_single_choice
                , dataSet);

        listView.setChoiceMode(android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selNum = position;
                listView.setItemChecked(selNum, true);
                textView.setText(dataSet.get(selNum));
            }
        });

        // region
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.add("리스트 데이터 " + (dataSet.size()+ 1));
                adapter.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder dlg = new AlertDialog.Builder(getApplicationContext());
                dlg.setIcon(R.drawable.ic_launcher_foreground);
                dlg.setTitle("리스트 아이템 수정");
                dlg.setMessage("현재 데이터 : 리스트 데이터" + selNum);
                final EditText editText = new EditText(getApplicationContext());
                dlg.setView(editText);
                dlg.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dlg.setNegativeButton("취소",null);
                        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataSet.set(selNum, editText.getText().toString());
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
                dlg.show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.remove(selNum--);
                adapter.notifyDataSetChanged();
            }
        });
    // endregion
    }
}
