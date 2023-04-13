package org.example.Entity;

public class SlotTracker {

    String vehicleType;
    int count;

    public SlotTracker(String vehicleType, int count) {
        this.vehicleType = vehicleType;
        this.count = count;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getCount() {
        return count;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
