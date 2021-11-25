package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlannerTest {
    private Planner testPlanner;
    private Events events1;

    @BeforeEach
    void runBefore() {
        testPlanner = new Planner("TestPlanner");
        events1 = new Events("Event 1", 1, "Test 1");
        testPlanner.addEvent(events1);


    }

    @Test
    void testGetPlannerSize() {
        Events events2 = new Events("Event 2", 7, "Test 2");
        Events events3 = new Events("Event 3", 4, "Test 3");
        testPlanner.addEvent(events2);
        testPlanner.addEvent(events3);
        assertEquals(3, testPlanner.getPlannerSize());
    }


    @Test
    void testAddOneEventToPlanner() {
        assertEquals(1, testPlanner.getPlannerSize());
    }

    @Test
    void testAddMultipleEventsToPlanner() {
        Events events2 = new Events("Event 2", 2, "Test 2");
        Events events3 = new Events("Event 3", 3, "Test 3");
        testPlanner.addEvent(events2);
        testPlanner.addEvent(events3);
        assertEquals(3, testPlanner.getPlannerSize());
    }

    @Test
    void testRemoveEventFromPlanner() {
        Events events2 = new Events("Event 2", 2, "Test 2");
        Events events3 = new Events("Event 3", 3, "Test 3");
        testPlanner.addEvent(events2);
        testPlanner.addEvent(events3);
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
        Events events2 = new Events("Event 2", 2, "Test 2");
        Events events3 = new Events("Event 3", 3, "Test 3");
        testPlanner.addEvent(events2);
        testPlanner.addEvent(events3);
        assertEquals(testPlanner.numEvent(2), events3);
    }

    @Test
    void testGetPlannerName() {
        assertEquals("TestPlanner", testPlanner.getPlannerName());
    }

    @Test
    void testGetEvents() {
        Planner eventsPlannerTest = new Planner("many events");
        Events events1 = new Events("Event 1", 1, "Test 1");
        Events events2 = new Events("Event 2", 7, "Test 2");
        Events events3 = new Events("Event 3", 4, "Test 3");
        eventsPlannerTest.addEvent(events1);
        eventsPlannerTest.addEvent(events2);
        eventsPlannerTest.addEvent(events3);
        ArrayList<Events> eventsList = new ArrayList<>();
        eventsList.add(events1);
        eventsList.add(events2);
        eventsList.add(events3);
        assertEquals(eventsPlannerTest.getEvents(), eventsList);
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
