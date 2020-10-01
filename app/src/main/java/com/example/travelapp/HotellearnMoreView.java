package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HotellearnMoreView extends AppCompatActivity {

    ImageView imageView;
    TextView name,des;
    String hname, description;
    int hImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotellearn_more_view);
        imageView = findViewById(R.id.image);
        name = findViewById(R.id.hotelName);
        des = findViewById(R.id.description);
        Intent intent = getIntent();
        hname = intent.getStringExtra("name");
        description = intent.getStringExtra("desc");
        hImage = intent.getIntExtra("image",0);
        name.setText(hname);
        des.setText(description);
        imageView.setImageResource(hImage);
    }
    public void goToBook(View view){
        Intent intent = new Intent(this,hotelBookinForm1.class);
        TextView name = findViewById(R.id.hotelName);
        String hName = name.getText().toString();
        intent.putExtra("hotelName",hName);
        startActivity(intent);

    }
}