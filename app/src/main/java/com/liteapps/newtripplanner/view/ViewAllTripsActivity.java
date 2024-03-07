package com.liteapps.newtripplanner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.liteapps.newtripplanner.OnClickListener;
import com.liteapps.newtripplanner.R;
import com.liteapps.newtripplanner.adapter.TripAdapter;
import com.liteapps.newtripplanner.utils.Constants;

public class ViewAllTripsActivity extends AppCompatActivity implements OnClickListener {

   RecyclerView rvTrip;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_trips);

        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setRecyclerView();
    }

    private void setRecyclerView() {
        rvTrip = findViewById(R.id.rvTrip);
        if (Constants.tripList != null && !Constants.tripList.isEmpty())
        {
            rvTrip.setAdapter(new TripAdapter(Constants.tripList,this,this));
            rvTrip.getAdapter().notifyDataSetChanged();
        }

    }

    @Override
    public void onItemClick(int position) {


    }

    @Override
    public void onItemDelete(int position) {

        Constants.tripList.remove(position);
        rvTrip.getAdapter().notifyItemRemoved(position);
    }
}