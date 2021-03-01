package MODULE_4;

import javax.swing.*;

import MODULE_2.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class addpatient {

    String s;
    String prob;

    private addpatient() {
        JFrame f = new JFrame();
        JLabel l = new JLabel("Hospital Management System", JLabel.CENTER);

        JButton b1 = new JButton("LOG OUT");
        b1.setBounds(1780, 120, 100, 30);
        b1.setFont(new Font("Verdana", Font.PLAIN, 11));
        b1.setBackground(new Color(171, 222, 158));
        JButton b2 = new JButton("BACK");
        b2.setBounds(20, 120, 100, 30);
        b2.setFont(new Font("Verdana", Font.PLAIN, 11));
        b2.setBackground(new Color(171, 222, 158));
        JButton b3 = new JButton("ADD");
        b3.setBounds(900, 880, 150, 50);
        b3.setFont(new Font("Verdana", Font.PLAIN, 20));
        b3.setBackground(new Color(171, 222, 158));


        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171, 222, 158));
        l.setFont(new Font("Verdana", Font.PLAIN, 30));
        l.setBounds(0, 20, 1920, 90);

        JLabel l1 = new JLabel("PATIENT", JLabel.CENTER);
        l1.setOpaque(true);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Verdana", Font.PLAIN, 20));
        l1.setBounds(800, 120, 300, 30);
        l1.setBackground(new Color(215, 247, 224));

        JLabel l2 = new JLabel("ENTER THE ID", JLabel.CENTER);
        l2.setOpaque(true);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Verdana", Font.PLAIN, 20));
        l2.setBounds(600, 226, 300, 30);
        l2.setBackground(new Color(215, 247, 224));

        JLabel l3 = new JLabel("NAME", JLabel.CENTER);
        l3.setOpaque(true);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Verdana", Font.PLAIN, 20));
        l3.setBounds(560, 326, 300, 30);
        l3.setBackground(new Color(215, 247, 224));

        JLabel l4 = new JLabel("AGE", JLabel.CENTER);
        l4.setOpaque(true);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Verdana", Font.PLAIN, 20));
        l4.setBounds(200, 429, 100, 30);
        l4.setBackground(new Color(215, 247, 224));

        JLabel l5 = new JLabel("PHONE NUMBER", JLabel.CENTER);
        l5.setOpaque(true);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Verdana", Font.PLAIN, 20));
        l5.setBounds(740, 429, 250, 30);
        l5.setBackground(new Color(215, 247, 224));

        JLabel l6 = new JLabel("ADDRESS", JLabel.CENTER);
        l6.setOpaque(true);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Verdana", Font.PLAIN, 20));
        l6.setBounds(1320, 429, 150, 30);
        l6.setBackground(new Color(215, 247, 224));

        JLabel l7 = new JLabel("LAST APPOINTMENT", JLabel.CENTER);
        l7.setOpaque(true);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Verdana", Font.PLAIN, 20));
        l7.setBounds(180, 529, 300, 30);
        l7.setBackground(new Color(215, 247, 224));

        JLabel l8 = new JLabel("NO OF APPOINTMENT CHANGES", JLabel.CENTER);
        l8.setOpaque(true);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Verdana", Font.PLAIN, 20));
        l8.setBounds(740, 529, 400, 30);
        l8.setBackground(new Color(215, 247, 224));

        JLabel l9=new JLabel("GENDER",JLabel.CENTER);
        l9.setOpaque(true);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Verdana",Font.PLAIN,20));
        l9.setBounds(1260,529,250,30);
        l9.setBackground(new Color(215, 247, 224));

        JLabel l10=new JLabel("PROBLEM OF VISIT",JLabel.CENTER);
        l10.setOpaque(true);
        l10.setForeground(Color.BLACK);
        l10.setFont(new Font("Verdana",Font.PLAIN,20));
        l10.setBounds(500,729,250,30);
        l10.setBackground(new Color(215, 247, 224));


        JLabel l11=new JLabel("BLOOD GROUP",JLabel.CENTER);
        l11.setOpaque(true);
        l11.setForeground(Color.BLACK);
        l11.setFont(new Font("Verdana",Font.PLAIN,20));
        l11.setBounds(480,629,250,30);
        l11.setBackground(new Color(215, 247, 224));

        JTextField t1 = new JTextField();
        t1.setBounds(900, 220, 200, 40);
        t1.setFont(new Font("Verdana", Font.PLAIN, 20));

        JTextField t2 = new JTextField();
        t2.setBounds(900, 320, 300, 40);
        t2.setFont(new Font("Verdana", Font.PLAIN, 20));

        JTextField t3 = new JTextField();
        t3.setBounds(500, 426, 100, 40);
        t3.setFont(new Font("Verdana", Font.PLAIN, 20));

        JTextField t4 = new JTextField();
        t4.setBounds(1000, 426, 200, 40);
        t4.setFont(new Font("Verdana", Font.PLAIN, 20));

        JTextArea t5 = new JTextArea();
        t5.setBounds(1700, 426, 300, 70);
        t5.setLineWrap(true);
        t5.setFont(new Font("Verdana", Font.PLAIN, 20));
        JScrollPane pane = new JScrollPane(t5, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setBounds(1600, 426, 200, 70);


        JTextField t6 = new JTextField();
        t6.setBounds(500, 526, 150, 40);
        t6.setFont(new Font("Verdana", Font.PLAIN, 20));
        t6.setText(String.valueOf(LocalDate.now()));
        t6.setEditable(false);

        JTextField t7 = new JTextField("0");t7.setEditable(false);
        t7.setBounds(1120, 526, 50, 40);
        t7.setFont(new Font("Verdana", Font.PLAIN, 20));

        JTextField t8=new JTextField();t8.setBounds(1600,526,100,40);
        t8.setFont(new Font("Verdana", Font.PLAIN,20));


        JTextArea t10=new JTextArea();t10.setBounds(1200,629,600,40);
        t10.setFont(new Font("Verdana", Font.PLAIN,20));t10.setLineWrap(true);
        JScrollPane pane1=new JScrollPane(t10,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane1.setBounds(800,729,600,100);

        JTextField t9=new JTextField();t9.setBounds(800,629,100,40);
        t9.setFont(new Font("Verdana", Font.PLAIN,20));


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                patient.getInstance();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().isEmpty()||t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty()||t6.getText().isEmpty()||t7.getText().isEmpty()||t8.getText().isEmpty()||t10.getText().isEmpty()||t9.getText().isEmpty()){
                    JOptionPane.showMessageDialog(f, "FILL ALL THE DETAILS", "error", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    String id=t1.getText();
                    String name=t2.getText();
                    int age=Integer.parseInt(t3.getText());
                    String num=t4.getText();
                    String address=t5.getText();
                    String date=t6.getText();
                    String bg=t8.getText();
                    String gen=t9.getText();
                    String po=t10.getText();



                    try{
                        
                    PreparedStatement ps = Login.getConnection().prepareStatement("INSERT INTO patient (ID,Name,Age,Phone_Number,Address,Last_Appointment,No_Of_Appointment_Changes,Blood_Group,Problem_Of_Visit,Gender,doctor) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1,id);
                    ps.setString(2,name);
                    ps.setInt(3,age);
                    ps.setString(4,num);
                    ps.setString(5,address);
                    ps.setString(6,date);
                    ps.setString(7,t7.getText());
                    ps.setString(10,bg);
                    ps.setString(9,po);
                    ps.setString(8,gen);
                    ps.setString(11, Login.Doctor_Login_ID);
                    boolean a=ps.execute();
                    ps.close();
                    
                        JOptionPane.showMessageDialog(f, "SUCCESSFULL", "Success", JOptionPane.WARNING_MESSAGE);
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t8.setText("");t9.setText("");
                        t10.setText("");


                    }
        catch (Exception ec){
            System.out.println(ec);
            JOptionPane.showMessageDialog(f, "ID ALREADY EXISTS", "Alert", JOptionPane.WARNING_MESSAGE);


                }
                }
            }
        });
        b1.addActionListener(e->{
            Login.getInstance();
            f.setVisible(false);
        });

        f.setSize(1920, 1080);
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.add(l);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(t1);
        f.add(t2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(t3);
        f.add(t4);
        f.add(l5);
        f.add(t6);
        f.add(t7);
        f.add(t8);
        f.add(l3);
        f.add(l4);
        f.add(pane);
        f.add(l6);
        f.add(l7);
        f.add(l8);
        f.add(l9);
        f.add(l10);f.add(l11);f.add(t9);
        f.add(pane1);
        f.setLayout(null);
        f.setResizable(true);f.setDefaultCloseOperation(3);
        f.setVisible(true);

    }


    public static addpatient getInstance(){
        return new addpatient();
    }
}
