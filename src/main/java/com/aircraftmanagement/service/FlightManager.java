package com.aircraftmanagement.service;

import com.aircraftmanagement.exception.*;
import com.aircraftmanagement.model.Aircraft;
import com.aircraftmanagement.model.Flight;
import com.aircraftmanagement.model.Pilot;

public class FlightManager
{
    private Flight[] flights = new Flight[50];
    private int flightCount = 0;

    private AircraftManager aircraftManager;
    private PilotManager pilotManager;

    public FlightManager(AircraftManager aircraftManager, PilotManager pilotManager)
    {
        this.aircraftManager=aircraftManager;
        this.pilotManager=pilotManager;
    }

    public void scheduleFlight(String flightId,
                               String source,
                               String destination,
                               String aircraftId,
                               String pilotId)
            throws   InvalidFlightException,
                     AircraftNotFoundException,
                     AircraftNotAvailableException,
                     PilotNotFoundException,
                     PilotAlreadyAssignedException
    {
        if (flightCount >= flights.length)
        {
            throw new InvalidFlightException(
                    "Flight storage is full.");
        }

        if (source == null || destination == null
                || source.trim().isEmpty()
                || destination.trim().isEmpty())
        {
            throw new InvalidFlightException("Source and destination cannot be empty.");
        }

        if (source.equalsIgnoreCase(destination))
        {
            throw new InvalidFlightException("Source and destination cannot be the same.");
        }

        // Check duplicate flight ID
        for (int i = 0; i < flightCount; i++)
        {
            if (flights[i].getFlightId()
                    .equalsIgnoreCase(flightId))
            {
                throw new InvalidFlightException(
                        "Flight "
                                + flightId
                                + " is already registered.");
            }
        }

        // Find aircraft
        Aircraft aircraft = aircraftManager.searchAircraft(aircraftId);

        // Check aircraft
        aircraftManager.checkAircraftAvailability(aircraft);

        // Find pilot
        Pilot pilot =pilotManager.searchPilot(pilotId);

        // Check pilot
        pilotManager.checkPilotAvailability(pilot);

        // Create flight
        Flight flight = new Flight(flightId,source,destination,aircraft,pilot);

        flights[flightCount] = flight;
        flightCount++;

        // Change status only after all validation succeeds
        aircraft.setStatus("ASSIGNED");
        pilot.setAvailability(false);

        System.out.println("Flight scheduled successfully.");

    }

    public Flight searchFlight(String flightId) throws FlightNotFoundException
    {
        for (int i = 0; i < flightCount; i++)
        {
            if (flights[i].getFlightId()
                    .equalsIgnoreCase(flightId))
            {
                return flights[i];
            }
        }

        throw new FlightNotFoundException(
                "Flight with ID "
                        + flightId
                        + " does not exist.");

    }


    public void displayAllFlights()
    {
        if (flightCount == 0)
        {
            System.out.println("No flights scheduled.");
            return;
        }

        for (int i = 0; i < flightCount; i++)
        {
            flights[i].displayDetails();
        }
    }


    public void cancelFlight(String flightId) throws
            FlightNotFoundException
    {
        Flight flight = searchFlight(flightId);

        if (flight.getFlightStatus()
                .equalsIgnoreCase("CANCELLED"))
        {
            System.out.println("Flight is already cancelled.");
            return;
        }

        flight.setFlightStatus("CANCELLED");

        flight.getAircraft().setStatus("AVAILABLE");

        flight.getPilot().setAvailability(true);

        System.out.println(
                "Flight " + flightId
                        + " cancelled successfully.");

        System.out.println(
                "Aircraft "
                        + flight.getAircraft().getAircraftId()
                        + " -> AVAILABLE");

        System.out.println(
                "Pilot "
                        + flight.getPilot().getPilotId()
                        + " -> AVAILABLE");
    }

}
