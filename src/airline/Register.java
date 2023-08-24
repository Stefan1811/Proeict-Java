package airline;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Register extends JFrame implements ActionListener {
    JTextField t1,t2;
    JLabel l1,l2;

    JButton b1,b2;
    public Register(){
        super("Register");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
        setVisible(true);
        setSize(600,300);
        setLocation(600,350);

        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);

        b1 = new JButton("Create account");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(600,350);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c1 = new conn();
                String u = t1.getText();
                String v = t2.getText();

                String str = "INSERT INTO login values( '"+u+"', '"+v+"')";
                    c1.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Account Created");
                    setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new Register();
    }
}
