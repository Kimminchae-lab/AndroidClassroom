package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecentDestination extends AppCompatActivity {
    ListView recentDestination;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_destination);

        recentDestination = findViewById(R.id.listView);

        // ListView와 ArrayList를 연결해줄 Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, arrayList);
        recentDestination.setAdapter(adapter);

        // 최근 목적지 표시
        Intent getDestination = getIntent();
        arrayList.add(getDestination.getExtras().getString("Destination"));



    }
}
