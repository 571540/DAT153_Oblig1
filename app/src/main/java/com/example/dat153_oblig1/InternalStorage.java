package com.example.dat153_oblig1;

import android.app.Application;
import android.graphics.Bitmap;

import java.util.ArrayList;

public class InternalStorage extends Application {

    private ArrayList<ItemsObject> fullList = new ArrayList<ItemsObject>();

    public ArrayList<ItemsObject> getFullList() {
        return fullList;
    }

    public void addItem(ItemsObject itemsObject){
        fullList.add(itemsObject);
    }

    public boolean removeItem(ItemsObject itemsObject){
        return this.fullList.remove(itemsObject);
    }

    public ItemsObject getItem(Bitmap bitmapImage){
        for(int i = 0; i < fullList.size(); i++){
            if(fullList.get(i).getImage() == bitmapImage){
                return fullList.get(i);
            }
        }
        return null;
    }
}
