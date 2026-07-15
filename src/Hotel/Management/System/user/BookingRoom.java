package Hotel.Management.System.user;

import Hotel.Management.System.Conn;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookingRoom extends JFrame implements ActionListener {

    String BookingID;

    // Colors
    Color NAVY = new Color(8, 29, 73);
    Color GOLD = new Color(212, 163, 73);
    Color WHITE = Color.WHITE;

    JPanel mainPanel;
    JPanel leftPanel;
    JPanel formPanel;
    JTextField guestField;
    JTextField emailField;
    JTextField phoneField;
    JTextField roomNo;
    JTextField status;
    JTextField bedType;
    JComboBox<String> paymentBox;

    JCheckBox termsCheck;

    JLabel totalPrice;

    JButton bookBtn;
    JButton back;
    JTextArea specialRequestArea;

    JTextField roomType;

    JTextField checkInField;
    JTextField checkOutField;


    //// By search Room se aati hui sarri field
    String room_no  , room_type ,  bed_type ,  prices ,  statuss , checkIn ,  checkOut ;

    public BookingRoom(String room_no , String room_type , String bed_type , String prices , String statuss,  String checkIn , String checkOut ) {

        this.room_no = room_no;
        this.room_type = room_type;
        this.bed_type = bed_type;
        this.prices = prices;
        this.statuss = statuss;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        System.out.println(bed_type);

        setTitle("Royal Haven - Book Your Stay");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main Background
        mainPanel = new JPanel(null);
        mainPanel.setBackground(NAVY);
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1400,1200));
//        setContentPane(mainPanel);

        createSidebar();
        createFormPanel();
        createBookingFields();
        createMoreFields();
        createBottomPanel();

        roomNo.setText(room_no);
        roomType.setText(room_type);
        status.setText(statuss);
        bedType.setText(bed_type);
        checkInField.setText(checkIn);
        checkOutField.setText(checkOut);
        totalPrice.setText(prices);



        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // JFrame me direct panel add mat karo
        setContentPane(scrollPane);
        setVisible(true);
    }

    // ================= LEFT SIDEBAR =================

    private void createSidebar() {

        leftPanel = new JPanel(null);
        leftPanel.setBounds(15, 15, 320, 960);
        leftPanel.setBackground(NAVY);
        leftPanel.setBorder(new LineBorder(GOLD,2,true));

        //---------------- LOGO ----------------

        JLabel logo = new JLabel("H");
        logo.setBounds(0,40,320,80);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setForeground(GOLD);
        logo.setFont(new Font("Serif",Font.BOLD,60));
        leftPanel.add(logo);

        JLabel hotel = new JLabel("ROYAL HAVEN");
        hotel.setBounds(0,145,320,40);
        hotel.setHorizontalAlignment(SwingConstants.CENTER);
        hotel.setForeground(GOLD);
        hotel.setFont(new Font("Serif",Font.BOLD,26));
        leftPanel.add(hotel);

        JLabel luxury = new JLabel("LUXURY HOTEL");
        luxury.setBounds(0,180,320,30);
        luxury.setHorizontalAlignment(SwingConstants.CENTER);
        luxury.setForeground(GOLD);
        luxury.setFont(new Font("Segoe UI",Font.PLAIN,18));
        leftPanel.add(luxury);

        //---------------- LINE ----------------

        JSeparator sp = new JSeparator();
        sp.setBounds(40,235,240,2);
        sp.setForeground(GOLD);
        leftPanel.add(sp);

        //---------------- TEXT ----------------

        JLabel txt = new JLabel("<html><center>Experience Comfort<br>Like Never Before</center></html>");
        txt.setBounds(0,260,320,90);
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("Segoe UI",Font.PLAIN,18));
        leftPanel.add(txt);

        //---------------- IMAGE ----------------

        JLabel image = new JLabel("Hotel Image Here");
        image.setBounds(0,360,320,600);
        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setForeground(Color.WHITE);
        image.setOpaque(true);
        image.setBackground(new Color(25,45,90));

        /*
            IMAGE LAGANE KE LIYE

            ImageIcon img = new ImageIcon("hotel.jpg");
            image.setIcon(img);
            image.setText("");

        */

        leftPanel.add(image);

        mainPanel.add(leftPanel);
    }

    //================ FORM PANEL =================

    private void createFormPanel() {

        formPanel = new JPanel(null);
        formPanel.setBounds(340,40,1160,1050);
        formPanel.setBackground(WHITE);
        formPanel.setBorder(new LineBorder(GOLD,2,true));

        //---------------- TITLE ----------------

        JLabel title = new JLabel("BOOK YOUR STAY");
        title.setBounds(0,30,1180,60);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(NAVY);
        title.setFont(new Font("Serif",Font.BOLD,56));
        formPanel.add(title);

        //---------------- SUB TITLE ----------------

        JLabel sub = new JLabel("Reserve Your Perfect Experience");
        sub.setBounds(0,90,1180,40);
        sub.setHorizontalAlignment(SwingConstants.CENTER);
        sub.setForeground(GOLD);
        sub.setFont(new Font("Segoe UI",Font.PLAIN,24));
        formPanel.add(sub);

        //---------------- DIVIDER ----------------

        JSeparator s1 = new JSeparator();
        s1.setBounds(340,145,180,2);
        formPanel.add(s1);

        JSeparator s2 = new JSeparator();
        s2.setBounds(660,145,180,2);
        formPanel.add(s2);

        mainPanel.add(formPanel);
    }

    private void createBookingFields() {

        //---------------- LEFT COLUMN ----------------

        JLabel guestLabel = new JLabel("Guest Name");
        guestLabel.setBounds(95,170,180,30);
        guestLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        guestLabel.setForeground(NAVY);
        formPanel.add(guestLabel);

        guestField = new RoundTextField();
        guestField.setBounds(95,205,460,48);
        guestField.setFont(new Font("Segoe UI",Font.PLAIN,18));
        formPanel.add(guestField);




        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(95,285,200,30);
        phoneLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        phoneLabel.setForeground(NAVY);
        formPanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(95,320,460,48);
        phoneField.setFont(new Font("Segoe UI",Font.PLAIN,18));
        formPanel.add(phoneField);




        JLabel checkInLabel = new JLabel("Check-In Date");
        checkInLabel.setBounds(95,400,200,30);
        checkInLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        checkInLabel.setForeground(NAVY);
        formPanel.add(checkInLabel);

        checkInField = new JTextField();
        checkInField.setBounds(95,435,460,48);
        checkInField.setFont(new Font("Segoe UI",Font.PLAIN,18));
        checkInField.setText("dd/mm/yyyy");
        formPanel.add(checkInField);




        //---------------- RIGHT COLUMN ----------------

        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setBounds(625,170,200,30);
        emailLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        emailLabel.setForeground(NAVY);
        formPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(625,205,460,48);
        emailField.setFont(new Font("Segoe UI",Font.PLAIN,18));
        formPanel.add(emailField);




        JLabel roomLabel = new JLabel("Room Type");
        roomLabel.setBounds(625,285,200,30);
        roomLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        roomLabel.setForeground(NAVY);
        formPanel.add(roomLabel);


        // Room type JText Field
        roomType = new JTextField();
        roomType.setBounds(625,320,460,48);
        roomType.setFont(new Font("Segoe UI",Font.PLAIN,18));
        formPanel.add(roomType);




        JLabel checkOutLabel = new JLabel("Check-Out Date");
        checkOutLabel.setBounds(625,400,220,30);
        checkOutLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        checkOutLabel.setForeground(NAVY);
        formPanel.add(checkOutLabel);

        checkOutField = new JTextField();
        checkOutField.setBounds(625,435,460,48);
        checkOutField.setFont(new Font("Segoe UI",Font.PLAIN,18));
        checkOutField.setText("dd/mm/yyyy");
        formPanel.add(checkOutField);

    }

    private void createMoreFields() {

        //-------------------- Adults --------------------

        JLabel adultsLabel = new JLabel("Room No:");
        adultsLabel.setBounds(95,510,200,30);
        adultsLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        adultsLabel.setForeground(NAVY);
        formPanel.add(adultsLabel);

        roomNo = new JTextField();

        roomNo.setBounds(95,545,460,48);
        roomNo.setFont(new Font("Segoe UI",Font.PLAIN,18));

        formPanel.add(roomNo);





        //-------------------- Children --------------------

        JLabel childLabel = new JLabel("Status");
        childLabel.setBounds(625,510,200,30);
        childLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        childLabel.setForeground(NAVY);
        formPanel.add(childLabel);

        status = new JTextField();
        status.setBounds(625,545,460,48);
        status.setFont(new Font("Segoe UI",Font.PLAIN,18));
        formPanel.add(status);


        //-------------------- Bed Type --------------------

        JLabel bedLabel = new JLabel("Bed Type");
        bedLabel.setBounds(95,620,200,30);
        bedLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        bedLabel.setForeground(NAVY);
        formPanel.add(bedLabel);


        bedType = new JTextField();
        bedType.setBounds(95,655,460,48);
        bedType.setFont(new Font("Segoe UI",Font.PLAIN,18));
        formPanel.add(bedType);



        //-------------------- Payment --------------------

        JLabel paymentLabel = new JLabel("Payment Method");
        paymentLabel.setBounds(625,620,220,30);
        paymentLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        paymentLabel.setForeground(NAVY);
        formPanel.add(paymentLabel);

        paymentBox = new JComboBox<>();

        paymentBox.addItem("Cash");
        paymentBox.addItem("Credit Card");
        paymentBox.addItem("Debit Card");
        paymentBox.addItem("UPI");

        paymentBox.setBounds(625,655,460,48);
        paymentBox.setFont(new Font("Segoe UI",Font.PLAIN,18));

        formPanel.add(paymentBox);


        //-------------------- Special Request --------------------

        JLabel requestLabel = new JLabel("Special Request");
        requestLabel.setBounds(95,735,250,30);
        requestLabel.setFont(new Font("Segoe UI",Font.BOLD,22));
        requestLabel.setForeground(NAVY);
        formPanel.add(requestLabel);

        specialRequestArea = new JTextArea();

        specialRequestArea.setFont(new Font("Segoe UI",Font.PLAIN,18));
        specialRequestArea.setLineWrap(true);
        specialRequestArea.setWrapStyleWord(true);

        JScrollPane sp = new JScrollPane(specialRequestArea);
        sp.setBounds(95,770,990,100);

        formPanel.add(sp);

    }

    private void createBottomPanel() {

        //---------------- Checkbox ----------------

        termsCheck = new JCheckBox("I agree to the Hotel Terms & Conditions");

        termsCheck.setBounds(95,885,420,30);
        termsCheck.setBackground(Color.WHITE);
        termsCheck.setForeground(NAVY);
        termsCheck.setFont(new Font("Segoe UI",Font.PLAIN,18));

        formPanel.add(termsCheck);


        //---------------- Divider ----------------

        JSeparator line = new JSeparator();
        line.setBounds(0,935,1180,2);
        formPanel.add(line);


        //---------------- Rupee Box ----------------

        JPanel rupeePanel = new JPanel();
        rupeePanel.setLayout(new BorderLayout());
        rupeePanel.setBackground(NAVY);
        rupeePanel.setBounds(40,965,75,75);
        JLabel rupee = new JLabel("₹");
        rupee.setHorizontalAlignment(SwingConstants.CENTER);
        rupee.setForeground(Color.WHITE);
        rupee.setFont(new Font("Segoe UI",Font.BOLD,38));
        rupeePanel.add(rupee);

        formPanel.add(rupeePanel);


        //---------------- Total Amount ----------------

        JLabel totalLabel = new JLabel("Total Amount");
        totalLabel.setBounds(135,968,250,30);
        totalLabel.setFont(new Font("Segoe UI",Font.BOLD,24));
        totalLabel.setForeground(NAVY);
        formPanel.add(totalLabel);


        totalPrice = new JLabel();
        totalPrice.setBounds(135,1000,250,40);
        totalPrice.setFont(new Font("Segoe UI",Font.BOLD,38));
        totalPrice.setForeground(new Color(205,145,45));
        formPanel.add(totalPrice);


        //---------------- Book Button ----------------

        bookBtn = new JButton("BOOK NOW");
        bookBtn.setBounds(600,975,260,60);
        bookBtn.setBackground(NAVY);
        bookBtn.setForeground(Color.WHITE);
        bookBtn.addActionListener(this);
        bookBtn.setFocusPainted(false);
        bookBtn.setFont(new Font("Segoe UI",Font.BOLD,22));
        formPanel.add(bookBtn);


        //---------------- Reset Button ----------------

        back = new JButton("Back");
        back.setBounds(900,975,245,60);
        back.setBackground(new Color(212,163,73));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setFont(new Font("Segoe UI",Font.BOLD,22));
        formPanel.add(back);

    }


    ///////// ------------------------------------------ mordern-UI ------------------------------ ////////

    class RoundTextField extends JTextField {

        public RoundTextField() {
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            setFont(new Font("Segoe UI", Font.PLAIN, 18));
        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(Color.white);
            g2.fillRoundRect(0,0,getWidth(),getHeight(),25,25);

            super.paintComponent(g);

            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {

            Graphics2D g2=(Graphics2D)g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(new Color(215,215,215));
            g2.drawRoundRect(0,0,getWidth()-1,getHeight()-1,25,25);

            g2.dispose();
        }
    }

    ////--- combo box
    class RoundComboBox<E> extends JComboBox<E>{

        public RoundComboBox(){

            setFont(new Font("Segoe UI",Font.PLAIN,18));

            setBackground(Color.WHITE);

        }

        @Override
        protected void paintComponent(Graphics g){

            Graphics2D g2=(Graphics2D)g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(Color.WHITE);

            g2.fillRoundRect(0,0,getWidth(),getHeight(),25,25);

            super.paintComponent(g);

            g2.dispose();
        }
    }

    //// ================ MAIN =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new BookingRoom("","","","","","","");
        });

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(bookBtn)){


            //generate the booking id here ====>
            BookingID = "bt" + (int)(Math.random()* 1000) + "sk" + (int)(Math.random()* 1000);
            System.out.println(BookingID);

            String Guest = guestField.getText();
            String phone = phoneField.getText();
            System.out.println(phone);
            String email = emailField.getText();
            statuss = "Booked";

            try{

                Conn c = new Conn();
                String query = "insert into guestDetails values('"+BookingID+"' , '"+Guest+"' , '"+email+"' , '"+phone+"' , '"+room_no+"' , '"+room_type+"' ,'"+bed_type+"', '"+prices+"' , '"+checkIn+"' ,'"+checkOut+"' , '"+statuss+"' )";
                String query2 = "UPDATE roomInfo SET aval = 'Not Available' WHERE room_no = '"+room_no+"'  ";

                c.statement.executeUpdate(query);
                c.statement.executeUpdate(query2);

            }catch (Exception E){
                E.printStackTrace();
            }

            Payment p = new Payment(this);
            p.setVisible(true);
        }

        if(ae.getSource().equals(back)){
            new SearchRoom().setVisible(true);
            setVisible(false);
        }
    }



}