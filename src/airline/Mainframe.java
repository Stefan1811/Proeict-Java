package airline;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Mainframe extends JFrame{

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
        initialize();
    }

    
    private void initialize() {
        setForeground(Color.CYAN);
        setLayout(null);
        JLabel NewLabel = new JLabel("");
	NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg")));
	NewLabel.setBounds(0, 0, 1920, 990); 
	add(NewLabel); 
        
    JLabel AirlineManagementSystem = new JLabel("AIRlLINE BODESCU WELCOMES YOU");
	AirlineManagementSystem.setForeground(Color.DARK_GRAY);
    AirlineManagementSystem.setFont(new Font("Courier", Font.BOLD, 36));
	AirlineManagementSystem.setBounds(700, 60, 1000, 55);
	NewLabel.add(AirlineManagementSystem);
		
		
    JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
    JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM MANAGEMENT");
    AirlineSystem.setForeground(Color.DARK_GRAY);
	menuBar.add(AirlineSystem);
		
    JMenuItem FlightDetails = new JMenuItem("Flight Information");
    FlightDetails.setForeground(Color.DARK_GRAY);
	AirlineSystem.add(FlightDetails);

    JMenuItem Planes = new JMenuItem("Planes Information");
    Planes.setForeground(Color.DARK_GRAY);
    AirlineSystem.add(Planes);
		
	JMenuItem ReservationDetails = new JMenuItem("Add Costumer Details");
    ReservationDetails.setForeground(Color.DARK_GRAY);
	AirlineSystem.add(ReservationDetails);
		
	JMenuItem PassengerDetails = new JMenuItem("Journey Details");
    PassengerDetails.setForeground(Color.DARK_GRAY);
    AirlineSystem.add(PassengerDetails);
		
	JMenuItem SectorDetails_1 = new JMenuItem("Payment Details");
    SectorDetails_1.setForeground(Color.DARK_GRAY);
    AirlineSystem.add(SectorDetails_1);
		
	JMenuItem Cancellation = new JMenuItem("Cancellation Details");
    Cancellation.setForeground(Color.DARK_GRAY);
    AirlineSystem.add(Cancellation);
        
    JMenu exit = new JMenu("Logout");
    exit.setForeground(Color.RED);
	menuBar.add(exit);
		
        JMenuItem logout = new JMenuItem("Logout");
	exit.add(logout);
        
		
	FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Flight_Info();
            }
	});
        
	ReservationDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Customer();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        PassengerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Journey_Details();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
        Planes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            PlaneDetails imageSlider = new PlaneDetails();
                            imageSlider.setVisible(true);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        SectorDetails_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Payment_Details();
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
            }
	});
        
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new Login().setVisible(true);
            }
	});
        setSize(1950,1090);
	    setVisible(true);
    }
}
