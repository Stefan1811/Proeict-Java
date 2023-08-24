package airline;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.*;
public class PlaneDetails extends JFrame {
    private JLabel imageLabel;
    private Timer timer;
    private int currentIndex;
    private String[] imagePaths = {
            "1.jpg",
            "2.jpg",
            "3.jpg",
            "4.jpg",
            "5.jpg",
            "6.jpg",
            "7.jpg",
            "8.jpg"
    };

    PlaneDetails(){
        setTitle("All Company Planes");
        JLabel OK = new JLabel("ALL COMPANY PLANES");
        OK.setFont(new Font("Courier", Font.BOLD, 31));
        OK.setBounds(320, 24, 500, 38);
        add(OK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        currentIndex = 0;
        displayImage();

        timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % imagePaths.length;
                displayImage();
            }
        });
        timer.start();

    }

    private void displayImage() {
        String imagePath = imagePaths[currentIndex];
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
            imageLabel.setIcon(new ImageIcon(scaledImage));
        } else {
            System.err.println("Image not found: " + imagePath);
        }
    }

    public static void main(String[] args) {
        PlaneDetails ok=new PlaneDetails();
    }
}