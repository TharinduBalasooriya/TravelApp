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


    public class TripAdapter extends ArrayAdapter<TripModel> {

        private Context context;
        private int resource;
        List<TripModel> trips;


        public TripAdapter(@NonNull Context context, int resource, @NonNull List<TripModel> trips) {
            super(context, resource, trips);

            this.context = context;
            this.resource = resource;
            this.trips = trips;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View row = inflater.inflate(resource,parent,false);

            TextView tripID= row.findViewById(R.id.singleTripID);



            TripModel order = trips.get(position);
            tripID.setText("Trip ID : " + order.getId());


            return row;

        }
}
