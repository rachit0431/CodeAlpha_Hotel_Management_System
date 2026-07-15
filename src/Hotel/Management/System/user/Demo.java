package Hotel.Management.System.user;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo extends JFrame implements ActionListener {

    Color navy = new Color(17, 44, 87);
    Color bg = new Color(245,247,252);
    Color green = new Color(34,197,94);

    JTextField bookingID;
    JButton done;

    public Demo() {

        setTitle("Search Booking-ID");
        setSize(380,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("Enter booking-ID here: ");
        label.setBounds(30,40,300,35);
        label.setFont(new Font("Sogue UI" , Font.PLAIN , 28 ));
        add(label);

        bookingID = new JTextField();
        bookingID.setBounds(30,90,300,30);
        add(bookingID);

        done = new JButton("Done");
        done.setBounds(30,150,300,30);
        done.addActionListener(this);
        done.setFocusable(false);
        add(done);

        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(done)){
            String BookingID = bookingID.getText();

            new GuestRoomDetails(BookingID).setVisible(true);
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Demo();
    }
}
