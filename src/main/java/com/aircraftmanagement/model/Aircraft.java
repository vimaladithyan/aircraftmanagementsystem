package com.aircraftmanagement.model;

import com.aircraftmanagement.interf.Maintenance;

public abstract class Aircraft implements Maintenance
{
    private String aircraftId;
    private String model;
    private String manufacturer;
    private int capacity;
    private String status;

    public Aircraft(String aircraftId, String model,
                    String manufacturer, int capacity)
    {
        this.aircraftId = aircraftId;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.status = "AVAILABLE";
    }



    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void start()
    {
        status="Active";
        System.out.println("Aircraft " + aircraftId + " has started.");
    }

    public void stop()
    {
        status="Inactive";
        System.out.println("Aircraft " + aircraftId + " has not started.");
    }

    public void validateCapacity()
    {
        if (capacity <= 0)
        {
            System.out.println("Invalid aircraft capacity.");
        }
    }

    public abstract void displayDetails();
    public abstract String getAircraftType();

}
