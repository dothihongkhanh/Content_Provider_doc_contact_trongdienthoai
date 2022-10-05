package com.example.content_provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    Button btnDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        addEvents();
    }
    public void addEvents(){
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyManHinhDanhBa();
            }
        });
    }
    private void xuLyManHinhDanhBa(){
        Intent intent = new Intent(MainActivity.this,DanhBa.class);
        intent.setClassName("com.example.content_provider","com.example.content_provider.DanhBa");
        startActivity(intent);
            }
    public void AnhXa(){
        btnDoc = (Button) findViewById(R.id.button);
    }
}
