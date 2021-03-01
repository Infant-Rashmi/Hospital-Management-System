package MODULE_3;


import javax.swing.*;

import com.mysql.jdbc.MiniAdmin;

import MODULE_2.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class addappointment  {

    private addappointment(){
        LocalDate date=LocalDate.now();

        JFrame f=new JFrame();
        JLabel l= new JLabel("Hospital Management System",JLabel.CENTER);
        JButton b1=new JButton("LOG OUT");b1.setBounds(1780,120,100,30);
        b1.setFont(new Font("Verdana", Font.PLAIN,11));b1.setBackground(new Color(171,222,158));
        JButton b2=new JButton("BACK");b2.setBounds(20,120,100,30);
        b2.setFont(new Font("Verdana", Font.PLAIN,11));b2.setBackground(new Color(171,222,158));
        JButton b3=new JButton("SEARCH");b3.setBounds(810,400,200,40);
        b3.setFont(new Font("Verdana", Font.PLAIN,20));b3.setBackground(new Color(171,222,158));
        JButton b4=new JButton("SAVE");b4.setBounds(650,500,200,40);
        b4.setFont(new Font("Verdana", Font.PLAIN,20));b4.setBackground(new Color(171,222,158));
        JButton b5=new JButton("CANCEL");b5.setBounds(1050,500,200,40);
        b5.setFont(new Font("Verdana", Font.PLAIN,20));b5.setBackground(new Color(171,222,158));


        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171,222,158));
        l.setFont(new Font("Verdana",Font.PLAIN,30));
        l.setBounds(0,20,1920,90);

        JLabel l1=new JLabel("ADD APPOINTMENT",JLabel.CENTER);
        l1.setOpaque(true);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Verdana",Font.PLAIN,20));
        l1.setBounds(850,120,200,30);
        l1.setBackground(new Color(215, 247, 224));


        JLabel l2=new JLabel("ENTER THE ID",JLabel.CENTER);
        l2.setOpaque(true);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Verdana",Font.PLAIN,20));
        l2.setBounds(600,226,300,30);
        l2.setBackground(new Color(215, 247, 224));

        JLabel l3=new JLabel("APPOINTMENT DATE",JLabel.CENTER);
        l3.setOpaque(true);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Verdana",Font.PLAIN,20));
        l3.setBounds(630,326,300,30);
        l3.setBackground(new Color(215, 247, 224));

        JLabel l4=new JLabel("DATE",JLabel.CENTER);
        l4.setOpaque(true);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Verdana",Font.PLAIN,20));
        l4.setBounds(20,220,100,30);
        l4.setBackground(new Color(215, 247, 224));

        JTextField t1=new JTextField();t1.setBounds(900,220,200,40);
        t1.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t2=new JTextField();t2.setBounds(900,320,200,40);
        t2.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t3=new JTextField(String.valueOf(date));t3.setBounds(130,220,170,30);
        t3.setFont(new Font("Verdana", Font.PLAIN,20));
        t3.setEditable(false);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s[]={};
                Receptionist.getInstance();
                f.setVisible(false);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.setText("");
                String s=t1.getText();int n=s.length();
                if(n!=0){
                    try{
                        
                        Login.getConnection().setAutoCommit(false);
                        PreparedStatement ps=Login.getConnection().prepareStatement("SELECT * from patient WHERE ID=(?)");
                        ps.setString(1,s);
                        ResultSet rs = ps.executeQuery();
                        String date = "";
                        while (rs.next()) {
                            date = rs.getString(10);
                            t2.setText(date);
                            }
                            Login.getConnection().commit();
                    }
                    catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date1=t2.getText();
                LocalDate date = LocalDate.parse(date1);String id=t1.getText();
                try {
                    Login.getConnection().setAutoCommit(false);
                    PreparedStatement ps = Login.getConnection().prepareStatement("UPDATE patient SET Next_Appointment=?, LAST_APPOINTMENT=? WHERE ID=?");
                    ps.setString(1, String.valueOf(date));
                    ps.setString(2,t3.getText());
                    ps.setString(3, id);
                    int i = ps.executeUpdate();
                    t1.setText("");
                    t2.setText("");
                    Login.getConnection().commit();
                    JOptionPane.showMessageDialog(f, "Appointment Added.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                catch (Exception ex){
                    System.out.println(ex);
                }

            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s[]={};
                Receptionist.getInstance();
                f.setVisible(false);
            }
        });
        f.setSize(1920,1080);
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.add(l);f.add(b1);f.add(b2);f.add(t1);f.add(b3);f.add(t2);f.add(b4);f.add(b5);f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(t3);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);

    }
    public static addappointment getInstance(){
        return new addappointment();
    }
    public static void main(String[] args) {
        addappointment.getInstance();
    }
    
}

