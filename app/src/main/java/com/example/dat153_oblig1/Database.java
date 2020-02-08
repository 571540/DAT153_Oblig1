package com.example.dat153_oblig1;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Database extends AppCompatActivity {

    ListView databaseListView;
    ArrayList<ItemsObject> mainList;
    String[] imageName;
    Bitmap[] images;
    ItemsObject itemsObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_database_image_adapter);

        mainList = MainActivity.quizList;

        databaseListView = (ListView) findViewById(R.id.databaseListView);
        ImageAndTextAdapter imageAndTextAdapter = new ImageAndTextAdapter(this, imageName, images);
        databaseListView.setAdapter(imageAndTextAdapter);

        databaseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });

        databaseListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return false;
            }
        });
    }
}
