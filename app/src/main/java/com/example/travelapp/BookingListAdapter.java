package com.example.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookingListAdapter extends ArrayAdapter<BookingModel> {

    private Context context;
    private int resource;
    List<BookingModel> bookings;


    public BookingListAdapter(@NonNull Context context, int resource, @NonNull List<BookingModel> bookings) {
        super(context, resource, bookings);

        this.context = context;
        this.resource = resource;
        this.bookings = bookings;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView bookingID = row.findViewById(R.id.bookingID);
        TextView bookingDate = row.findViewById(R.id.bookingDate);
        TextView hotelName = row.findViewById(R.id.bookingHname);

        BookingModel book = bookings.get(position);
        bookingID.setText("Booking ID :B " + book.getId());
        bookingDate.setText(Integer.toString(book.getMobile()));
        hotelName.setText(book.gethName());

        return row;

    }
}
