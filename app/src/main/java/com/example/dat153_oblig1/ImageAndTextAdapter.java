package com.example.dat153_oblig1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageAndTextAdapter extends ArrayAdapter<String> {

    private String[] imageName;
    private Integer[] images;
    private Activity context;

    public ImageAndTextAdapter(Activity context, String[] imageName, Integer[] images){
        super(context, R.layout.display_database_listview, imageName);

        this.context = context;
        this.images = images;
        this.imageName = imageName;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;
        ViewHolder viewHolder = null;
        if(v == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            v = layoutInflater.inflate(R.layout.display_database_listview, null, true);
            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) v.getTag();
        }
        viewHolder.imageView.setImageResource(images[position]);
        viewHolder.textView.setText(imageName[position]);

        return v;
    }

    class ViewHolder{
        TextView textView;
        ImageView imageView;

        ViewHolder(View v){
            textView = v.findViewById(R.id.databaseImageTextView);
            imageView = v.findViewById(R.id.databaseImageView);
        }
    }
}
