package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class StranuActivity extends AppCompatActivity {



    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stranu);
        Bundle arguments = getIntent().getExtras();
        int vubor = (int) arguments.get("hello");
        String[] nameArr;
        int[] flagsArr;
        String activity;



       if (vubor == 1){
            nameArr = new String[]{"Советский союз","Третий рейх","Соединенные штаты Америки","Италия","Великобритания"};
            flagsArr = new int[]{R.drawable.flag_ussr,R.drawable.flag_reich,R.drawable.flag_usa,R.drawable.flag_italy,R.drawable.flag_britain};

        } else  {
            nameArr = new String[]{"Пехота для мажоров","Пехота для миноров","Шаблон среднего танка","Шаблон танковой дивизии",};
            flagsArr = new int[]{R.drawable.major_division,R.drawable.minor_division,R.drawable.midtank_division,R.drawable.tank_division};

        }

        listView = (ListView) findViewById(R.id.listStranu);
        Adapter adapter = new Adapter(this,nameArr,flagsArr,vubor);
        listView.setAdapter(adapter);




    }


    public void goHome(View view){
        Intent intent = new Intent(this,VuborActivity.class);
        startActivity(intent);
    }



}
