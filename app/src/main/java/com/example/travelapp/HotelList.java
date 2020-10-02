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

        main_list.add(new HotelModel(R.drawable.asset_1,"Heritance Kandalama","Heritance Kandalama; located at an aesthetic location with views of the magnificent rock fortress & the Kandalama Lake, makes it one of the most popular ..",2500,10));
        main_list.add(new HotelModel(R.drawable.asset_2,"Cinnamon Citadel","description 1",3000,20));
        main_list.add(new HotelModel(R.drawable.asset_3,"Sundaras Resort & Spa","description 1",1000,30));
        main_list.add(new HotelModel(R.drawable.asset_1,"Aswadduma Hotel","description 1",1500,40));
        main_list.add(new HotelModel(R.drawable.asset_2,"Hunas falls","description 1",1800,30));
        main_list.add(new HotelModel(R.drawable.asset_3,"Jetwing vil uyana","description 1",2000,50));
        main_list.add(new HotelModel(R.drawable.asset_1,"Amaya Lake","description 1",2500,10));
        main_list.add(new HotelModel(R.drawable.asset_2,"Habarana village by cinnamon","description 1",2500,10));
        main_list.add(new HotelModel(R.drawable.asset_3,"Roo Mansala Boutique Villa","description 1",2500,10));

        adapter = new HotelAdapter(main_list,this);
        recyclerView.setAdapter(adapter);
    }
}