package persistence;

import model.Event;
import model.Planner;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//Code based on JsonSerializationDemo

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Planner pl = new Planner("My Planner");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Planner pl = new Planner("My Planner");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPlanner.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPlanner.json");
            pl = reader.read();
            assertEquals("My Planner", pl.getPlannerName());
            assertEquals(0, pl.getPlannerSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralPlanner() {
        try {
            Planner pl = new Planner("My Planner");
            pl.addEvent(new Event("Club Meeting", 2, "Test Writer 1" ));
            pl.addEvent(new Event("Job Interview", 5, "Test Writer 2"));
            pl.addEvent(new Event("Laundry Day", 4, "Test Writer 3"));

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPlanner.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPlanner.json");
            pl = reader.read();
            assertEquals("My Planner", pl.getPlannerName());
            List<Event> events = pl.getEvents();
            assertEquals(3, events.size());
            checkEvent("Club Meeting", 2, "Test Writer 1", events.get(0));
            checkEvent("Job Interview", 5, "Test Writer 2", events.get(1));
            checkEvent("Laundry Day", 4, "Test Writer 3", events.get(2));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}

