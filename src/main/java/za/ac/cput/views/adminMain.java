package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Administrator - Hospital Management");
        Font f1  = new Font(Font.SANS_SERIF, Font.PLAIN,  17);
        Font  f2  = new Font(Font.SANS_SERIF, Font.PLAIN,  10);

        JComboBox menuComboBox = new JComboBox();
        String departments[] =
                {
                        "Nurse", "Cleaning Staff",
                        "Room", "Patient", "Medical Aid", "Doctor",
                        "Appointment", "Secretary", "Invoice", "Medicine",
                        "Driver", "Supplier"
                };
        for(String item : departments)
        {
            menuComboBox.addItem(item);
        }
        menuComboBox.setBounds(270, 20, 150, 30);

        JButton createButton = new JButton("create");
        JButton deleteButton = new JButton("delete");
        JButton readAllButton = new JButton("read all");
        JButton readByIdButton = new JButton("read by id");

        createButton.setBounds(50, 150, 100, 20);
        deleteButton.setBounds(550, 150, 100, 20);
        readByIdButton.setBounds(300, 150, 100, 20);
        readAllButton.setBounds(300, 280, 100, 20);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(0, 310, 700, 250);

        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        frame.add(textArea);
        frame.add(menuComboBox);
        frame.add(createButton);
        frame.add(readAllButton);
        frame.add(readByIdButton);
        frame.add(deleteButton);

        switch(menuComboBox.getSelectedIndex())
        {
            case 0:
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String fname = JOptionPane.showInputDialog("Please enter the nurse's first name");
                        String lname = JOptionPane.showInputDialog("Please enter the nurse's last name");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String nurseGetId = JOptionPane.showInputDialog("Please enter the id of the nurse you're looking for.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String nurseDeleteId = JOptionPane.showInputDialog("Please enter the id of the nurse you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 1:
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String fname = JOptionPane.showInputDialog("Please enter the staff member's first name");
                        String lname = JOptionPane.showInputDialog("Please enter the staff member's last name");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String staffGetId = JOptionPane.showInputDialog("Please enter the id of the cleaning staff member you're looking for.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String staffDeleteId = JOptionPane.showInputDialog("Please enter the id of the staff member you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 2:
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String roomFloor = JOptionPane.showInputDialog("Please enter the room floor");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String roomFloorGetId = JOptionPane.showInputDialog("Please enter the id of the room you're looking for.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String roomFloorDeleteId = JOptionPane.showInputDialog("Please enter the id of the room you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 3:
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String fname = JOptionPane.showInputDialog("Please enter the patient's first name.");
                        String lname = JOptionPane.showInputDialog("Please enter the patient's last name.");
                        String address = JOptionPane.showInputDialog("Please enter the patient's address.");
                        String cell = JOptionPane.showInputDialog("Please enter the patient's cell number,");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String patientId = JOptionPane.showInputDialog("Please enter the id of the patient you're looking for.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String patientId = JOptionPane.showInputDialog("Please enter the id of the patient you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 4:
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String name = JOptionPane.showInputDialog("Please enter the medical aid name.");
                        String address = JOptionPane.showInputDialog("Please enter the medical aid address.");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String medicalAidId = JOptionPane.showInputDialog("Please enter the id of the medical aid you're looking for.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String medicalAidId = JOptionPane.showInputDialog("Please enter the id of the medical aid you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 5:
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String fname = JOptionPane.showInputDialog("Please enter the doctor's first name.");
                        String lname = JOptionPane.showInputDialog("Please enter the doctor's last name.");
                        String cell = JOptionPane.showInputDialog("Please enter the doctor's cell number,");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String doctorId = JOptionPane.showInputDialog("Please enter the id of the doctor you're looking for.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String doctorId = JOptionPane.showInputDialog("Please enter the id of the doctor you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 6:
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String time = JOptionPane.showInputDialog("Please enter the time of the appointment.");
                        String duration = JOptionPane.showInputDialog("Please enter the appointment duration.");
                        String date = JOptionPane.showInputDialog("Please enter the appointment date.");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String appointmentId = JOptionPane.showInputDialog("Please enter the id of the appointment.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String appointmentId = JOptionPane.showInputDialog("Please enter the id of the appointment.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 7:
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String fname = JOptionPane.showInputDialog("Please enter the scretary's first name.");
                        String lname = JOptionPane.showInputDialog("Please enter the secretary's last name.");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String secretaryId = JOptionPane.showInputDialog("Please enter the id of the secretary you're looking for.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String secretaryId = JOptionPane.showInputDialog("Please enter the id of the secretary you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 8://invoice
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String type = JOptionPane.showInputDialog("Please enter the invoice type.");
                        String date = JOptionPane.showInputDialog("Please enter the invoice date.");
                        String amount = JOptionPane.showInputDialog("Please enter the invoice amount.");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String invoiceNum = JOptionPane.showInputDialog("Please enter the invoice number.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String invoiceNum = JOptionPane.showInputDialog("Please enter the invoice number you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 9://medicine
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String amount = JOptionPane.showInputDialog("Please enter the amount for this medicine.");
                        String type = JOptionPane.showInputDialog("What type of medicine is this?.");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String medicineId = JOptionPane.showInputDialog("Please enter the ID of the medicine you would like to find.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String medicineNum = JOptionPane.showInputDialog("Please enter the medicine ID you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 10://driver
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String fname = JOptionPane.showInputDialog("Please enter the driver's first name.");
                        String lname = JOptionPane.showInputDialog("Please enter the driver's last name.");
                        String licenseNum = JOptionPane.showInputDialog("Please enter the license number.");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String driverID = JOptionPane.showInputDialog("Please enter the ID of the driver.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String driverID = JOptionPane.showInputDialog("Please enter the ID of the driver you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
            case 11://supplier
                createButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String address = JOptionPane.showInputDialog("Please enter the supplier's address.");
                        String regNum = JOptionPane.showInputDialog("Please enter the supplier's registration number.");
                    }
                });
                readByIdButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String supplier = JOptionPane.showInputDialog("Please enter the ID of the supplier.");
                    }
                });
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        String supplierID = JOptionPane.showInputDialog("Please enter the ID of the supplier you would like to delete.");
                    }
                });
                readAllButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //read all code goes here
                    }
                });
                break;
        }

        frame.setVisible(true);
    }
}
