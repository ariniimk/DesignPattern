package com.smartoffice;

import com.smartoffice.observers.Observer;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private boolean booked;
    private boolean occupied;
    private List<Observer> observers = new ArrayList<>();

    public Room(int id) {
        this.id = id;
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void setOccupied(boolean status) {
        this.occupied = status;
        notifyObservers();
    }

    public void setBooked(boolean status) {
        this.booked = status;
    }

    public boolean isBooked() { return booked; }
    public boolean isOccupied() { return occupied; }
    public int getId() { return id; }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(this);
        }
    }
}
