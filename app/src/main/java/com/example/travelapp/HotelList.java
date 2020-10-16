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
        //creating a array list to save hotels
        main_list = new ArrayList<>();

        //catch the recycler view on hotel list
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //add hotel details to array list
        main_list.add(new HotelModel(R.drawable.hn1,"Heritance Kandalama","Heritance Kandalama; located at an aesthetic location with views of the magnificent rock fortress & the Kandalama Lake, makes it one of the most popular ..",2500,10));
        main_list.add(new HotelModel(R.drawable.hn2,"Cinnamon Citadel","Cinnamon Citadel Kandy. Kandy is renowned to be one of the most scenic cities in Sri Lanka. Surrounded by sweeping green hills, misty mornings bordered by ...",3000,20));
        main_list.add(new HotelModel(R.drawable.asset_3,"Sundaras Resort & Spa","description 1",1000,30));
        main_list.add(new HotelModel(R.drawable.hn3,"Aswadduma Hotel","description 1",1500,40));
        main_list.add(new HotelModel(R.drawable.hn4,"Hunas falls","Take delight in a stay at a popular hotel in Kandy Sri Lanka when holidaying in the hill country. Behold beguiling views of the mountainous landscape and ...",1800,30));
        main_list.add(new HotelModel(R.drawable.hn5,"Jetwing vil uyana","description 1",2000,50));
        main_list.add(new HotelModel(R.drawable.hn6,"Amaya Lake","description 1",2500,10));
        main_list.add(new HotelModel(R.drawable.hn7,"Habarana village by cinnamon","description 1",2500,10));
        main_list.add(new HotelModel(R.drawable.hn8,"Roo Mansala Boutique Villa","description 1",2500,10));

        //creating a adapter object
        adapter = new HotelAdapter(main_list,this);
       //set list in recycler view
        recyclerView.setAdapter(adapter);
    }
}