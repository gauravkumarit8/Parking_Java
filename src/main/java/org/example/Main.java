package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void printAvailableCommands() {
        System.out.println("Available commands:");
        System.out.println("create_parking_lot <capacity>: Create a parking lot with specified capacity");
        System.out.println("park <registration_number> <colour>: Park a car with registration number and colour");
        System.out.println("leave <slot_number>: Remove a car from the parking lot by slot number");
        System.out.println("status: Print the current status of the parking lot");
        System.out.println("registration_numbers_for_cars_with_colour <color>: Get registration numbers of cars with specified color");
        System.out.println("slot_number_for_registration_number <registration_number>: Get slot number for a car with specified registration number");
        System.out.println("slot_numbers_for_cars_with_colour <color>: Get slot numbers of cars with specified color");
        System.out.println("help: Print available commands");
        System.out.println("exit: Exit the program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = null;
        printAvailableCommands();
        while (true) {
            try {
                System.out.print("$ ");
                String queryToPerform = scanner.nextLine();
                String[] parts = queryToPerform.split(" ");

                switch (parts[0]) {
                    case "create_parking_lot":
                        int parkingCapacity = Integer.parseInt(parts[1]);
                        parkingLot = new ParkingLot(parkingCapacity);
                        System.out.println("Created a parkinglot with " + parkingCapacity + " slots");
                        break;

                    case "park":
                        if (parts.length < 3) {
                            throw new IllegalArgumentException("Usage: park <registration_number> <color>");
                        }
                        String registrationNumber = parts[1];
                        String color = parts[2];
                        Car car = new Car(registrationNumber, color);
                        int slotNumber = 0;
                        if (parkingLot != null) {
                            slotNumber = parkingLot.parkCar(car);
                        }
                        if (slotNumber == -1) {
                            System.out.println("Sorry, parking lot is full");
                        } else {
                            System.out.println("Allocated slot number: " + slotNumber);
                        }
                        break;

                    case "leave":
                        if (parts.length < 2) {
                            throw new IllegalArgumentException("Usage: leave <slot_number>");
                        }
                        int leaveSlotNumber = Integer.parseInt(parts[1]);
                        boolean success = false;
                        if (parkingLot != null) {
                            success = parkingLot.leave(leaveSlotNumber);
                        }
                        if (success) {
                            System.out.println("Slot number " + leaveSlotNumber + " is free");
                        } else {
                            System.out.println("Invalid slot number");
                        }
                        break;

                    case "status":
                        if (parkingLot != null) {
                            parkingLot.printStatus();
                        }
                        break;

                    case "registration_numbers_for_cars_with_colour":
                        if (parts.length < 2) {
                            throw new IllegalArgumentException("Usage: registration_numbers_for_cars_with_colour <color>");
                        }
                        String colourSearch = parts[1];
                        List<String> registrationNumbers = new ArrayList<>();
                        if (parkingLot != null) {
                            registrationNumbers = parkingLot.getRegistrationNumbersForColour(colourSearch);
                        }
                        System.out.println(String.join(", ", registrationNumbers));
                        break;

                    case "slot_number_for_registration_number":
                        if (parts.length < 2) {
                            throw new IllegalArgumentException("Usage: slot_number_for_registration_number <registration_number>");
                        }
                        String registrationNumberQuery = parts[1];
                        int slotNoQuery = 0;
                        if (parkingLot != null) {
                            slotNoQuery = parkingLot.getSlotNumberForRegistrationNumber(registrationNumberQuery);
                        }
                        if (slotNoQuery == -1) {
                            System.out.println("Not found");
                        } else {
                            System.out.println(slotNoQuery);
                        }
                        break;

                    case "slot_numbers_for_cars_with_colour":
                        if (parts.length < 2) {
                            throw new IllegalArgumentException("Usage: slot_numbers_for_cars_with_colour <color>");
                        }
                        String colorQuery2 = parts[1];
                        List<Integer> slotNumbers = null;
                        if (parkingLot != null) {
                            slotNumbers = parkingLot.getSlotNumbersForColor(colorQuery2);
                        }
                        if (slotNumbers != null) {
                            System.out.println(slotNumbers.toString().replaceAll("[\\[\\],]", ""));
                        }
                        break;

                    case "help":
                        printAvailableCommands();
                        break;

                    case "exit":
                        return;

                    default:
                        System.out.println("Invalid command");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
