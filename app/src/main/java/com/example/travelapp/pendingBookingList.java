package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class pendingBookingList extends AppCompatActivity {

    private ListView listView;
    Context context;
    private DBHandler dbHandler;
    private List<BookingModel> cusBookings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_booking_list);

        context = this;
        //create a database class
        dbHandler = new DBHandler(context);

        //get the list view of pending booking inteface
        listView = findViewById(R.id.pendingBooking);
        //create a array list for all bookings in database
        cusBookings = new ArrayList<>();
        //set all bookings in to the array list
        cusBookings = dbHandler.getAllBookings();

        //set bookings to the list view
        BookingListAdapter adapter = new BookingListAdapter(context,R.layout.single_booking,cusBookings);
        listView.setAdapter(adapter);

        //when user clicks on a booking
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //catch the booking model
                //get the i th value from the cus bookings array list
                BookingModel booking =cusBookings.get(i);
                Intent intent = new Intent(context,hotel_booking_preview.class);
                //passing the booking object through intent
                intent.putExtra("book",booking);
                startActivity(intent);

            }
        });
    }
}