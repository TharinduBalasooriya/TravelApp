package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TripList extends AppCompatActivity {

    private ListView listView;
    Context context;
    private DBHandler dbHandler;
    private List<TripModel> cusTrips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);

        context = this;
        dbHandler = new DBHandler(context);

        listView = findViewById(R.id.tripList);
        cusTrips = new ArrayList<>();
        cusTrips = dbHandler.getAllTrips();

        TripAdapter adapter = new TripAdapter(context,R.layout.single_trip,cusTrips);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TripModel trip = cusTrips.get(i);
                Intent intent = new Intent(context,TripProfile.class);
                Log.d("TRIP",Integer.toString(trip.getId()));
                intent.putExtra("Trip",trip);
                startActivity(intent);

            }
        });
    }
}