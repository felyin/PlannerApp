package model;

import java.awt.*;
import java.util.Date;


public class Event {
    private String eventName;   //Name of the event
    private int date;    //Day of the week to schedule the event, with 1 being Monday and 7 being Sunday
    private String description;   //Description of the event


    //REQUIRES: String length cannot be 0
    //MODIFIES: this
    //EFFECTS: Initializes a new event with a name, date, and description. If no input is given for name,
    //         returns "Unnamed Event". If no date is given, the default date is set as Monday.
    //         If no description is given, description is set as "No description".
    public Event(String name, int day, String desc) {
        eventName = name;
        date = day;
        description = desc;
    }

    //GETTERS
    public String getEventName() {
        return eventName;
    }

    public int getEventDate() {
        return date;
    }

    public String getEventDescription() {
        return description;
    }


    //REQUIRES: String length cannot be 0
    //MODIFIES: this
    //EFFECT: Sets or changes the name of the event to newName.
    public void setEventName(String newName) {
        eventName = newName;
    }


    //MODIFIES: this
    //EFFECT: Sets or changes the date of the event to newDate
    public void setEventDate(int newDate) {
        date = newDate;
    }


    //MODIFIES: this
    //EFFECT: Sets or changes the description of the event to newDesc
    public void setEventDescription(String newDesc) {
        description = newDesc;
    }


}