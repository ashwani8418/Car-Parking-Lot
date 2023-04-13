package org.example.Entity;

public class Slot {
    VehicleType vehicleType;
    Vehicle vehicle;
    int floorNumber;
    int slotID;
    boolean isOccupied;

    public Slot(VehicleType vehicleType,  int floorNumber, int slotID) {
        this.vehicleType = vehicleType;
        this.floorNumber = floorNumber;
        this.slotID = slotID;
        this.isOccupied = false;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotID() {
        return slotID;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
