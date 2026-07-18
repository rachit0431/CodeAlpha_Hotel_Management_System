package Hotel.Management.System.user;

import Hotel.Management.System.Conn;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    String room_no , room_type , prices , bed_type , status , chechIn , chechOut;
    int row;
    JTable tabel;
    JPanel tableData,content;
    JButton searchBtn , book , back;
    JComboBox<String> category ,guest;
    JTextField checkIn ,checkOut ,price;
    JScrollPane scrollPane1;

    Color navy = new Color(7, 28, 68);
    Color gold = new Color(218, 165, 32);
    Color cream = new Color(247, 243, 236);

    public SearchRoom() {

        setTitle("The Royal Crest - Hotel Reservation System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(cream);

        //JPanel

        content = new JPanel();
        content.setLayout(null);
        content.setBackground(cream);
        content.setPreferredSize(new Dimension(1400, 1300));

        //---------------- HEADER ----------------//

        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBounds(0,0,1900,240);
        header.setBackground(navy);
        content.add(header);

        JLabel logo = new JLabel("R");
        logo.setBounds(55,35,80,80);
        logo.setForeground(gold);
        logo.setFont(new Font("Serif",Font.BOLD,60));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setBorder(BorderFactory.createLineBorder(gold,3));
        header.add(logo);

        JLabel hotelName = new JLabel("THE ROYAL CREST");
        hotelName.setBounds(330,25,800,70);
        hotelName.setForeground(gold);
        hotelName.setFont(new Font("Serif",Font.BOLD,58));
        hotelName.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(hotelName);

        JLabel sub = new JLabel("HOTEL RESERVATION SYSTEM");
        sub.setBounds(330,95,800,35);
        sub.setForeground(Color.WHITE);
        sub.setFont(new Font("SansSerif",Font.BOLD,28));
        sub.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(sub);

        JLabel line1 = new JLabel("───────────────────────────");
        line1.setBounds(330,115,180,20);
        line1.setForeground(gold);
        header.add(line1);

        JLabel line2 = new JLabel("───────────────────────────");
        line2.setBounds(940,115,180,20);
        line2.setForeground(gold);
        header.add(line2);

        JLabel searchTitle = new JLabel("Search Available Rooms");
        searchTitle.setBounds(330,160,800,40);
        searchTitle.setForeground(gold);
        searchTitle.setFont(new Font("Serif",Font.ITALIC,34));
        searchTitle.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(searchTitle);

        //---------------- SEARCH PANEL ----------------//

        JPanel search = new JPanel();
        search.setLayout(null);
        search.setBounds(100,250,1320,220);
        search.setBackground(cream);
        search.setBorder(new LineBorder( new Color(247, 243, 236),2,true));
        content.add(search);

        Font labelFont = new Font("SansSerif",Font.BOLD,18);
        Font fieldFont = new Font("SansSerif",Font.PLAIN,18);

        //// --> Category
        JLabel l1 = new JLabel("Category");
        l1.setBounds(60,30,150,30);
        l1.setFont(labelFont);
        l1.setForeground(navy);
        search.add(l1);

        category = new JComboBox<>(
                new String[]{"Standard","Deluxe","Suite","Presidential"});
        category.setBounds(45,80,160,30);
        category.setFont(fieldFont);
        category.setBackground(cream);
        category.setForeground(navy);
        search.add(category);

        // Check In
        JLabel l2 = new JLabel("Check-In Date");
        l2.setBounds(305,30,200,30);
        l2.setFont(labelFont);
        l2.setForeground(navy);
        search.add(l2);

        checkIn = new JTextField();
        checkIn.setBounds(295,80,230,30);
        checkIn.setFont(fieldFont);
        checkIn.setBackground(cream);
        checkIn.setForeground(navy);
        search.add(checkIn);



        // Check Out
        JLabel l3 = new JLabel("Check-Out Date");
        l3.setBounds(580,30,220,30);
        l3.setFont(labelFont);
        l3.setForeground(navy);
        search.add(l3);

        checkOut = new JTextField();
        checkOut.setBounds(570,80,230,30);
        checkOut.setFont(fieldFont);
        checkOut.setBackground(cream);
        checkOut.setForeground(navy);
        search.add(checkOut);



        // Guests
        JLabel l4 = new JLabel("Guests");
        l4.setBounds(875,30,120,30);
        l4.setFont(labelFont);
        l4.setForeground(navy);
        search.add(l4);

        guest = new JComboBox<>(
                new String[]{"1 Persons","2 Persons","3 Persons","4 Persons"});
        guest.setBounds(860,80,170,30);
        guest.setFont(fieldFont);
        search.add(guest);

        // Max Price
        JLabel l5 = new JLabel("Max Price (₹)");
        l5.setBounds(1095,30,180,30);
        l5.setFont(labelFont);
        l5.setForeground(navy);
        search.add(l5);

        price = new JTextField("3000");
        price.setBounds(1080,80,180,30);
        price.setFont(fieldFont);
        search.add(price);

        checkIn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180,180,180)),
                BorderFactory.createEmptyBorder(5,10,5,10)
        ));

        checkOut.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180,180,180)),
                BorderFactory.createEmptyBorder(5,10,5,10)
        ));

        price.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180,180,180)),
                BorderFactory.createEmptyBorder(5,10,5,10)
        ));


        searchBtn = new JButton("Search Rooms");
        searchBtn.setBounds(500,155,320,50);
        searchBtn.setBackground(navy);
        searchBtn.setForeground(Color.WHITE);
        searchBtn.addActionListener(this);
        searchBtn.setFont(new Font("SansSerif",Font.BOLD,24));
        searchBtn.setFocusPainted(false);
        searchBtn.setBorder(new LineBorder(gold,2,true));
        search.add(searchBtn);

        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        searchBtn.addMouseListener(new MouseAdapter(){

            public void mouseEntered(MouseEvent e){

                searchBtn.setBackground(new Color(20,45,110));

            }

            public void mouseExited(MouseEvent e){

                searchBtn.setBackground(new Color(8,25,63));

            }

        });


        ////-----------------------table header-----------------------

        JPanel roomHeader = new JPanel();
        roomHeader.setLayout(null);
        roomHeader.setBounds(100,500,1320,45);
        roomHeader.setBackground(new Color(8,25,63));
        content.add(roomHeader);

        Font headerFont = new Font("SansSerif",Font.BOLD,20);

        JLabel h1 = new JLabel("Room");
        h1.setForeground(Color.WHITE);
        h1.setFont(headerFont);
        h1.setBounds(90,8,100,30);
        roomHeader.add(h1);

        JLabel h2 = new JLabel("Room No");
        h2.setForeground(Color.WHITE);
        h2.setFont(headerFont);
        h2.setBounds(290,8,120,30);
        roomHeader.add(h2);

        JLabel h3 = new JLabel("Category");
        h3.setForeground(Color.WHITE);
        h3.setFont(headerFont);
        h3.setBounds(500,8,120,30);
        roomHeader.add(h3);

        JLabel h4 = new JLabel("Price");
        h4.setForeground(Color.WHITE);
        h4.setFont(headerFont);
        h4.setBounds(750,8,100,30);
        roomHeader.add(h4);

        JLabel h5 = new JLabel("Capacity");
        h5.setForeground(Color.WHITE);
        h5.setFont(headerFont);
        h5.setBounds(980,8,150,30);
        roomHeader.add(h5);

        JLabel h6 = new JLabel("Status");
        h6.setForeground(Color.WHITE);
        h6.setFont(headerFont);
        h6.setBounds(1160,8,120,30);
        roomHeader.add(h6);


        //// ----------- table ----



//        tableData = new JPanel();
//        tableData.setBounds(100,550,1320,750);
////      tableData.setBackground(Color.BLACK);
//        tableData.setLayout(null);
//        tableData.setBackground(cream);
//        content.add(tableData);

//        RoomData();


        //// Buttons srt hai yha se


        book = new JButton("Book Selected Room");

        book.setBounds(200,1200,270,48);
        book.setBackground(new Color(8,25,63));
        book.setForeground(cream);
        book.setFont(new Font("SansSerif",Font.BOLD,20));
        book.addActionListener(this);
        book.setFocusPainted(false);
        book.setCursor(new Cursor(Cursor.HAND_CURSOR));
        book.setBorder(BorderFactory.createEmptyBorder());

        book.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                book.setBackground(new Color(20,45,110));
            }

            public void mouseExited(MouseEvent e) {
                book.setBackground(new Color(8,25,63));
            }

        });

        content.add(book);



        back = new JButton("Back");

        back.setBounds(1100,1200,180,48);
        back.setBackground(new Color(212,175,55));
        back.setForeground(cream);
        back.setFont(new Font("SansSerif",Font.BOLD,20));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusPainted(false);

        back.addMouseListener(new MouseAdapter(){

            public void mouseEntered(MouseEvent e){
                back.setBackground(new Color(235,190,70));
            }

            public void mouseExited(MouseEvent e){
                back.setBackground(new Color(212,175,55));
            }

        });

        content.add(back);

        JPanel footer = new JPanel();

        footer.setBounds(0,1100,1590,40);
        footer.setBackground(new Color(8,25,63));

        footer.setLayout(new BorderLayout());

        JLabel copy = new JLabel(
                "© 2026 The Royal Crest Hotel Reservation System",
                SwingConstants.CENTER);
        copy.setBounds(650,10,800,30);
        copy.setForeground(Color.WHITE);
        copy.setFont(new Font("SansSerif",Font.PLAIN,15));
        footer.add(copy);
        content.add(footer);

        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        setContentPane(scrollPane);


        setVisible(true);
    }

    void RoomData() {

        tabel = new JTable();
        tabel.setBounds(50,0,1200,600);
        tabel.setForeground(navy);
        tabel.setBorder(BorderFactory.createLineBorder(navy,2));
        tabel.setBackground(cream);
        tabel.setFont(new Font("Seogue UI",Font.PLAIN,18));
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabel.setFillsViewportHeight(true);
        tableData.add(tabel);


        try{
            Conn c = new Conn();
            String resultShow = "select room_type , room_no , bed_type , price , person , clean from roomInfo";

            ResultSet rs = c.statement.executeQuery(resultShow);
            tabel.setModel(DbUtils.resultSetToTableModel(rs));

            tabel.revalidate();
            tabel.repaint();


            tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            for(int i =0 ;i<tabel.getColumnCount();i++){

                DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
                centerRender.setHorizontalAlignment(JLabel.CENTER);
                tabel.getColumnModel().getColumn(i).setPreferredWidth(220);
                tabel.getColumnModel().getColumn(i).setCellRenderer(centerRender);
                tabel.setRowHeight(30);

            }

            tabel.getColumnModel().getColumn(5).setPreferredWidth(220);

        }
        catch(Exception E){
            E.printStackTrace();
        }
    }   //// not found

        public void actionPerformed(ActionEvent ae){

                if (ae.getSource().equals(searchBtn)) {

                    if (scrollPane1 != null) {
                        content.remove(scrollPane1);
                    }

                    String Category = (String) category.getSelectedItem();
                    String Guest = (String) guest.getSelectedItem();
                    String Price = price.getText();

                    Conn conn = new Conn();

                    try {

                        tabel = new JTable();

                        tabel.setForeground(navy);
                        tabel.setBackground(cream);
                        tabel.setBorder(BorderFactory.createLineBorder(navy, 2));
                        tabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                        tabel.setRowHeight(35);

                        // Sirf row select hogi
                        tabel.setRowSelectionAllowed(true);
                        tabel.setColumnSelectionAllowed(false);
                        tabel.setCellSelectionEnabled(false);

                        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                        tabel.setFillsViewportHeight(true);

                        String query = "SELECT room_type, room_no, bed_type, price, person, aval "
                                + "FROM roomInfo "
                                + "WHERE room_type='" + Category + "' "
                                + "AND person<='" + Guest + "' "
                                + "AND price<='" + Price + "'"
                                + "AND aval = 'Available' ";

                        ResultSet rs = conn.statement.executeQuery(query);
                        tabel.setModel(DbUtils.resultSetToTableModel(rs));

                        // Header Style
//                        JTableHeader header = tabel.getTableHeader();
//                        header.setFont(new Font("Segoe UI", Font.BOLD, 18));
//                        header.setBackground(navy);
//                        header.setForeground(cream);
                        tabel.setTableHeader(null);

                        // Center Alignment
                        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
                        center.setHorizontalAlignment(JLabel.CENTER);

                        for (int i = 0; i < tabel.getColumnCount(); i++) {
                            tabel.getColumnModel().getColumn(i).setCellRenderer(center);
                            tabel.getColumnModel().getColumn(i).setPreferredWidth(220);
                        }

                        scrollPane1 = new JScrollPane(tabel);
                        scrollPane1.setBounds(100, 550, 1450, 500);
                        scrollPane1.setBorder(BorderFactory.createEmptyBorder());

                        content.add(scrollPane1);

                        content.revalidate();
                        content.repaint();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            tabel.getSelectionModel().addListSelectionListener(e -> {

                if (!e.getValueIsAdjusting()) {

                    row = tabel.getSelectedRow();

                    if (row != -1) {
                        System.out.println("Selected Row = " + row);
                        System.out.println("Room No = " + tabel.getValueAt(row,1));
                         room_no = tabel.getValueAt(row, 1).toString();
                         room_type = tabel.getValueAt(row, 0).toString();
                         bed_type = tabel.getValueAt(row, 2).toString();
                         prices = tabel.getValueAt(row, 3).toString();
                         status = tabel.getValueAt(row, 5).toString();
                         chechIn =  checkIn.getText();
                         chechOut = checkOut.getText();

                         System.out.println(bed_type);
                    }
                }

            });

                if (ae.getSource().equals(book)){
                   if(tabel.getSelectedRow() == -1){
                       JOptionPane.showMessageDialog(null,"Please select the room");
                   }
                   else{
                       new BookingRoom(room_no , room_type , bed_type , prices , status , chechIn , chechOut );
                   }
                }
            if(ae.getSource().equals(back)){
                new HomePage().setVisible(true);
                setVisible(false);
            }
        }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SearchRoom());
    }
}

