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
}
