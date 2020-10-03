package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Update_Booking extends AppCompatActivity {

    private EditText hotelName;
    private EditText cusName,cusMail,cusNic,cusMobile,cusCheckIn,cusCheckOut,cusNumberOfPerson,hPrice,hDisc;
    private BookingModel book ;
    private Context context;
    private  DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__booking);
        Intent intent = getIntent();
        book = (BookingModel) intent.getSerializableExtra("BOOKING");

        context = this;

        hotelName = findViewById(R.id.uphotelName);
        cusName = findViewById(R.id.upcutomerName);
        cusMail = findViewById(R.id.upcustomerEmail);
        cusNic = findViewById(R.id.upcustomerID);
        cusMobile = findViewById(R.id.upcustomerMobile);
        cusCheckIn = findViewById(R.id.upfrmCheckIn);
        cusCheckOut = findViewById(R.id.upfrmCheckOut);
        cusNumberOfPerson = findViewById(R.id.uppersonNumber);
        hPrice = findViewById(R.id.upfrmPrice);
        hDisc = findViewById(R.id.upfrmDis);

        hotelName.setText(book.gethName());
        cusName.setText(book.getName());
        cusMail.setText(book.getEmail());
        cusNic.setText(book.getNic());
        cusMobile.setText(Integer.toString(book.getMobile()));
        cusCheckIn.setText(book.getCheckIn());
        cusCheckOut.setText(book.getCheckOut());
        cusNumberOfPerson.setText(Integer.toString(book.getPersonCount()));
        hPrice.setText(Integer.toString(book.getPrice()));
        hDisc.setText(Integer.toString(book.getDiscount()));
        db = new DBHandler(context);


    }
    public void updateBookingNow(View view){
        int id = book.getId();
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
        BookingModel bookingModel = new BookingModel(id,name,nic,email,hn,mobile,started,0,hotelPrice,hotelDiscount,checkIn,checkout,personCount);
        int state = db.updateSingleBooking(bookingModel);
        System.out.println(state);

        Intent intent = new Intent(context,pendingBookingList.class);
        startActivity(intent);



    }

}