package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Trip extends AppCompatActivity {


    private EditText id,place,t_date,time,no_ofp;
    private Button create;
    private DBHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        id = findViewById(R.id.tid);
        place = findViewById(R.id.editTextTextPersonName3);
        t_date = findViewById(R.id.editTextTextPersonName4);
        time = findViewById(R.id.editTextTextPersonName5);
        no_ofp = findViewById(R.id.editTextTextPersonName6);
        create = findViewById(R.id.button_create);

        context = this;

        //create data base object
        dbHandler = new DBHandler(context);




        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //catch user inputs
                String place_s = place.getText().toString();
                String date_s = t_date.getText().toString();
                String time_s = time.getText().toString();
                String nop_s = no_ofp.getText().toString();
                long started = System.currentTimeMillis();

                //validations
                //validate place
                if(place_s.length() == 0){
                    place.requestFocus();
                    place.setError("please fill this");
                }
                //validate date
                else if(date_s.length() == 0){
                    t_date.requestFocus();
                    t_date.setError("enter date");
                }
                //if there is no invalid data
                else{
                    //create a trip model object
                    //save user inputs through constructor
                    TripModel tripmodel = new TripModel(place_s, date_s, time_s, nop_s, started, 0);

                    //passing trip model object to addTrip function
                    dbHandler.addTrip(tripmodel);

                    Toast.makeText(context, "Your Trip Profile created Succesfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context,MainActivity.class));

                }

            }
        });



    }

}