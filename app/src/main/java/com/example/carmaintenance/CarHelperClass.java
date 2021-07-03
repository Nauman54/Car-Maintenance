package com.example.carmaintenance;

public class CarHelperClass {

    String name, licensePlate, model, brand, year;

    public CarHelperClass() {
    }

    public CarHelperClass(String name, String licensePlate, String model, String brand, String year) {
        this.name = name;
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
