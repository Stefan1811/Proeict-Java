package airline;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CancelTable extends JFrame {

    private JTable table;


    public static void main(String[] args) {
        new CancelTable();
    }

    public CancelTable() {

        JLabel Cancellation = new JLabel("CANCELLATION TABLE");
        Cancellation.setFont(new Font("Courier", Font.BOLD, 31));
        Cancellation.setBounds(280, 24, 500, 38);
        add(Cancellation);

        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Courier", Font.BOLD, 13));


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(860, 523);
        setLayout(null);
        setVisible(true);


        JButton btnShow = new JButton("SHOW");
        btnShow.setFont(new Font("Courier", Font.BOLD, 20));
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {


                try {
                    conn c = new conn();
                    String str = "select * from cancellation";

                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

					/*else{
						JOptionPane.showMessageDialog(null,"No Flights with this Number");

					}*/

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(350, 100, 180, 80);
        add(btnShow);

        table = new JTable();
        table.setBackground(Color.WHITE);
        table.setBounds(23, 250, 800, 300);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);

        JLabel FlightCode = new JLabel("Pnr No");
        FlightCode.setFont(new Font("Courier", Font.BOLD, 13));
        FlightCode.setBounds(100, 220, 126, 14);
        add(FlightCode);

        JLabel FlightName = new JLabel("Cancellation No");
        FlightName.setFont(new Font("Courier", Font.BOLD, 13));
        FlightName.setBounds(280, 220, 150, 14);
        add(FlightName);

        JLabel Source = new JLabel("Cancellation Date");
        Source.setFont(new Font("Courier", Font.BOLD, 13));
        Source.setBounds(480, 220, 150, 14);
        add(Source);

        JLabel Destination = new JLabel("Flight Code");
        Destination.setFont(new Font("Courier", Font.BOLD, 13));
        Destination.setBounds(680, 220, 150, 14);
        add(Destination);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900, 650);
        setVisible(true);
        setLocation(400, 200);

    }
}