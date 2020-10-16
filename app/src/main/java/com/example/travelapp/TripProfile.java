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
        date = findViewById(R.id.upTripDate);
        time = findViewById(R.id.upTripTime);
        paticipent = findViewById(R.id.upTripNumb);


        // set text in trip profile view
        tripID.setText("ID : " + trip.getId());
        place.setText(trip.getPlace());
        date.setText(trip.getDate());
        time.setText(trip.getTime());
        paticipent.setText(trip.getNumber());



    }

    public void deleteTrip(View view){
        db.deleteTrip(trip.getId());
        startActivity(new Intent(context,my_deals.class));
    }

    //when user clicks on update button
    public void UpdateTrip(View view){
        TripModel tr = new TripModel(trip.getId(),place.getText().toString(),date.getText().toString(),
                date.getText().toString(),time.getText().toString(),0,0
        );
        int s = db.updateTrp(tr);
        startActivity(new Intent(context,my_deals.class));

    }
}