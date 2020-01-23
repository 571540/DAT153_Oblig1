package com.example.dat153_oblig1;

public class QuizEntity {

    int id;
    String fullName;
    byte[] image;

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public byte[] getImage() {
        return image;
    }
}
