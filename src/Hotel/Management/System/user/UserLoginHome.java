package Hotel.Management.System.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HomePage extends JFrame implements ActionListener {

    JButton book ;

    String menu[] ={"Home", "Rooms", "About", "Pages", "News", "Contact"};

    HomePage() {

        setTitle("Hotel Management");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main Panel
        JPanel bg = new JPanel();
        bg.setLayout(null);
        bg.setBackground(new Color(40, 40, 40)); // Dark Background
        add(bg);

       ////  NavBar

        JPanel nav = new JPanel();
        nav.setBackground(new Color(20, 20, 20));
        nav.setBounds(0, 0, 1950, 70);
        nav.setLayout(null);
        bg.add(nav);

        JLabel logo = new JLabel("The Royal Crest");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Serif", Font.BOLD, 24));
        logo.setBounds(40, 20, 250, 30);
        nav.add(logo);

        int x = 700;

        for (String s : menu) {

            JButton b = new JButton(s);
            b.setBounds(x, 20, 120, 40);
            b.setFocusPainted(false);
            b.setBackground(new Color(20, 20, 20));
            b.addActionListener(this);
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Segoe UI", Font.BOLD,16));
            b.setBorderPainted(false);
            b.setContentAreaFilled(false);

            nav.add(b);

            x += 100;
        }

        book = new JButton("BOOK NOW");
        book.setBounds(1380, 24, 120, 25);
        book.setFont(new Font("Segoe UI", Font.BOLD,14));
        book.setBackground(Color.WHITE);
        book.addActionListener(this);
        book.setFocusable(false);
        book.setForeground(Color.BLACK);
        nav.add(book);

        //// center text

        JLabel small = new JLabel("LUXURY HOTEL & BEST RESORT");
        small.setForeground(Color.LIGHT_GRAY);
        small.setBounds(100, 160, 400, 30);
        small.setFont(new Font("Arial", Font.PLAIN, 18));
        bg.add(small);

        JLabel l1 = new JLabel("ENJOY A LUXURY");
        l1.setBounds(100, 220, 700, 60);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Serif", Font.BOLD, 50));
        bg.add(l1);

        JLabel l2 = new JLabel("EXPERIENCE");
        l2.setBounds(100, 290, 600, 60);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Serif", Font.BOLD, 50));
        bg.add(l2);

        JButton suite = new JButton("BOOK SUITE");
        suite.setBounds(100, 390, 180, 45);
        suite.setBackground(Color.WHITE);
        suite.setForeground(Color.BLACK);
        suite.setFont(new Font("Arial", Font.BOLD, 14));
        suite.setFocusable(false);
        bg.add(suite);


        //// Booking Panel

        JPanel booking = new JPanel();
        booking.setBounds(250, 610, 900, 100);
        booking.setLayout(new GridLayout(1, 4));
        booking.setBackground(Color.WHITE);

        bg.add(booking);

        booking.add(createBox("CHECK IN", "14"));
        booking.add(createBox("CHECK OUT", "15"));
        booking.add(createBox("GUESTS", "1"));

        JButton check = new JButton("<html><center>CHECK<br>AVAILABILITY</center></html>");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Arial", Font.BOLD, 14));

        booking.add(check);

        setVisible(true);
    }

    JPanel createBox(String title, String value) {

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBackground(Color.WHITE);

        JLabel t = new JLabel(title, SwingConstants.CENTER);
        t.setForeground(Color.GRAY);
        t.setFont(new Font("Arial", Font.PLAIN, 13));

        JLabel v = new JLabel(value, SwingConstants.CENTER);
        v.setFont(new Font("Serif", Font.BOLD, 34));

        p.add(t, BorderLayout.NORTH);
        p.add(v, BorderLayout.CENTER);

        return p;
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(book)){
            new SearchRoom().setVisible(true);
            setVisible(false);
        }

        JButton btn = (JButton) ae.getSource();

        String name = btn.getText();
        if(name.equals("Rooms")){
            setVisible(false);
            new Demo();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new HomePage());

    }
}