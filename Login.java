package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername, tfpass;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);

        JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(40,70,100,30);
        add(lblpass);

        tfpass = new JTextField();
        tfpass.setBounds(150,70,150,30);
        add(tfpass);

        JButton login = new JButton("Login");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.LIGHT_GRAY);
        login.addActionListener(this);
        login.setBounds(150,140,150,30);
        add(login);

//        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("src/icons/second.jpg"));
//        Image i2 = il.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(350,0,200,200);

        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username = tfusername.getText();
            String pass = tfpass.getText();

            Conn c = new Conn();

            String query = "select * from login where username = '"+username+"' and password = '"+pass+"'  ";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
               setVisible(false);
               new Home();
            }else {
                JOptionPane.showMessageDialog(null,"Invalid credentials");
                setVisible(false);
            }

        }catch (Exception ee){
            ee.printStackTrace();
        }
    }
}
