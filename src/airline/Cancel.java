package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Cancel extends JFrame {
    private JTextField textField,textField_1,textField_2,textField_3;

    public static void main(String[] args) {
        new Cancel();
    }
    
    public Cancel() {
        initialize();
    }
    
    private void initialize() {
		setTitle("CANCELLATION");
	getContentPane().setBackground(Color.WHITE);
	setBounds(100, 100, 801, 472);
	setLayout(null);
		
	JLabel Cancellation = new JLabel("CANCELLATION");
	Cancellation.setFont(new Font("Courier", Font.BOLD, 31));
	Cancellation.setBounds(185, 24, 259, 38);
	add(Cancellation);
		
	
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
	Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 250, 250);
	add(NewLabel);
		
	JLabel PassengerNo = new JLabel("PASSENGER NO");
	PassengerNo.setFont(new Font("Courier", Font.BOLD, 15));
	PassengerNo.setBounds(60, 100, 132, 26);
	add(PassengerNo);
		
	JLabel CancellationNo = new JLabel("CANCELLATION NO");
	CancellationNo.setFont(new Font("Courier", Font.BOLD, 15));
	CancellationNo.setBounds(60, 150, 150, 27);
	add(CancellationNo);
		
	JLabel CancellationDate = new JLabel("CANCELLATION DATE");
	CancellationDate.setFont(new Font("Courier", Font.BOLD, 15));
	CancellationDate.setBounds(60, 200, 180, 27);
	add(CancellationDate);
		
	JLabel Flightcode = new JLabel("FLIGHT_CODE");
	Flightcode.setFont(new Font("Courier", Font.BOLD, 15));
	Flightcode.setBounds(60, 300, 150, 27);
	add(Flightcode);
		
	JButton Cancel = new JButton("CANCEL");
	Cancel.setFont(new Font("Courier", Font.BOLD, 14));
	Cancel.setBackground(Color.BLACK);
	Cancel.setForeground(Color.WHITE);
	Cancel.setBounds(250, 350, 150, 30);
	add(Cancel);

	JButton Tabell = new JButton("SHOW TABLE");
	Tabell.setFont(new Font("Courier", Font.BOLD, 14));
	Tabell.setBackground(Color.BLACK);
	Tabell.setForeground(Color.WHITE);
	Tabell.setBounds(500, 350, 150, 30);
	add(Tabell);
		
	textField = new JTextField();
	textField.setBounds(250, 100, 150, 27);
	add(textField);
	
	textField_1 = new JTextField();
	textField_1.setBounds(250, 150, 150, 27);
	add(textField_1);
		
	textField_2 = new JTextField();
	textField_2.setBounds(250, 200, 150, 27);
	add(textField_2);
		
	textField_3 = new JTextField();
	textField_3.setBounds(250, 300, 150, 27);
	add(textField_3);
		Tabell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == Tabell) {
					new CancelTable();
				}
			}
		});

	Cancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae) {

			if (ae.getSource() == Cancel) {
				try {
					String passenger_no = textField.getText();
					String cancellation_no = textField_1.getText();
					String cancellation_date = textField_2.getText();
					String flight_code = textField_3.getText();
					conn c = new conn();
					String str = "INSERT INTO cancellation values('" + passenger_no + "', '" + cancellation_no + "', '" + cancellation_date + "', '" + flight_code + "')";
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Ticket Canceled");
					//setVisible(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
        });
			
	setSize(860,500);
	setVisible(true);
	setLocation(400,200);
    }
}
