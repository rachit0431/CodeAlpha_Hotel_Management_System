package Hotel.Management.System.user;

import Hotel.Management.System.Conn;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class GuestRoomDetails extends JFrame implements ActionListener {

    Color navy = new Color(17, 44, 87);
    Color bg = new Color(245,247,252);
    Color green = new Color(34,197,94);

    JPanel imagePanel;
    JLabel roomNo ,type,bed , guestName , status ,email ,phone ,guests ,checkIn ,checkOut ,duration ,roomType ,bed1 ,roomPrice;
    JLabel totalPrice;

    String BookingID;
    JButton cancelBooking;

    String Gname , Gemail , Gphone ,Groom_no , Groom_type , Gbed_type , Gprice  , Gstatus ,Gcheck_in , Gcheck_out;

    public GuestRoomDetails(String BookingID) {

        this.BookingID = BookingID;

        setTitle("Booking Summary");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(bg);

        //// MainPanel

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(bg);
        mainPanel.setPreferredSize(new Dimension(1500, 1020));


        System.out.println("hello");
        //// table se data fetch krna -->
        try{
            Conn conn = new Conn();

            String query = "select * from guestDetails where bookingID = '"+BookingID+"' ";

            ResultSet rs = conn.statement.executeQuery(query);

            while(rs.next()){
            System.out.println("by");

                Gname = rs.getString("gname");
                Gemail = rs.getString("gemail");
                Gphone = rs.getString("gphone");
                System.out.println(Gphone);
                Groom_no = rs.getString("groom_no");
                Groom_type = rs.getString("groom_type");
                Gbed_type = rs.getString("gbed_type");
                Gprice = rs.getString("gprices");
                Gcheck_in = rs.getString("gcheckIn");
                Gcheck_out = rs.getString("gcheckOut");
                Gstatus = rs.getString("r_status");

            }

        }catch (Exception E){
            E.printStackTrace();
        }



        //---------------- Header yha se suru ----------------

        JButton back = new JButton("←");
        back.setBounds(30,25,50,50);
        back.setFont(new Font("Segoe UI",Font.BOLD,22));
        back.setBackground(bg);
        back.setFocusPainted(false);
        back.setBorder(new LineBorder(new Color(220,220,220),1,true));
        mainPanel.add(back);

        JLabel title = new JLabel("BOOKING DETAILS");
        title.setBounds(100,30,350,45);
        title.setFont(new Font("Segoe UI",Font.BOLD,34));
        title.setForeground(navy);
        mainPanel.add(title);

        //---------------- Image Panel yha se----------------

        imagePanel = new JPanel(null);
        imagePanel.setBounds(40,100,810,480);
        imagePanel.setBackground(new Color(225,225,225));
        imagePanel.setBorder(new LineBorder(new Color(210,210,210),1,true));

        ImageIcon imageIcon = new ImageIcon("icon/hotel2.png");
        Image img = imageIcon.getImage().getScaledInstance(40,100,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(img);
        JLabel imgg = new JLabel(imageIcon1);
        imgg.setBounds(0,0,40,100);
        imagePanel.add(imgg);
        mainPanel.add(imagePanel);


        JLabel imageText = new JLabel("ROOM IMAGE");
        imageText.setFont(new Font("Segoe UI",Font.BOLD,28));
        imageText.setForeground(Color.GRAY);
        imageText.setBounds(300,210,250,40);
        imagePanel.add(imageText);

//        mainPanel.add(imagePanel);

        //---------------- Confirm Badge yha se----------------

        JPanel badge = new JPanel(null);
        badge.setBounds(650,120,170,50);
        badge.setBackground(new Color(60,60,60));

        JLabel dot = new JLabel("●");
        dot.setBounds(15,10,20,25);
        dot.setForeground(green);
        dot.setFont(new Font("Segoe UI",Font.BOLD,20));
        badge.add(dot);

        JLabel confirmed = new JLabel("Confirmed");
        confirmed.setBounds(40,10,120,25);
        confirmed.setForeground(Color.WHITE);
        confirmed.setFont(new Font("Segoe UI",Font.BOLD,22));
        badge.add(confirmed);

        imagePanel.add(badge);

        //2nd PArt

        //==================== Bottom Information Card ====================

        JPanel infoCard = new JPanel(null);
        infoCard.setBounds(0, 385, 810, 95);
        infoCard.setBackground(navy);


//---------------- Room No ----------------

        JLabel roomIcon = new JLabel("🛏");
        roomIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
        roomIcon.setForeground(Color.WHITE);
        roomIcon.setBounds(25,18,40,30);
        infoCard.add(roomIcon);

        JLabel roomNoText = new JLabel("Room No.");
        roomNoText.setForeground(new Color(220,220,220));
        roomNoText.setFont(new Font("Segoe UI",Font.PLAIN,14));
        roomNoText.setBounds(60,18,80,20);
        infoCard.add(roomNoText);

        //// ------------

        roomNo = new JLabel();
        roomNo.setForeground(Color.WHITE);
        roomNo.setFont(new Font("Segoe UI",Font.BOLD,30));
        roomNo.setBounds(60,40,80,35);
        infoCard.add(roomNo);

        JSeparator s1 = new JSeparator(JSeparator.VERTICAL);
        s1.setBounds(190,18,2,58);
        infoCard.add(s1);

//---------------- Room Type ----------------

        JLabel typeIcon = new JLabel("🛌");
        typeIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
        typeIcon.setForeground(Color.WHITE);
        typeIcon.setBounds(215,18,40,30);
        infoCard.add(typeIcon);

        JLabel typeText = new JLabel("Room Type");
        typeText.setForeground(new Color(220,220,220));
        typeText.setFont(new Font("Segoe UI",Font.PLAIN,14));
        typeText.setBounds(260,18,120,20);
        infoCard.add(typeText);

        type = new JLabel("Deluxe");
        type.setForeground(Color.WHITE);
        type.setFont(new Font("Segoe UI",Font.BOLD,28));
        type.setBounds(260,40,150,35);
        infoCard.add(type);


        JSeparator s2 = new JSeparator(JSeparator.VERTICAL);
        s2.setBounds(430,18,2,58);
        infoCard.add(s2);

//---------------- Bed Type ----------------

        JLabel bedIcon = new JLabel("🛏");
        bedIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
        bedIcon.setForeground(Color.WHITE);
        bedIcon.setBounds(455,18,40,30);
        infoCard.add(bedIcon);

        JLabel bedText = new JLabel("Bed Type");
        bedText.setForeground(new Color(220,220,220));
        bedText.setFont(new Font("Segoe UI",Font.PLAIN,14));
        bedText.setBounds(500,18,100,20);
        infoCard.add(bedText);

        bed = new JLabel("King Bed");
        bed.setForeground(Color.WHITE);
        bed.setFont(new Font("Segoe UI",Font.BOLD,28));
        bed.setBounds(500,40,180,35);
        infoCard.add(bed);

// Divider
        JSeparator s3 = new JSeparator(JSeparator.VERTICAL);
        s3.setBounds(680,18,2,58);
        infoCard.add(s3);

//---------------- Status ----------------//

        JLabel statusIcon = new JLabel("✔");
        statusIcon.setFont(new Font("Segoe UI", Font.BOLD,22));
        statusIcon.setForeground(Color.WHITE);
        statusIcon.setBounds(700,18,30,30);
        infoCard.add(statusIcon);

        JLabel statusText = new JLabel("Status");
        statusText.setForeground(new Color(220,220,220));
        statusText.setFont(new Font("Segoe UI",Font.PLAIN,14));
        statusText.setBounds(735,18,60,20);
        infoCard.add(statusText);

        status = new JLabel("Booked");
        status.setForeground(new Color(40,230,90));
        status.setFont(new Font("Segoe UI",Font.BOLD,24));
        status.setBounds(700,42,90,30);
        infoCard.add(status);

//        imagePanel.add(badge);
        imagePanel.add(infoCard);
        mainPanel.add(badge);
        mainPanel.add(imagePanel);

        //// 3rd part start --->

        //==================== Guest Information ====================//

        JLabel guestTitle = new JLabel("Guest Information");
        guestTitle.setBounds(90,650,320,35);
        guestTitle.setFont(new Font("Segoe UI",Font.BOLD,30));
        guestTitle.setForeground(navy);
        mainPanel.add(guestTitle);

        // Blue Circle Icon
        JPanel guestCircle = new JPanel();
        guestCircle.setBounds(40,650,42,42);
        guestCircle.setBackground(new Color(30,80,180));
        guestCircle.setBorder(BorderFactory.createLineBorder(new Color(30,80,180),1,true));
        guestCircle.setLayout(new BorderLayout());

        JLabel person = new JLabel("👤",SwingConstants.CENTER);
        person.setForeground(Color.WHITE);
        person.setFont(new Font("Segoe UI Emoji",Font.PLAIN,22));

        guestCircle.add(person);
        mainPanel.add(guestCircle);

//==================== Guest Card ====================//

        JPanel guestCard = new JPanel(null);
        guestCard.setBounds(40,720,810,170);
        guestCard.setBackground(Color.WHITE);
        guestCard.setBorder(new LineBorder(new Color(220,220,220),1,true));

//---------------- Name ----------------//

        JLabel nameIcon = new JLabel("👤");
        nameIcon.setBounds(25,30,40,30);
        nameIcon.setFont(new Font("Segoe UI Emoji",Font.PLAIN,24));
        guestCard.add(nameIcon);

        JLabel fullName = new JLabel("Full Name");
        fullName.setBounds(85,22,120,20);
        fullName.setForeground(Color.GRAY);
        fullName.setFont(new Font("Segoe UI",Font.PLAIN,14));
        guestCard.add(fullName);

        guestName = new JLabel();
        guestName.setBounds(85,48,300,30);
        guestName.setFont(new Font("Segoe UI",Font.BOLD,22));
        guestName.setForeground(navy);
        guestCard.add(guestName);

//---------------- Email ----------------//

        JLabel emailIcon = new JLabel("✉");
        emailIcon.setBounds(430,30,40,30);
        emailIcon.setFont(new Font("Segoe UI",Font.PLAIN,22));
        guestCard.add(emailIcon);

        JLabel emailText = new JLabel("Email");
        emailText.setBounds(490,22,120,20);
        emailText.setForeground(Color.GRAY);
        emailText.setFont(new Font("Segoe UI",Font.PLAIN,14));
        guestCard.add(emailText);

        email = new JLabel();
        email.setBounds(490,48,360,30);
        email.setFont(new Font("Segoe UI",Font.BOLD,22));
        email.setForeground(navy);
        guestCard.add(email);

//---------------- Divider ----------------//

        JSeparator line = new JSeparator();
        line.setBounds(30,90,750,2);
        guestCard.add(line);

//---------------- Phone ----------------//

        JLabel phoneIcon = new JLabel("📞");
        phoneIcon.setBounds(25,105,40,30);
        phoneIcon.setFont(new Font("Segoe UI Emoji",Font.PLAIN,22));
        guestCard.add(phoneIcon);

        JLabel phoneText = new JLabel("Phone");
        phoneText.setBounds(85,98,100,20);
        phoneText.setForeground(Color.GRAY);
        phoneText.setFont(new Font("Segoe UI",Font.PLAIN,14));
        guestCard.add(phoneText);

        phone = new JLabel();
        phone.setBounds(85,120,220,30);
        phone.setFont(new Font("Segoe UI",Font.BOLD,22));
        phone.setForeground(navy);
        guestCard.add(phone);

//---------------- Guests ----------------//

        JLabel guestsIcon = new JLabel("👥");
        guestsIcon.setBounds(430,105,40,30);
        guestsIcon.setFont(new Font("Segoe UI Emoji",Font.PLAIN,22));
        guestCard.add(guestsIcon);

        JLabel guestsText = new JLabel("Guests");
        guestsText.setBounds(490,98,100,20);
        guestsText.setForeground(Color.GRAY);
        guestsText.setFont(new Font("Segoe UI",Font.PLAIN,14));
        guestCard.add(guestsText);

        guests = new JLabel();
        guests.setBounds(490,120,240,30);
        guests.setFont(new Font("Segoe UI",Font.BOLD,22));
        guests.setForeground(navy);
        guestCard.add(guests);

        mainPanel.add(guestCard);

        //// 4th PArt ---->

        //==================== Room Details Title ====================//

        JLabel roomTitle = new JLabel("Room Details");
        roomTitle.setBounds(910,80,300,35);
        roomTitle.setFont(new Font("Segoe UI",Font.BOLD,30));
        roomTitle.setForeground(navy);
        mainPanel.add(roomTitle);

//==================== Room Details Card ====================//

        JPanel detailsCard = new JPanel(null);
        detailsCard.setBounds(890,130,540,420);
        detailsCard.setBackground(Color.WHITE);
        detailsCard.setBorder(new LineBorder(new Color(220,220,220),1,true));


//---------------- Heading ----------------//

        JLabel heading = new JLabel("Luxury" + " Room");
        heading.setBounds(30,25,350,35);
        heading.setFont(new Font("Segoe UI",Font.BOLD,28));
        heading.setForeground(navy);
        detailsCard.add(heading);

        JLabel sub = new JLabel("Booking Information");
        sub.setBounds(30,60,220,20);
        sub.setForeground(Color.GRAY);
        sub.setFont(new Font("Segoe UI",Font.PLAIN,15));
        detailsCard.add(sub);

        JSeparator topLine = new JSeparator();
        topLine.setBounds(25,95,490,2);
        detailsCard.add(topLine);

//==================== Check-In ====================//

        JLabel checkInText = new JLabel("Check-In");
        checkInText.setBounds(30,120,120,20);
        checkInText.setForeground(Color.GRAY);
        checkInText.setFont(new Font("Segoe UI",Font.PLAIN,15));
        detailsCard.add(checkInText);

        checkIn = new JLabel();
        checkIn.setBounds(30,145,180,28);
        checkIn.setForeground(navy);
        checkIn.setFont(new Font("Segoe UI",Font.BOLD,22));
        detailsCard.add(checkIn);

//==================== Check-Out ====================//

        JLabel checkOutText = new JLabel("Check-Out");
        checkOutText.setBounds(280,120,120,20);
        checkOutText.setForeground(Color.GRAY);
        checkOutText.setFont(new Font("Segoe UI",Font.PLAIN,15));
        detailsCard.add(checkOutText);

        checkOut = new JLabel();
        checkOut.setBounds(280,145,180,28);
        checkOut.setForeground(navy);
        checkOut.setFont(new Font("Segoe UI",Font.BOLD,22));
        detailsCard.add(checkOut);

// Divider

        JSeparator line1 = new JSeparator();
        line1.setBounds(25,190,490,2);
        detailsCard.add(line1);

//==================== Stay Duration ====================//

        JLabel durationText = new JLabel("Stay Duration");
        durationText.setBounds(30,210,150,20);
        durationText.setForeground(Color.GRAY);
        durationText.setFont(new Font("Segoe UI",Font.PLAIN,15));
        detailsCard.add(durationText);

        duration = new JLabel("2 Night");
        duration.setBounds(30,235,180,28);
        duration.setForeground(navy);
        duration.setFont(new Font("Segoe UI",Font.BOLD,22));
        detailsCard.add(duration);

//==================== Room Type ====================//

        JLabel roomTypeText = new JLabel("Room Type");
        roomTypeText.setBounds(280,260,150,20);
        roomTypeText.setForeground(Color.GRAY);
        roomTypeText.setFont(new Font("Segoe UI",Font.PLAIN,15));
        detailsCard.add(roomTypeText);

        roomType = new JLabel("Deluxe");
        roomType.setBounds(280,235,180,28);
        roomType.setForeground(navy);
        roomType.setFont(new Font("Segoe UI",Font.BOLD,22));
        detailsCard.add(roomType);

// Divider

        JSeparator line2 = new JSeparator();
        line2.setBounds(25,280,490,2);
        detailsCard.add(line2);

//==================== Bed ====================//

        JLabel bedText1 = new JLabel("Bed Type");
        bedText1.setBounds(30,300,120,20);
        bedText1.setForeground(Color.GRAY);
        bedText1.setFont(new Font("Segoe UI",Font.PLAIN,15));
        detailsCard.add(bedText1);

        bed1 = new JLabel("King Size");
        bed1.setBounds(30,325,180,28);
        bed1.setForeground(navy);
        bed1.setFont(new Font("Segoe UI",Font.BOLD,22));
        detailsCard.add(bed1);

//==================== Meal ====================//

        JLabel mealText = new JLabel("Meal Plan");
        mealText.setBounds(280,300,120,20);
        mealText.setForeground(Color.GRAY);
        mealText.setFont(new Font("Segoe UI",Font.PLAIN,15));
        detailsCard.add(mealText);

        JLabel meal = new JLabel("Breakfast Included");
        meal.setBounds(280,325,220,28);
        meal.setForeground(navy);
        meal.setFont(new Font("Segoe UI",Font.BOLD,22));
        detailsCard.add(meal);

        mainPanel.add(detailsCard);

        //// 5th Part

        //==================== Price Summary ====================//

        JLabel priceTitle = new JLabel("Price Summary");
        priceTitle.setBounds(910,580,300,35);
        priceTitle.setFont(new Font("Segoe UI",Font.BOLD,30));
        priceTitle.setForeground(navy);
        mainPanel.add(priceTitle);

//==================== Price Card ====================//

        JPanel priceCard = new JPanel(null);
        priceCard.setBounds(890,630,540,220);
        priceCard.setBackground(Color.WHITE);
        priceCard.setBorder(new LineBorder(new Color(220,220,220),1,true));

// Room Charge
        JLabel roomCharge = new JLabel("Room Charge");
        roomCharge.setBounds(30,30,180,25);
        roomCharge.setFont(new Font("Segoe UI",Font.PLAIN,18));
        priceCard.add(roomCharge);

        roomPrice = new JLabel();
        roomPrice.setBounds(400,30,100,25);
        roomPrice.setHorizontalAlignment(SwingConstants.RIGHT);
        roomPrice.setFont(new Font("Segoe UI",Font.BOLD,18));
        priceCard.add(roomPrice);

// GST
//        JLabel gst = new JLabel("GST (18%)");
//        gst.setBounds(30,70,180,25);
//        gst.setFont(new Font("Segoe UI",Font.PLAIN,18));
//        priceCard.add(gst);
//
//        JLabel gstPrice = new JLabel("₹ 810");
//        gstPrice.setBounds(400,70,100,25);
//        gstPrice.setHorizontalAlignment(SwingConstants.RIGHT);
//        gstPrice.setFont(new Font("Segoe UI",Font.BOLD,18));
//        priceCard.add(gstPrice);
//
//// Service Charge
//        JLabel service = new JLabel("Service Charge");
//        service.setBounds(30,110,180,25);
//        service.setFont(new Font("Segoe UI",Font.PLAIN,18));
//        priceCard.add(service);
//
//        JLabel servicePrice = new JLabel("₹ 200");
//        servicePrice.setBounds(400,110,100,25);
//        servicePrice.setHorizontalAlignment(SwingConstants.RIGHT);
//        servicePrice.setFont(new Font("Segoe UI",Font.BOLD,18));
//        priceCard.add(servicePrice);

// Divider
        JSeparator totalLine = new JSeparator();
        totalLine.setBounds(30,80,480,2);
        priceCard.add(totalLine);

// Total
        JLabel total = new JLabel("Total Amount");
        total.setBounds(30,95,180,30);
        total.setFont(new Font("Segoe UI",Font.BOLD,24));
        total.setForeground(navy);
        priceCard.add(total);

        totalPrice = new JLabel();
        totalPrice.setBounds(320,95,180,30);
        totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
        totalPrice.setForeground(new Color(0,150,70));
        totalPrice.setFont(new Font("Segoe UI",Font.BOLD,28));
        priceCard.add(totalPrice);

//==================== Buttons ====================//

        JButton printBtn = new JButton("Print Details");
        printBtn.setBounds(300,155,210,40);
        printBtn.setBackground(navy);
        printBtn.setForeground(bg);
        printBtn.setFocusPainted(false);
        printBtn.setFont(new Font("Segoe UI",Font.BOLD,16));
        printBtn.setBorder(new LineBorder(navy,2,true));
        priceCard.add(printBtn);

//        JButton confirmBtn = new JButton("Confirm Booking");
//        confirmBtn.setBounds(280,155,230,40);
//        confirmBtn.setBackground(navy);
//        confirmBtn.setForeground(Color.WHITE);
//        confirmBtn.setFocusPainted(false);
//        confirmBtn.setFont(new Font("Segoe UI",Font.BOLD,16));
//        confirmBtn.setBorderPainted(false);
//        priceCard.add(confirmBtn);

        mainPanel.add(priceCard);

//==================== Button Actions ====================//

        printBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Invoice Printed Successfully!",
                    "Print",
                    JOptionPane.INFORMATION_MESSAGE);
        });

//        confirmBtn.addActionListener(e -> {
//            JOptionPane.showMessageDialog(
//                    this,
//                    "Booking Confirmed Successfully!",
//                    "Success",
//                    JOptionPane.INFORMATION_MESSAGE);
//        });

        JPanel Cbutton = new JPanel(null);
        Cbutton.setBackground(Color.white);
        Cbutton.setBounds(890,900,540,40);
        Cbutton.setBorder(new LineBorder(new Color(220,220,220),1,true));

        cancelBooking = new JButton("Cancel Booking");
        cancelBooking.setBounds(0,0,540,40);
        cancelBooking.setBackground(navy);
        cancelBooking.setForeground(bg);
        cancelBooking.setFocusPainted(false);
        cancelBooking.setFont(new Font("Segoe UI",Font.BOLD,16));
        cancelBooking.addActionListener(this);
        cancelBooking.setBorder(new LineBorder(navy,2,true));
        Cbutton.add(cancelBooking);


        mainPanel.add(Cbutton);



        roomNo.setText(Groom_no);
        type.setText(Groom_type);
        guestName.setText(Gname);
        email.setText(Gemail);
        phone.setText(Gphone);
        guests.setText(Gbed_type);
        checkIn.setText(Gcheck_in);
        checkOut.setText(Gcheck_out);
        roomType.setText(Groom_type);
        bed1.setText(Gbed_type);
        roomPrice.setText(Gprice);
        totalPrice.setText(Gprice);
        status.setText(Gstatus);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        setContentPane(scrollPane);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(cancelBooking)){
            Object[] option = {"Yes"};

            JOptionPane.showOptionDialog(null,"do you really want to cancel the Booking Room / you will get only 50% of the amount","Cancel Booking",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,option,option[0]);

            Timer timer = new Timer(4000,e ->{
                setVisible(false);
            });
            timer.start();
            timer.setRepeats(false);
        }

        try{
            Conn conn = new Conn();
            String query = "DELETE FROM guestDetails WHERE bookingID = '"+BookingID+"' ";

            conn.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Booking Room Cancled Successfully");



        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new GuestRoomDetails("");
    }
}