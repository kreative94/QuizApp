package com.example.android.quizapp;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WomenHistoryQuiz extends AppCompatActivity {
    int baseScore;
    int points;
    String isCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_history_quiz);

        //Add Quiz Intro Fragment to Activity Layout
        if (findViewById(R.id.output) != null) {
            if (savedInstanceState != null) {
                return;
            }
            QuizIntro firstFragment = new QuizIntro();
            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.output, firstFragment).commit();
        }
    }

    public void displayQuestions(View view){
        //Switch to Question Fragment
        Button startQuiz = findViewById(R.id.start_quiz_button);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create fragment and give it an argument specifying the article it should show
                Questions newFragment = new Questions();
                Bundle args = new Bundle();
                newFragment.setArguments(args);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.output, newFragment);
                //transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });
    }
}