package persistence;

import model.Event;
import model.Planner;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Code based on JsonSerializationDemo
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Planner pl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPlanner() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPlanner.json");
        try {
            Planner pl = reader.read();
            assertEquals("My Planner", pl.getPlannerName());
            assertEquals(0, pl.getPlannerSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralPlanner() {
        JsonReader reader = new JsonReader("./data/testGeneralPlanner.json");
        try {
            Planner pl = reader.read();
            List<Event> event = pl.getEvents();
            assertEquals("My Planner", pl.getPlannerName());
            assertEquals(3, pl.getPlannerSize());
            checkEvent("CPSC Midterm", 1, "Test 1", event.get(0));
            checkEvent("BIOL Midterm", 7, "Test 2", event.get(1));
            checkEvent("PSYC Midterm", 4, "Test 3", event.get(2));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}