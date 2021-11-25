package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class EventsTest {
    private Events testEvents;


    @BeforeEach
    void runBefore() {
        testEvents = new Events("Test Event", 7,"This event is a test" );
    }

    @Test
    void testSetEvent() {
        assertEquals("Test Event", testEvents.getEventName());
        assertEquals(7, testEvents.getEventDate());
        assertEquals("This event is a test", testEvents.getEventDescription());
    }

    @Test
    void testSetEventName() {
        testEvents.setEventName("New Name");
        assertEquals("New Name", testEvents.getEventName());
    }

    @Test
    void testSetEventDate() {
        testEvents.setEventDate(5);
        assertEquals(5, testEvents.getEventDate());
    }

    @Test
    void testSetEventDescription() {
        testEvents.setEventDescription("New description");
        assertEquals("New description", testEvents.getEventDescription());
    }

    @Test
    void testGetEventDateStringSunday() {
        assertEquals("Sunday", testEvents.getEventDateString());
    }

    @Test
    void testGetEventDateStringSaturday() {
        testEvents.setEventDate(6);
        assertEquals("Saturday", testEvents.getEventDateString());
    }

    @Test
    void testGetEventDateStringFriday() {
        testEvents.setEventDate(5);
        assertEquals("Friday", testEvents.getEventDateString());
    }

    @Test
    void testGetEventDateStringThursday() {
        testEvents.setEventDate(4);
        assertEquals("Thursday", testEvents.getEventDateString());
    }

    @Test
    void testGetEventDateStringWednesday() {
        testEvents.setEventDate(3);
        assertEquals("Wednesday", testEvents.getEventDateString());
    }

    @Test
    void testGetEventDateStringTuesday() {
        testEvents.setEventDate(2);
        assertEquals("Tuesday", testEvents.getEventDateString());
    }

    @Test
    void testGetEventDateStringMonday() {
        testEvents.setEventDate(1);
        assertEquals("Monday", testEvents.getEventDateString());
    }

    @Test
    void testGetEventDateStringInvalid() {
        testEvents.setEventDate(9);
        assertEquals("Invalid Selection", testEvents.getEventDateString());
    }

    @Test
    void testToJson() {
        JSONObject testObject = testEvents.toJson();
        assertEquals(testObject.get("name"), testEvents.getEventName());
        assertEquals(testObject.get("day"), testEvents.getEventDate());
        assertEquals(testObject.get("description"), testEvents.getEventDescription());
    }

}

