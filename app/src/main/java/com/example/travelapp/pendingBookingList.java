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
        dbHandler = new DBHandler(context);

        listView = findViewById(R.id.pendingBooking);
        cusBookings = new ArrayList<>();
        cusBookings = dbHandler.getAllBookings();

        BookingListAdapter adapter = new BookingListAdapter(context,R.layout.single_booking,cusBookings);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                BookingModel booking =cusBookings.get(i);
                Intent intent = new Intent(context,hotel_booking_preview.class);
                intent.putExtra("book",booking);
                startActivity(intent);

            }
        });
    }
}