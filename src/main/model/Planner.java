package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Represents a planner, which is a list of events scheduled for the upcoming week (Monday to Sunday)

public class Planner implements Writable {
    private ArrayList<Event> schedule;
    private String plannerName;

    //Constructs a planner with an empty schedule and name
    public Planner(String name) {
        schedule = new ArrayList<>();
        plannerName = name;
    }

    //MODIFIES: this
    //EFFECTS: adds an Event to the schedule.
    public void addEvent(Event event) {
        schedule.add(event);
    }

    //EFFECTS: returns how many items are currently in the planner
    public int getPlannerSize() {
        return schedule.size();
    }

    //EFFECTS: returns the name of the planner  //TODO: ADD TEST FOR THIS AND ADD USER STORY
    public String getPlannerName() {
        return plannerName;
    }

    //MODIFIES: this
    //EFFECTS: removes an Event from the schedule
    public void removeEvent(String name) {
        for (int i = 0; i < schedule.size(); i++) {
            Event e = schedule.get(i);
            if (e.getEventName() == name) {
                schedule.remove(e);
            }
        }
    }

    //EFFECTS: Returns the requested Event from the schedule
    public Event numEvent(int i) {
        return schedule.get(i);
    }

    // EFFECTS: returns an unmodifiable list of events in this planner
    public List<Event> getEvents() {
        return Collections.unmodifiableList(schedule);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", plannerName);
        json.put("events", eventsToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray eventsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Event e : schedule) {
            jsonArray.put(e.toJson());
        }

        return jsonArray;
    }



}
