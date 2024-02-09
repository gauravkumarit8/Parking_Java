package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ParkingLot parkingLot=null;

        while(true){
            System.out.print("$ ");
            String queryToPerform= scanner.nextLine();
            String[] parts=queryToPerform.split(" ");
            switch (parts[0]){
                case "create_parking_lot":
                    int parkingCapacity=Integer.parseInt(parts[1]);
                    parkingLot=new ParkingLot(parkingCapacity);
                    System.out.println("Created a parkinglot with "+parkingCapacity+" slots");
                    break;

                case "park":
                    String registrationNumber=parts[1];
                    String color=parts[2];
                    Car car=new Car(registrationNumber,color);
                    int slotNumber= 0;
                    if (parkingLot != null) {
                        slotNumber = parkingLot.parkCar(car);
                    }
                    if(slotNumber== -1){
                        System.out.println("Sorry, parking lot is full");
                    }else {
                        System.out.println("Allocated slot number: "+slotNumber);
                    }
                    break;

                case "leave":
                    int leaveSlotNumber=Integer.parseInt(parts[1]);
                    boolean success= false;
                    if (parkingLot != null) {
                        success = parkingLot.leave(leaveSlotNumber);
                    }
                    if(success){
                        System.out.println("Slot number "+leaveSlotNumber+" is free");
                    }else{
                        System.out.println("Invalid slot number");
                    }
                    break;

                case "status":
                    if (parkingLot != null) {
                        parkingLot.printStatus();
                    }
                    break;

                case "registration_numbers_for_cars_with_colour":
                    String colourSearch=parts[1];
                    List<String> registrationNumbers=new ArrayList<>();
                    if (parkingLot != null) {
                        registrationNumbers=parkingLot.getRegistrationNumbersForColour(colourSearch);
                    }
                    System.out.println(String.join(", ",registrationNumbers));
                    break;

                case "slot_number_for_registration_number" :
                    String registrationNumberQuery=parts[1];
                    int slotNoQuery= 0;
                    if (parkingLot != null) {
                        slotNoQuery = parkingLot.getSlotNumberForRegistrationNumber(registrationNumberQuery);
                    }

                    if(slotNoQuery== -1){
                        System.out.println("Not found");
                    }else{
                        System.out.println(slotNoQuery);
                    }
                    break;

                case "slot_numbers_for_cars_with_colour":
                    String colorQuery2 = parts[1];
                    List<Integer> slotNumbers = null;
                    if (parkingLot != null) {
                        slotNumbers = parkingLot.getSlotNumbersForColor(colorQuery2);
                    }
                    if (slotNumbers != null) {
                        System.out.println(slotNumbers.toString().replaceAll("[\\[\\],]", ""));
                    }
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("Invalid command");
            }
        }
    }
}