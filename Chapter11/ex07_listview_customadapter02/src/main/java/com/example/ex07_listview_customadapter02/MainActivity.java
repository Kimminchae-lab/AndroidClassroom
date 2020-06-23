package com.example.ex07_listview_customadapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    Button btnAdd;

    ArrayList<ItemVO> dataList = new ArrayList<ItemVO>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);

        dataList.add(new ItemVO("doc", "Document 1", "Sample Data"));
        dataList.add(new ItemVO("img", "Image 1", "Sample Data"));
        dataList.add(new ItemVO("File", "File 1", "Sample Data"));

        CustomAdapter adapter = new CustomAdapter(this, R.layout.row, dataList);

        listView.setAdapter(adapter);
    }
}
