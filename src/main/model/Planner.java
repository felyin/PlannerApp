package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Represents a planner, which is a list of events scheduled for the upcoming week (Monday to Sunday)

public class Planner implements Writable {
    private ArrayList<Event> eventsList;
    private String plannerName;

    //Constructs a planner with an empty schedule and name
    public Planner(String name) {
        eventsList = new ArrayList<>();
        plannerName = name;
    }

    //MODIFIES: this
    //EFFECTS: adds an Event to the EventsList.
    public void addEvent(Event event) {
        eventsList.add(event);
    }

    //EFFECTS: returns how many items are currently in the planner
    public int getPlannerSize() {
        return eventsList.size();
    }

    //EFFECTS: returns the name of the planner  //TODO: ADD TEST FOR THIS AND ADD USER STORY
    public String getPlannerName() {
        return plannerName;
    }

    //MODIFIES: this
    //EFFECTS: removes an Event from the events list
    public void removeEvent(String name) {
        for (int i = 0; i < eventsList.size(); i++) {
            Event e = eventsList.get(i);
            if (e.getEventName() == name) {
                eventsList.remove(e);
            }
        }
    }

    //EFFECTS: Returns the requested Event from the list
    public Event numEvent(int i) {
        return eventsList.get(i);
    }

    // EFFECTS: returns an unmodifiable list of events in this planner
    public List<Event> getEvents() {
        return Collections.unmodifiableList(eventsList);
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

        for (Event e : eventsList) {
            jsonArray.put(e.toJson());
        }

        return jsonArray;
    }



}
