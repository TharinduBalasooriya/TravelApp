package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToHotel(View view){
        Intent intent = new Intent(this,HotelList.class);
        startActivity(intent);

    }
    public void goMyDeals(View view){
        Intent intent = new Intent(this,my_deals.class);
        startActivity(intent);

    }
}