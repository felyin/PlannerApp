package persistence;

import model.Event;
import model.Planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Code based on JsonSerializationDemo

public class JsonTest {
    protected void checkEvent(String name, Integer date, String desc, Event event) {
        assertEquals(name, event.getEventName());
        assertEquals(date, event.getEventDate());
        assertEquals(desc, event.getEventDescription());
    }
}
