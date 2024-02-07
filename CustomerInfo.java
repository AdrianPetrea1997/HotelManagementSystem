import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame {
    JTable table;
    JButton back;

    CustomerInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        JLabel i4 = new JLabel("Document");
        i4.setBounds(40, 10, 100, 20);
        add(i4);

        JLabel i5 = new JLabel("Number");
        i5.setBounds(180, 10, 100, 20);
        add(i5);

        JLabel i6 = new JLabel("Name");
        i6.setBounds(300, 10, 100, 20);
        add(i6);

        JLabel i7 = new JLabel("Gender");
        i7.setBounds(420, 10, 100, 20);
        add(i7);

        JLabel i8 = new JLabel("Country");
        i8.setBounds(540, 10, 100, 20);
        add(i8);

        JLabel i9 = new JLabel("Room");
        i9.setBounds(660, 10, 100, 20);
        add(i9);

        JLabel i10 = new JLabel("CheckInTime");
        i10.setBounds(780, 10, 100, 20);
        add(i10);

        JLabel i11 = new JLabel("Deposit");
        i11.setBounds(900, 10, 100, 20);
        add(i11);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
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
        new CustomerInfo();
    }
}

