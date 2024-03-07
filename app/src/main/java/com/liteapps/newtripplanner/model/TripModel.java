package com.liteapps.newtripplanner.model;

public class TripModel {

    private String destination;
    private String pickupLocation;
    private String price;
    private String vehicleModel;
    private String tripDetails;
    private String date;
    private String time;

    public TripModel(String destination, String pickupLocation, String price, String vehicleModel, String tripDetails, String date, String time) {
        this.destination = destination;
        this.pickupLocation = pickupLocation;
        this.price = price;
        this.vehicleModel = vehicleModel;
        this.tripDetails = tripDetails;
        this.date = date;
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {

        this.destination = destination;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(String tripDetails) {
        this.tripDetails = tripDetails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
