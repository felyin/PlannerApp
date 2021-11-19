package ui;

import javax.swing.*;

public class EventMaker {
    JFrame frame;
    JLabel label;

    public EventMaker() {
        label = new JLabel();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLayout(null);
    }

    public void initiate() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLayout(null);
    }


}
