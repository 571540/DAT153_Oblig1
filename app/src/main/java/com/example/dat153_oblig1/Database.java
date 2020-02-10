package com.example.dat153_oblig1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Database extends AppCompatActivity {

    public static ArrayList<ItemsObject> mainList;

    private ListView databaseListView;
    private Button btnAdd;
    private ImageAndTextAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_listview);
        mainList = MainActivity.quizList;
        btnAdd = findViewById(R.id.btnAdd);
        databaseListView = findViewById(R.id.databaseListView);
        adapter = new ImageAndTextAdapter();
        databaseListView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Database.this, Add.class);
                startActivity(intent);
            }
        });
    }

    class ImageAndTextAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mainList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent){
            View view = getLayoutInflater().inflate(R.layout.database_adapter, null);

            TextView textView = view.findViewById(R.id.databaseTextView);
            ImageView imageView = view.findViewById(R.id.databaseImageView);
            ImageButton imageButton = view.findViewById(R.id.databaseImageButton);

            imageView.setImageBitmap(mainList.get(position).getImage());
            textView.setText(mainList.get(position).getName());
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Database.this, mainList.get(position).getName() + " was deleted from database", Toast.LENGTH_SHORT).show();
                    mainList.remove(position);
                    notifyDataSetChanged();
                }
            });

            return view;
        }
    }
}
