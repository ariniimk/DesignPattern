package com.smartoffice.observers;

import com.smartoffice.Room;
import com.smartoffice.utils.Logger;

public class LightController implements Observer {
    public void update(Room room) {
        if (room.isOccupied()) {
            Logger.log("Lights ON in Room " + room.getId());
        } else {
            Logger.log("Lights OFF in Room " + room.getId());
        }
    }
}
