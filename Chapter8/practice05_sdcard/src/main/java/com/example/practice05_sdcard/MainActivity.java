package com.example.practice05_sdcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    Button btnRead, btnWrite;
    EditText editText;
    TextView textView;

    // 권한 목록 배열
    String[] permissionList = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        // 권한 체크
        checkPermissions();

        // region 외부 저장장치의 사용 가능 여부 체크
        if (isExternalStorageWritable()) {
            Toast.makeText(this, "외부 저장소 쓰기 가능", Toast.LENGTH_SHORT).show();
        }
        if (isExternalStorageReadable()) {
            Toast.makeText(this, "외부 저장소 읽읽기 가능", Toast.LENGTH_SHORT).show();
        }
        // endregion

        // region 외부 저장소의 앱별 디렉토리에 접은 getExternalFilesDir( )
        File[] externalStorageVolumes = ContextCompat.getExternalFilesDirs(this, null);
        File primaryExternalStorage = externalStorageVolumes[0];
        Log.d("MainActivity",String.valueOf(primaryExternalStorage.isFile()));
        Log.d("MainActivity",String.valueOf(primaryExternalStorage.isDirectory()));
        Log.d("MainActivity",primaryExternalStorage.getName());
        Log.d("MainActivity",primaryExternalStorage.getAbsolutePath());
        Log.d("MainActivity",primaryExternalStorage.getPath());
        Log.d("MainActivity",String.valueOf(primaryExternalStorage.canRead()));
        Log.d("MainActivity",String.valueOf(primaryExternalStorage.canWrite()));
        // endregion

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void checkPermissions() {
        for (String permission : permissionList) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, permission + " 권한 없음", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, permission + " 권한 없음", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    };

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    };
}
