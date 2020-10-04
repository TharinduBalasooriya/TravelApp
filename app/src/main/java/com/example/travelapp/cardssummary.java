package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class cardssummary extends AppCompatActivity {

    private ListView listView;
    Context context;
    private DBHandler dbHandler;
    private List<cardModel> cusCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardssummary);

        context = this;
        dbHandler = new DBHandler(context);

        listView = findViewById(R.id.cardListView);
        cusCards = new ArrayList<>();
        cusCards = dbHandler.getAllCard();

        cardAdapter adapter = new cardAdapter(context,R.layout.single_card,cusCards);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                cardModel card = cusCards.get(i);
                Intent intent = new Intent(context,UpdateCard.class);
                Log.d("TRIP",Integer.toString(card.getId()));
                intent.putExtra("CARD",card);
                startActivity(intent);

            }
        });
    }
    public void goToAddCard(View view){

        startActivity(new Intent(this,carddetails02.class));
    }
}