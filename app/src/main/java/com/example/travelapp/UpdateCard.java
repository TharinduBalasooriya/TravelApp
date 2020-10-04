package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateCard extends AppCompatActivity {

    private cardModel card;
    private Context context;
    DBHandler db ;
    EditText name,number,cvv,exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_card);

        context = this;
        db = new  DBHandler(context);

        Intent intent = getIntent();
        card = (cardModel) intent.getSerializableExtra("CARD");

        name = findViewById(R.id.upcrdcrdName);
        number = findViewById(R.id.upcrdcrdNumber);
        cvv = findViewById(R.id.upcrdcrdCVV);
        exp = findViewById(R.id.upcrdcrdED);

        name.setText(card.getName());
        number.setText(card.getNumber());
        cvv.setText(card.getCvv());
        exp.setText(card.getExpDate());
    }
    public void deleteCard(View view){
        db.deleteCard(card.getId());
        startActivity(new Intent(context,cardssummary.class));
    }
    public void UpdateCard(View view){

        cardModel crd = new cardModel(card.getId(),name.getText().toString(),number.getText().toString(),exp.getText().toString(),cvv.getText().toString());
        int s = db.updateCard(crd);
        startActivity(new Intent(context,cardssummary.class));

    }
}