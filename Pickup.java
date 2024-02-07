import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.*;

public class Pickup extends JFrame {
    JTable table;
    JButton back, submit;
    Choice typeofcar;
    JCheckBox available;

    Pickup() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Thoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Type of car");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        typeofcar=new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from driver");
            while (rs.next()) {
                typeofcar.add(rs.getString("brand"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        JLabel i1 = new JLabel("Driver Name");
        i1.setBounds(35, 160, 100, 20);
        add(i1);

        JLabel i2 = new JLabel("Age");
        i2.setBounds(200, 160, 100, 20);
        add(i2);

        JLabel i3 = new JLabel("Gender");
        i3.setBounds(340, 160, 100, 20);
        add(i3);

        JLabel i4 = new JLabel("Brand");
        i4.setBounds(480, 160, 100, 20);
        add(i4);

        JLabel i5 = new JLabel("Company");
        i5.setBounds(600, 160, 100, 20);
        add(i5);

        JLabel i6 = new JLabel("Availability");
        i6.setBounds(750, 160, 100, 20);
        add(i6);

        JLabel i7 = new JLabel("Location");
        i7.setBounds(900, 160, 100, 20);
        add(i7);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300, 520, 120, 30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {
                    try {
                        String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
                        Conn c = new Conn();
                        ResultSet rs;
                        rs = c.s.executeQuery(query);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    setVisible(false);
                    new Reception();
                }
            }
        });
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500, 520, 120, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Reception();
            }
        });
        add(back);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Pickup();
    }
}
