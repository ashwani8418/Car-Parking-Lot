package org.example;

import org.example.Entity.Vehicle;
import org.example.ParkingLotService.ParkingLot;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = null;

        while (true) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            String command = tokens[0];
            switch (command) {
                case "create_parking_lot":
                    String parkingLotId = tokens[1];
                    int noOfFloors = Integer.parseInt(tokens[2]);
                    int noOfSlotsPerFloor = Integer.parseInt(tokens[3]);
                    parkingLot = new ParkingLot(parkingLotId, noOfFloors, noOfSlotsPerFloor);
                    System.out.println("Created parking lot with "+ noOfFloors + " floors and " + noOfSlotsPerFloor + " slots per floor");
                    break;
                case "park_vehicle":
                    if (parkingLot == null) {
                        System.out.println("Please create parking lot first");
                        break;
                    }
                    String vehicleType = tokens[1];
                    String regNo = tokens[2];
                    String color = tokens[3];
                    Vehicle vehicle = new Vehicle(vehicleType, regNo, color);
                    parkingLot.parkVehicle(vehicle);
                    break;
                case "unpark_vehicle":
                    if (parkingLot == null) {
                        System.out.println("Please create parking lot first");
                        break;
                    }
                    String ticketId = tokens[1];
                    parkingLot.unparkVehicle(ticketId);
                    break;
                case "display":
                    if (parkingLot == null) {
                        System.out.println("Please create parking lot first");
                        break;
                    }
                    String displayType = tokens[1];
                    vehicleType = tokens[2];
                    switch (displayType) {
                        case "free_count" -> parkingLot.displayFreeCount(vehicleType);
                        case "free_slots" -> parkingLot.displayFreeSlots(vehicleType);
                        case "occupied_slots" -> parkingLot.displayOccupiedSlots(vehicleType);
                        default -> System.out.println("Invalid display type");
                    }
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}