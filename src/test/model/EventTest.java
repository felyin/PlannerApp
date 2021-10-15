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
        assertEquals(7, testEvent.getDate());
        assertEquals("This event is a test", testEvent.getDescription());
    }

}

