package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hospital Management");
        Font  f1  = new Font(Font.SANS_SERIF, Font.PLAIN,  17);
        Font  f2  = new Font(Font.SANS_SERIF, Font.PLAIN,  10);

        JLabel imageContainer = new JLabel();
        JButton loginButton = new JButton("Login");
        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        JTextField usernameField = new JTextField();
        JPasswordField passField = new JPasswordField();

        imageContainer.setIcon(new ImageIcon("hospital.png"));
        imageContainer.setBounds(20, 10, 50, 50);

        usernameLabel.setBounds(290, 160, 100, 40);
        usernameLabel.setFont(f1);
        usernameLabel.setForeground(Color.WHITE);
        usernameField.setBounds(230, 200, 200, 25);

        passwordLabel.setBounds(290, 310, 100, 40);
        passwordLabel.setFont(f1);
        passwordLabel.setForeground(Color.WHITE);
        passField.setBounds(230, 360, 200, 25);

        loginButton.setBounds(280, 460, 110, 30);
        loginButton.setFont(f2);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);

        Image icon = Toolkit.getDefaultToolkit().getImage("src/za/ac/cput/views/hospital(2).jpg");
        frame.setIconImage(icon);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        frame.getContentPane().add(loginButton);
        frame.getContentPane().add(usernameLabel);
        frame.getContentPane().add(usernameField);
        frame.getContentPane().add(passwordLabel);
        frame.getContentPane().add(passField);
        frame.getContentPane().add(imageContainer);

        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                //Check login details
            }
        });

        frame.setVisible(true);
    }


}
