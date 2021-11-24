//package ui;
//
//import javax.swing.*;
//import javax.swing.table.TableModel;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//
//import model.Event;
//import model.Planner;
//
//public class PlannerAppListGUI extends JPanel {
//    private boolean debug = false;
//    private Planner planner;
//    private Event event;
//    private Object[][] data;
//
//
//    public PlannerAppListGUI() {
//        super(new GridLayout(1,0));
//
//        String[] columnNames = {"Event Name", "Event Date", "Event Description"};
//
////        Object[][] data = {
////                for (int i = 0; i < planner.getPlannerSize(); i++) {
////                    Event currentEvent = planner.numEvent(i);
////                    currentEvent.getEventName();
////                    currentEvent.getEventDate();
////                }
////        };
//        Object[][] data = { {planner.getEvents().toArray()} };
//        this.event = new Event("Test", 2, "Desc");
//
//        for (int i = 0; i < planner.getPlannerSize(); i++) {
//            Event currentEvent = planner.numEvent(i);
//            currentEvent.getEventName();
//            currentEvent.getEventDate();
//
//            this.data = new Object[][]{
//                    {"Event 1", "Monday", "Happening Soon"},
//                    {"Event 2", "Tuesday", "Now"},
//                    {event.getEventName(), event.getEventDateString(), event.getEventDescription()}
//            };
//
//            final JTable table = new JTable(data, columnNames);
//            table.setPreferredScrollableViewportSize(new Dimension(500, 70));
//            table.setFillsViewportHeight(true);
//
//            if (debug) {
//                table.addMouseListener(new MouseAdapter() {
//                    public void mouseClicked(MouseEvent e) {
//                        printDebugData(table);
//                    }
//                });
//            }
//
//            //Create the scroll pane and add the table to it.
//            JScrollPane scrollPane = new JScrollPane(table);
//
//            //Add the scroll pane to this panel.
//            add(scrollPane);
//        }
//
//        private void printDebugData(JTable table) {
//            int numRows = table.getRowCount();
//            int numCols = table.getColumnCount();
//            TableModel model = table.getModel();
//
//            System.out.println("Value of data: ");
//            for (int i=0; i < numRows; i++) {
//                System.out.print("    row " + i + ":");
//                for (int j=0; j < numCols; j++) {
//                    System.out.print("  " + model.getValueAt(i, j));
//                }
//                System.out.println();
//            }
//            System.out.println("--------------------------");
//        }
//
//        /**
//         * Create the GUI and show it.  For thread safety,
//         * this method should be invoked from the
//         * event-dispatching thread.
//         */
//        private static void createAndShowGUI() {
//            //Create and set up the window.
//            JFrame frame = new JFrame("SimpleTableDemo");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            //Create and set up the content pane.
//            PlannerAppListGUI newContentPane = new PlannerAppListGUI();
//            newContentPane.setOpaque(true); //content panes must be opaque
//            frame.setContentPane(newContentPane);
//
//            //Display the window.
//            frame.pack();
//            frame.setVisible(true);
//        }
//
//        public static void main(String[] args) {
//            //Schedule a job for the event-dispatching thread:
//            //creating and showing this application's GUI.
//            SwingUtilities.invokeLater(new Runnable() {
//                public void run() {
//                    createAndShowGUI();
//                }
//            });
//        }
