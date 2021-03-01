package MODULE_3;
import javax.swing.*;

import MODULE_2.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Feepayment {
    String id;int paid;
    private Feepayment(){
        JFrame f=new JFrame();

        JButton b1=new JButton("LOG OUT");b1.setBounds(1780,120,100,30);
        b1.setFont(new Font("Verdana", Font.PLAIN,11));b1.setBackground(new Color(171,222,158));
        JButton b2=new JButton("BACK");b2.setBounds(20,120,100,30);
        b2.setFont(new Font("Verdana", Font.PLAIN,11));b2.setBackground(new Color(171,222,158));
        JButton b3=new JButton("SEARCH");b3.setBounds(1150,220,150,40);
        b3.setFont(new Font("Verdana", Font.PLAIN,11));b3.setBackground(new Color(171,222,158));
        JButton b4=new JButton("PAY");b4.setBounds(900,620,150,40);
        b4.setFont(new Font("Verdana", Font.PLAIN,15));b4.setBackground(new Color(171,222,158));
        JButton b5=new JButton("CHECK BALANCE");b5.setBounds(1500,520,150,40);
        b5.setFont(new Font("Verdana", Font.PLAIN,11));b5.setBackground(new Color(171,222,158));

        JLabel l= new JLabel("Hospital Management System",JLabel.CENTER);
        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171,222,158));
        l.setFont(new Font("Verdana",Font.PLAIN,30));
        l.setBounds(0,20,1920,90);


        JLabel l1=new JLabel("FEE PAYMENT",JLabel.CENTER);
        l1.setOpaque(true);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Verdana",Font.PLAIN,20));
        l1.setBounds(800,120,300,30);
        l1.setBackground(new Color(215, 247, 224));

        JLabel l2=new JLabel("ENTER THE ID",JLabel.CENTER);
        l2.setOpaque(true);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Verdana",Font.PLAIN,20));
        l2.setBounds(600,226,300,30);
        l2.setBackground(new Color(215, 247, 224));

        JLabel l3=new JLabel("NAME",JLabel.CENTER);
        l3.setOpaque(true);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Verdana",Font.PLAIN,20));
        l3.setBounds(560,326,300,30);
        l3.setBackground(new Color(215, 247, 224));

        JLabel l4=new JLabel("FEES",JLabel.CENTER);
        l4.setOpaque(true);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Verdana",Font.PLAIN,20));
        l4.setBounds(560,426,300,30);
        l4.setBackground(new Color(215, 247, 224));

        JLabel l5=new JLabel("AMOUNT PAID",JLabel.CENTER);
        l5.setOpaque(true);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Verdana",Font.PLAIN,20));
        l5.setBounds(400,526,300,30);
        l5.setBackground(new Color(215, 247, 224));

        JLabel l6=new JLabel("CHANGE",JLabel.CENTER);
        l6.setOpaque(true);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Verdana",Font.PLAIN,20));
        l6.setBounds(930,526,200,30);
        l6.setBackground(new Color(215, 247, 224));



        JTextField t1=new JTextField();t1.setBounds(900,220,200,40);
        t1.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t2=new JTextField();t2.setBounds(900,320,300,40);
        t2.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t3=new JTextField();t3.setBounds(900,420,200,40);
        t3.setFont(new Font("Verdana", Font.PLAIN,20));
        t3.setEditable(false);

        JTextField t4=new JTextField();t4.setBounds(730,520,200,40);
        t4.setFont(new Font("Verdana", Font.PLAIN,20));


        JTextField t5=new JTextField();t5.setBounds(1200,520,200,40);
        t5.setFont(new Font("Verdana", Font.PLAIN,20));
        t5.setEditable(false);

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
                id=t1.getText();
                try{
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    
                    Login.getConnection().setAutoCommit(false);
                    PreparedStatement ps=Login.getConnection().prepareStatement("SELECT * from patient WHERE ID=(?)");
                    ps.setString(1,t1.getText());
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        t2.setText(rs.getString(1));
                        t3.setText(String.valueOf(rs.getInt(14)));
                    }
                    Login.getConnection().commit();
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int change=Integer.parseInt(t5.getText());
                if(change>=0){
                    try{
                        
                        Login.getConnection().setAutoCommit(false);
                        PreparedStatement ps=Login.getConnection().prepareStatement("UPDATE patient SET FEES=(?) WHERE ID=(?)");
                        ps.setInt(1,0);
                        ps.setString(2,id);
                        int a=ps.executeUpdate();
                        Login.getConnection().commit();
                         
                        JOptionPane.showMessageDialog(f, "PAYMENT SUCCESSFULL", "Success", JOptionPane.WARNING_MESSAGE);
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");

                    }
                    catch (Exception ex){
                        System.out.println(ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(f, "PAYMENT NOT SUCCESSFULL", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((t4.getText().isEmpty())||(t1.getText().isEmpty())){
                    JOptionPane.showMessageDialog(f, "ENTER AMOUNT PAID and ID", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else{
                     paid=Integer.parseInt(t4.getText());
                    try{
                        Login.getConnection().setAutoCommit(false);
                        PreparedStatement ps=Login.getConnection().prepareStatement("SELECT * from patient WHERE ID=(?)");
                        ps.setString(1,t1.getText());
                        ResultSet rs = ps.executeQuery();
                        while(rs.next()){
                            t5.setText(String.valueOf(paid-(rs.getInt(14))));
                        }
                        Login.getConnection().commit();
                         
                    }
                    catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            }
        });

        f.setSize(1920, 1080);
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.setLayout(null);
        f.setResizable(true); f.setDefaultCloseOperation(3);
        f.add(l);f.add(b1);f.add(b2);f.add(l1);f.add(b3);f.add(l2);f.add(l3);f.add(t1);f.add(t2);f.add(l4);f.add(t3);f.add(l5);f.add(t4);f.add(l6);
        f.add(t5);f.add(b4);f.add(b5);
        f.setVisible(true);

    }
    public static Feepayment getInstance(){
        return new Feepayment();
    }
}
