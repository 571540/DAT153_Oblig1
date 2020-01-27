package com.example.dat153_oblig1;

public class ItemsObject {

    private byte image;
    private String name;

    public ItemsObject(byte image, String name){
        this.image = image;
        this.name = name;
    }

    public byte getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setImage(byte image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
}
