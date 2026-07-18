package Hotel.Management.System.user;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Demo extends JFrame{

    Demo() {
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1000,1000);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        add(panel);

        java.net.URL url = getClass().getResource("/icons/booking.png");
        System.out.println(url);

        ImageIcon imageIcon = new ImageIcon(url);
        Image img = imageIcon.getImage().getScaledInstance(320,200,Image.SCALE_SMOOTH);

        JLabel imgg = new JLabel(new ImageIcon(img));
        imgg.setBounds(0,0,320,200);

        panel.add(imgg);

        setLayout(null);
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    static void main(String[] args) {
        new Demo();
    }
}
