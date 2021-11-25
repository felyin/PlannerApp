package persistence;

import model.Events;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Code based on JsonSerializationDemo

public class JsonTest {
    protected void checkEvent(String name, Integer date, String desc, Events events) {
        assertEquals(name, events.getEventName());
        assertEquals(date, events.getEventDate());
        assertEquals(desc, events.getEventDescription());
    }
}
