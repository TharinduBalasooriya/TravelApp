package com.example.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class OrderListAdapter extends ArrayAdapter<OrderModel> {

    private Context context;
    private int resource;
    List<OrderModel> orders;


    public OrderListAdapter(@NonNull Context context, int resource, @NonNull List<OrderModel> orders) {
        super(context, resource, orders);

        this.context = context;
        this.resource = resource;
        this.orders = orders;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView orderName= row.findViewById(R.id.singleOrderName);
        TextView orderPrice = row.findViewById(R.id.singleOrderPrice);


        OrderModel order = orders.get(position);
        orderName.setText("Order Number : " + order.getId() );
        orderPrice.setText("Order Price : " + order.getTotPrice());


        return row;

    }
}
