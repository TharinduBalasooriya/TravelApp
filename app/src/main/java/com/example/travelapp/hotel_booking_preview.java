package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class hotel_booking_preview extends AppCompatActivity {
    private BookingModel book;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_booking_preview);
        context = this;
        Intent intent = getIntent();
        book = (BookingModel) intent.getSerializableExtra("book");
        String name = book.getName();
        TextView nameView = findViewById(R.id.bpreName);
        nameView.setText("Name : " + name);
    }
    public void deleteBooking(View view){
        DBHandler db = new DBHandler(context);
        db.deleteBooking(book.getId());
        startActivity(new Intent(context,pendingBookingList.class));
    }
}