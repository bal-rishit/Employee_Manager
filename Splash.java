package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    Splash(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGER SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.red);
        add(heading);

//        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("/src/main/java/front.jpg"));
//        Image i2 = il.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(50,100,1050,500);

        JButton clickhere = new JButton("CLICK HERE");
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.LIGHT_GRAY);
        clickhere.setBounds(400,400,300,70);
        clickhere.addActionListener(this);
        add(clickhere);


        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}
