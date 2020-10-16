package com.example.travelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder> {
    List<HotelModel> mylist;
    private  Context mcontext;

    public HotelAdapter(List<HotelModel> mylist, Context context) {
        this.mylist = mylist;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_hotel,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final HotelModel model = mylist.get(position);
        //set data in hotel list
        holder.name.setText(model.getHotel_name());
        holder.image.setImageDrawable(mcontext.getResources().getDrawable(model.getImage()));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {

                Toast.makeText(mcontext, model.getHotel_name(), Toast.LENGTH_SHORT).show();


                //creating a intent object
                Intent intent = new Intent(mcontext,HotellearnMoreView.class);

                //put extra messages in intent object
                intent.putExtra("image",model.getImage());
                intent.putExtra("name",model.getHotel_name());
                intent.putExtra("desc",model.getDescription());
                intent.putExtra("disc",model.getDiscount());
                intent.putExtra("price",model.getPrice());

                //starting next activity
                //goto descriptive view of hotel
                mcontext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        RelativeLayout parentLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.hotelName);
            parentLayout = itemView.findViewById(R.id.relativeL);

        }
    }
}
