package model;

import java.util.ArrayList;

public class Planner {
    private ArrayList<Event> schedule;
    private Event event;

    public Planner() {
        schedule = new ArrayList<>();
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

}
