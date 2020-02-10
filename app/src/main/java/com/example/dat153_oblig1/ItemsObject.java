package com.example.dat153_oblig1;

import android.graphics.Bitmap;

public class ItemsObject {

    private Bitmap image;
    private String name;

    public ItemsObject(Bitmap image, String name){
        this.image = image;
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
}
