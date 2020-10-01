package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class hotelBookinForm1 extends AppCompatActivity {
    private TextView hotelName;
    private EditText cusName,cusMail,cusNic,cusMobile;
    private ImageButton add;
    private DBHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_bookin_form1);
        Intent intent = getIntent();
        String message = intent.getStringExtra("hotelName");
        TextView textView = findViewById(R.id.hotelName);
        textView.setText("Book " + message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        hotelName = findViewById(R.id.hotelName);
        cusName = findViewById(R.id.cutomerName);
        cusMail = findViewById(R.id.customerEmail);
        cusNic = findViewById(R.id.customerID);
        cusMobile = findViewById(R.id.customerMobile);
        add = findViewById(R.id.bookNow);
        context = this;
        dbHandler = new DBHandler(context);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hn = hotelName.getText().toString();
                String name = cusName.getText().toString();
                String email = cusMail.getText().toString();
                String nic = cusNic.getText().toString();
                int mobile = Integer.parseInt(cusMobile.getText().toString());
                long started = System.currentTimeMillis();
                BookingModel bookingModel = new BookingModel(name,nic,email,hn,mobile,started,0);
                dbHandler.addBooking(bookingModel);


            }
        });

    }

}