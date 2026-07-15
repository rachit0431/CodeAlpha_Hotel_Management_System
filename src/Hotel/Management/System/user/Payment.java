package Hotel.Management.System.user;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {

    private BookingRoom bookingRoom;

    Color navy = new Color(16, 55, 92);
    Color blue = new Color(32, 84, 147);
    Color gold = new Color(255, 193, 7);

    JButton pay;

    public Payment(BookingRoom bookingRoom) {

        setTitle("Payment");
        setSize(900,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        this.bookingRoom = bookingRoom;

        //---------------- LEFT WALA PANEL ----------------

        JPanel left = new JPanel(null);
        left.setBackground(navy);
        left.setPreferredSize(new Dimension(300,500));

        JPanel card = new JPanel(null);
        card.setBounds(40,90,220,140);
        card.setBackground(blue);
        card.setBorder(new LineBorder(new Color(255,255,255,60),1,true));

        JLabel wifi = new JLabel("≋");
        wifi.setFont(new Font("Segoe UI",Font.BOLD,22));
        wifi.setForeground(Color.WHITE);
        wifi.setBounds(15,10,40,30);
        card.add(wifi);

        JLabel chip = new JLabel();
        chip.setOpaque(true);
        chip.setBackground(new Color(220,220,220));
        chip.setBounds(18,95,28,20);
        card.add(chip);

        JLabel number = new JLabel("0000 0000 0000 0000");
        number.setForeground(Color.WHITE);
        number.setFont(new Font("Segoe UI",Font.BOLD,16));
        number.setBounds(18,55,180,25);
        card.add(number);

        JLabel visa = new JLabel("VISA");
        visa.setForeground(Color.WHITE);
        visa.setFont(new Font("Segoe UI",Font.BOLD,18));
        visa.setBounds(155,100,60,25);
        card.add(visa);

        left.add(card);

        //---------------- RIGHT WALA PANEL ----------------

        JPanel right = new JPanel(null);
        right.setBackground(Color.WHITE);

        JLabel title = new JLabel("Payment Details");
        title.setFont(new Font("Segoe UI",Font.BOLD,24));
        title.setBounds(40,30,250,35);
        right.add(title);

        JLabel l1 = new JLabel("Card Number");
        l1.setBounds(40,85,150,20);
        right.add(l1);

        JTextField cardNo = new JTextField();
        cardNo.setBounds(40,110,350,38);
        right.add(cardNo);

        JLabel l2 = new JLabel("Card Holder Name");
        l2.setBounds(40,165,150,20);
        right.add(l2);

        JTextField holder = new JTextField();
        holder.setBounds(40,190,350,38);
        right.add(holder);

        JLabel l3 = new JLabel("Expiry Date");
        l3.setBounds(40,245,100,20);
        right.add(l3);

        JTextField expiry = new JTextField();
        expiry.setBounds(40,270,160,38);
        right.add(expiry);

        JLabel l4 = new JLabel("CVV");
        l4.setBounds(240,245,60,20);
        right.add(l4);

        JPasswordField cvv = new JPasswordField();
        cvv.setBounds(240,270,150,38);
        right.add(cvv);

        pay = new JButton("Pay Now");
        pay.setBounds(40,340,350,45);
        pay.setBackground(navy);
        pay.addActionListener(this);
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Segoe UI",Font.BOLD,16));
        pay.setFocusPainted(false);
        right.add(pay);

        add(left,BorderLayout.WEST);
        add(right,BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(pay)){

            JOptionPane.showMessageDialog(null,"Payment successfully done and Room Booked");

            Timer timer = new Timer(2000,e ->{
                bookingRoom.dispose();
                setVisible(false);
            });

            timer.setRepeats(false);
            timer.start();

            new HomePage().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Payment(new BookingRoom("","","","","","",""));
    }
}