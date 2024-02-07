import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame {
    JTable table;
    JButton back, submit;
    JComboBox<String> bedType;
    JCheckBox available;

    SearchRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Thoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        bedType = new JComboBox<>(new String[]{"Single Bed", "Double Bed"});
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only display Available");
        available.setBounds(650, 100, 200, 25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel i1 = new JLabel("Room number");
        i1.setBounds(50, 160, 100, 20);
        add(i1);

        JLabel i2 = new JLabel("Availability");
        i2.setBounds(270, 160, 100, 20);
        add(i2);

        JLabel i3 = new JLabel("Cleaning Status");
        i3.setBounds(450, 160, 100, 20);
        add(i3);

        JLabel i4 = new JLabel("Price");
        i4.setBounds(670, 160, 100, 20);
        add(i4);

        JLabel i5 = new JLabel("Bed Type");
        i5.setBounds(870, 160, 100, 20);
        add(i5);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });
        submit.setBounds(300, 520, 120, 30);
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Reception();
            }
        });
        back.setBounds(500, 520, 120, 30);
        add(back);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }

    private void performSearch() {
        try {
            String bedTypeValue = (String) bedType.getSelectedItem();
            String query;

            if (available.isSelected()) {
                query = "SELECT * FROM room WHERE bed_type = '" + bedTypeValue + "' AND avaibility = 'Available'";
            } else {
                query = "SELECT * FROM room WHERE bed_type = '" + bedTypeValue + "'";
            }

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
