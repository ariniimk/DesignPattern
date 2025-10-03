package com.smartoffice.commands;

import com.smartoffice.BookingManager;

public class AddOccupantCommand implements Command {
    private int room;
    private int occupants;

    public AddOccupantCommand(int room, int occupants) {
        this.room = room;
        this.occupants = occupants;
    }

    public void execute() {
        BookingManager.getInstance().addOccupant(room, occupants);
    }
}
