package com.smartoffice;

import com.smartoffice.commands.*;
import com.smartoffice.utils.Logger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger.log("Smart Office System Started");
        Scanner scanner = new Scanner(System.in);
        BookingManager manager = BookingManager.getInstance();
        boolean running = true;
        
        while (running) {
            System.out.println("\n--- Smart Office Menu ---");
            System.out.println("1. Configure Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Add Occupant");
            System.out.println("5. Room Status");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();
            
            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter number of rooms: ");
                        int count = Integer.parseInt(scanner.nextLine());
                        OfficeConfig.getInstance().configureRooms(count);
                        break;
                    case "2":
                        System.out.print("Enter room number: ");
                        int room = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter start time (HH:mm): ");
                        String time = scanner.nextLine();
                        System.out.print("Enter duration (minutes): ");
                        int dur = Integer.parseInt(scanner.nextLine());
                        new BookRoomCommand(room, time, dur).execute();
                        break;
                    case "3":
                        System.out.print("Enter room number: ");
                        int cancelRoom = Integer.parseInt(scanner.nextLine());
                        new CancelBookingCommand(cancelRoom).execute();
                        break;
                    case "4":
                        System.out.print("Enter room number: ");
                        int occRoom = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter occupants: ");
                        int occ = Integer.parseInt(scanner.nextLine());
                        new AddOccupantCommand(occRoom, occ).execute();
                        break;
                    case "5":
                        System.out.print("Enter room number: ");
                        int statusRoom = Integer.parseInt(scanner.nextLine());
                        new RoomStatusCommand(statusRoom).execute();
                        break;
                    case "6":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                Logger.error("Error: " + e.getMessage());
            }
        }
        scanner.close();
        Logger.log("Smart Office System Stopped");
    }
}
