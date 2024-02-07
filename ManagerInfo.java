import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame {
    JTable table;
    JButton back;

    ManagerInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        JLabel i4 = new JLabel("Name");
        i4.setBounds(40, 10, 100, 20);
        add(i4);

        JLabel i5 = new JLabel("Age");
        i5.setBounds(200, 10, 100, 20);
        add(i5);

        JLabel i6 = new JLabel("Gender");
        i6.setBounds(340, 10, 100, 20);
        add(i6);

        JLabel i7 = new JLabel("Job");
        i7.setBounds(500, 10, 100, 20);
        add(i7);

        JLabel i8 = new JLabel("Salary");
        i8.setBounds(630, 10, 100, 20);
        add(i8);

        JLabel i9 = new JLabel("Phone");
        i9.setBounds(760, 10, 100, 20);
        add(i9);

        JLabel i10 = new JLabel("Email");
        i10.setBounds(900, 10, 100, 20);
        add(i10);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job ='Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Reception();
            }
        });
        back.setBounds(420, 500, 120, 30);
        add(back);

        setBounds(300, 200, 1020, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}

