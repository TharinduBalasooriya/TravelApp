package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hotelBookinForm1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText hotelName;
    private EditText cusName,cusMail,cusNic,cusMobile,cusNumberOfPerson,hPrice,hDisc;
    private EditText cusCheckIn,cusCheckOut;
    private ImageButton add;
    private DBHandler dbHandler;
    private Context context;
    private String hn,name,email,nic,checkIn,checkout;
    private int personCount ,mobile;
    private int dateID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_bookin_form1);
        Intent intent = getIntent();
        //get hotel name
        String message = intent.getStringExtra("hotelName");
        //get hotel price
        String hp = intent.getStringExtra("hotelPrice");
        //get hotel discount
        String dc = intent.getStringExtra("hotelDiscount");
        //set hotel name
        EditText textView = findViewById(R.id.hotelName);
        textView.setText(message);
        //set hotel price
        EditText price = findViewById(R.id.frmPrice);
        price.setText(hp);
        //set hotel discount
        EditText discount = findViewById(R.id.frmDis);
        discount.setText(dc);

        //toast message of hotel name
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        //catching view
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
        //creating object of db handler class
        dbHandler = new DBHandler(context);

        //on click listener to get calender view for check in date
        cusCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateID = 1;
                getDateCalender();
            }
        });

        //on click listener to get calender view for check out date
        cusCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateID = 2;
                getDateCalender();
            }
        });


        //on click listener to request a booking
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //catching booking details
                 hn = hotelName.getText().toString();//hotel name
                 name = cusName.getText().toString();//customer name
                 email = cusMail.getText().toString();//customer email
                 nic = cusNic.getText().toString();//customer nid
                 checkIn = cusCheckIn.getText().toString();//check in date
                 checkout = cusCheckOut.getText().toString();//check out date
                try{
                    //get number of persons
                    personCount = Integer.parseInt(cusNumberOfPerson.getText().toString());
                }catch (NumberFormatException e){
                    personCount = 0;
                }

                 try{
                     //get customer mobile number
                     mobile = Integer.parseInt(cusMobile.getText().toString());
                 }catch (NumberFormatException e){
                   mobile = 0;
                 }

                 //converting hotel price and discount
                 int hotelPrice = Integer.parseInt(hPrice.getText().toString());
                 int hotelDiscount = Integer.parseInt(hDisc.getText().toString());
                 long started = System.currentTimeMillis();

                //form validations

                if(name.length() == 0){
                    //if customer name is empty
                    cusName.requestFocus();
                    cusName.setError("please enter your namw");
                }else if(email.length() == 0){
                    //if customer email is empty
                        cusMail.requestFocus();
                        cusMail.setError("please enter your email");

                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        //check email address pattern
                        cusMail.requestFocus();
                        cusMail.setError("Invalid email address");
                }else if(nic.length() == 0){
                    //check nic
                    cusNic.requestFocus();
                    cusNic.setError("please enter your email address");
                }else if(checkIn.length() == 0){
                    //check check in date empty or not
                    cusCheckIn.requestFocus();
                    cusCheckIn.setError("please fill this section");
                }else if(checkout.length() == 0){

                    //check check in date empty or not
                    cusCheckOut.requestFocus();
                    cusCheckOut.setError("please fill this section");

                }
                //check date patterns
                else if(!matchDatePattern(checkIn,checkout)){
                    cusCheckIn.requestFocus();
                    cusCheckIn.setError("invalid pattern , please enter dd/MM/yyyy");
                    cusCheckOut.requestFocus();
                    cusCheckOut.setError("invalid pattern , please enter dd/MM/yyyy");
                }
                //check difference bet ween check in date and check out dates
                else if(!(getDateDif(checkIn,checkout) > 0)){
                    cusCheckOut.requestFocus();
                    //cusCheckOut.setText("");
                    cusCheckOut.setError("checkout date is smaller than check in date");
                    //cusCheckOut.setError("");
                }
                // check personal count
                else if(!(personCount >0)){
                    cusNumberOfPerson.requestFocus();
                    cusNumberOfPerson.setError("Number of persons should be larger than zero");
                }
                //check mobile number
                else if(!(mobile >0)){
                    cusMobile.requestFocus();
                    cusMobile.setError("Invalid mobile number");
                }
                //if there is no invalid data
                else{
                    // creating a booking object from Booking model class
                    //set data to booking model
                    BookingModel bookingModel = new BookingModel(name,nic,email,hn,mobile,started,0,hotelPrice,hotelDiscount,checkIn,checkout,personCount);
                    //calling addBooking method in Db handler class
                    dbHandler.addBooking(bookingModel);
                    Toast.makeText(context, "Booking added successfully", Toast.LENGTH_SHORT).show();

                    //navigate back to the main activity
                    startActivity(new Intent(context,MainActivity.class));
                }




            }
        });




    }

    public void getDateCalender(){

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        if(dateID == 1){
            cusCheckIn.setText(i2 + "/" +i1 + "/" +i);
        }else if(dateID ==2){
            cusCheckOut.setText(i2 + "/" +i1 + "/" +i);
        }

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