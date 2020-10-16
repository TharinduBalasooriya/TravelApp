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

        //catch the booking object
        book = (BookingModel) intent.getSerializableExtra("book");

        //set values
        String name = book.getName();
        TextView nameView = findViewById(R.id.bpreName);
        nameView.setText("Name : " + name);

        TextView idView = findViewById(R.id.bpreID);
        idView.setText("Customer ID : " + book.getNic());

        TextView mobView = findViewById(R.id.bpreMobile);
        mobView.setText("MObile : " + book.getMobile());

        TextView mailView = findViewById(R.id.bpreMail);
        mailView.setText("Email : " + book.getEmail());

        TextView hNameView = findViewById(R.id.bpreHotelName);
        hNameView.setText("Hotel: " + book.gethName());

        TextView checkinView = findViewById(R.id.bpreCheckIn);
        checkinView.setText("Check In : " + book.getCheckIn());

        TextView checkoutView = findViewById(R.id.bpreCheckOut);
        checkoutView.setText("Check Out : " + book.getCheckOut());

        TextView personCountView = findViewById(R.id.bprenumberOfPersons);
        personCountView.setText("Number of Persons : " + book.getPersonCount());

        TextView bookPrice = findViewById(R.id.bprePrice);
        bookPrice.setText("Price for one person : " + book.getPrice() + "LKR");

        TextView booktotPrice = findViewById(R.id.bpreTotPrice);
        booktotPrice.setText("Total  : " + book.getTotPrice() + "LKR");

        TextView discountRate = findViewById(R.id.bpreDiscountR);
        discountRate.setText("Discount Rate : " + book.getDiscount() + " %");

        TextView discountPrice = findViewById(R.id.bpreDiscountVal);
        discountPrice.setText("Discount Value  : " + book.getDiscountPrice());

        TextView finalPrice = findViewById(R.id.bpreFinalPrice);
        finalPrice.setText("Final Value : " + book.getFinalPrice());



    }

    //delete booking
    public void deleteBooking(View view){

        DBHandler db = new DBHandler(context);
        //calling delete booking class in DB handler class
        db.deleteBooking(book.getId());
        Toast.makeText(context, "Your booking has been canceled", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(context,pendingBookingList.class)); // navigate back to pending booking list
    }

    //passing data to update from
    public void goToUpdate(View view){


        Intent intent = new Intent(context,Update_Booking.class);
        //passing the booking object
        intent.putExtra("BOOKING",book);
        startActivity(intent);//go to update booking class

    }
}