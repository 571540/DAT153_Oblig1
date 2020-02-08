package com.example.dat153_oblig1;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Add extends AppCompatActivity {

    String currentPhotoPath;
    ImageView imageView;
    Bitmap imageBitmap;
    EditText fullName;
    ArrayList<ItemsObject> addToDatabase = MainActivity.quizList;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int PERMISSION_CODE = 1001;
    static final int IMAGE_PICK_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_main_add);

        Button btnCamera = findViewById(R.id.btnTakePicture);
        Button btnSavePicture = findViewById(R.id.btnSavePicture);
        Button btnShowPictures = findViewById(R.id.btnShowPictures);

        imageView = findViewById(R.id.pictureImageView);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                }
                takePicture();
            }
        });

        btnSavePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePictureToDatabase(v);
                galleryAddPic();
            }
        });

        btnShowPictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        String[] permissons = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissons, PERMISSION_CODE);
                    }else{
                        pickImageFromGallary();
                    }
                }else{
                    pickImageFromGallary();
                }
            }
        });
    }

    private void pickImageFromGallary(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallary();
                }else{
                    Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void takePicture(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }else{
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Taking picture using camera
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            if(imageBitmap != null){
                imageView.setImageBitmap(imageBitmap);
            }else{
                Toast.makeText(this, "Bitmap is null", Toast.LENGTH_SHORT).show();
            }
        }

        //Picking image from gallary
        if(requestCode == IMAGE_PICK_CODE && resultCode == RESULT_OK){
            Uri selectedImage = data.getData();
            Bitmap imageBitmap = null;
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageView.setImageBitmap(imageBitmap);
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(currentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    public void savePictureToDatabase(View view){
        fullName = findViewById(R.id.fullNameEditText);
        if(fullName.getText().toString().isEmpty() || imageBitmap == null){
            Toast.makeText(this, "Data is missing, can't save", Toast.LENGTH_SHORT).show();
        }else{
            BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            addToDatabase.add(new ItemsObject(bitmap, fullName.getText().toString()));
            Toast.makeText(this, "Item was stored to the database", Toast.LENGTH_SHORT).show();
        }
    }

}
