import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Room extends JFrame {
    JTable table;
    JButton back;

    Room() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/room2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);

        JLabel i4 = new JLabel("Room number");
        i4.setBounds(10, 10, 100, 20);
        add(i4);

        JLabel i5 = new JLabel("Availability");
        i5.setBounds(120, 10, 100, 20);
        add(i5);

        JLabel i6 = new JLabel("Status");
        i6.setBounds(230, 10, 100, 20);
        add(i6);

        JLabel i7 = new JLabel("Price");
        i7.setBounds(330, 10, 100, 20);
        add(i7);

        JLabel i8 = new JLabel("Bed type");
        i8.setBounds(410, 10, 100, 20);
        add(i8);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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
        back.setBounds(200, 500, 120, 30);
        add(back);

        setBounds(300, 200, 1050, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
