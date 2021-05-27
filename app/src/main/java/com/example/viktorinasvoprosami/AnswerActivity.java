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

public class AnswerActivity extends AppCompatActivity{
    private TextView answerTextView;
    private boolean isAnswerTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        Log.d("SYSTEM INFO: ", "Метод onCreate() AnswerActivity запущен");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        isAnswerTrue = getIntent().getBooleanExtra("answer",false);

        answerTextView = findViewById(R.id.answerTextView);
        answerTextView.setText(isAnswerTrue?R.string.yes:R.string.no);
        /*if(isAnswerTrue){
            answerTextView.setText(R.string.yes);
        }else{
            answerTextView.setText(R.string.no);
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        Log.d("SYSTEM INFO: ", "Метод onCreateOptionsMenu() AnswerActivity запущен");
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    public void onExitMenuClick (MenuItem item){
        Log.d("SYSTEM INFO: ", "Метод onExitMenuClick() AnswerActivity запущен");
        finish ();
    }
}