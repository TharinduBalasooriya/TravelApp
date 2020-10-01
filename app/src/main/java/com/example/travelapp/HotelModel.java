package com.example.travelapp;

public class HotelModel {
    int image;
    String hotel_name,description;

    public HotelModel(int image, String hotel_name, String description) {
        this.image = image;
        this.hotel_name = hotel_name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
