package MODULE_4;

import javax.swing.*;

import MODULE_2.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fees {
    String id,fees;
    private fees(){

        JFrame f=new JFrame();
        JLabel l= new JLabel("Hospital Management System",JLabel.CENTER);

        JButton b1=new JButton("LOG OUT");b1.setBounds(1780,120,100,30);
        b1.setFont(new Font("Verdana", Font.PLAIN,11));b1.setBackground(new Color(171,222,158));
        JButton b2=new JButton("BACK");b2.setBounds(20,120,100,30);
        b2.setFont(new Font("Verdana", Font.PLAIN,11));b2.setBackground(new Color(171,222,158));
        JButton b3=new JButton("SEARCH");b3.setBounds(1150,220,150,40);
        b3.setFont(new Font("Verdana", Font.PLAIN,11));b3.setBackground(new Color(171,222,158));
        JButton b4=new JButton("CONFIRM");b4.setBounds(900,520,150,40);
        b4.setFont(new Font("Verdana", Font.PLAIN,11));b4.setBackground(new Color(171,222,158));

        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171,222,158));
        l.setFont(new Font("Verdana",Font.PLAIN,30));
        l.setBounds(0,20,1920,90);

        JLabel l1=new JLabel("FEES",JLabel.CENTER);
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

        JTextField t1=new JTextField();t1.setBounds(900,220,200,40);
        t1.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t2=new JTextField();t2.setBounds(900,320,300,40);
        t2.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t3=new JTextField();t3.setBounds(900,420,200,40);
        t3.setFont(new Font("Verdana", Font.PLAIN,20));

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s[]={};
                Main.getInstance();
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
                    PreparedStatement ps=Login.getConnection().prepareStatement("SELECT * from patient WHERE ID=(?) AND Doctor=(?);");
                    ps.setString(1,t1.getText());
                    ps.setString(2,Login.Doctor_Login_ID);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        t2.setText(rs.getString(1));
                        t3.setText(String.valueOf(rs.getInt(14)));
                    }
                    fees=t3.getText();
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fees=t3.getText();
                try{

                    PreparedStatement ps=Login.getConnection().prepareStatement("UPDATE patient SET FEES=(?) WHERE ID=(?)");
                    ps.setString(1,fees);
                    ps.setString(2,id);
                    int a=ps.executeUpdate();

                    JOptionPane.showMessageDialog(f, "SUCCESSFULL", "Success", JOptionPane.WARNING_MESSAGE);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });

        b1.addActionListener(e->{
            Login.getInstance();
            f.setVisible(false);
        });
        f.setSize(1920,1080);
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.add(l);f.add(l1);f.add(b1);f.add(b2);f.add(l2);f.add(l3);
        f.add(b3);f.add(t1);f.add(t2);f.add(l4);f.add(t3);f.add(b4);
        f.setLayout(null);f.setResizable(true);f.setDefaultCloseOperation(3);
        f.setVisible(true);
    }
    public static fees getInstance(){
        return new fees();
    }
}
