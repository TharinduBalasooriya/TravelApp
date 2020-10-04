package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hotelBookinForm1 extends AppCompatActivity {
    private EditText hotelName;
    private EditText cusName,cusMail,cusNic,cusMobile,cusCheckIn,cusCheckOut,cusNumberOfPerson,hPrice,hDisc;
    private ImageButton add;
    private DBHandler dbHandler;
    private Context context;
    private String hn,name,email,nic,checkIn,checkout;
    private int personCount ,mobile;
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
                 hn = hotelName.getText().toString();
                 name = cusName.getText().toString();
                 email = cusMail.getText().toString();
                 nic = cusNic.getText().toString();
                 checkIn = cusCheckIn.getText().toString();
                 checkout = cusCheckOut.getText().toString();
                try{
                     personCount = Integer.parseInt(cusNumberOfPerson.getText().toString());
                }catch (NumberFormatException e){
                    personCount = 0;
                }

                 try{
                     mobile = Integer.parseInt(cusMobile.getText().toString());
                 }catch (NumberFormatException e){
                   mobile = 0;
                 }
                 int hotelPrice = Integer.parseInt(hPrice.getText().toString());
                 int hotelDiscount = Integer.parseInt(hDisc.getText().toString());


                long started = System.currentTimeMillis();


                if(name.length() == 0){
                    cusName.requestFocus();
                    cusName.setError("please enter your namw");
                }else if(email.length() == 0){
                        cusMail.requestFocus();
                        cusMail.setError("please enter your email");

                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        cusMail.requestFocus();
                        cusMail.setError("Invalid email address");
                }else if(nic.length() == 0){
                    cusNic.requestFocus();
                    cusNic.setError("please enter your email address");
                }else if(checkIn.length() == 0){
                    cusCheckIn.requestFocus();
                    cusCheckIn.setError("please fill this section");
                }else if(checkout.length() == 0){
                    cusCheckOut.requestFocus();
                    cusCheckOut.setError("please fill this section");

                }else if(!matchDatePattern(checkIn,checkout)){
                    cusCheckIn.requestFocus();
                    cusCheckIn.setError("invalid pattern , please enter dd/MM/yyyy");
                    cusCheckOut.requestFocus();
                    cusCheckOut.setError("invalid pattern , please enter dd/MM/yyyy");
                }else if(!(getDateDif(checkIn,checkout) > 0)){
                    cusCheckOut.requestFocus();
                    cusCheckOut.setError("checkout date should be larger than check in date");
                }else if(!(personCount >0)){
                    cusNumberOfPerson.requestFocus();
                    cusNumberOfPerson.setError("Number of persons should be larger than zero");
                }else if(!(mobile >0)){
                    cusMobile.requestFocus();
                    cusMobile.setError("Invalid mobile number");
                }
                else{
                    BookingModel bookingModel = new BookingModel(name,nic,email,hn,mobile,started,0,hotelPrice,hotelDiscount,checkIn,checkout,personCount);
                    dbHandler.addBooking(bookingModel);
                    Toast.makeText(context, "Booking added successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context,MainActivity.class));
                }




            }
        });




    }
    public boolean matchDatePattern (String cid,String coud){
        String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);


        Matcher matcher1 = pattern.matcher(cid);
        Matcher matcher2 = pattern.matcher(coud);

        if(matcher1.matches() && matcher2.matches()){
           return true;
        }else{
            return  false;
        }
    }
    public float getDateDif( String cid, String cod){
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateBeforeString = cid;
        String dateAfterString = cod;
        float daysBetween = 0;
        try {
            Date dateBefore = myFormat.parse(dateBeforeString);
            Date dateAfter = myFormat.parse(dateAfterString);
            long difference = dateAfter.getTime() - dateBefore.getTime();
            daysBetween = (difference / (1000*60*60*24));
            /* You can also convert the milliseconds to days using this method
             * float daysBetween =
             *         TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)
             */


        } catch (Exception e) {
            e.printStackTrace();
        }
        return daysBetween;
    }





}