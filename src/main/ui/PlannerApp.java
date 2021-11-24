package ui;

import model.Event;
import model.Planner;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.*;


//The planner application

public class PlannerApp extends JPanel {
    private Planner planner;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/Planner.json";

    public PlannerApp() {
        runPlanner();
    }


//runPlanner based off of TellerApp
    private void runPlanner() {
        boolean keepGoing = true;

        initializeEvent();

        while (keepGoing) {
            displayMenu();
            String command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else if (command.equals("new")) {
                System.out.println("Enter event name:");
                makeEvent();
            } else if (command.equals("edit")) {
                editEvent();
            } else if (command.equals("list")) {
                displayEventList();
            } else if (command.equals("save")) {
                savePlanner();
            } else if (command.equals("load")) {
                loadPlanner();
            } else {
                System.out.println("Invalid Selection.");
            }
        }
        //System.out.println("\nSee you next time.");
    }

    // MODIFIES: this
    // EFFECTS: initializes a new event for the user to modify
    private void initializeEvent() {
        planner = new Planner("My Planner");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    //EFFECTS: Displays menu of options to the user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tnew -> make a new event");
        System.out.println("\tedit -> edit the details of an event");
        System.out.println("\tlist -> see a list of upcoming events");
        System.out.println("\tsave -> save your current planner to file");
        System.out.println("\tload -> load your planner from file");
        System.out.println("\tquit -> quit");
    }

    //REQUIRES: input to be an integer
    //MODIFIES: Event
    //EFFECTS: Makes a new event, sets the name for the event as the user input and then proceeds to setDate
    private void makeEvent() {
        Event newEvent = new Event("No Name Set",0,"No description");
        String selectedName = input.next();
        if (selectedName.length() > 0) {
            newEvent.setEventName(selectedName);
            System.out.println("Event name has been set as " + selectedName);
            setDate(newEvent);

        } else {
            System.out.println("Please enter a name for your event. \n");
        }
    }

    //MODIFIES: Event
    //EFFECTS: Sets the date as the user input
    private void setDate(Event newEvent) {
        displayDateMenu();

        try {
            int date = input.nextInt();
            if (date > 0 && date < 8) {
                newEvent.setEventDate(date);
                setEventDescription(newEvent);
            } else {
                System.out.println("Please enter a number from 1 to 7.");
            }
        } catch (Exception e) {
            System.out.println("Please input a number.");
        }

    }

    //EFFECTS: Prints out a menu of dates for the user to see
    private void displayDateMenu() {
        System.out.print("\nSelect a date for your event:\n");
        System.out.println("\t1 -> Monday");
        System.out.println("\t2 -> Tuesday");
        System.out.println("\t3 -> Wednesday");
        System.out.println("\t4 -> Thursday");
        System.out.println("\t5 -> Friday");
        System.out.println("\t6 -> Saturday");
        System.out.println("\t7 -> Sunday");
        System.out.println("Please enter the number for your selected date.");
    }

    //MODIFIES: Event
    //EFFECTS: Sets the description for the event
    private void setEventDescription(Event newEvent) {
        System.out.println("Please enter a description for your event:");
        String eventDescription = input.next();
        newEvent.setEventDescription(eventDescription);
        System.out.println("Description has been set as " + newEvent.getEventDescription());
        planner.addEvent(newEvent);
        System.out.println("Event " + newEvent.getEventName()
                + " has been scheduled for " + newEvent.getEventDateString() + "!");
    }

    //EFFECTS: Displays a list of all current scheduled events
    private void displayEventList() {
        for (int i = 0; i < planner.getPlannerSize(); i++) {
            Event currentEvent = planner.numEvent(i);
            System.out.println((i + 1) + " -> " + currentEvent.getEventName()
                    + " is scheduled for " + currentEvent.getEventDateString() + "\n");
        }
    }

    //EFFECTS: Lets user select the event they want to edit.
    private void editEvent() {
        System.out.println("Which event would you like to edit? Type in its number on the list.");
        displayEventList();
        Event toEdit = planner.numEvent((input.nextInt()) - 1);

        selectEditOption(toEdit);
    }

    //MODIFIES: this
    //EFFECTS: Lets user choose how to edit their selected event
    private void selectEditOption(Event toEdit) {
        System.out.println("How would you like to edit this event?");
        System.out.println("\tr -> Rename");
        System.out.println("\te -> Edit date");
        System.out.println("\td -> Delete");
        System.out.println("\tb -> Back to Menu");
        String command = input.next();
        if (command.equals("r")) {
            renameEvent(toEdit);
        } else if (command.equals("e")) {
            changeEventDate(toEdit);
        } else if (command.equals("d")) {
            planner.removeEvent(toEdit.getEventName());
        } else if (command.equals("b")) {
            runPlanner();
        } else {
            System.out.println("Please select an option.");
        }
    }

    //MODIFIES: thisEvent
    //EFFECTS: Renames the event to the chosen name
    private void renameEvent(Event toEdit) {
        System.out.println("What would you like to rename it to?");
        toEdit.setEventName(input.next());
        System.out.println("Event has been renamed to " + toEdit.getEventName());
    }

    //MODIFIES: thisEvent
    //EFFECTS: Changes the date of the event to a new date
    private void changeEventDate(Event toEdit) {
        displayDateMenu();

        try {
            int newDate = input.nextInt();
            if (newDate > 0 && newDate < 8) {
                toEdit.setEventDate(newDate);
                System.out.println("Event date has been changed to " + toEdit.getEventDateString());
            } else {
                System.out.println("Please select a number from 1 to 7.");
            }
        } catch (Exception e) {
            System.out.println("Invalid.");
        }
    }

    //Code based on JsonSerializationDemo
    // EFFECTS: saves the planner to file
    private void savePlanner() {
        try {
            jsonWriter.open();
            jsonWriter.write(planner);
            jsonWriter.close();
            System.out.println("Saved " + planner.getPlannerName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //Code based on JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads planner from file
    private void loadPlanner() {
        try {
            planner = jsonReader.read();
            System.out.println("Loaded " + planner.getPlannerName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



// Points to fix: Edit and Load.
    //What should happen in edit: It should make drop-down list off all events in planner, you choose one to edit
    //Icons don't work? I made one in new event button and also for the frame.
    //What's up with checkstyle



}
