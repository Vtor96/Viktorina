package com.example.viktorinasvoprosami;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity{
    private TextView result;
    private Button buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO: ", "Метод onCreate() ResultActivity запущен");
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.result);
        result.setText(getIntent().getStringExtra("result"));

        buttonHome = findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("SYSTEM INFO: ", "Метод onClick() кнопки В начало запущен");
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}