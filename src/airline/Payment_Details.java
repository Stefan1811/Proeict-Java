package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Payment_Details extends JFrame{
    JTextField textField;
    JTable table;
    JLabel Sector;
    JLabel FlightCode, Capacity, Classcode, Classname, label;

    public static void main(String[] args) {
        new Payment_Details();
    }

    public Payment_Details(){
	initialize();
    }

    private void initialize(){
		setTitle("PAYMENT_DETAILS");
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setSize(860,486);
	setLayout(null);
		
	JLabel Fcode = new JLabel("PNR NO");
	Fcode.setFont(new Font("Courier", Font.BOLD, 17));
	Fcode.setBounds(60, 160, 150, 26);
	add(Fcode);
		
	textField = new JTextField();
	textField.setBounds(200, 160, 150, 26);
	add(textField);
	
	table = new JTable();
	table.setBounds(45, 329, 766, 87);
	add(table);
		
	JButton Show = new JButton("SHOW");
	Show.setFont(new Font("Courier", Font.BOLD, 17));
	Show.setBackground(Color.BLACK);
	Show.setForeground(Color.WHITE);
	Show.setBounds(200, 210, 150, 26);
	add(Show);
		
	Sector = new JLabel("PAYMENT DETAILS");
	Sector.setForeground(Color.BLUE);
	Sector.setFont(new Font("Courier", Font.BOLD, 31));
	Sector.setBounds(51, 17, 300, 39);
	add(Sector);
		
	FlightCode = new JLabel("PNR_NO");
	FlightCode.setFont(new Font("Courier", Font.BOLD, 13));
	FlightCode.setBounds(84, 292, 108, 26);
	add(FlightCode);
		
	Capacity = new JLabel("PAID_AMOUNT");
	Capacity.setFont(new Font("Courier", Font.BOLD, 13));
	Capacity.setBounds(183, 298, 92, 14);
	add(Capacity);
		
	Classcode = new JLabel("PAY_DATE");
	Classcode.setFont(new Font("Courier", Font.BOLD, 13));
	Classcode.setBounds(322, 294, 101, 24);
	add(Classcode);
		
	Classname = new JLabel("CHEQUE_NO");
	Classname.setFont(new Font("Courier", Font.BOLD, 13));
	Classname.setBounds(455, 298, 114, 14);
	add(Classname);

	JLabel Cardno = new JLabel("CARD_NO");
	Cardno.setFont(new Font("Courier", Font.BOLD, 13));
	Cardno.setBounds(602, 299, 101, 19);
	add(Cardno);
		
	JLabel Phoneno = new JLabel("PHONE_NO");
	Phoneno.setFont(new Font("Courier", Font.BOLD, 13));
	Phoneno.setBounds(712, 294, 86, 24);
	add(Phoneno);

	label = new JLabel("");
	label.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payment.png")));
	label.setBounds(425, 15, 400, 272);
	add(label);

	setVisible(true);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                try {
                    String code  = textField.getText();
                    
                    conn c = new conn();
                    String str = "select pnr_no,paid_amt,pay_date,cheque_no,card_no,ph_no from payment where pnr_no = '"+code+"'";
					ResultSet rs = c.s.executeQuery(str);

						table.setModel(DbUtils.resultSetToTableModel(rs));
					/*else{
						JOptionPane.showMessageDialog(null, "Invalid PNR Number");
					}*/
					
		}catch(SQLException e) {
                    e.printStackTrace();
                }
            }
	});
		
	setSize(960,590);
	setLocation(400,200);
	setVisible(true);

    }
}
