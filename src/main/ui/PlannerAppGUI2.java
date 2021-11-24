//package ui;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import model.Event;
//import model.Planner;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//
//public class PlannerAppGUI2 extends JFrame implements ActionListener {
//    private Planner planner;
//    private JsonWriter jsonWriter;
//    private JsonReader jsonReader;
//    private static final String JSON_STORE = "./data/Planner.json";
//    private JList list;
//    private DefaultListModel listModel;
//
//    private JButton newEventButton;
//    private JButton editEventButton;
//    private JButton saveButton;
//    private JButton loadButton;
//    private JPanel calendarContainer;
//    private JPanel monPanel;
//    private JPanel tuesPanel;
//    private JPanel wedPanel;
//    private JPanel thursPanel;
//    private JPanel friPanel;
//    private JPanel satPanel;
//    private JPanel sunPanel;
//
//
//    public PlannerAppGUI2() {
//        initializeEvent();
//        initializeMenu();
//    }
//
//    //EFFECT: Creates the planner object, jsonWriter, jsonReader
//    private void initializeEvent() {
//        planner = new Planner("My Planner");
//        jsonWriter = new JsonWriter(JSON_STORE);
//        jsonReader = new JsonReader(JSON_STORE);
//    }
//
//    //EFFECT: Creates a planner frame with title, Border Layout, sidebar menu, and calendar container
//    public void initializeMenu() {
//        this.setTitle("Your weekly planner!");
//        ImageIcon image = new ImageIcon("clockicon.png");
//        this.setIconImage(image.getImage());
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//        this.setSize(1700, 750);
//        this.setResizable(false);
//        this.getContentPane().setBackground(new Color(200, 230, 230));
//        this.setLayout(new BorderLayout());
//        initializeSidebarMenu();
//        calendarContainer();
////        initializeDates();
//
//    }
//
//    //EFFECTS: Creates the sidebar menu with the save/load/edit/new event buttons
//    public void initializeSidebarMenu() {
//        makeNewEventButton();
//        makeEditEventButton();
//        makeSaveButton();
//        makeLoadButton();
//
//        JPanel menuBorder = new JPanel();
//        menuBorder.setPreferredSize(new Dimension(280, 100));
//        menuBorder.setBackground(Color.LIGHT_GRAY);
//        menuBorder.setLayout(new GridLayout(4, 1));
//        this.add(menuBorder, BorderLayout.EAST);
//        menuBorder.add(newEventButton);
//        menuBorder.add(editEventButton);
//        menuBorder.add(saveButton);
//        menuBorder.add(loadButton);
//
//    }
//
//    //EFFECT: Creates button to make new event
//    private void makeNewEventButton() {
//        newEventButton = new JButton();
//        newEventButton.setBounds(100, 400, 100, 100);
//        newEventButton.addActionListener(this);
//        newEventButton.setText("New Event");
//    }
//
//    //EFFECT: Creates button to edit an event
//    private void makeEditEventButton() {
//        editEventButton = new JButton();
//        editEventButton.setBounds(1450, 400, 100, 100);
//        newEventButton.addActionListener(this);
//        editEventButton.setText("Edit Event");
//    }
//
//    //EFFECT: Creates button to save
//    private void makeSaveButton() {
//        saveButton = new JButton();
//        saveButton.setBounds(100, 100, 100, 100);
//        saveButton.addActionListener(this);
//        saveButton.setText("Save");
//    }
//
//    //EFFECT: Creates button to load
//    private void makeLoadButton() {
//        loadButton = new JButton();
//        loadButton.setBounds(1450, 400, 100, 100);
//        saveButton.addActionListener(this);
//        loadButton.setText("Load");
//    }
//
////-----------------------------------------------CALENDAR INIT-------------------------------------
//
//    //Initializes containers for dates from Monday to Sunday
//    public void initializeDates() {
//        initializeMon();
//        initializeTues();
//        initializeWed();
//        initializeThurs();
//        initializeFri();
//        initializeSat();
//        initializeSun();
//    }
//
//    //Creates the container that the dates are placed in
//    public void calendarContainer() {
//        calendarContainer = new JPanel();
//        this.add(calendarContainer, BorderLayout.CENTER);
//        calendarContainer.setLayout(new BorderLayout());
//
//        listModel = new DefaultListModel();
//        listModel.addElement("Test Event - " + "Monday");
//
//        //Create the list and put it in a scroll pane.
//        list = new JList(listModel);
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        list.setSelectedIndex(0);
////        list.addListSelectionListener(listener);
//        list.setVisibleRowCount(5);
//        JScrollPane listScrollPane = new JScrollPane(list);
//
//        calendarContainer.add(listScrollPane);
//
//    }
//
//    //Effect: Initializes the Monday column as a JPanel with BorderLayout
//    public void initializeMon() {
//        monPanel = new JPanel();
//        monPanel.setVisible(true);
//        monPanel.setBounds(0, 0, 200, 1000);
//        monPanel.setLayout(new BorderLayout());
////
////        JList list = new JList(new DefaultListModel());
////        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
////        list.setSelectedIndex(0);
////
////        JScrollPane listScrollPane = new JScrollPane(list);
//
//        monPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        calendarContainer.add(monPanel, BorderLayout.CENTER);
//
//        JLabel date = new JLabel();
//        date.setText("Monday");
//        monPanel.add(date, BorderLayout.NORTH);
////        monPanel.add(listScrollPane);
//    }
//
//    public void initializeTues() {
//        tuesPanel = new JPanel();
//        tuesPanel.setVisible(true);
//        tuesPanel.setBounds(200, 0, 200, 1000);
//        tuesPanel.setLayout(new BorderLayout());
//        tuesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        calendarContainer.add(tuesPanel, BorderLayout.CENTER);
//
//        JLabel date = new JLabel();
//        date.setText("Tuesday");
//        tuesPanel.add(date, BorderLayout.NORTH);
//    }
//
//    public void initializeWed() {
//        wedPanel = new JPanel();
//        wedPanel.setVisible(true);
//        wedPanel.setBounds(400, 0, 200, 1000);
//        wedPanel.setLayout(new BorderLayout());
//        wedPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        calendarContainer.add(wedPanel, BorderLayout.CENTER);
//
//        JLabel date = new JLabel();
//        date.setText("Wednesday");
//        wedPanel.add(date, BorderLayout.NORTH);
//    }
//
//    public void initializeThurs() {
//        thursPanel = new JPanel();
//        thursPanel.setVisible(true);
//        thursPanel.setBounds(600, 0, 200, 1000);
//        thursPanel.setLayout(new BorderLayout());
//        thursPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        calendarContainer.add(thursPanel, BorderLayout.CENTER);
//
//        JLabel date = new JLabel();
//        date.setText("Thursday");
//        thursPanel.add(date, BorderLayout.NORTH);
//    }
//
//    public void initializeFri() {
//        friPanel = new JPanel();
//        friPanel.setVisible(true);
//        friPanel.setBounds(800, 0, 200, 1000);
//        friPanel.setLayout(new BorderLayout());
//        friPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        calendarContainer.add(friPanel, BorderLayout.CENTER);
//
//        JLabel date = new JLabel();
//        date.setText("Friday");
//        friPanel.add(date, BorderLayout.NORTH);
//    }
//
//    public void initializeSat() {
//        satPanel = new JPanel();
//        satPanel.setVisible(true);
//        satPanel.setBounds(1000, 0, 200, 1000);
//        satPanel.setLayout(new BorderLayout());
//        satPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        calendarContainer.add(satPanel, BorderLayout.CENTER);
//
//        JLabel date = new JLabel();
//        date.setText("Saturday");
//        satPanel.add(date, BorderLayout.NORTH);
//    }
//
//    public void initializeSun() {
//        sunPanel = new JPanel();
//        sunPanel.setVisible(true);
//        sunPanel.setBounds(1200, 0, 200, 1000);
//        sunPanel.setLayout(new BorderLayout());
//        sunPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        calendarContainer.add(sunPanel, BorderLayout.CENTER);
//
//        JLabel date = new JLabel();
//        date.setText("Sunday");
//        sunPanel.add(date, BorderLayout.NORTH);
//    }
//
//
//    //--------------------------------------END DATE INIT------------------------------------
//
//
//    //Code based on JsonSerializationDemo
//    // EFFECTS: saves the planner to file
//    private void savePlanner() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(planner);
//            jsonWriter.close();
//            System.out.println("Saved " + planner.getPlannerName() + " to " + JSON_STORE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE);
//        }
//    }
//
//
//    //Code based on JsonSerializationDemo
//    // MODIFIES: this
//    // EFFECTS: loads planner from file
//    private void loadPlanner() {
//        try {
//            planner = jsonReader.read();
//            System.out.println("Loaded " + planner.getPlannerName() + " from " + JSON_STORE);
//            displayEvents();
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//    }
//
//
//    //EFFECTS: Displays a list of all current scheduled events
//    private void displayEvents() {
//        for (int i = 0; i < planner.getPlannerSize(); i++) {
//            Event currentEvent = planner.numEvent(i);
//            JLabel eventLabel = makeDateLabel(currentEvent);
//
//            if (currentEvent.getEventDateString() == "Monday") {
//                monPanel.add(eventLabel, BorderLayout.CENTER);
//            } else if (currentEvent.getEventDateString() == "Tuesday") {
//                tuesPanel.add(eventLabel, BorderLayout.CENTER);
//            } else if (currentEvent.getEventDateString() == "Wednesday") {
//                wedPanel.add(eventLabel, BorderLayout.CENTER);
//            } else if (currentEvent.getEventDateString() == "Thursday") {
//                thursPanel.add(eventLabel, BorderLayout.CENTER);
//            } else if (currentEvent.getEventDateString() == "Friday") {
//                friPanel.add(eventLabel, BorderLayout.CENTER);
//            } else if (currentEvent.getEventDateString() == "Saturday") {
//                satPanel.add(eventLabel, BorderLayout.CENTER);
//            } else if (currentEvent.getEventDateString() == "Sunday") {
//                sunPanel.add(eventLabel, BorderLayout.CENTER);
//            }
//            System.out.println((i + 1) + " -> " + currentEvent.getEventName()
//                    + " is scheduled for " + currentEvent.getEventDateString() + "\n");
//        }
//    }
//
//    private JLabel makeDateLabel(Event currentEvent) {
////        JPanel eventPanel = new JPanel();
//        JLabel eventLabel = new JLabel();
//        eventLabel.setText(currentEvent.getEventName());
//////        eventPanel.add(eventLabel);
////        eventPanel.setBackground(Color.red);
////        eventPanel.setVisible(true);
////        eventPanel.setOpaque(true);
////        eventPanel.setSize(180,100);
//        return eventLabel;
//    }
//
//    //MODIFIES: this, Planner
//    //EFFECT: Displays the pop-up window for making a new event, and creates new event based on input
//    private void newEventWindow() {
//        String eventName = JOptionPane.showInputDialog("What would you like to name your event?");
//        System.out.println(eventName);
//
//        Object[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
//        String eventDate = (String) JOptionPane.showInputDialog(
//                null,
//                "Please select a date for your event.",
//                "Date Selection",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                weekdays,
//                "Monday");
//
//        System.out.println(eventDate);
//
//        Integer dateInt = dayToInt(eventDate);
//
//        Event newEvent = new Event(eventName, dateInt,"desc");
//        addEvent(newEvent);
//    }
//
//    //NOT IMPLEMENTED YET!!! Should have option to rename, change date, and delete selected event
//    private void editEventWindow() {
//        //Select Event, then can change the date, name, or remove
//
//
//        Object[] events = {planner.getEvents()};
//        String selectedEvent = (String) JOptionPane.showInputDialog(
//                null,
//                "How would you like to edit your event?",
//                "Edit Selection",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                events,
//                planner.getEvents().indexOf(0));
//
//        Object[] options = {"Rename Event", "Change Event Date", "Remove Event"};
//        String selection = (String) JOptionPane.showInputDialog(
//                null,
//                "How would you like to edit your event?",
//                "Edit Selection",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                options,
//                "Rename Event");
//
//        if (selection == "Rename Event") {
//            System.out.println("rename");
//            //enter name, then change selected event name to new name
//        } else if (selection == "Change Event Date") {
//            System.out.println("Change");
//        } else if (selection == "Remove Event") {
//            planner.removeEvent(selectedEvent);
//        }
//    }
//
//    //EFFECT: Adds event to planner and displays it
//    private void addEvent(Event event) {
//
////        Event newEvent = new Event(name,dateInt,"No description");
//        planner.addEvent(event);
//        System.out.println("New event created! Event:" + event.getEventName() + " at " + event.getEventDateString());
//        displayEvents();
//    }
//
//    //EFFECT: Returns the corresponding int each day corresponds to
//    private int dayToInt(String eventDate) {
//        Integer dateInt = 0;
//        if (eventDate == "Monday") {
//            dateInt = 1;
//        } else if (eventDate == "Tuesday") {
//            dateInt = 2;
//        } else if (eventDate == "Wednesday") {
//            dateInt = 3;
//        } else if (eventDate == "Thursday") {
//            dateInt = 4;
//        } else if (eventDate == "Friday") {
//            dateInt = 5;
//        } else if (eventDate == "Saturday") {
//            dateInt = 6;
//        } else if (eventDate == "Sunday") {
//            dateInt = 7;
//        }
//        return dateInt;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == saveButton) {
//            savePlanner();
//        } else if (e.getSource() == loadButton) {
//            loadPlanner();
//        }  else if (e.getSource() == newEventButton) {
//            newEventWindow();
//            monPanel.revalidate();
//            monPanel.repaint();
//        } else if (e.getSource() == editEventButton) {
//            editEventWindow();
//        }
//
//    }
//
//}