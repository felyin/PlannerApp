package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlannerTest {
    private Planner testPlanner;

    @BeforeEach
    void runBefore() {
        testPlanner = new Planner("TestPlanner");
        Event event1 = new Event("Event 1", 1, "Test 1");
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


}
