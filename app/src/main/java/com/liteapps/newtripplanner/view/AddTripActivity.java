package com.liteapps.newtripplanner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.liteapps.newtripplanner.R;
import com.liteapps.newtripplanner.controller.TripController;
import com.liteapps.newtripplanner.model.TripModel;

public class AddTripActivity extends AppCompatActivity implements View.OnClickListener {

    EditText tDestination, tPickupPoint, tVModel, tPrice, tDetail, tTime, tDate;
    AppCompatButton saveTrip;
    ImageView btnBack;
    private TripController controller;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

         controller = new TripController();
        tDestination = findViewById(R.id.et_dest);
        tPickupPoint = findViewById(R.id.et_from);
        tVModel = findViewById(R.id.vehicle_model);
        tPrice = findViewById(R.id.et_price);
        tDetail = findViewById(R.id.et_trip_details);
        tTime = findViewById(R.id.et_time);
        tDate = findViewById(R.id.et_trip_date);

        saveTrip = findViewById(R.id.save_trip_btn);
        btnBack = findViewById(R.id.btn_back);

        saveTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (controller.validateTrip(AddTripActivity.this, tDestination.getText().toString(), tPickupPoint.getText().toString(), tVModel.getText().toString(), tPrice.getText().toString(), tDetail.getText().toString(), tTime.getText().toString(), tDate.getText().toString())
                ) {
                    TripModel tripModel = new TripModel(tDestination.getText().toString(), tPickupPoint.getText().toString(), tPrice.getText().toString(), tVModel.getText().toString(), tDetail.getText().toString(), tDate.getText().toString() ,tTime.getText().toString());
                    controller.saveTrip(tripModel);
                    Toast.makeText(AddTripActivity.this, "Trip added successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View view) {


        if (view == saveTrip) {


        }
        else if (view == btnBack)
        {

        }

    }
}