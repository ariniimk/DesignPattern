package com.smartoffice.commands;

import com.smartoffice.BookingManager;

public class RoomStatusCommand implements Command {
    private int room;

    public RoomStatusCommand(int room) {
        this.room = room;
    }

    public void execute() {
        BookingManager.getInstance().status(room);
    }
}
