package com.aircraftmanagement.main;

import com.aircraftmanagement.exception.*;
import com.aircraftmanagement.model.*;
import com.aircraftmanagement.service.AircraftManager;
import com.aircraftmanagement.service.FlightManager;
import com.aircraftmanagement.service.PilotManager;

import java.util.Scanner;

public class AircraftManagementApplication
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        AircraftManager aircraftManager = new AircraftManager();
        PilotManager pilotManager = new PilotManager();
        FlightManager flightManager = new FlightManager(aircraftManager,pilotManager);

        boolean running = true;
        
        while(running)
        {
            displayMenu();

            try
            {
                System.out.println("Enter the choice");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice)
                {
                    case 1: registerAircraft(sc, aircraftManager);
                            break;

                    case 2: aircraftManager.displayAllAircraft();
                            break;

                    case 3: searchAircraft(sc, aircraftManager);
                            break;

                    case 4: addPilot(sc, pilotManager);
                            break;

                    case 5: pilotManager.displayAllPilots();
                            break;

                    case 6: searchPilot(sc, pilotManager);
                            break;

                    case 7: scheduleFlight(sc, flightManager);
                            break;

                    case 8: flightManager.displayAllFlights();
                            break;

                    case 9: searchFlight(sc, flightManager);
                            break;

                    case 10: cancelFlight(sc, flightManager);
                            break;

                    case 11:
                        running = false;
                        System.out.println(
                                "Thank you for using Aircraft Management System.");
                        break;

                    default: System.out.println("Invalid choice. Please enter 1 to 11.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(
                        "Invalid input. Please enter a number.");
            }
            catch (Exception e)
            {
                System.out.println(
                        "Error: " + e.getMessage());
            }
        }
        sc.close();
    }

    public static void cancelFlight(Scanner sc, FlightManager manager)
    {
        try
        {
            System.out.print("Enter Flight ID: ");

            String id = sc.nextLine();

            manager.cancelFlight(id);
        }
        catch (FlightNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // SEARCH FLIGHT
    public static void searchFlight(Scanner sc, FlightManager manager)
    {
        try
        {
            System.out.print("Enter Flight ID: ");
            String id = sc.nextLine();
            manager.searchFlight(id).displayDetails();
        }
        catch (FlightNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // SCHEDULE FLIGHT
    public static void scheduleFlight(Scanner sc, FlightManager manager)
    {
        try
        {
            System.out.print("Enter Flight ID: ");
            String flightId = sc.nextLine();

            System.out.print("Enter Source: ");
            String source = sc.nextLine();

            System.out.print("Enter Destination: ");
            String destination = sc.nextLine();

            System.out.print("Enter Aircraft ID: ");
            String aircraftId = sc.nextLine();

            System.out.print("Enter Pilot ID: ");
            String pilotId = sc.nextLine();

            manager.scheduleFlight(
                    flightId,
                    source,
                    destination,
                    aircraftId,
                    pilotId
            );
        }
        catch (AircraftNotFoundException | PilotNotFoundException | AircraftNotAvailableException |
               PilotAlreadyAssignedException | InvalidFlightException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // SEARCH PILOT
    public static void searchPilot(Scanner sc, PilotManager manager)
    {
        try
        {
            System.out.print("Enter Pilot ID: ");

            String id = sc.nextLine();

            Pilot pilot =
                    manager.searchPilot(id);

            pilot.displayDetails();
        }
        catch (PilotNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }

    // ADD PILOT
    public static void addPilot(Scanner sc, PilotManager manager)
    {
        try
        {
            System.out.print("Enter Pilot ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Pilot Name: ");
            String name = sc.nextLine();

            System.out.print("Enter License Number: ");
            String license = sc.nextLine();

            System.out.print("Enter Experience: ");
            int experience =
                    Integer.parseInt(sc.nextLine());

            if (experience < 0)
            {
                System.out.println(
                        "Experience cannot be negative.");
                return;
            }

            Pilot pilot = new Pilot(
                    id,
                    name,
                    license,
                    experience
            );

            manager.addPilot(pilot);
        }
        catch (NumberFormatException e)
        {
            System.out.println(
                    "Experience must be a number.");
        }
        catch (PilotAlreadyAssignedException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // SEARCH AIRCRAFT
    public static void searchAircraft(Scanner sc, AircraftManager manager)
    {
        try
        {
            System.out.print("Enter Aircraft ID: ");
            String id = sc.nextLine();
            Aircraft aircraft =
                    manager.searchAircraft(id);

            aircraft.displayDetails();
        }
        catch (AircraftNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // REGISTER AIRCRAFT
    public static void registerAircraft(Scanner sc, AircraftManager manager)
    {
        try
        {
            System.out.println();
            System.out.println("1. Passenger Aircraft");
            System.out.println("2. Cargo Aircraft");
            System.out.println("3. Private Aircraft");

            System.out.print("Enter aircraft type: ");
            int type = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Aircraft ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Model: ");
            String model = sc.nextLine();

            System.out.print("Enter Manufacturer: ");
            String manufacturer = sc.nextLine();

            System.out.print("Enter Capacity: ");
            int capacity = Integer.parseInt(sc.nextLine());

            Aircraft aircraft;

            if (type == 1)
            {
                System.out.print("Enter Number of Passengers: ");
                int passengers = Integer.parseInt(sc.nextLine());

                System.out.print(
                        "Business Class Available (true/false): ");
                boolean business =
                        Boolean.parseBoolean(sc.nextLine());

                aircraft = new PassengerAircraft(
                        id,
                        model,
                        manufacturer,
                        capacity,
                        passengers,
                        business
                );

            }
            else if (type == 2)
            {
                System.out.print("Enter Cargo Capacity: ");
                double cargoCapacity =
                        Double.parseDouble(sc.nextLine());

                System.out.print("Enter Cargo Type: ");
                String cargoType = sc.nextLine();

                aircraft = new CargoAircraft(
                        id,
                        model,
                        manufacturer,
                        capacity,
                        cargoCapacity,
                        cargoType
                );
            }
            else if (type == 3)
            {
                System.out.print("Enter Owner Name: ");
                String ownerName = sc.nextLine();

                System.out.print("Enter Luxury Level: ");
                String luxuryLevel = sc.nextLine();

                aircraft = new PrivateAircraft(
                        id,
                        model,
                        manufacturer,
                        capacity,
                        ownerName,
                        luxuryLevel
                );
            }
            else
            {
                System.out.println(
                        "Invalid aircraft type.");
                return;
            }

            manager.addAircraft(aircraft);
        }
        catch (NumberFormatException e)
        {
            System.out.println(
                    "Invalid input. Please enter a valid number.");
        }
        catch (AircraftAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidAircraftException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static void displayMenu()
    {
        System.out.println();
        System.out.println("=========================================");
        System.out.println("       AIRCRAFT MANAGEMENT SYSTEM");
        System.out.println("=========================================");
        System.out.println("1. Register Aircraft");
        System.out.println("2. Display All Aircraft");
        System.out.println("3. Search Aircraft");
        System.out.println("4. Add Pilot");
        System.out.println("5. Display All Pilots");
        System.out.println("6. Search Pilot");
        System.out.println("7. Schedule Flight");
        System.out.println("8. Display All Flights");
        System.out.println("9. Search Flight");
        System.out.println("10. Cancel Flight");
        System.out.println("11. Exit");
        System.out.println("=========================================");
    }

}
