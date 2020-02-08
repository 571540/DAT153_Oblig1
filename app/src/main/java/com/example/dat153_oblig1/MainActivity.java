package com.example.dat153_oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ItemsObject> quizList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] images = {R.drawable.donald, R.drawable.cartman, R.drawable.homer, R.drawable.sonic, R.drawable.mario};
        String[] imageName = {"donald trump", "eric cartman", "homer simpson", "sonic", "mario"};

        for(int i = 0; i < images.length; i++){
            ItemsObject itemsObject = new ItemsObject(convertDrawableToBitmap(images[i]), imageName[i]);
            quizList.add(itemsObject);
        }

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

    public Bitmap convertDrawableToBitmap(Integer image){
        Drawable drawable = this.getResources().getDrawable(image);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        return bitmap;
    }


}
