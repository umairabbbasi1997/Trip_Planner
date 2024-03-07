package com.liteapps.newtripplanner.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.liteapps.newtripplanner.model.TripModel;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "trip_db";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "user_trips";

    //Table Columns
    private static final String PRIMARY_KEY = "id";

    private static final String TRIP_DESTINATION = "destination";
    private static final String TRIP_PICKUP_POINT = "pickup_point";
    private static final String TRIP_VEHICLE_MODEL = "vehicle_model";
    private static final String TRIP_PRICE = "trip_price";
    private static final String TRIP_DETAIL = "trip_detail";

    private static final String TRIP_TIME = "trip_time";
    private static final String TRIP_DATE = "trip_date";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + PRIMARY_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TRIP_DESTINATION + " TEXT,"
                + TRIP_PICKUP_POINT + " TEXT,"
                + TRIP_VEHICLE_MODEL + " TEXT,"
                + TRIP_PRICE + " TEXT,"
                + TRIP_DETAIL + " TEXT,"
                + TRIP_TIME + " TEXT,"
                + TRIP_DATE + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewTrip(String destination, String pickup, String vModel, String tPrice, String tDetail, String tTime, String tDate) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(TRIP_DESTINATION, destination);
        values.put(TRIP_PICKUP_POINT, pickup);
        values.put(TRIP_VEHICLE_MODEL, vModel);
        values.put(TRIP_PRICE, tPrice);
        values.put(TRIP_DETAIL, tDetail);
        values.put(TRIP_TIME, tTime);
        values.put(TRIP_DATE, tDate);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // code to get all contacts in a list view
    public List<TripModel> getAllTrips() {
        List<TripModel> tripList = new ArrayList<TripModel>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TripModel trip = new TripModel();

                trip.setTripId(Integer.parseInt(cursor.getString(0)));
                trip.setDestination(cursor.getString(1));
                trip.setPickupLocation(cursor.getString(2));
                trip.setVehicleModel(cursor.getString(3));
                trip.setPrice(cursor.getString(4));
                trip.setTripDetails(cursor.getString(5));
                trip.setTime(cursor.getString(6));
                trip.setDate(cursor.getString(7));

                // Adding contact to list
                tripList.add(trip);
            } while (cursor.moveToNext());
        }

        // return trip list
        return tripList;
    }

    // Deleting single Trip
    public void deleteTrip(TripModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, PRIMARY_KEY + " = ?",
                new String[] { String.valueOf(model.getTripId()) });
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

