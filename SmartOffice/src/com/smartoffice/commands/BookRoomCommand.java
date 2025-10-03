package com.smartoffice.commands;

import com.smartoffice.BookingManager;

public class BookRoomCommand implements Command {
    private int room;
    private String time;
    private int duration;

    public BookRoomCommand(int room, String time, int duration) {
        this.room = room;
        this.time = time;
        this.duration = duration;
    }

    public void execute() {
        BookingManager.getInstance().bookRoom(room, time, duration);
    }
}
