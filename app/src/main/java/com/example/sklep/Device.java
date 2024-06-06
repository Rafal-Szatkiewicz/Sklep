package com.example.sklep;

public class Device {
    private int imageResId;
    private String description;

    public Device(int imageResId, String description) {
        this.imageResId = imageResId;
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }
}
