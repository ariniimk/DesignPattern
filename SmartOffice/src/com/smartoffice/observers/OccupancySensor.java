package com.smartoffice.observers;

import com.smartoffice.Room;
import com.smartoffice.utils.Logger;

public class OccupancySensor implements Observer {
    public void update(Room room) {
        if (room.isOccupied()) {
            Logger.log("Sensor: Room " + room.getId() + " occupied.");
        } else {
            Logger.log("Sensor: Room " + room.getId() + " empty.");
        }
    }
}
