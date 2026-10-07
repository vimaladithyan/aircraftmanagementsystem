package com.aircraftmanagement.model;

public class Pilot
{
    private String pilotId;
    private String pilotName;
    private String licenseNumber;
    private int    experience;
    private boolean availability;

    public Pilot(String pilotId, String pilotName, String licenseNumber,
                 int experience) {
        this.pilotId = pilotId;
        this.pilotName = pilotName;
        this.licenseNumber = licenseNumber;
        this.experience = experience;
        this.availability = availability;
    }

    public String getPilotId() {
        return pilotId;
    }

    public void setPilotId(String pilotId) {
        this.pilotId = pilotId;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void displayDetails() {

        System.out.println("----- Pilot Details -----");
        System.out.println("Pilot ID       : " + pilotId);
        System.out.println("Pilot Name     : " + pilotName);
        System.out.println("License Number : " + licenseNumber);
        System.out.println("Experience     : " + experience + " years");
        System.out.println("Availability   : "
                + (availability ? "Available" : "Unavailable"));
    }

}
