package com.example.carmaintenance;

public class Service {

    String date, distance, type, cost;

    public Service() {
    }

    public Service(String date, String distance, String type, String cost) {
        this.date = date;
        this.distance = distance;
        this.type = type;
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
