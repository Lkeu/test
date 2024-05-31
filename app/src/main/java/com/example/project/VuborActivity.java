package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VuborActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vubor);
    }
    public void starStranu(View view){
        Intent intent = new Intent(this, StranuActivity.class);
        intent.putExtra("hello", 1);
        startActivity(intent);

    }

    public void startDivision(View view){
        Intent intent = new Intent(this, StranuActivity.class);
        intent.putExtra("hello", 2);
        startActivity(intent);

    }
    public void startServer(View view){
        Intent intent = new Intent(this, ServerActivity.class);

        startActivity(intent);

    }
}