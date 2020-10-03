package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class my_deals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_deals);
    }

    public void goToBookingList(View view){
        Intent intent = new Intent(this,pendingBookingList.class);
        startActivity(intent);

    }

    public void goToFoodOrderList(View view){
        Intent intent = new Intent(this,FoodorderList.class);
        startActivity(intent);
    }
}