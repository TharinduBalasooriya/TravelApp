package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Trip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
    }

    public void showToast(View view){

                    Toast toast = Toast.makeText(getApplicationContext(), "Your Trip Profile created Succesfully", Toast.LENGTH_SHORT);
                    toast.show();


            }


}