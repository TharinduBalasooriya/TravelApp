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
    private EditText hotelName;
    private EditText cusName,cusMail,cusNic,cusMobile,cusCheckIn,cusCheckOut,cusNumberOfPerson,hPrice,hDisc;
    private ImageButton add;
    private DBHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_bookin_form1);
        Intent intent = getIntent();
        String message = intent.getStringExtra("hotelName");
        String hp = intent.getStringExtra("hotelPrice");
        String dc = intent.getStringExtra("hotelDiscount");
        //set hotel name
        EditText textView = findViewById(R.id.hotelName);
        textView.setText(message);
        //catch hotel price
        EditText price = findViewById(R.id.frmPrice);
        price.setText(hp);
        //catch hotel discount

        EditText discount = findViewById(R.id.frmDis);
        discount.setText(dc);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        hotelName = findViewById(R.id.hotelName);
        cusName = findViewById(R.id.cutomerName);
        cusMail = findViewById(R.id.customerEmail);
        cusNic = findViewById(R.id.customerID);
        cusMobile = findViewById(R.id.customerMobile);
        cusCheckIn = findViewById(R.id.frmCheckIn);
        cusCheckOut = findViewById(R.id.frmCheckOut);
        cusNumberOfPerson = findViewById(R.id.personNumber);
        hPrice = findViewById(R.id.frmPrice);
        hDisc = findViewById(R.id.frmDis);
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
                String checkIn = cusCheckIn.getText().toString();
                String checkout = cusCheckOut.getText().toString();
                int personCount = Integer.parseInt(cusNumberOfPerson.getText().toString());
                int hotelPrice = Integer.parseInt(hPrice.getText().toString());
                int hotelDiscount = Integer.parseInt(hDisc.getText().toString());
                int mobile = Integer.parseInt(cusMobile.getText().toString());

                long started = System.currentTimeMillis();
                BookingModel bookingModel = new BookingModel(name,nic,email,hn,mobile,started,0,hotelPrice,hotelDiscount,checkIn,checkout,personCount);
                dbHandler.addBooking(bookingModel);

                startActivity(new Intent(context,pendingBookingList.class));


            }
        });

    }

}