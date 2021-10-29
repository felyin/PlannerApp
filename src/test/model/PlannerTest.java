package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlannerTest {
    private Planner testPlanner;
    private Event event1;

    @BeforeEach
    void runBefore() {
        testPlanner = new Planner("TestPlanner");
        event1 = new Event("Event 1", 1, "Test 1");
        testPlanner.addEvent(event1);


    }

    @Test
    void testGetPlannerSize() {
        Event event2 = new Event("Event 2", 7, "Test 2");
        Event event3 = new Event("Event 3", 4, "Test 3");
        testPlanner.addEvent(event2);
        testPlanner.addEvent(event3);
        assertEquals(3, testPlanner.getPlannerSize());
    }


    @Test
    void testAddOneEventToPlanner() {
        assertEquals(1, testPlanner.getPlannerSize());
    }

    @Test
    void testAddMultipleEventsToPlanner() {
        Event event2 = new Event("Event 2", 2, "Test 2");
        Event event3 = new Event("Event 3", 3, "Test 3");
        testPlanner.addEvent(event2);
        testPlanner.addEvent(event3);
        assertEquals(3, testPlanner.getPlannerSize());
    }

    @Test
    void testRemoveEventFromPlanner() {
        Event event2 = new Event("Event 2", 2, "Test 2");
        Event event3 = new Event("Event 3", 3, "Test 3");
        testPlanner.addEvent(event2);
        testPlanner.addEvent(event3);
        testPlanner.removeEvent("Event 2");
        assertEquals(2,testPlanner.getPlannerSize());
    }

    @Test
    void testRemoveOnlyEventFromPlanner() {
        testPlanner.removeEvent("Event 1");
        assertEquals(0,testPlanner.getPlannerSize());
    }

    @Test
    void testGetThirdEvent() {
        Event event2 = new Event("Event 2", 2, "Test 2");
        Event event3 = new Event("Event 3", 3, "Test 3");
        testPlanner.addEvent(event2);
        testPlanner.addEvent(event3);
        assertEquals(testPlanner.numEvent(2), event3);
    }

    @Test
    void testGetPlannerName() {
        assertEquals("TestPlanner", testPlanner.getPlannerName());
    }

    @Test
    void testGetEvents() {
        Planner eventsPlannerTest = new Planner("many events");
        Event event1 = new Event("Event 1", 1, "Test 1");
        Event event2 = new Event("Event 2", 7, "Test 2");
        Event event3 = new Event("Event 3", 4, "Test 3");
        eventsPlannerTest.addEvent(event1);
        eventsPlannerTest.addEvent(event2);
        eventsPlannerTest.addEvent(event3);
        ArrayList<Event> eventList = new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);
        eventList.add(event3);
        assertEquals(eventsPlannerTest.getEvents(),eventList);
    }

//    @Test
//    void testToJson() {
//        JSONObject testObject = testPlanner.toJson();
//        assertEquals(testObject.get("name"), testPlanner.getPlannerName());
//        Event firstEvent = event1;
//        ArrayList newList = new ArrayList();
//        newList.add(firstEvent.toJson());
//        assertEquals(testObject.get("events"), newList);
//    }



}
