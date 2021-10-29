package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class EventTest {
    private Event testEvent;


    @BeforeEach
    void runBefore() {
        testEvent = new Event("Test Event", 7,"This event is a test" );
    }

    @Test
    void testSetEvent() {
        assertEquals("Test Event", testEvent.getEventName());
        assertEquals(7, testEvent.getEventDate());
        assertEquals("This event is a test", testEvent.getEventDescription());
    }

    @Test
    void testSetEventName() {
        testEvent.setEventName("New Name");
        assertEquals("New Name", testEvent.getEventName());
    }

    @Test
    void testSetEventDate() {
        testEvent.setEventDate(5);
        assertEquals(5, testEvent.getEventDate());
    }

    @Test
    void testSetEventDescription() {
        testEvent.setEventDescription("New description");
        assertEquals("New description", testEvent.getEventDescription());
    }

    @Test
    void testGetEventDateStringSunday() {
        assertEquals("Sunday", testEvent.getEventDateString());
    }

    @Test
    void testGetEventDateStringSaturday() {
        testEvent.setEventDate(6);
        assertEquals("Saturday", testEvent.getEventDateString());
    }

    @Test
    void testGetEventDateStringInvalid() {
        testEvent.setEventDate(9);
        assertEquals("Invalid Selection", testEvent.getEventDateString());
    }

}

