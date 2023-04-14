package org.example.ParkingLotService;

import org.example.Entity.*;

import java.util.*;

public class ParkingLot {
    String parkingId;
    int numberOfFloors;
    int numberOfSlots;
    HashMap<Integer, Floor> floors;
    HashMap<Integer, ArrayList<SlotTracker>> slotTracker;


    public ParkingLot(String parkingId, int numberOfFloors, int numberOfSlots) {
        this.parkingId = parkingId;
        this.numberOfFloors = numberOfFloors;
        this.numberOfSlots = numberOfSlots;
        this.floors = new HashMap<>();
        for (int floorNumber = 0; floorNumber < numberOfFloors; floorNumber++) {
           Floor floor = new Floor(floorNumber, numberOfSlots);
           floors.put(floorNumber, floor);
        }
        initializeSlotTracker();
    }

    public void initializeSlotTracker(){
        slotTracker = new HashMap<>();
        String[] vehicles = {"TRUCK", "BIKE", "CAR"};
        for(int floor = 0; floor < numberOfFloors; floor++){
            ArrayList<SlotTracker> list = new ArrayList<>();
            for (String vehicle : vehicles) {
                list.add(new SlotTracker(vehicle, 0));
            }
            slotTracker.put(floor, list);
        }
    }
    public void parkVehicle(Vehicle vehicle){
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = floors.get(i);
            List<Slot> slot = floor.getSlots();
            for (Slot value : slot) {
                if(String.valueOf(value.getVehicleType().toString()).equals(vehicle.getType()) && !value.isOccupied()){
                    value.setOccupied(true);
                    value.setVehicle(vehicle);
                    for(SlotTracker val : slotTracker.get(i)){
                        if(val.getVehicleType().equals(vehicle.getType())){
                            val.setCount(val.getCount() + 1);
                        }
                    }
                    System.out.println("Vehicle Parked. " + "TicketID : " + parkingId + "_" + (value.getFloorNumber() + 1) + "_"+ (value.getSlotID() + 1));
                    return;
                }
            }
        }
        System.out.println("Slot is full.....");
    }
    public void unparkVehicle(String ticketId){
        String[] token = ticketId.split("_");
        int floorNumber = Integer.parseInt(token[1]) - 1;
        int slotNumber = Integer.parseInt(token[2]) - 1;
        Floor floor = floors.get(floorNumber);
        if(floorNumber < numberOfFloors && slotNumber < numberOfSlots){
            if(floor.getSlots().get(slotNumber).isOccupied()){
                floor.getSlots().get(slotNumber).setOccupied(false);
                System.out.println("Unparked vehicle with Registration Number: " + floor.getSlots().get(slotNumber).getVehicle().getRegistrationNumber() + " and Color " + floor.getSlots().get(slotNumber).getVehicle().getColor());
            }
            else {
                System.out.println("Invalid Ticket");
            }
        }
        else{
            System.out.println("Invalid Ticket");
        }

    }

    public void displayFreeCount(String vehicleType){
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = floors.get(i);
            List<Slot> slot = floor.getSlots();
            int count = 0;
            for (Slot value : slot) {
                if(String.valueOf(value.getVehicleType().toString()).equals(vehicleType) && !value.isOccupied()){
                    count++;
                }
            }
            System.out.println("No. of free slots for "+ vehicleType  + " on Floor " +  (i + 1) + " : " + count);
        }
    }

    public void displayFreeSlots(String vehicleType){
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = floors.get(i);
            List<Slot> slot = floor.getSlots();
            StringBuilder st = new StringBuilder("");
            for (Slot value : slot) {
                if(String.valueOf(value.getVehicleType().toString()).equals(vehicleType) && !value.isOccupied()){
                    st.append(value.getSlotID() + 1 + " , ");
                }
            }
            System.out.println("No. of free slots for "+ vehicleType  + " on Floor " +  (i + 1) + " : " + st.toString());
        }
    }

    public void displayOccupiedSlots(String vehicleType){
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = floors.get(i);
            List<Slot> slot = floor.getSlots();
            StringBuilder st = new StringBuilder("");
            for (Slot value : slot) {
                if(String.valueOf(value.getVehicleType()).equals(vehicleType) && value.isOccupied()){
                    st.append(value.getSlotID() + 1 + " , ");
                }
            }
            System.out.println("Occupied slots for "+ vehicleType  + " on Floor " +  (i + 1) + " : " + st.toString());
        }
    }


}
