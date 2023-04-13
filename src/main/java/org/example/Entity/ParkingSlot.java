package org.example.Entity;

public class ParkingSlot {
    private int slotNumber;
    private VehicleType type;
    private int floor;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber, VehicleType type, int floor) {
        this.slotNumber = slotNumber;
        this.type = type;
        this.floor = floor;
        this.isOccupied = false;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
