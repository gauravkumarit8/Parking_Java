package org.example;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private int capacity;
    private List<ParkingSlot> parkingSlots;

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
