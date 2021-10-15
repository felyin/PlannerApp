package ui;

import model.Event;
import model.Planner;

import java.util.Locale;
import java.util.Scanner;


public class PlannerApp {
    private Event event;
    private Planner planner;
    private Scanner input;

    public PlannerApp() {
        runPlanner();
    }

//Code based off of TellerApp
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
            } else {
                System.out.println("Invalid Selection.");
            }
        }

        System.out.println("\nSee you next time.");
    }

    // MODIFIES: this
    // EFFECTS: initializes a new event for the user to modify
    private void initializeEvent() {
        Event newEvent = new Event("No Name Set",0,"No description");
        Planner planner = new Planner();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    //EFFECTS: Displays menu of options to the user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tnew -> make a new event");
        System.out.println("\tedit -> edit the details of an event");
        System.out.println("\tlist -> see a list of upcoming events");
        System.out.println("\tquit -> quit");
    }

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
        Integer date = input.nextInt();

        if (date > 0 && date < 8) {
            newEvent.setEventDate(date);
            setEventDescription(newEvent);
        } else {
            System.out.println("Please enter a number from 1 to 7.");
        }

    }

    //EFFECTS: Prints out a menu of dates for the user to see
    private void displayDateMenu() {
        System.out.print("\nSelect a date for your event:");
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
        //String eventDescription = input.toString();
        newEvent.setEventDescription("eventDescription");
        planner.addEvent(newEvent);
        System.out.println("Event created!");
    }

    //EFFECTS: Displays a list of all current scheduled events
    private void displayEventList() {
        for (int i = 0; i < planner.getPlannerSize(); i++) {
            System.out.println(event.getEventName() + " is scheduled for " + event.getEventDate());
        }
    }

    //EFFECTS: Lets user select the event they want to edit.
    private void editEvent() {
        System.out.println("Which event would you like to edit? Type in its name.");
        displayEventList();
        Event toEdit;
        for (int i = 0; i < planner.getPlannerSize(); i++) {
            if (input.next() == event.getEventName()) {
                toEdit = event;
                selectEditOption(toEdit);
            } else {
                System.out.println("That event does not exist.");
            }
        }
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
        toEdit.setEventName(input.next());
        System.out.println("Event has been renamed to " + toEdit.getEventName());
    }

    //MODIFIES: thisEvent
    //EFFECTS: Changes the date of the event to a new date
    private void changeEventDate(Event toEdit) {
        displayDateMenu();
        if (input.nextInt() > 0 && input.nextInt() < 8) {
            toEdit.setEventDate(input.nextInt());
            System.out.println("Event date has been changed to " + toEdit.getEventDate());
        } else {
            System.out.println("Please select a number from 1 to 7.");
        }
    }




}
