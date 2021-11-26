package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;


import model.Event;
import model.EventLog;
import model.Events;
import model.Planner;
import persistence.JsonReader;
import persistence.JsonWriter;

public class PlannerAppGUI extends JFrame implements ActionListener {
    private Planner planner;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/Planner.json";


    private JButton newEventButton;
    private JButton editEventButton;
    private JButton saveButton;
    private JButton loadButton;
    private JPanel calendarContainer;
    private JPanel monPanel;
    private JPanel tuesPanel;
    private JPanel wedPanel;
    private JPanel thursPanel;
    private JPanel friPanel;
    private JPanel satPanel;
    private JPanel sunPanel;


    public PlannerAppGUI() {
        initializeEvent();
        initializeMenu();


    }

    //EFFECT: Creates the planner object, jsonWriter, jsonReader
    private void initializeEvent() {
        planner = new Planner("My Planner");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    //EFFECT: Creates a planner frame with title, Border Layout, sidebar menu, and calendar container
    public void initializeMenu() {
        this.setTitle("Your weekly planner!");

        ImageIcon image = new ImageIcon("data/clockicon.png");
        this.setIconImage(image.getImage());

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                printLog(EventLog.getInstance());
                System.exit(0);
            }
        });
        this.setVisible(true);
        this.setSize(1700, 750);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(200, 230, 230));
        this.setLayout(new BorderLayout());

        initializeSidebarMenu();
        calendarContainer();
        initializeDates();

    }

    public void printLog(EventLog el) {
        for (Event next : el) {
            System.out.println(next);
        }
    }


    //EFFECTS: Creates the sidebar menu with the save/load/edit/new event buttons
    public void initializeSidebarMenu() {
        makeNewEventButton();
        makeEditEventButton();
        makeSaveButton();
        makeLoadButton();


        JPanel menuBorder = new JPanel();
        menuBorder.setPreferredSize(new Dimension(280, 100));
        menuBorder.setBackground(Color.LIGHT_GRAY);
        menuBorder.setLayout(new GridLayout(4, 1));
        this.add(menuBorder, BorderLayout.EAST);
        menuBorder.add(newEventButton);
        menuBorder.add(editEventButton);
        menuBorder.add(saveButton);
        menuBorder.add(loadButton);

    }

    //EFFECT: Creates button to make new event
    private void makeNewEventButton() {
        newEventButton = new JButton("New Event");
        newEventButton.setBounds(100, 400, 100, 100);
        newEventButton.addActionListener(this);

    }

    //EFFECT: Creates button to edit an event
    private void makeEditEventButton() {
        editEventButton = new JButton();
        editEventButton.setBounds(100, 400, 100, 100);
        editEventButton.addActionListener(this);
        editEventButton.setText("Edit Event");
    }

    //EFFECT: Creates button to save
    private void makeSaveButton() {
        saveButton = new JButton();
        saveButton.setBounds(100, 400, 100, 100);
        saveButton.addActionListener(this);
        saveButton.setText("Save");
    }

    //EFFECT: Creates button to load
    private void makeLoadButton() {
        loadButton = new JButton();
        loadButton.setBounds(100, 400, 100, 100);
        loadButton.addActionListener(this);
        loadButton.setText("Load");
    }


//-----------------------------------------------CALENDAR INIT-------------------------------------

    //Initializes containers for dates from Monday to Sunday
    public void initializeDates() {
        initializeMon();
        initializeTues();
        initializeWed();
        initializeThurs();
        initializeFri();
        initializeSat();
        initializeSun();
    }

    //Creates the container that the dates are placed in
    public void calendarContainer() {
        calendarContainer = new JPanel();
        calendarContainer.setLayout(null);
        this.add(calendarContainer, BorderLayout.CENTER);
    }

    //Effect: Initializes the Monday column as a JPanel with BorderLayout
    public void initializeMon() {
        monPanel = new JPanel();
        monPanel.setVisible(true);
        monPanel.setBounds(0, 0, 200, 1000);
        monPanel.setLayout(new BoxLayout(monPanel, BoxLayout.Y_AXIS));
        monPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        calendarContainer.add(monPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Monday");
        monPanel.add(date, BorderLayout.NORTH);
        date.setFont(new Font("Verdana", Font.BOLD, 25));

    }

    public void initializeTues() {
        tuesPanel = new JPanel();
        tuesPanel.setVisible(true);
        tuesPanel.setBounds(200, 0, 200, 1000);
        tuesPanel.setLayout(new BoxLayout(tuesPanel, BoxLayout.Y_AXIS));
        tuesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        calendarContainer.add(tuesPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Tuesday");
        date.setFont(new Font("Verdana", Font.BOLD, 25));
        tuesPanel.add(date, BorderLayout.NORTH);
    }

    public void initializeWed() {
        wedPanel = new JPanel();
        wedPanel.setVisible(true);
        wedPanel.setBounds(400, 0, 200, 1000);
        wedPanel.setLayout(new BoxLayout(wedPanel, BoxLayout.Y_AXIS));
        wedPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        calendarContainer.add(wedPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Wednesday");
        date.setFont(new Font("Verdana", Font.BOLD, 25));
        wedPanel.add(date, BorderLayout.NORTH);
    }

    public void initializeThurs() {
        thursPanel = new JPanel();
        thursPanel.setVisible(true);
        thursPanel.setBounds(600, 0, 200, 1000);
        thursPanel.setLayout(new BoxLayout(thursPanel, BoxLayout.Y_AXIS));
        thursPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        calendarContainer.add(thursPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Thursday");
        date.setFont(new Font("Verdana", Font.BOLD, 25));
        thursPanel.add(date, BorderLayout.NORTH);
    }

    public void initializeFri() {
        friPanel = new JPanel();
        friPanel.setVisible(true);
        friPanel.setBounds(800, 0, 200, 1000);
        friPanel.setLayout(new BoxLayout(friPanel, BoxLayout.Y_AXIS));
        friPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        calendarContainer.add(friPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Friday");
        date.setFont(new Font("Verdana", Font.BOLD, 25));
        friPanel.add(date, BorderLayout.NORTH);
    }

    public void initializeSat() {
        satPanel = new JPanel();
        satPanel.setVisible(true);
        satPanel.setBounds(1000, 0, 200, 1000);
        satPanel.setLayout(new BoxLayout(satPanel, BoxLayout.Y_AXIS));
        satPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        calendarContainer.add(satPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Saturday");
        date.setFont(new Font("Verdana", Font.BOLD, 25));
        satPanel.add(date, BorderLayout.NORTH);
    }

    public void initializeSun() {
        sunPanel = new JPanel();
        sunPanel.setVisible(true);
        sunPanel.setBounds(1200, 0, 200, 1000);
        sunPanel.setLayout(new BoxLayout(sunPanel, BoxLayout.Y_AXIS));
        sunPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        calendarContainer.add(sunPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Sunday");
        date.setFont(new Font("Verdana", Font.BOLD, 25));
        sunPanel.add(date, BorderLayout.NORTH);
    }


    //--------------------------------------END DATE INIT------------------------------------


    //Code based on JsonSerializationDemo
    // EFFECTS: saves the planner to file
    private void savePlanner() {
        try {
            jsonWriter.open();
            jsonWriter.write(planner);
            jsonWriter.close();
          //  System.out.println("Saved " + planner.getPlannerName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }


    //Code based on JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads planner from file
    private void loadPlanner() {
        try {
            planner.loadingEvents();
            planner = jsonReader.read();
            //System.out.println("Loaded " + planner.getPlannerName() + " from " + JSON_STORE);
            updateDisplay();
        } catch (IOException e) {
            //System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    //EFFECTS: Displays a list of all current scheduled events
    private void displayEvents() {
        for (int i = 0; i < planner.getPlannerSize(); i++) {
            Events currentEvents = planner.numEvent(i);
            JLabel eventLabel = makeDateLabel(currentEvents);
            eventLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
            eventLabel.setForeground(Color.BLUE);
            eventLabel.setVisible(true);

            if (currentEvents.getEventDateString() == "Monday") {
                monPanel.add(eventLabel);
            } else if (currentEvents.getEventDateString() == "Tuesday") {
                tuesPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvents.getEventDateString() == "Wednesday") {
                wedPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvents.getEventDateString() == "Thursday") {
                thursPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvents.getEventDateString() == "Friday") {
                friPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvents.getEventDateString() == "Saturday") {
                satPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvents.getEventDateString() == "Sunday") {
                sunPanel.add(eventLabel, BorderLayout.CENTER);
            }
//            System.out.println((i + 1) + " -> " + currentEvent.getEventName()
//                    + " is scheduled for " + currentEvent.getEventDateString() + "\n");
        }
    }

    private void updateDisplay() {
        calendarContainer.remove(monPanel);
        calendarContainer.remove(tuesPanel);
        calendarContainer.remove(wedPanel);
        calendarContainer.remove(thursPanel);
        calendarContainer.remove(friPanel);
        calendarContainer.remove(satPanel);
        calendarContainer.remove(sunPanel);
        initializeDates();
        displayEvents();
    }

    private JLabel makeDateLabel(Events currentEvents) {
        JLabel eventLabel = new JLabel();
        eventLabel.setText(currentEvents.getEventName());
        return eventLabel;
    }

    //MODIFIES: this, Planner
    //EFFECT: Displays the pop-up window for making a new event, and creates new event based on input
    private void newEventWindow() {
        String eventName = JOptionPane.showInputDialog("What would you like to name your event?");
        //System.out.println(eventName);

        Object[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String eventDate = (String) JOptionPane.showInputDialog(
                null,
                "Please select a date for your event.",
                "Date Selection",
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("data/clockicon.png"),
                weekdays,
                "Monday");
        //System.out.println(eventDate);
        Integer dateInt = dayToInt(eventDate);

        Events newEvents = new Events(eventName, dateInt, "Default Description");
        addEvent(newEvents);
    }

    private Events eventStringToEvent(String eventName) {
        for (int i = 0; i < planner.getPlannerSize(); i++) {
            Events e = planner.numEvent(i);
            if (e.getEventName() == eventName) {
                return e;
            }
        }
        return null;
    }

    //EFFECT: Create JOptionPane and allows you to choose an event to edit
    private void editEventWindow() {
        //Select Event, then can change the date, name, or remove

        ArrayList<String> eventNames = new ArrayList<>();
        for (int i = 0; i < planner.getPlannerSize(); i++) {
            Events currentEvents = planner.numEvent(i);
            eventNames.add(currentEvents.getEventName());
        }
        String[] events = eventNames.toArray(new String[0]);
        String selectedEvent = (String) JOptionPane.showInputDialog(
                null,
                "Which Event would you like to edit?",
                "Edit Selection",
                JOptionPane.PLAIN_MESSAGE,
                null,
                events,
                planner.getEvents().indexOf(0));
        editEventWindowSelection(selectedEvent);
    }

    //EFFECTS: Creates JOptionPane to select how you would like to edit your event
    private void editEventWindowSelection(String selectedEvent) {

        Object[] options = {"Rename Event", "Change Event Date", "Remove Event"};
        String selection = (String) JOptionPane.showInputDialog(
                null,
                "How would you like to edit your event?",
                "Edit Selection",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                "Rename Event");
        selectionHandler(eventStringToEvent(selectedEvent), selection);
    }


    //EFFECTS: Calls either rename event, change event date, or remove event depending on selection
    private void selectionHandler(Events selectedEvents, String selection) {
        if (selection == "Rename Event") {
            renameEvent(selectedEvents);
        } else if (selection == "Change Event Date") {
            changeDate(selectedEvents);
        } else if (selection == "Remove Event") {
            removeEvent(selectedEvents);
        }
    }

    //MODIFIES: Event
    //EFFECTS: Changes name of event to the input
    private void renameEvent(Events events) {
        String eventName = JOptionPane.showInputDialog("What would you like to name your event?");
        events.setEventName(eventName);
        updateDisplay();
    }

    //MODIFIES: Event
    //EFFECTS: Changes date of event to the new selection
    private void changeDate(Events events) {
        Object[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String eventDate = (String) JOptionPane.showInputDialog(
                null,
                "Please select a date for your event.",
                "Date Selection",
                JOptionPane.PLAIN_MESSAGE,
                null,
                weekdays,
                "Monday");
        events.setEventDate(dayToInt(eventDate));
        updateDisplay();
    }


    //MODIFIES: This
    //EFFECTS: Removes Event from planner list
    private void removeEvent(Events events) {
        planner.removeEvent(events.getEventName());
        repaintRevalidatePanels();
        updateDisplay();
    }

    //EFFECT: Adds event to planner and displays it
    private void addEvent(Events events) {
        planner.addEvent(events);
        updateDisplay();
    }


    //EFFECT: Returns the corresponding int each day corresponds to
    private int dayToInt(String eventDate) {
        Integer dateInt = 0;
        if (eventDate == "Monday") {
            dateInt = 1;
        } else if (eventDate == "Tuesday") {
            dateInt = 2;
        } else if (eventDate == "Wednesday") {
            dateInt = 3;
        } else if (eventDate == "Thursday") {
            dateInt = 4;
        } else if (eventDate == "Friday") {
            dateInt = 5;
        } else if (eventDate == "Saturday") {
            dateInt = 6;
        } else if (eventDate == "Sunday") {
            dateInt = 7;
        }
        return dateInt;
    }

    private void repaintRevalidatePanels() {
        monPanel.revalidate();
        monPanel.repaint();
        tuesPanel.revalidate();
        tuesPanel.repaint();
        wedPanel.revalidate();
        wedPanel.repaint();
        thursPanel.revalidate();
        thursPanel.repaint();
        friPanel.revalidate();
        friPanel.repaint();
        satPanel.revalidate();
        satPanel.repaint();
        sunPanel.revalidate();
        sunPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            savePlanner();
        } else if (e.getSource() == loadButton) {
            loadPlanner();
        } else if (e.getSource() == newEventButton) {
            newEventWindow();
        } else if (e.getSource() == editEventButton) {
            editEventWindow();
        }
        repaintRevalidatePanels();
    }
}