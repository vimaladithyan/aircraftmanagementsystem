package com.aircraftmanagement.service;

import com.aircraftmanagement.exception.PilotAlreadyAssignedException;
import com.aircraftmanagement.exception.PilotNotFoundException;
import com.aircraftmanagement.model.Pilot;

public class PilotManager
{
    private Pilot[] pilots = new Pilot[50];
    private int pilotCount = 0;

    public void addPilot(Pilot pilot) throws
            PilotAlreadyAssignedException
    {
        if (pilotCount >= pilots.length)
        {
            throw new PilotAlreadyAssignedException(
                    "Pilot storage is full.");
        }

        for (int i = 0; i < pilotCount; i++)
        {
            if (pilots[i].getPilotId()
                    .equalsIgnoreCase(pilot.getPilotId()))
            {
                throw new PilotAlreadyAssignedException(
                        "Pilot "
                                + pilot.getPilotId()
                                + " is already registered.");
            }
        }

        pilots[pilotCount] = pilot;
        pilotCount++;
        System.out.println("Pilot added successfully.");
    }

    public Pilot searchPilot(String pilotId) throws
            PilotNotFoundException
    {
        for (int i = 0; i < pilotCount; i++)
        {
            if (pilots[i].getPilotId()
                    .equalsIgnoreCase(pilotId))
            {
                return pilots[i];
            }
        }

        throw new PilotNotFoundException(
                "Pilot with ID "
                        + pilotId
                        + " does not exist.");
    }

    public void checkPilotAvailability(Pilot pilot) throws
            PilotAlreadyAssignedException
    {
        if (!pilot.isAvailability())
        {
            throw new PilotAlreadyAssignedException(
                    "Pilot "
                            + pilot.getPilotId()
                            + " is already assigned to an active flight.");
        }

    }

    public void displayAllPilots()
    {
        if (pilotCount == 0)
        {
            System.out.println("No pilots registered.");
            return;
        }

        for (int i = 0; i < pilotCount; i++)
        {
            pilots[i].displayDetails();
        }
    }

}


