import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HotelManagementSystem extends JFrame implements ActionListener{

    private JLabel text;

    HotelManagementSystem() {
        setSize(1200, 800);
        setLocation(100, 100);
        setLayout(null);

        JLabel image = null;
        try {
            File file = new File("src/icons/background.jpg");
            BufferedImage bufferedImage = ImageIO.read(file);
            Image scaledImage = bufferedImage.getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
            ImageIcon i1 = new ImageIcon(scaledImage);

            image = new JLabel(i1);
            image.setBounds(0, 0, 1200, 800);

            text = new JLabel("HOTEL MANAGEMENT SYSTEM");
            text.setBounds(270, 680, 1000, 90);
            text.setForeground(Color.BLACK);
            text.setFont(new Font("serif", Font.PLAIN, 50));
            add(text);
            add(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton next = new JButton("Next");
        next.setBounds(1100, 680, 80, 75);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.black);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 18));
        assert image != null;
        image.add(next);

        setVisible(true);

        int delay = 600;
        Timer timer = new Timer(delay, new ActionListener() {
            boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                text.setVisible(visible);
                visible = !visible;
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HotelManagementSystem::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();

    }
}
