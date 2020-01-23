package com.example.dat153_oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnDatabase = findViewById(R.id.btnDatabase);
        Button btnQuiz = findViewById(R.id.btnQuiz);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAdd();
            }
        });

        btnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDatabase();
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickQuiz();
            }
        });
    }

    public void onClickAdd(){
        Intent intent = new Intent(this, Add.class);
        startActivity(intent);
    }

    public void onClickDatabase(){
        Intent intent = new Intent(this, Database.class);
        startActivity(intent);
    }

    public void onClickQuiz(){
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }


}
