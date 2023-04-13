package org.example.Entity;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private int numberOfSlots;
    private List<Slot> slots;

    public Floor(int floorNumber, int numberOfSlots) {
        this.floorNumber = floorNumber;
        this.numberOfSlots = numberOfSlots;
        this.slots = new ArrayList<>();
        for (int i = 0; i < numberOfSlots; i++) {
            if(i == 0){
                slots.add(new Slot(VehicleType.TRUCK, floorNumber, i));
            }
            else if(i > 0 && i < 3){
                slots.add(new Slot(VehicleType.BIKE, floorNumber, i));
            }
            else{
                slots.add(new Slot(VehicleType.CAR, floorNumber, i));
            }
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public List<Slot> getSlots() {
        return slots;
    }
}

