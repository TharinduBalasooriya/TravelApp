package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HotellearnMoreView extends AppCompatActivity {

    ImageView imageView;
    TextView name,des,pr,dc;
    String hname, description;
    int hImage,price,discount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotellearn_more_view);
        imageView = findViewById(R.id.image);
        name = findViewById(R.id.hotelName);
        des = findViewById(R.id.description);
        pr = findViewById(R.id.lrnPrice);
        dc = findViewById(R.id.lrndisc);
        Intent intent = getIntent();
        hname = intent.getStringExtra("name");
        description = intent.getStringExtra("desc");
        hImage = intent.getIntExtra("image",0);
        price = intent.getIntExtra("price",0);
        discount = intent.getIntExtra("disc",0);
        name.setText(hname);
        des.setText(description);
        imageView.setImageResource(hImage);
        pr.setText(Integer.toString(price));
        dc.setText(Integer.toString(discount));
    }
    public void goToBook(View view){
        Intent intent = new Intent(this,hotelBookinForm1.class);
        TextView name = findViewById(R.id.hotelName);
        TextView price = findViewById(R.id.lrnPrice);
        TextView discount = findViewById(R.id.lrndisc);
        String hName = name.getText().toString();
        String hPrice = price.getText().toString();
        String hDiscount = discount.getText().toString();
        intent.putExtra("hotelName",hName);
        intent.putExtra("hotelPrice",hPrice);
        intent.putExtra("hotelDiscount",hDiscount);

        startActivity(intent);

    }
}