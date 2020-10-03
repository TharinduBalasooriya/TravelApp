package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FoodorderList extends AppCompatActivity {

    private ListView listView;
    Context context;
    private DBHandler dbHandler;
    private List<OrderModel> cusOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodorder_list);

        context = this;
        dbHandler = new DBHandler(context);

        listView = findViewById(R.id.orderList);
        cusOrders = new ArrayList<>();
        cusOrders = dbHandler.getAllOrders();

        OrderListAdapter adapter = new OrderListAdapter(context,R.layout.single_forder,cusOrders);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                OrderModel order =cusOrders.get(i);
                Intent intent = new Intent(context,UpdateOrder.class);
                intent.putExtra("order",order);
                startActivity(intent);

            }
        });

    }
}