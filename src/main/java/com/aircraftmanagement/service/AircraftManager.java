package com.aircraftmanagement.service;

import com.aircraftmanagement.exception.AircraftAlreadyExistsException;
import com.aircraftmanagement.exception.AircraftNotAvailableException;
import com.aircraftmanagement.exception.AircraftNotFoundException;
import com.aircraftmanagement.exception.InvalidAircraftException;
import com.aircraftmanagement.model.Aircraft;

public class AircraftManager
{
    private Aircraft[] aircrafts=new Aircraft[50];
    private int aircraftCount = 0;

    public void addAircraft(Aircraft aircraft) throws
            InvalidAircraftException,
            AircraftAlreadyExistsException
    {
        if (aircraft == null)
        {
            throw new InvalidAircraftException("Aircraft cannot be null.");
        }

        if (aircraft.getCapacity() <= 0)
        {
            throw new InvalidAircraftException("Capacity must be greater than zero.");
        }

        if (aircraftCount >= aircrafts.length)
        {
            throw new InvalidAircraftException("Aircraft storage is full.");
        }

        for (int i = 0; i < aircraftCount; i++)
        {
            if (aircrafts[i].getAircraftId().equalsIgnoreCase(aircraft.getAircraftId()))
            {
                throw new AircraftAlreadyExistsException("Aircraft "
                                + aircraft.getAircraftId()
                                + " is already registered.");
            }
        }
        aircrafts[aircraftCount] = aircraft;
        aircraftCount++;

        System.out.println("Aircraft registered successfully.");
    }

    public Aircraft searchAircraft(String aircraftId) throws
            AircraftNotFoundException
    {
        for (int i = 0; i < aircraftCount; i++)
        {
            if (aircrafts[i].getAircraftId()
                    .equalsIgnoreCase(aircraftId))
            {
                return aircrafts[i];
            }
        }

        throw new AircraftNotFoundException("Aircraft with ID"
                        + aircraftId
                        + " does not exist.");
    }

    // Method Overloading
    public Aircraft searchAircraft(String model, String manufacturer) throws
            AircraftNotFoundException
    {
        for (int i = 0; i < aircraftCount; i++)
        {
            if (aircrafts[i].getModel()
                    .equalsIgnoreCase(model)
                    &&
                    aircrafts[i].getManufacturer()
                            .equalsIgnoreCase(manufacturer))
            {
                return aircrafts[i];
            }
        }

        throw new AircraftNotFoundException(
                "Aircraft with model "
                        + model
                        + " and manufacturer "
                        + manufacturer
                        + " not found.");

    }


    public void displayAllAircraft()
    {
        if (aircraftCount == 0)
        {
            System.out.println("No aircraft registered.");
            return;
        }

        for (int i = 0; i < aircraftCount; i++)
        {
            aircrafts[i].displayDetails();
        }
    }

    public void checkAircraftAvailability(Aircraft aircraft)
            throws AircraftNotAvailableException
    {
        if (!aircraft.getStatus().equals("AVAILABLE"))
        {
            throw new AircraftNotAvailableException(
                    "Aircraft "
                            + aircraft.getAircraftId()
                            + " is currently assigned to another flight.");
        }
    }


}
