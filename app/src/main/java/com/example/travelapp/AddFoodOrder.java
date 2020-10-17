package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddFoodOrder extends AppCompatActivity {
    private  Button add;
    private Context context;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_order);

        final TextView cusName =  findViewById(R.id.orderCusName);
        final TextView cusMob = findViewById(R.id.orderCusMobile);
        final TextView q1 = findViewById(R.id.orderKottu);
        final TextView q2 = findViewById(R.id.orderFriedRice);
        final TextView q3 = findViewById(R.id.orderCoc);
        add = (Button) findViewById(R.id.addOrder);

        context = this;
        dbHandler =  new DBHandler(context);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = cusName.getText().toString();
                String mob = cusMob.getText().toString();
                String f1 = q1.getText().toString();
                String f2 = q2.getText().toString();
                String f3 = q3.getText().toString();

                if(name.length() == 0){
                    cusName.requestFocus();
                    cusName.setError("enter your name");
                }else if (mob.length() == 0){
                    cusMob.requestFocus();
                    cusMob.setError("Enter your mobile number");
                }else{

                    //creating a model for orders
                    // pass the set data to model order
                    OrderModel myorder = new OrderModel(name,mob,Integer.parseInt(f1),Integer.parseInt(f2),Integer.parseInt(f3));
                    dbHandler.adddOrder(myorder);
                    Toast.makeText(context, "Order Add Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context,MainActivity.class));

                }


            }
        });





    }

}