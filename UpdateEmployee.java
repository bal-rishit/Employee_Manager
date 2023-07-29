package org.example;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateEmployee extends JFrame implements ActionListener {

    JButton add, back ;
    JTextField  tffname , tfaddress, tfphone , tfemail , tfsalary ,tfdes, tfedu ;
    JLabel labelempidno;
    String empid;


    UpdateEmployee(String empId){
        this.empid = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,20,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);

        /////////////////////////////////////////////////////////////////////////////////

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel labeledu = new JLabel("Higher Education");
        labeledu.setBounds(400,300,150,30);
        labeledu.setFont(new Font("serif",Font.PLAIN,20));
        add(labeledu);


        tfedu = new JTextField();
        tfedu.setBounds(600,300,150,30);
        add(tfedu);

        JLabel labeldes = new JLabel("Designation");
        labeldes.setBounds(50,350,150,30);
        labeldes.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldes);

        tfdes = new JTextField();
        tfdes.setBounds(200,350,150,30);
        add(tfdes);

        JLabel labelaadhar = new JLabel("Aadhar No.");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);

        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);

        JLabel labelempid = new JLabel("Employee Id");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);

        labelempidno = new JLabel();
        labelempidno.setBounds(200,400,150,30);
        labelempidno.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempidno);

        try {

            Conn c = new Conn();
            String query = "Select * from employee where empId = '"+empid+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfsalary.setText(rs.getString("salary"));
                tfedu.setText(rs.getString("education"));
                tfemail.setText(rs.getString("email"));
                lblaadhar.setText(rs.getString("aadhar"));
                labelempidno.setText(rs.getString("empId"));
                tfdes.setText(rs.getString("designation"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        add = new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(500,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    public static void main(String[] args) {

        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== add){


            String fname = tffname.getText();
            String education = tfedu.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            String designation = tfdes.getText();



            try {
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated successfully");
                setVisible(false);
                new Home();
            }catch (Exception e1){
                e1.printStackTrace();
            }

        }else {
            setVisible(false);
            new Home();
        }
    }
}
