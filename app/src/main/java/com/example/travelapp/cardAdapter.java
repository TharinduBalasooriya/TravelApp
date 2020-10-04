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


public class cardAdapter extends ArrayAdapter<cardModel> {

    private Context context;
    private int resource;
    List<cardModel> cards;


    public cardAdapter(@NonNull Context context, int resource, @NonNull List<cardModel> cards) {
        super(context, resource, cards);

        this.context = context;
        this.resource = resource;
        this.cards = cards;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView pID= row.findViewById(R.id.pcardName);



        cardModel card = cards.get(position);
        pID.setText("Card ID : " + card.getId());


        return row;

    }
}
