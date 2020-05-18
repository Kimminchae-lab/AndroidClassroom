package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout myLayout, friend1Layout, friend2Layout;
    TextView myName, mySangme;
    View dialogView;
    EditText inputArea;
    int selectFriends = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (LinearLayout) findViewById(R.id.myLayout);
        friend1Layout = (LinearLayout) findViewById(R.id.friend1Layout);
        friend2Layout = (LinearLayout) findViewById(R.id.friend2Layout);

        registerForContextMenu(myLayout);
        registerForContextMenu(friend1Layout);
        registerForContextMenu(friend2Layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInf = getMenuInflater();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optionMenu_deleteAllFriends:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setMessage("모든 친구를 삭제하시겠습니까?");
                dlg.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        friend1Layout.setVisibility(View.GONE);
                        friend2Layout.setVisibility(View.GONE);
                    }
                });
                dlg.setNegativeButton("아니오",null);
                return true;
            case R.id.optionMenu_restoreAllFriends:
                friend1Layout.setVisibility(View.VISIBLE);
                friend2Layout.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == myLayout) {
            MenuInflater mInf = getMenuInflater();
            mInf.inflate(R.menu.my_context_menu, menu);
        }
        if(v == friend1Layout) {
            selectFriends = 1;
            MenuInflater mInf = getMenuInflater();
            mInf.inflate(R.menu.friends_context_menu, menu);
        }
        if(v == friend2Layout) {
            selectFriends = 2;
            MenuInflater mInf = getMenuInflater();
            mInf.inflate(R.menu.friends_context_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }
}
