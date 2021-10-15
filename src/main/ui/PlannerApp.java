package ui;

import model.Event;
import model.Planner;

import java.util.Scanner;


public class PlannerApp {
    private Event event;
    private Planner planner;
    private Scanner input;

    public PlannerApp() {
        runPlanner();
    }

    private void runPlanner() {
        boolean keepGoing = true;
        String command = null;

        initializeEvent();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nSee you next time.");
    }

    // MODIFIES: this
    // EFFECTS: initializes a new event for the user to modify
    private void initializeEvent() {
        Event newEvent = new Event("No Name Set",0,"No description");
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

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("new")) {
            makeEvent(input.next());
 //       } else if (command.equals("edit")) {
 //           editEvent();
 //       } else if (command.equals("list")) {
 //           displayList();
        } else {
            System.out.println("Invalid Selection.");
        }
    }

    private void makeEvent(String command) {
        System.out.print("Enter event name: ");
        String selectedName = input.toString();
        if (selectedName.length() > 0) {
            event.setEventName(selectedName);
            System.out.println("Event name has been set as " + selectedName);

        } else {
            System.out.println("Please enter a name for your event. \n");
        }
        setDate(input.nextInt());
    }

    private void setDate(Integer command) {
        displayDateMenu();
        command = input.nextInt();

        if (command > 0 && command < 8) {
            event.setEventDate(command);
            setEventDescription(input.next());
        } else {
            System.out.println("Please enter a number from 1 to 7.");
        }

    }

    private void displayDateMenu() {
        System.out.print("Select a date for your event: ");
        System.out.println("\t1 -> Monday");
        System.out.println("\t2 -> Tuesday");
        System.out.println("\t3 -> Wednesday");
        System.out.println("\t4 -> Thursday");
        System.out.println("\t5 -> Friday");
        System.out.println("\t6 -> Saturday");
        System.out.println("\t7 -> Sunday");
        System.out.println("Please enter the number for your selected date.");
    }

    private void setEventDescription(String command) {
        System.out.println("Please enter a description for your event:");
        event.setEventDescription(input.next());
        planner.addEvent(event);
        System.out.println("Event created!");

    }




}
