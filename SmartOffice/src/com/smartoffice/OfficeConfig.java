package com.smartoffice;

import com.smartoffice.utils.Logger;

public class OfficeConfig {
    private static OfficeConfig instance;
    private int rooms;

    private OfficeConfig() {}

    public static synchronized OfficeConfig getInstance() {
        if (instance == null) {
            instance = new OfficeConfig();
        }
        return instance;
    }

    public void configureRooms(int count) {
        if (count <= 0) {
            Logger.error("Invalid room count");
            return;
        }
        this.rooms = count;
        Logger.log("Office configured with " + count + " rooms.");
    }

    public int getRooms() {
        return rooms;
    }
}
