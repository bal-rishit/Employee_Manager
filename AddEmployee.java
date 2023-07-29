package org.example;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    JButton add, back ;
    JTextField tfname, tffname , tfaddress, tfphone , tfaadhar , tfemail , tfsalary ,tfdes ;
    JDateChooser dcdob;
    JComboBox tfedu;
    JLabel labelempidno;


    Random ran = new Random();
    int rno = ran.nextInt(999999);

    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,20,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);

        /////////////////////////////////////////////////////////////////////////////////

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

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

        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

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

        String[] courses = {"BBA","BCA","BA","BSC","B.Com","BTech" ,"MBA","MCA","MA","MTech","MSC","PhD"};

        tfedu = new JComboBox(courses);
        tfedu.setBackground(Color.WHITE);
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

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);

        JLabel labelempid = new JLabel("Employee Id");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);

        labelempidno = new JLabel("" + rno);
        labelempidno.setBounds(200,400,150,30);
        labelempidno.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempidno);

        add = new JButton("Add Details");
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

        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== add){

            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) tfedu.getSelectedItem();
            String designation = tfdes.getText();
            String aadhar = tfaadhar.getText();
            String empId = labelempidno.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
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
