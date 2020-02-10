package com.example.dat153_oblig1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    public static ArrayList<ItemsObject> quizList;
    public List<ItemsObject> quizDatabase;

    private int fullQuizAmount = 0;
    private int currentQuizNumber = 1;
    private int tempQuizIndex = 0;
    private int score = 0;


    private TextView scoreTextView;
    private TextView questionLabelTextView;
    private TextView whoIsThisTextView;

    private ImageView quizImageView;
    private ImageView correctAnswerImageView;
    private ImageView wrongAnswerImageView;

    private EditText answerEditText;

    private Button btnSubmitAnswer;
    private Button btnQuitQuiz;
    private Button btnRestartQuiz;

    private TextView finalResultTextView;
    private TextView finalScoreTextView;
    private TextView correctQuestionAnswersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        quizList = MainActivity.quizList;
        quizDatabase = new ArrayList<>(quizList);

        //TextViews
        scoreTextView = findViewById(R.id.scoreTextView);
        questionLabelTextView = findViewById(R.id.questionLabelTextView);
        whoIsThisTextView = findViewById(R.id.whoIsThisTextView);

        //ImageViews
        quizImageView = findViewById(R.id.quizImageView);
        correctAnswerImageView = findViewById(R.id.correctAnswerImageView);
        wrongAnswerImageView = findViewById(R.id.wrongAnswerImageView);

        //EditTexts
        answerEditText = findViewById(R.id.answerEditText);

        //Buttons
        btnSubmitAnswer = findViewById(R.id.btnSubmitAnswer);
        btnQuitQuiz = findViewById(R.id.btnQuitQuiz);
        btnRestartQuiz = findViewById(R.id.btnRestartQuiz);

        //The quiz is initialized for the first time
        resetQuiz();
    }

    public void resetQuiz(){
        correctAnswerImageView.setVisibility(View.INVISIBLE);
        wrongAnswerImageView.setVisibility(View.INVISIBLE);
        fullQuizAmount = quizList.size();
        currentQuizNumber = 1;
        score = 0;

        if(fullQuizAmount == 0){
            whoIsThisTextView.setTextSize(19);
            whoIsThisTextView.setText("You need at least one picture to play the quiz");
            btnSubmitAnswer.setText("Go To Database");
            btnSubmitAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Quiz.this, Database.class);
                    startActivity(intent);
                }
            });
            btnRestartQuiz.setEnabled(false);
        }else{
            updateQuiz();
        }

        btnQuitQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnRestartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetQuiz();
            }
        });


    }

    public void updateQuiz(){
        correctAnswerImageView.setVisibility(View.INVISIBLE);
        wrongAnswerImageView.setVisibility(View.INVISIBLE);
        questionLabelTextView.setText("Question: " + currentQuizNumber + "/" + fullQuizAmount);
        scoreTextView.setText("Score: " + score);
        loadPicture();
        btnSubmitAnswer.setEnabled(true);
        btnSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerEditText.getText().toString().isEmpty()) {
                    Toast.makeText(Quiz.this, "Please enter something to submit first", Toast.LENGTH_SHORT).show();
                }else{
                    answer();
                    if(currentQuizNumber == fullQuizAmount){
                        quizFinished();
                    }else{
                        currentQuizNumber++;
                        updateQuiz();
                    }
                }
            }
        });
    }

    public void loadPicture(){
        int index = new Random().nextInt(quizDatabase.size());
        tempQuizIndex = index;
        quizImageView.setAlpha(0f);
        quizImageView.setImageBitmap(quizDatabase.get(index).getImage());
        quizImageView.animate().alpha(1).setDuration(1500);
    }

    public void answer(){
        String dbName = quizDatabase.get(tempQuizIndex).getName();
        if(dbName.toLowerCase().equals(answerEditText.getText().toString().toLowerCase())){
            score++;
            correctAnswerImageView.setVisibility(View.VISIBLE);
            quizImageView.animate().alpha(0f).setDuration(3000);
        }else{
            wrongAnswerImageView.setVisibility(View.VISIBLE);
            quizImageView.animate().alpha(0f).setDuration(3000);
        }
        quizDatabase.remove(tempQuizIndex);
        answerEditText.setText("");
    }

    public void quizFinished(){
        setContentView(R.layout.quiz_result);

        //TextViews for final result view
        finalResultTextView = findViewById(R.id.finalResultTextView);
        finalScoreTextView = findViewById(R.id.finalScoreTextView);
        correctQuestionAnswersTextView = findViewById(R.id.correctQuestionAnswersTextView);

        finalScoreTextView.setText("Score: " + score);
        correctQuestionAnswersTextView.setText("You answered " + score + "/" + fullQuizAmount + " questions correct!");

    }
}
