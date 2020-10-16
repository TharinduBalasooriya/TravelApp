package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateOrder extends AppCompatActivity {
    private OrderModel order;
    private Context context;
    EditText name,mobile,q1,q2,q3;
    DBHandler db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_order);

        context = this;
        db = new  DBHandler(context);
        Intent intent = getIntent();

        //catching the order object
        order = (OrderModel) intent.getSerializableExtra("order");

        name = findViewById(R.id.uporderCusName);
        mobile = findViewById(R.id.uporderCusMobile);
        q1 = findViewById(R.id.uporderKottu);
        q2 = findViewById(R.id.uporderFriedRice);
        q3 = findViewById(R.id.uporderCoc);

        //set the deatils into the view

        name.setText(order.getCusName());
        mobile.setText(order.getCusMobile());
        q1.setText(Integer.toString(order.getItem1q()));
        q2.setText(Integer.toString(order.getItemq2()));
        q3.setText(Integer.toString(order.getItemq3()));

    }

    public void delOrder(View view){
        db.deleteOrder(order.getId());
        startActivity(new Intent(context,my_deals.class));

    }
    public void updateOrder(View view){
        int id = order.getId();
        String cuname = name.getText().toString();
        String cumobile = mobile.getText().toString();
        int cq1 = Integer.parseInt(q1.getText().toString());
        int cq2 = Integer.parseInt(q2.getText().toString());
        int cq3 = Integer.parseInt(q3.getText().toString());
        
        //create model with updated values
        OrderModel uporder = new OrderModel(id,cuname,cumobile,cq1,cq2,cq3);

        int s = db.updateOrder(uporder);

        startActivity(new Intent(context,my_deals.class));
        Toast.makeText(context, "Order update succssfully", Toast.LENGTH_SHORT).show();

    }
}