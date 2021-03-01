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

public class changeRequest {
    String s;


    private changeRequest(){
        JFrame f=new JFrame();
        JLabel l= new JLabel("Hospital Management System",JLabel.CENTER);
        JButton b1=new JButton("LOG OUT");b1.setBounds(1780,120,100,30);
        b1.setFont(new Font("Verdana", Font.PLAIN,11));b1.setBackground(new Color(171,222,158));
        JButton b2=new JButton("BACK");b2.setBounds(20,120,100,30);
        b2.setFont(new Font("Verdana", Font.PLAIN,11));b2.setBackground(new Color(171,222,158));
        JButton b3=new JButton("SEARCH");b3.setBounds(1150,220,150,40);
        b3.setFont(new Font("Verdana", Font.PLAIN,11));b3.setBackground(new Color(171,222,158));
        JButton b4=new JButton("ADD REQUEST");b4.setBounds(850,726,250,50);
        b4.setFont(new Font("Verdana", Font.PLAIN,11));b4.setBackground(new Color(171,222,158));

        JLabel l1=new JLabel("CHANGE REQUEST",JLabel.CENTER);
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

        JLabel l4=new JLabel("AGE",JLabel.CENTER);
        l4.setOpaque(true);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Verdana",Font.PLAIN,20));
        l4.setBounds(200,429,100,30);
        l4.setBackground(new Color(215, 247, 224));

        JLabel l5=new JLabel("PHONE NUMBER",JLabel.CENTER);
        l5.setOpaque(true);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Verdana",Font.PLAIN,20));
        l5.setBounds(720,429,250,30);
        l5.setBackground(new Color(215, 247, 224));

        JLabel l6=new JLabel("ADDRESS",JLabel.CENTER);
        l6.setOpaque(true);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Verdana",Font.PLAIN,20));
        l6.setBounds(1300,429,150,30);
        l6.setBackground(new Color(215, 247, 224));

        JLabel l7=new JLabel("NEXT APPOINTMENT",JLabel.CENTER);
        l7.setOpaque(true);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Verdana",Font.PLAIN,20));
        l7.setBounds(180,629,300,30);
        l7.setBackground(new Color(215, 247, 224));

        JLabel l8=new JLabel("LAST APPOINTMENT",JLabel.CENTER);
        l8.setOpaque(true);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Verdana",Font.PLAIN,20));
        l8.setBounds(740,629,250,30);
        l8.setBackground(new Color(215, 247, 224));

        JLabel l9=new JLabel("NO OF APPOINTMENT CHANGES",JLabel.CENTER);
        l9.setOpaque(true);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Verdana",Font.PLAIN,20));
        l9.setBounds(1290,629,400,30);
        l9.setBackground(new Color(215, 247, 224));

        JTextField t1=new JTextField();t1.setBounds(900,220,200,40);
        t1.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t2=new JTextField();t2.setBounds(900,320,300,40);
        t2.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t3=new JTextField();t3.setBounds(350,426,100,40);
        t2.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t4=new JTextField();t4.setBounds(1000,426,200,40);
        t4.setFont(new Font("Verdana", Font.PLAIN,20));


        JTextArea t5=new JTextArea();
        t5.setFont(new Font("Verdana", Font.PLAIN,20));t5.setLineWrap(true);
        JScrollPane pane=new JScrollPane(t5,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setBounds(1500,426,400,150);


        JTextField t6=new JTextField();t6.setBounds(500,626,150,40);
        t6.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t7=new JTextField();t7.setBounds(1000,626,150,40);
        t7.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t8=new JTextField();t8.setBounds(1700,626,50,40);
        t8.setFont(new Font("Verdana", Font.PLAIN,20));



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
                s=t1.getText();
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                try{
                    PreparedStatement ps=Login.getConnection().prepareStatement("SELECT * from patient WHERE ID=(?)");
                    ps.setString(1,t1.getText());
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        t2.setText(rs.getString(1));
                        t3.setText(String.valueOf(rs.getInt(4)));
                        t4.setText(String.valueOf(rs.getInt(7)));
                        t5.setText(rs.getString(5));
                        t6.setText(rs.getString(10));
                        t7.setText(rs.getString(9));
                        t8.setText(String.valueOf(rs.getInt(11)));
                    }

                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement ps = Login.getConnection().prepareStatement("UPDATE patient SET APPOINTMENT_CHANGE_REQUEST=(?),INFORMED=(?) WHERE ID=(?)");
                    ps.setInt(1, 1);
                    ps.setInt(2, 0);
                    ps.setString(3, s);
                    int a = ps.executeUpdate();
                    
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    JOptionPane.showMessageDialog(f, "Initiated Appointment Change Request", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                catch (Exception ev){
                    System.out.println(ev);
                }
            }
        });

        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171,222,158));
        l.setFont(new Font("Verdana",Font.PLAIN,30));
        l.setBounds(0,20,1920,90);

        f.setSize(1920, 1080);
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.add(l);f.add(b1);f.add(b2);f.add(l1);f.add(l2);f.add(t1);f.add(l3);f.add(t2);f.add(l4);f.add(t3);f.add(l5);f.add(t4);f.add(l6);
        f.add(l7);f.add(l8);f.add(t6);f.add(t7);f.add(l9);f.add(t8);f.add(b3);f.add(b4);f.add(pane);
        f.setLayout(null);
        f.setResizable(true);
        f.setVisible(true);


        f.setDefaultCloseOperation(3);
    }
    public static changeRequest getInstance(){
        return  new changeRequest();
    }


}

