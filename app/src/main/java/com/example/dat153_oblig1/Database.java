package com.example.dat153_oblig1;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Database extends AppCompatActivity {

    ListView listView;





    Integer[] images = {R.drawable.donald, R.drawable.cartman, R.drawable.homer, R.drawable.sonic, R.drawable.sonic};
    String[] imageName = {"donald trump", "eric cartman", "homer simpson", "sonic", "mario"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_main_database);

        listView = (ListView) findViewById(R.id.databaseListView);
        ImageAndTextAdapter imageAndTextAdapter = new ImageAndTextAdapter(this, imageName, images);
        listView.setAdapter(imageAndTextAdapter);
    }

    private ArrayList<ItemsObject> populateList(){
        ArrayList<ItemsObject> list = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            ItemsObject itemsObject = new ItemsObject();
            itemsObject.setImage();
        }
    }
}
