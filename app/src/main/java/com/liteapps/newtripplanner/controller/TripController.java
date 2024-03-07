package com.liteapps.newtripplanner.controller;

import android.content.Context;
import android.widget.Toast;

import com.liteapps.newtripplanner.model.TripModel;
import com.liteapps.newtripplanner.utils.Constants;

public class TripController {

    public  boolean validateTrip(Context context, String tDestination, String tPickupPoint, String tVModel, String tPrice,String tDetail, String tTime, String tDate) {
        if(tDestination.isEmpty()) {
            Toast.makeText(context, "Please enter destination", Toast.LENGTH_SHORT).show();
            return false;
        }else if(tPickupPoint.isEmpty()) {
            Toast.makeText(context, "Please enter pickup point", Toast.LENGTH_SHORT).show();
            return false;
        }else if(tVModel.isEmpty()) {
            Toast.makeText(context, "Please enter vehicle model", Toast.LENGTH_SHORT).show();
            return false;
        }else if(tPrice.isEmpty()) {
            Toast.makeText(context, "Please enter trip price", Toast.LENGTH_SHORT).show();
            return false;
        } else if (tDetail.isEmpty()) {
            Toast.makeText(context, "Please enter trip details", Toast.LENGTH_SHORT).show();
        }
        else if (tTime.isEmpty()) {
            Toast.makeText(context, "Please enter time", Toast.LENGTH_SHORT).show();
            return false;
        }else if (tDate.isEmpty()) {
            Toast.makeText(context, "Please enter destination", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void saveTrip(TripModel tripModel) {

        Constants.tripList.add(tripModel);
    }
}
