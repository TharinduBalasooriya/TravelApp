package com.example.travelapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HotelList extends AppCompatActivity {
    RecyclerView recyclerView;
    List<HotelModel> main_list;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);
        main_list = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        main_list.add(new HotelModel(R.drawable.asset_1,"hotel 1","description 1"));
        main_list.add(new HotelModel(R.drawable.asset_2,"hotel 1","description 1"));
        main_list.add(new HotelModel(R.drawable.asset_3,"hotel 1","description 1"));
        main_list.add(new HotelModel(R.drawable.asset_1,"hotel 1","description 1"));
        main_list.add(new HotelModel(R.drawable.asset_2,"hotel 1","description 1"));
        main_list.add(new HotelModel(R.drawable.asset_3,"hotel 1","description 1"));
        main_list.add(new HotelModel(R.drawable.asset_1,"hotel 1","description 1"));
        main_list.add(new HotelModel(R.drawable.asset_2,"hotel 1","description 1"));
        main_list.add(new HotelModel(R.drawable.asset_3,"hotel 1","description 1"));

        adapter = new HotelAdapter(main_list,this);
        recyclerView.setAdapter(adapter);
    }
}