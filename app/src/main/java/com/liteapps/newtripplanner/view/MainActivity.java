package com.liteapps.newtripplanner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liteapps.newtripplanner.R;

public class MainActivity extends AppCompatActivity {

    CardView btnViewAll,btnAddTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewAll = findViewById(R.id.btn_view_trip);
        btnAddTrip = findViewById(R.id.btn_add_trip);


        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,ViewAllTripsActivity.class));
            }
        });


        btnAddTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,AddTripActivity.class));

            }
        });


    }
}