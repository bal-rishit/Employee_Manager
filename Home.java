package org.example;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton add,view,update,delete;

    Home(){
        setLayout(null);

//        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("src/icons/home.jpg"));
//        Image i2 = il.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0,0,1120,630);
//        add(image);

        JLabel heading = new JLabel("Employee Manager System");
        heading.setBounds(650,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        add(heading);

        add = new JButton("Add");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        add(add);

        view = new JButton("View");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        add(view);

        update = new JButton("Update");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        add(update);

        delete = new JButton("Remove");
        delete.setBounds(820,140,150,40);
        delete.addActionListener(this);
        add(delete);

        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            setVisible(false);
            new AddEmployee();

        } else if (e.getSource()==view) {
            setVisible(false);
            new ViewEmployee();

        } else if (e.getSource()==update) {
            setVisible(false);
            new ViewEmployee();
        } else {
            setVisible(false);
            new RemoveEmployee();
        }
    }
}
