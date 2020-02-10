package com.example.dat153_oblig1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    public static ArrayList<ItemsObject> quizList;

    private String rightAnswer;
    private int quizCount;
    private int tempQuizIndex = 0;
    private int score = 0;


    private TextView scoreTextView;
    private TextView questionLabelTextView;
    private TextView whoIsThisTextView;
    private ImageView quizImageView;
    private EditText answerEditText;
    private Button btnSubmitAnswer;
    private Button btnQuitQuiz;
    private Button btnRestartQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        quizList = MainActivity.quizList;
        quizCount = quizList.size();

        //TextViews
        scoreTextView = findViewById(R.id.scoreTextView);
        questionLabelTextView = findViewById(R.id.questionLabelTextView);
        whoIsThisTextView = findViewById(R.id.whoIsThisTextView);

        //ImageViews
        quizImageView = findViewById(R.id.quizImageView);

        //EditTexts
        answerEditText = findViewById(R.id.answerEditText);

        //Buttons
        btnSubmitAnswer = findViewById(R.id.btnSubmitAnswer);
        btnQuitQuiz = findViewById(R.id.btnQuitQuiz);
        btnRestartQuiz = findViewById(R.id.btnRestartQuiz);

        btnSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnQuitQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnRestartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void loadPicture(){
        int index = new Random().nextInt(quizList.size());
        tempQuizIndex = index;
        quizImageView.setImageBitmap(quizList.get(index).getImage());
    }

    public void answer(View view){
        String dbName = quizList.get(tempQuizIndex).getName();
        if(dbName.toLowerCase().equals(answerEditText.getText().toString().toLowerCase())){
            score++;
        }
    }

    public void updateQuiz(){
        if(!(quizCount == 0)){

        }else{

        }
    }
}
