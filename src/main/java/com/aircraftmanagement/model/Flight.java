package com.aircraftmanagement.model;

public class Flight
{
    private String flightId;
    private String source;
    private String destination;

    //Has-a Relation
    private Aircraft aircraft;
    private Pilot pilot;
    private String flightStatus;

    public Flight(String flightId, String source,
                  String destination, Aircraft aircraft,
                  Pilot pilot) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.aircraft = aircraft;
        this.pilot = pilot;
        this.flightStatus = flightStatus;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public void displayDetails()
    {
        System.out.println("=================================");
        System.out.println("          FLIGHT DETAILS         ");
        System.out.println("=================================");

        System.out.println("Flight ID       : " + flightId);
        System.out.println("Source          : " + source);
        System.out.println("Destination     : " + destination);
        System.out.println("Flight Status   : " + flightStatus);

        System.out.println("\nAircraft Type   : " + aircraft.getAircraftType());
        System.out.println("Aircraft ID     : "   + aircraft.getAircraftId());
        System.out.println("Pilot ID        : "   + pilot.getPilotId());
        System.out.println("Pilot Name      : "   + pilot.getPilotName());
        System.out.println("=================================");
    }

}
