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

import model.Event;
import model.Planner;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.util.Scanner;

public class PlannerAppGUI extends JFrame implements ActionListener {
    private Planner planner;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/Planner.json";

    JButton newEventButton;
    JButton editEventButton;
    JButton saveButton;
    JButton loadButton;
    JPanel calendarContainer;
    JPanel monPanel;
    JPanel tuesPanel;
    JPanel wedPanel;
    JPanel thursPanel;
    JPanel friPanel;
    JPanel satPanel;
    JPanel sunPanel;


    public PlannerAppGUI() {
        initializeEvent();
        initializeMenu();
    }

    private void initializeEvent() {
        planner = new Planner("My Planner");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    public void initializeMenu() {
        this.setTitle("Your weekly planner!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1700, 750);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(200, 230, 230));
        this.setLayout(new BorderLayout());
        initializeSidebarMenu();
        calendarContainer();
        initializeDates();

        JPanel titleBorder = new JPanel();
        titleBorder.setPreferredSize(new Dimension(100,100));
        titleBorder.setBackground(Color.gray);
        titleBorder.setVisible(true);
        this.add(titleBorder, BorderLayout.NORTH);
    }


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

//        JLabel titleLabel = new JLabel();
//        titleLabel.setText("Weekly Planner App");
//        titleLabel.setSize(100,100);
//        titleBorder.add(titleLabel);
    }

    private void makeNewEventButton() {
        newEventButton = new JButton();
        newEventButton.setBounds(100, 400, 100, 100);
        newEventButton.addActionListener(this);
        newEventButton.setText("New Event");
    }

    private void makeEditEventButton() {
        editEventButton = new JButton();
        editEventButton.setBounds(1450, 400, 100, 100);
        newEventButton.addActionListener(this);
        editEventButton.setText("Edit Event");
    }

    private void makeSaveButton() {
        saveButton = new JButton();
        saveButton.setBounds(100, 100, 100, 100);
        saveButton.addActionListener(this);
        saveButton.setText("Save");
    }

    private void makeLoadButton() {
        loadButton = new JButton();
        loadButton.setBounds(1450, 400, 100, 100);
        saveButton.addActionListener(this);
        loadButton.setText("Load");
    }

//-----------------------------------------------CALENDAR INIT-------------------------------------

    public void initializeDates() {
        initializeMon();
        initializeTues();
        initializeWed();
        initializeThurs();
        initializeFri();
        initializeSat();
        initializeSun();
    }

    public void calendarContainer() {
        calendarContainer = new JPanel();
        calendarContainer.setLayout(null);
        this.add(calendarContainer, BorderLayout.CENTER);
    }

    public void initializeMon() {
        monPanel = new JPanel();
        monPanel.setVisible(true);
        monPanel.setBounds(0, 0, 200, 1000);
        monPanel.setLayout(new BorderLayout());
        monPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        calendarContainer.add(monPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Monday");
        monPanel.add(date, BorderLayout.NORTH);
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
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    private void eventWindow() {
        String eventName = JOptionPane.showInputDialog("What would you like to name your event?");
        System.out.println(eventName);

        Object[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String eventDate = (String) JOptionPane.showInputDialog(
                null,
                "Please select a date for your event.",
                "Date Selection",
                JOptionPane.PLAIN_MESSAGE,
                null,
                weekdays,
                "Monday");
        System.out.println(eventDate);
        addEvent(eventName,eventDate);
    }

    private void addEvent(String name, String date) {
        Integer dateInt = 0;
        if (date == "Monday") {
            dateInt = 1;
        } else if (date == "Tuesday") {
            dateInt = 2;
        } else if (date == "Wednesday") {
            dateInt = 3;
        } else if (date == "Thursday") {
            dateInt = 4;
        } else if (date == "Friday") {
            dateInt = 5;
        } else if (date == "Saturday") {
            dateInt = 6;
        } else if (date == "Sunday") {
            dateInt = 7;
        }

        Event newEvent = new Event(name,dateInt,"No description");
        planner.addEvent(newEvent);
        System.out.println("New event created! Event:" + newEvent.getEventName() + " at " + newEvent.getEventDate());
        displayEvent(newEvent);
    }

    private void displayEvent(Event event) {
        JPanel eventPanel = new JPanel();
        JLabel eventLabel = new JLabel();
        eventLabel.setText(event.getEventName());
        eventPanel.add(eventLabel);
        eventPanel.setVisible(true);
        eventPanel.setSize(180,100);

        if (event.getEventDateString() == "Monday") {
            monPanel.add(eventPanel);
        } else if (event.getEventDateString() == "Tuesday") {
            tuesPanel.add(eventPanel);
        } else if (event.getEventDateString() == "Wednesday") {
            wedPanel.add(eventPanel);
        } else if (event.getEventDateString() == "Thursday") {
            thursPanel.add(eventPanel);
        } else if (event.getEventDateString() == "Friday") {
            friPanel.add(eventPanel);
        } else if (event.getEventDateString() == "Saturday") {
            satPanel.add(eventPanel);
        } else if (event.getEventDateString() == "Sunday") {
            sunPanel.add(eventPanel);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            savePlanner();
        } else if (e.getSource() == loadButton) {
            loadPlanner();
        }  else if (e.getSource() == newEventButton) {
            eventWindow();
        }

    }


    //ImageIcon image = new ImageIcon(); CAN ADD IMAGE AS ICON



}
