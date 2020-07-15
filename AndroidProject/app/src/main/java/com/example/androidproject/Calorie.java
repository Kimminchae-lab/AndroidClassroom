package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calorie extends AppCompatActivity {
    TextView cal;
    TextView backToMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);

        cal = findViewById(R.id.cal);
        backToMap = findViewById(R.id.backToMap);
        SQLiteDatabase calor = null;
        calor = SQLiteDatabase.openOrCreateDatabase("cal.db", null);

        String sql = "CREATE TABLE CALORIE(CAL INTEGER)";
        calor.execSQL(sql);


    }
}
