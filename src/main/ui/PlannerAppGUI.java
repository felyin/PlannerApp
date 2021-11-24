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
import model.Planner;
import persistence.JsonReader;
import persistence.JsonWriter;

public class PlannerAppGUI extends JFrame implements ActionListener {
    private Planner planner;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/Planner.json";
    private JList list;
    private DefaultListModel listModel;

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

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1700, 750);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(200, 230, 230));
        this.setLayout(new BorderLayout());

        initializeSidebarMenu();
        calendarContainer();
        initializeDates();

//        JPanel titleBorder = new JPanel();
//        titleBorder.setPreferredSize(new Dimension(100,100));
//        titleBorder.setBackground(Color.gray);
//        titleBorder.setVisible(true);
//
//        JLabel titleLabel = new JLabel();
//        titleLabel.setText("Weekly Planner App");
//        titleLabel.setSize(100,100);
//        titleLabel.setVisible(true);
//        titleBorder.add(titleLabel);
//
//        this.add(titleBorder, BorderLayout.NORTH);
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
        monPanel.setLayout(new BorderLayout());
//
//        JList list = new JList(new DefaultListModel());
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        list.setSelectedIndex(0);
//
//        JScrollPane listScrollPane = new JScrollPane(list);

        monPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        calendarContainer.add(monPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Monday");
        monPanel.add(date, BorderLayout.NORTH);
        date.setFont(new Font("Verdana", Font.BOLD, 25));

//        monPanel.add(listScrollPane);
    }

    public void initializeTues() {
        tuesPanel = new JPanel();
        tuesPanel.setVisible(true);
        tuesPanel.setBounds(200, 0, 200, 1000);
        tuesPanel.setLayout(new BorderLayout());
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
        wedPanel.setLayout(new BorderLayout());
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
        thursPanel.setLayout(new BorderLayout());
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
        friPanel.setLayout(new BorderLayout());
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
        satPanel.setLayout(new BorderLayout());
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
        sunPanel.setLayout(new BorderLayout());
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
            updateDisplay();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    //EFFECTS: Displays a list of all current scheduled events
    private void displayEvents() {
        for (int i = 0; i < planner.getPlannerSize(); i++) {
            Event currentEvent = planner.numEvent(i);
            JLabel eventLabel = makeDateLabel(currentEvent);
            eventLabel.setOpaque(true);

            if (currentEvent.getEventDateString() == "Monday") {
                monPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvent.getEventDateString() == "Tuesday") {
                tuesPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvent.getEventDateString() == "Wednesday") {
                wedPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvent.getEventDateString() == "Thursday") {
                thursPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvent.getEventDateString() == "Friday") {
                friPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvent.getEventDateString() == "Saturday") {
                satPanel.add(eventLabel, BorderLayout.CENTER);
            } else if (currentEvent.getEventDateString() == "Sunday") {
                sunPanel.add(eventLabel, BorderLayout.CENTER);
            }
            System.out.println((i + 1) + " -> " + currentEvent.getEventName()
                    + " is scheduled for " + currentEvent.getEventDateString() + "\n");
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

    private JLabel makeDateLabel(Event currentEvent) {
        JLabel eventLabel = new JLabel();
        eventLabel.setText(currentEvent.getEventName());
        return eventLabel;
    }

    //MODIFIES: this, Planner
    //EFFECT: Displays the pop-up window for making a new event, and creates new event based on input
    private void newEventWindow() {
        String eventName = JOptionPane.showInputDialog("What would you like to name your event?");
        System.out.println(eventName);

        Object[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String eventDate = (String) JOptionPane.showInputDialog(
                null,
                "Please select a date for your event.",
                "Date Selection",
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("data/clockicon.png"),
                weekdays,
                "Monday");
        System.out.println(eventDate);
        Integer dateInt = dayToInt(eventDate);

        Event newEvent = new Event(eventName, dateInt,"Default Description");
        addEvent(newEvent);
    }

    private Event eventStringToEvent(String eventName) {
        for (int i = 0; i < planner.getPlannerSize(); i++) {
            Event e = planner.numEvent(i);
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
            Event currentEvent = planner.numEvent(i);
            eventNames.add(currentEvent.getEventName());
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
    private void selectionHandler(Event selectedEvent, String selection) {
        if (selection == "Rename Event") {
            renameEvent(selectedEvent);
        } else if (selection == "Change Event Date") {
            changeDate(selectedEvent);
        } else if (selection == "Remove Event") {
            removeEvent(selectedEvent);
        }
    }

    //MODIFIES: Event
    //EFFECTS: Changes name of event to the input
    private void renameEvent(Event event) {
        String eventName = JOptionPane.showInputDialog("What would you like to name your event?");
        System.out.println(eventName);
        event.setEventName(eventName);
        updateDisplay();
    }

    //MODIFIES: Event
    //EFFECTS: Changes date of event to the new selection
    private void changeDate(Event event) {
        Object[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String eventDate = (String) JOptionPane.showInputDialog(
                null,
                "Please select a date for your event.",
                "Date Selection",
                JOptionPane.PLAIN_MESSAGE,
                null,
                weekdays,
                "Monday");
        event.setEventDate(dayToInt(eventDate));
        updateDisplay();
    }


    //MODIFIES: This
    //EFFECTS: Removes Event from planner list
    private void removeEvent(Event event) {
        planner.removeEvent(event.getEventName());
        repaintRevalidatePanels();
        updateDisplay();
    }

    //EFFECT: Adds event to planner and displays it
    private void addEvent(Event event) {
        planner.addEvent(event);
        System.out.println("New event created! Event:" + event.getEventName() + " at " + event.getEventDateString());
        displayEvents();
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
            System.out.println("save button clicked");
            savePlanner();
        } else if (e.getSource() == loadButton) {
            System.out.println("Load button clicked");
            loadPlanner();
        }  else if (e.getSource() == newEventButton) {
            System.out.println("new event clicked");
            newEventWindow();
        } else if (e.getSource() == editEventButton) {
            System.out.println("edit button clicked");
            editEventWindow();
        }
        repaintRevalidatePanels();

    }

}
