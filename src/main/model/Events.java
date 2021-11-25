package model;

import org.json.JSONObject;
import persistence.Writable;

import java.awt.*;
import java.util.Date;

//Represents an Event, with its name, date, and description.

public class Events implements Writable {
    private String eventName;   //Name of the event
    private int date;    //Day of the week to schedule the event, with 1 being Monday and 7 being Sunday
    private String description;   //Description of the event


    //REQUIRES: String length cannot be 0
    //MODIFIES: this
    //EFFECTS: Initializes a new event with a name, date, and description. If no input is given for name,
    //         returns "Unnamed Event". If no date is given, the default date is set as Monday.
    //         If no description is given, description is set as "No description".
    public Events(String name, int day, String desc) {
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

    //REQUIRES: date > 0 and date < 8
    //EFFECT: Translates the event date from an integer to the date it represents
    public String getEventDateString() {
        if (date == 1) {
            return "Monday";
        } else if (date == 2) {
            return "Tuesday";
        } else if (date == 3) {
            return "Wednesday";
        } else if (date == 4) {
            return "Thursday";
        } else if (date == 5) {
            return "Friday";
        } else if (date == 6) {
            return "Saturday";
        } else if (date == 7) {
            return "Sunday";
        } else {
            return "Invalid Selection";
        }
    }

    //Code based on JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", eventName);
        json.put("day", date);
        json.put("description", description);
        return json;
    }


}