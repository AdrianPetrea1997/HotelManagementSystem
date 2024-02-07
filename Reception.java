import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    JButton newCustomer, rooms, department, allEmployee, managerInfo, customerInfo, searchRoom,
            updateStatus, roomStatus, pickup, checkout, logout;

    public Reception() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AddCustomer newCustomerForm = new AddCustomer();
                newCustomerForm.setVisible(true);  // Set the NewCustomer frame visible
                setVisible(false);  // Hide the Reception frame
            }
        });
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Room();
            }
        });
        add(rooms);

        department = new JButton("Departments");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Department();
            }
        });
        add(department);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new EmployeeInfo();
            }
        });
        add(allEmployee);

        customerInfo = new JButton("Customer Info");
        customerInfo.setBounds(10, 190, 200, 30);
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);
        customerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new CustomerInfo();
            }
        });
        add(customerInfo);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new ManagerInfo();
            }
        });
        add(managerInfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Checkout();
            }
        });
        add(checkout);

        JButton pendingStatus = new JButton("Pending Status");
        pendingStatus.setBounds(10, 310, 200, 30);
        pendingStatus.setBackground(Color.BLACK);
        pendingStatus.setForeground(Color.WHITE);
        add(pendingStatus);

        updateStatus = new JButton("Update Status");
        updateStatus.setBounds(10, 350, 200, 30);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new UpdateCheck();
            }
        });
        add(updateStatus);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 390, 200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new UpdateRoom();
            }
        });
        add(roomStatus);

        pickup = new JButton("Pickup Status");
        pickup.setBounds(10, 430, 200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Pickup();
            }
        });
        add(pickup);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 470, 200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new SearchRoom();
            }
        });
        add(searchRoom);

        logout = new JButton("Logout");
        logout.setBounds(10, 510, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                dispose(); // Close the current window
                // Perform logout actions here, if any
                System.exit(0);
            }
        });
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/receptie2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(100, 30, 800, 470);
        add(image);

        setBounds(350, 200, 800, 590);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
