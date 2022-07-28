package com.hcl.assignment3;
public class Vehicle {
    int vehicleNumber;
    String model;
    String manufacturer;
    String color;

    Vehicle(int vehicleNumber, String model, String manufacturer, String color) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.manufacturer = manufacturer;
        this.color = color;
    }
    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "vehicleNumber=" + vehicleNumber +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", color='" + color + '\'';
    }
}

class Truck extends Vehicle {
    String loadingCapacity;
    public Truck(int vehicleNumber, String model, String manufacturer, String color, String loadingCapacity) {
        super(vehicleNumber, model,manufacturer, color);
        this.loadingCapacity = loadingCapacity;
    }

    public String getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(String loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    @Override
    public String toString() {
        return super.toString()  +
                " loadingCapacity = '" + loadingCapacity + '\'';
    }
}
class Main {
    public static void main(String[] args) {
        Truck truck = new Truck(23, "RAM", "Ford", "Black", "100 Tons");
        System.out.println(truck);
        truck.setColor("Blue");
        truck.setLoadingCapacity("3 Tons");
        System.out.println(truck);
    }
}