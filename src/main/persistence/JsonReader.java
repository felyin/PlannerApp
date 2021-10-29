package persistence;

import model.Event;
import model.Planner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads planner from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads planner from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Planner read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePlanner(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Planner from JSON object and returns it
    private Planner parsePlanner(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Planner pl = new Planner(name);
        addEvents(pl, jsonObject);
        return pl;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addEvents(Planner pl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("events");
        for (Object json : jsonArray) {
            JSONObject nextEvent = (JSONObject) json;
            addEvent(pl, nextEvent);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addEvent(Planner pl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Integer day = jsonObject.getInt("day");
        String desc = jsonObject.getString("description");
        Event event = new Event(name, day, desc);
        pl.addEvent(event);
    }
}
