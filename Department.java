import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Department extends JFrame {
    JTable table;
    JButton back;

    public Department() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel i4 = new JLabel("Department");
        i4.setBounds(180, 10, 100, 20);
        add(i4);

        JLabel i5 = new JLabel("Budget");
        i5.setBounds(370, 10, 100, 20);
        add(i5);

        table = new JTable();
        table.setBounds(0, 40, 700, 350);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);

        // Provide an instance of ActionListener
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Reception();
            }
        });

        back.setBounds(280, 400, 120, 30);
        add(back);

        setBounds(400, 200, 700, 480);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}

