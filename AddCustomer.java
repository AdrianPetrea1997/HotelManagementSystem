import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    JComboBox<String> comboid;
    JTextField tfnumber, tfname, tfcountry, checkintime,tfdeposit;
    JRadioButton rmale, rfemale;
    Choice croom;
    JButton add, back;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Rale way", Font.PLAIN, 20));
        add(text);


        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Rale way", Font.PLAIN, 20));
        add(lblid);

        String options[] = {"Passport", "Driving License", "ID-card"};
        comboid = new JComboBox<>(options);
        comboid.setBounds(200, 80, 150, 25);
        add(comboid);


        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35, 120, 100, 20);
        lblnumber.setFont(new Font("Rale way", Font.PLAIN, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
        add(tfnumber);


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Rale way", Font.PLAIN, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);


        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Rale way", Font.PLAIN, 20));
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200, 200, 60, 25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270, 200, 100, 25);
        add(rfemale);


        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Rale way", Font.PLAIN, 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);


        JLabel lbltime = new JLabel("Check-in Time");
        lbltime.setBounds(35, 280, 180, 20);
        lbltime.setFont(new Font("Rale way", Font.PLAIN, 20));
        add(lbltime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        checkintime = new JTextField(dateFormat.format(new Date()));
        checkintime.setBounds(200, 280, 150, 25);
        checkintime.setFont(new Font("Rale way", Font.PLAIN, 15));
        add(checkintime);


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35, 320, 150, 20);
        lblroom.setFont(new Font("Rale way", Font.PLAIN, 20));
        add(lblroom);


        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35, 360, 100, 20);
        lbldeposit.setFont(new Font("Rale way", Font.PLAIN, 20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        add(tfdeposit);





        croom = new Choice();

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM room";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("room number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(200, 320, 150, 25);
        add(croom);


        add = new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(50,410,120,25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(200,410,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/customers.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);


        setBounds(350, 200, 800, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;

            if (rmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }

            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();

            try {
                String query = "INSERT INTO customer VALUES ('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "',  '" + room + "', '" + time + "', '" + deposit + "')";
                String query2 = "UPDATE room SET availability ='Occupied' WHERE roomnumber = '" + room + "'";
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new AddCustomer();
    }
}
