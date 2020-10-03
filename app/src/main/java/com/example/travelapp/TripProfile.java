package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TripProfile extends AppCompatActivity {

    private TripModel trip;
    private Context context;
    DBHandler db ;
    TextView tripID;
    EditText place,date,time,paticipent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_profile);
        context = this;
        db = new  DBHandler(context);

        Intent intent = getIntent();
        trip = (TripModel) intent.getSerializableExtra("Trip");

        tripID = findViewById(R.id.upTripid);
        place = findViewById(R.id.upTripPlace);
        date = findViewById(R.id.upTripPlace);
        time = findViewById(R.id.upTripTime);
        paticipent = findViewById(R.id.upTripNumb);



        tripID.setText("ID : " + trip.getId());
        place.setText(trip.getPlace());
        date.setText(trip.getDate());
        time.setText(trip.getTime());
        paticipent.setText(trip.getTime());



    }

    public void deleteTrip(View view){
        db.deleteTrip(trip.getId());
        startActivity(new Intent(context,my_deals.class));
    }

    public void UpdateTrip(View view){
        TripModel tr = new TripModel(trip.getId(),trip.getPlace().toString(),trip.getDate().toString(),
                trip.getTime().toString(),trip.getNumber().toString(),0,0
        );
        int s = db.updateTrp(tr);
        startActivity(new Intent(context,my_deals.class));

    }
}