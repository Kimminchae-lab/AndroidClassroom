package com.example.exercise03_contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // textView에 컨텍스트 메뉴 설정
        registerForContextMenu(textView);
    }

    // 컨텍스트 메뉴 생성

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();

        switch (v.getId()) {
            case R.id.textView:
                menu.setHeaderTitle("TextView의 컨텍스트 메뉴");
                menuInflater.inflate(R.menu.textview_menu, menu);
                break;
        }
    }


    // 컨텍스트 메뉴 아이템 선택에 따른 이벤트 처리
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.textViewItem1:
                textView.setText("메뉴1 선택.");
                break;
            case R.id.textViewItem2:
                textView.setText("메뉴2 선택.");
                break;
        }

        return super.onContextItemSelected(item);
    }
}
