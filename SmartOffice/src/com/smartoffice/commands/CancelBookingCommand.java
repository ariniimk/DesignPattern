package com.smartoffice.commands;

import com.smartoffice.BookingManager;

public class CancelBookingCommand implements Command {
    private int room;

    public CancelBookingCommand(int room) {
        this.room = room;
    }

    public void execute() {
        BookingManager.getInstance().cancelBooking(room);
    }
}
