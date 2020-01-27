package com.example.dat153_oblig1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;

public class DataConverter {

    public static byte[] convertImageToByteArray(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, stream);
        return stream.toByteArray();
    }

    public static Bitmap convertByteArrayToImage(byte[] array){
        return BitmapFactory.decodeByteArray(array, 0, array.length);
    }

    public static byte[] convertDrawableToByteArray(Drawable drawable){
        Resources res = get
        Drawable d = res.getDrawable(drawable);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }
}
