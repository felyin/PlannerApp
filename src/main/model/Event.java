package model;

import java.awt.*;
import java.util.Date;


public class Event {
    private String eventName;   //Name of the event
    private int date;    //Day of the week to schedule the event, with 1 being Monday and 7 being Sunday
    private String description;   //Description of the event


    //REQUIRES: String length cannot be 0
    //MODIFIES: this
    //EFFECTS: Initializes a new event
    public Event(String name, int day, String desc) {
        eventName = name;
        date = day;
        description = desc;
    }

    //GETTERS
    public String getEventName() {
        return eventName;
    }

    public int getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }


    //REQUIRES: String length cannot be 0
    //MODIFIES: this
    //EFFECT: Sets the name of the event to newName
    public void setEventName(String newName) {
        eventName = newName;
    }


    //MODIFIES: this
    //EFFECT: Sets the date of the event to newDate
    public void setDate(int newDate) {
        date = newDate;
    }


    //MODIFIES: this
    //EFFECT: Sets the description of the event to newDesc
    public void setDescription(String newDesc) {
        description = newDesc;
    }


}