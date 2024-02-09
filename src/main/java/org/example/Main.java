package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ParkingLot parkingLot=null;

        while(true){
            System.out.println("$ ");
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
            }
        }
    }
}