package com.example.android.quizapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class WomenHistoryQuiz extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_history_quiz);


        OnClickListener goToQuestions = new View.OnClickListener(){
            public void onClick(View view) {
                Fragment fragment = null;
                if(view == findViewById(R.id.go_to_questions)){
                    fragment = new Questions();
                }
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.output, fragment);
                transaction.commit();
            }
        };
        Button theQuestionsButton = findViewById(R.id.go_to_questions);
        theQuestionsButton.setOnClickListener(goToQuestions);
    }
}
