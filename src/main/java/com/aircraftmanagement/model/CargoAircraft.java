package com.aircraftmanagement.model;

public class CargoAircraft extends Aircraft
{
    private double cargoCapacity;
    private String cargoType;

    public CargoAircraft(String aircraftId,
                         String model,
                         String manufacturer,
                         int capacity,
                         double cargoCapacity,
                         String cargoType)
    {
        super(aircraftId, model, manufacturer, capacity);

        this.cargoCapacity = cargoCapacity;
        this.cargoType = cargoType;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("----- Cargo Aircraft -----");
        System.out.println("Aircraft ID       : " + getAircraftId());
        System.out.println("Model             : " + getModel());
        System.out.println("Manufacturer      : " + getManufacturer());
        System.out.println("Capacity          : " + getCapacity());
        System.out.println("Status            : " + getStatus());
        System.out.println("Cargo Capacity    : " + cargoCapacity);
        System.out.println("Cargo Type        : " + cargoType);
    }

    @Override
    public String getAircraftType() {
        return "Cargo Aircraft";
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on cargo aircraft "
                + getAircraftId());
    }

    @Override
    public boolean isMaintenanceRequired() {
        return getStatus().equalsIgnoreCase("MAINTENANCE");
    }

}

