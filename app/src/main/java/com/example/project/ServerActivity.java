package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

public class ServerActivity extends AppCompatActivity {
    private EditText messageText;
    private ListView messegeList;
    private DatabaseReference database;
    DatabaseReference myRef;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        messageText = findViewById(R.id.messegeText);
        messegeList= findViewById(R.id.messageList);



        FirebaseDatabase database = FirebaseDatabase.getInstance("https://project-c880a-default-rtdb.asia-southeast1.firebasedatabase.app/");
        myRef = database.getReference("message");
        myRef.setValue("");
        ArrayList<String> messegeArr = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item1, messegeArr);
        messegeList.setAdapter(adapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messegeArr.add(snapshot.getValue().toString());
                Log.d("bla", snapshot.getValue().toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public  void onClickSend(View view){
        String message = messageText.getText().toString();
        myRef.setValue(message);


    }


}
