package com.example.dat153_oblig1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageAndTextAdapter extends ArrayAdapter<String> {

    private String[] imageName;
    private Bitmap[] images;
    private Activity context;

    public ImageAndTextAdapter(Activity context, String[] imageName, Bitmap[] images){
        super(context, R.layout.display_database_listview, imageName);
        this.context = context;
        this.images = images;
        this.imageName = imageName;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.display_database_listview, null, true);

        TextView textView = view.findViewById(R.id.databaseTextView);
        ImageView imageView = view.findViewById(R.id.databaseImageView);;

        imageView.setImageBitmap(images[position]);
        textView.setText(imageName[position]);

        return view;
    }
}
