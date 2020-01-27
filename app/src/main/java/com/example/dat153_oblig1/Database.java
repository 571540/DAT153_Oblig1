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

    private ArrayList<ItemsObject> initList(){
        ArrayList<ItemsObject> list = new ArrayList<>();
        Integer[] images = {R.drawable.donald, R.drawable.cartman, R.drawable.homer, R.drawable.sonic, R.drawable.mario};
        String[] imageName = {"donald trump", "eric cartman", "homer simpson", "sonic", "mario"};

        for(int i = 0; i < images.length; i++){
            ItemsObject itemsObject = new ItemsObject(convertDrawableToBitmap(images[i]), imageName[i]);
            list.add(itemsObject);
        }
        return list;
    }

    public Bitmap convertDrawableToBitmap(Integer image){
        Drawable drawable = this.getResources().getDrawable(image);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        return bitmap;
    }


}
