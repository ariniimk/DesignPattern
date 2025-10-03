package com.smartoffice.observers;

import com.smartoffice.Room;
import com.smartoffice.utils.Logger;

public class AirConditionerController implements Observer {
    public void update(Room room) {
        if (room.isOccupied()) {
            Logger.log("AC ON in Room " + room.getId());
        } else {
            Logger.log("AC OFF in Room " + room.getId());
        }
    }
}
