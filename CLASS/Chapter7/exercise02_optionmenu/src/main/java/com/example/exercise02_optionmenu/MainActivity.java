package com.example.exercise02_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "메뉴 1");
        menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "메뉴 2");
        // menu.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "메뉴 3");

        Menu subMenu = menu.addSubMenu("메뉴3");
        subMenu.add(Menu.NONE, Menu.FIRST + 10, Menu.NONE, "서브메뉴1");
        subMenu.add(Menu.NONE, Menu.FIRST + 20, Menu.NONE, "서브메뉴2");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case Menu.FIRST:
                textView.setText("메뉴 1 선택됨");
                break;
            case Menu.FIRST + 1:
                textView.setText("메뉴 2 선택됨");
                break;
            case Menu.FIRST + 10:
                textView.setText("서브메뉴 1 선택됨");
                break;
            case Menu.FIRST + 20:
                textView.setText("서브메뉴 2 선택됨");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
