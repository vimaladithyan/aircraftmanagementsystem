package com.aircraftmanagement.model;

public class PrivateAircraft extends Aircraft
{
    private String ownerName;
    private String luxuryLevel;

    public PrivateAircraft(String aircraftId,
                           String model,
                           String manufacturer,
                           int capacity,
                           String ownerName,
                           String luxuryLevel)
    {
        super(aircraftId, model, manufacturer, capacity);
        this.ownerName = ownerName;
        this.luxuryLevel = luxuryLevel;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLuxuryLevel() {
        return luxuryLevel;
    }

    public void setLuxuryLevel(String luxuryLevel) {
        this.luxuryLevel = luxuryLevel;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("----- Private Aircraft -----");
        System.out.println("Aircraft ID       : " + getAircraftId());
        System.out.println("Model             : " + getModel());
        System.out.println("Manufacturer      : " + getManufacturer());
        System.out.println("Capacity          : " + getCapacity());
        System.out.println("Status            : " + getStatus());
        System.out.println("Owner Name        : " + ownerName);
        System.out.println("Luxury Level      : " + luxuryLevel);
    }

    @Override
    public String getAircraftType()
    {
        return "Private Aircraft";
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on private aircraft "
                + getAircraftId());
    }

    @Override
    public boolean isMaintenanceRequired() {
        return getStatus().equalsIgnoreCase("MAINTENANCE");
    }

}

