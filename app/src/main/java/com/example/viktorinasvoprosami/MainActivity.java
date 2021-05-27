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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Button yesBtn;
    private Button noBtn;
    private Button answer;

    private int questionIndex = 0;

    private TextView textView;
    private final StringBuilder Itog = new StringBuilder();

    private final Question[] questions = new Question[]{
            new Question(R.string.question0, true),
            new Question(R.string.question1, false),
            new Question(R.string.question2, true),
            new Question(R.string.question3, true),
            new Question(R.string.question4, false),
            new Question(R.string.question5, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO: ", "Метод onCreate() запущен");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            questionIndex = savedInstanceState.getInt("questionIndex");
        }

        yesBtn = findViewById(R.id.btnYes);
        noBtn = findViewById(R.id.btnNo);
        answer = findViewById(R.id.answer);

        textView = findViewById(R.id.textView);
        textView.setText(questions[questionIndex].getQuestionResId());

        yesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("SYSTEM INFO: ", "Метод onClick() кнопки Да запущен");
                if(questions[questionIndex].isAnswerTrue()){
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    setResult(true);
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    setResult(false);
                }

                if(questionIndex < (questions.length - 1)){
                    questionIndex++;
                    textView.setText(questions[questionIndex].getQuestionResId());
                }else{
                    showResult();
                }
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("SYSTEM INFO: ", "Метод onClick() кнопки Нет запущен");
                if(questions[questionIndex].isAnswerTrue()){
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    setResult(false);
                }else{
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    setResult(true);
                }

                if (questionIndex < (questions.length - 1)){
                    questionIndex++;
                    textView.setText(questions[questionIndex].getQuestionResId());
                }else{
                    showResult();
                }
            }
        });

        answer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("SYSTEM INFO: ", "Метод onClick() кнопки Подсмотреть ответ запущен");
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });
    }

    public void setResult(boolean question){
        Log.d("SYSTEM INFO: ", "Метод setResult() запущен");
        Itog.append("Вопрос: " + getString(questions[questionIndex].getQuestionResId()) + "\n" +
                "Ответ: " + ((question) ? "правильно!" : "не правильно!!") + "\n");
    }

    public void showResult(){
        Log.d("SYSTEM INFO: ", "Метод showResult() запущен");
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result", Itog.toString());
        startActivity(intent);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO: ", "Метод onStart() запущен");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("SYSTEM INFO: ", "Метод onResume() запущен");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO: ", "Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("questionIndex", questionIndex);
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO: ", "Метод onPause() запущен");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO: ", "Метод onStop() запущен");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO: ", "Метод onDestroy() запущен");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        Log.d("SYSTEM INFO: ", "Метод onCreateOptionsMenu() запущен");
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    public void onExitMenuClick (MenuItem item){
        Log.d("SYSTEM INFO: ", "Метод onExitMenuClick() запущен");
        finish ();
    }
}

//questionIndex = (questionIndex+1)%questions.length; //зациклить банк вопросов
//getSupportActionBar().hide(); //можно убрать сверху название приложения