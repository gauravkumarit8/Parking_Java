package org.example;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private int capacity;
    private List<ParkingSlot> parkingSlots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSlots = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            parkingSlots.add(new ParkingSlot(i));
        }
    }
    public int parkCar(Car car){
        for(ParkingSlot slot : parkingSlots){
            if(slot.getCar()==null){
                slot.parkCar(car);
                return slot.getSlotNumber();
            }
        }
        return -1;
    }

    public boolean leave(int slotNo){
        if(slotNo <=0 || slotNo>capacity){
            return false;
        }
        parkingSlots.get(slotNo-1).removeCar();
        return true;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public void printStatus() {
        System.out.println("Slot No.  Registration No.  Colour");
        for(ParkingSlot slot:parkingSlots){
            Car car=slot.getCar();
            if(car != null){
                System.out.println(slot.getSlotNumber()+"  "+car.getRegistrationNo()+"  "+car.getColour());
            }
        }
    }
}
