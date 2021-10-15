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

        init();

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
    // EFFECTS: initializes the list of events
    private void init() {
        Planner planner = new Planner();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("new")) {
            makeEvent();
        } else if (command.equals("edit")) {
            editEvent();
        } else if (command.equals("list")) {
            displayList();
        } else {
            System.out.println("Invalid Selection.");
        }
    }

    //EFFECTS: Displays menu of options to the user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tnew -> make a new event");
        System.out.println("\tedit -> edit the details of an event");
        System.out.println("\tlist -> see a list of upcoming events");
        System.out.println("\tquit -> quit");
    }

    //    // EFFECTS: prompts user to select chequing or savings account and returns it
    //    private Account selectAccount() {
    //        String selection = "";  // force entry into loop
    //
    //        while (!(selection.equals("c") || selection.equals("s"))) {
    //            System.out.println("c for chequing");
    //            System.out.println("s for savings");
    //            selection = input.next();
    //            selection = selection.toLowerCase();
    //        }
    //
    //        if (selection.equals("c")) {
    //            return cheq;
    //        } else {
    //            return sav;
    //        }
    //    }


}
