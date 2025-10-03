package com.smartoffice;

import com.smartoffice.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class BookingManager {
    private static BookingManager instance;
    private Map<Integer, Room> rooms = new HashMap<>();

    private BookingManager() {}

    public static synchronized BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    public Room getRoom(int id) {
        if (!rooms.containsKey(id)) {
            Room r = new Room(id);
            rooms.put(id, r);
        }
        return rooms.get(id);
    }

    public void bookRoom(int id, String time, int duration) {
        Room r = getRoom(id);
        if (r.isBooked()) {
            Logger.error("Room " + id + " is already booked.");
            return;
        }
        r.setBooked(true);
        Logger.log("Room " + id + " booked from " + time + " for " + duration + " minutes.");
    }

    public void cancelBooking(int id) {
        Room r = getRoom(id);
        if (!r.isBooked()) {
            Logger.error("Room " + id + " is not booked.");
            return;
        }
        r.setBooked(false);
        Logger.log("Booking for Room " + id + " cancelled.");
    }

    public void addOccupant(int id, int count) {
        Room r = getRoom(id);
        if (count >= 2) {
            r.setOccupied(true);
            Logger.log("Room " + id + " is now occupied by " + count + " persons.");
        } else {
            r.setOccupied(false);
            Logger.error("Room " + id + " occupancy insufficient.");
        }
    }

    public void status(int id) {
        Room r = getRoom(id);
        Logger.log("Room " + id + " | Booked: " + r.isBooked() + " | Occupied: " + r.isOccupied());
    }
}
