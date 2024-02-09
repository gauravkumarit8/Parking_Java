package org.example;

public class ParkingSlot {
    private int slotNumber;
    private Car car;


    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void parkCar(Car car) {
        this.car = car;
    }

    public void removeCar(){
        this.car=null;
    }

    public ParkingSlot(int slotNumber){
        this.slotNumber=slotNumber;
    }

    public ParkingSlot(int slotNumber, Car car) {
        this.slotNumber = slotNumber;
        this.car = car;
    }
}
