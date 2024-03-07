package com.liteapps.newtripplanner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.liteapps.newtripplanner.OnClickListener;
import com.liteapps.newtripplanner.R;
import com.liteapps.newtripplanner.adapter.TripAdapter;
import com.liteapps.newtripplanner.dao.DBHandler;
import com.liteapps.newtripplanner.utils.Constants;

public class ViewAllTripsActivity extends AppCompatActivity implements OnClickListener {

   RecyclerView rvTrip;
    ImageView btnBack;
    private DBHandler dbHandler;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_trips);

        btnBack = findViewById(R.id.btn_back);

        dbHandler = new DBHandler(this);

        new LoadData().execute();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //setRecyclerView();
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

        //Constants.tripList.remove(position);
        dbHandler.deleteTrip(Constants.tripList.get(position).getTripId());
        Constants.tripList.remove(position);
        rvTrip.getAdapter().notifyDataSetChanged();
    }

    public class LoadData extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(ViewAllTripsActivity.this);
            progressDialog.setMessage("loading Wait");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            Constants.tripList = dbHandler.getAllTrips();

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            setRecyclerView();
            progressDialog.dismiss();
        }
    }

}

