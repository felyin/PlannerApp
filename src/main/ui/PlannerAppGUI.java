package ui;

import javax.swing.*;
import java.awt.*;

public class PlannerAppGUI extends JFrame {
    JButton saveButton;
    JButton loadButton;
    JPanel calendar;

    public PlannerAppGUI() {
        initializeMenu();
    }

    public void initializeMenu() {
        this.setTitle("Your weekly planner!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1700, 1000);
        this.getContentPane().setBackground(new Color(200, 230, 230));
        this.setLayout(new BorderLayout());
        initializeSidebarMenu();
//        calendar.setLayout(new FlowLayout());
//        this.add(calendar, BorderLayout.CENTER);
        initializeMon();
        initializeTues();
//        initializeWed();
//        initializeThur();
//        initializeFri();
//        initializeSat();
//        initializeSun();
    }

//        JPanel titleBorder = new JPanel();
//        titleBorder.setPreferredSize(new Dimension(100,100));
//        titleBorder.setBackground(Color.gray);
//        this.add(titleBorder, BorderLayout.NORTH);

    public void initializeSidebarMenu() {
        JButton newEventButton = new JButton();
        newEventButton.setBounds(1450, 400, 200, 100);
        newEventButton.setText("New Event");

        JButton editEventButton = new JButton();
        editEventButton.setBounds(1450, 400, 200, 100);
        editEventButton.setText("Edit Event");

        saveButton = new JButton();
        saveButton.setBounds(1450, 100, 200, 100);
        saveButton.setText("Save");

        loadButton = new JButton();
        loadButton.setBounds(1450, 400, 200, 100);
        loadButton.setText("Load");

        JPanel menuBorder = new JPanel();
        menuBorder.setPreferredSize(new Dimension(200,100));
        menuBorder.setBackground(Color.LIGHT_GRAY);
        menuBorder.setLayout(new GridLayout(4,1));
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

    public void initializeMon() {
        JPanel monPanel = new JPanel();
        monPanel.setVisible(true);
        monPanel.setSize(200,100);
        monPanel.setLayout(new BorderLayout());
        monPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(monPanel, BorderLayout.CENTER);

        JLabel date = new JLabel();
        date.setText("Monday");
        monPanel.add(date, BorderLayout.NORTH);
    }

    public void initializeTues() {
        JPanel tuesPanel = new JPanel();
        tuesPanel.setVisible(true);
        tuesPanel.setOpaque(true);
        tuesPanel.setSize(100,200);
        tuesPanel.setBounds(200,0,200,500);
        tuesPanel.setLayout(new BorderLayout());
        tuesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(tuesPanel, BorderLayout.CENTER);
        JLabel date = new JLabel();
        date.setText("Tuesday");
        tuesPanel.add(date, BorderLayout.NORTH);
    }




    //ImageIcon image = new ImageIcon(); CAN ADD IMAGE AS ICON



}
