package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ServerActivity extends AppCompatActivity {
    private EditText messageText;
    private TextView chatView;
    private DatabaseReference database;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        messageText = findViewById(R.id.messegeText);
        chatView = findViewById(R.id.chatView);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }

    public  void onClickSend(View view){
        String message = messageText.getText().toString();
        database.push().setValue(message);

    }


}
