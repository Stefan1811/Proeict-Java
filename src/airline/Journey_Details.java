package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame{

    JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,Source,Destination,label,label1;
    JButton Show;

    public static void main(String[] args){
        new Journey_Details();
    }

    public Journey_Details(){
		setTitle("JOURNEY_DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	setLayout(null);
	setVisible(true);

	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Courier", Font.BOLD, 19));
	Source.setBounds(60, 100, 150, 27);
	add(Source);

	Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Courier", Font.BOLD, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);



	Show = new JButton("SHOW");
	Show.setBounds(680, 100, 100, 30);
	add(Show);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	ReservationDetails = new JLabel("JOURNEY DETAILS");
	ReservationDetails.setForeground(Color.BLUE);
	ReservationDetails.setFont(new Font("Courier", Font.BOLD, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	add(ReservationDetails);

	Pnrno = new JLabel("PNR_NO");
	Pnrno.setFont(new Font("Courier", Font.BOLD, 13));
	Pnrno.setBounds(79, 270, 83, 20);
	add(Pnrno);

	Ticketid = new JLabel("TICKET_ID");
	Ticketid.setFont(new Font("Courier", Font.BOLD, 13));
	Ticketid.setBounds(172, 270, 71, 20);
	add(Ticketid);

	Fcode = new JLabel("F_CODE");
	Fcode.setFont(new Font("Courier", Font.BOLD, 13));
	Fcode.setBounds(297, 270, 103, 20);
	add(Fcode);

	Jnydate = new JLabel("JNY_DATE");
	Jnydate.setFont(new Font("Courier", Font.BOLD, 13));
	Jnydate.setBounds(390, 270, 94, 20);
	add(Jnydate);

	Jnytime = new JLabel("JNY_TIME");
	Jnytime.setFont(new Font("Courier", Font.BOLD, 13));
	Jnytime.setBounds(494, 270, 83, 20);
	add(Jnytime);

	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Courier", Font.BOLD, 13));
	Source.setBounds(613, 270, 94, 20);
	add(Source);

	Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Courier", Font.BOLD, 13));
	Destination.setBounds(717, 270, 94, 20);
	add(Destination);

	String[] items1 =  {"Bucuresti", "Viena", "Roma","Munich","Amsterdam", "Atena","Berlin","Paris","Londra","Berlin","Oslo","Stockholm"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);


	String[] items2 =   {"Bucuresti", "Viena","Munich", "Roma","Amsterdam","Berlin","Atena","Paris","Londra","Berlin","Oslo","Stockholm"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);

		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String src = (String) comboBox.getSelectedItem();
					String dst = (String) comboBox_1.getSelectedItem();

					conn c = new conn();

					String str = "select * from reservation where src = '"+src+"' and dst = '"+dst+"'";
					ResultSet rs = c.s.executeQuery(str);
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


		table = new JTable();
	table.setBounds(38, 310, 770, 130);
	add(table);

	JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
	pane.setBackground(Color.WHITE);
	add(pane);

	setSize(860,600);
	setLocation(400,200);
	setVisible(true);

    }
}
