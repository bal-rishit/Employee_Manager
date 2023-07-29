package org.example;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener{

    JTable table;
    Choice chempid;
    JButton search , print , update , showAll, back;

    ViewEmployee(){

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel searchlbl = new JLabel("Search through Employee ID");
        searchlbl.setBounds(20,20,170,20);
        add(searchlbl);

        chempid = new Choice();
        chempid.setBounds(200,20,150,20);
        add(chempid);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                chempid.add(rs.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        showAll = new JButton("ShowAll");
        showAll.setBounds(320,70,80,20);
        showAll.addActionListener(this);
        add(showAll);

        back = new JButton("Back");
        back.setBounds(420,70,80,20);
        back.addActionListener(this);
        add(back);



        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==search){
            String query = "select * from employee where empId = '"+chempid.getSelectedItem()+"' ";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e1){
                e1.printStackTrace();
            }


        } else if (e.getSource()==print) {

            try{
                table.print();
            }catch (Exception e1){
                e1.printStackTrace();
            }

        } else if (e.getSource()==update) {
            setVisible(false);
            new UpdateEmployee(chempid.getSelectedItem());

        }else if (e.getSource()==showAll) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from employee");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }
}
