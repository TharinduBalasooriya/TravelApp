package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class carddetails02 extends AppCompatActivity {

    private Context context;
    private DBHandler dbHandler;
    private EditText crdname,crdnum,exp,cvv;
    private Button crdadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carddetails02);

        context = this;
        dbHandler = new DBHandler(context);

        crdname = findViewById(R.id.crdName);
        crdnum = findViewById(R.id.crdNumber);
        exp = findViewById(R.id.crdED);
        cvv = findViewById(R.id.crdCVV);
        crdadd = (Button) findViewById(R.id.crdSV);

        crdadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
}