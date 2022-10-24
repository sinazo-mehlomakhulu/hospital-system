package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;

public class User extends JFrame {
    private static final String[] entities = {" ", "Appointments", "Cleaning Staff", "Doctors", "Drivers", "Hospital Rooms", "Invoices", "Medical Aid", "Medicine", "Nurses", "Patients", "Secretaries", "Suppliers"};
    private static JFrame userFrame;
    private static JPanel userPanel;
    private static JTextArea userArea;
    private static JScrollPane sp;
    private static JLabel entityLabel;
    private static JComboBox<? extends String> comboBox;

  public void setGUI(){
        userFrame = new JFrame("Hospital Management - Client");
        userPanel = new JPanel();

        userFrame.setSize(450, 500);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);

        userFrame.add(userPanel);
        userPanel.setLayout(null);
        userPanel.setBackground(Color.black);

        entityLabel = new JLabel("Entities");
        entityLabel.setForeground(Color.WHITE);
        entityLabel.setFont(new Font("Arial", Font.BOLD, 20));
        entityLabel.setBounds(180, 20, 80, 25);

        comboBox = new JComboBox<>(entities);
        comboBox.setBounds(150, 50, 130, 25);

        userArea = new JTextArea("Silly Things goes here");
        userArea.setEditable(false);
        userArea.setBounds(20, 120, 390, 300);
        sp = new JScrollPane(userArea);

        userPanel.add(entityLabel);
        userPanel.add(comboBox);
        userPanel.add(userArea);
        userFrame.setVisible(true);
    }

}

