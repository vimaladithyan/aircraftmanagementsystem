package com.aircraftmanagement.model;

public class PassengerAircraft extends Aircraft
{
    private int numberOfPassengers;
    private boolean businessClassAvailable;

    public PassengerAircraft(String aircraftId,
                             String model,
                             String manufacturer,
                             int capacity,
                             int numberOfPassengers,
                             boolean businessClassAvailable)
    {
        super(aircraftId, model, manufacturer, capacity);

        this.numberOfPassengers = numberOfPassengers;
        this.businessClassAvailable = businessClassAvailable;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public boolean isBusinessClassAvailable() {
        return businessClassAvailable;
    }

    public void setBusinessClassAvailable(boolean businessClassAvailable) {
        this.businessClassAvailable = businessClassAvailable;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("----- Passenger Aircraft -----");
        System.out.println("Aircraft ID       : " + getAircraftId());
        System.out.println("Model             : " + getModel());
        System.out.println("Manufacturer      : " + getManufacturer());
        System.out.println("Capacity          : " + getCapacity());
        System.out.println("Status            : " + getStatus());
        System.out.println("Passengers        : " + numberOfPassengers);
        System.out.println("Business Class    : " + businessClassAvailable);
    }

    @Override
    public String getAircraftType()
    {
        return "Passenger Aircraft";
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on passenger aircraft "
                + getAircraftId());
    }

    @Override
    public boolean isMaintenanceRequired() {
        return getStatus().equalsIgnoreCase("MAINTENANCE");
    }

}