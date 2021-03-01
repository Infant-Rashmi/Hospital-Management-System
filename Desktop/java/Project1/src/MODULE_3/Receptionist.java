package MODULE_3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receptionist {
    Receptionist() {
        JFrame f = new JFrame();

        JButton b1 = new JButton("ADD APPOINTMENT");
        b1.setBounds(795, 300, 300, 50);
        b1.setBackground(new Color(171, 222, 158));
        b1.setFont(new Font("Verdana", Font.PLAIN, 15));
        JButton b2 = new JButton("DOCTOR'S AVAILABILITY");
        b2.setBounds(795, 400, 300, 50);
        b2.setBackground(new Color(171, 222, 158));
        b2.setFont(new Font("Verdana", Font.PLAIN, 15));
        JButton b3 = new JButton("CHANGE REQUEST");
        b3.setBounds(795, 500, 300, 50);
        b3.setBackground(new Color(171, 222, 158));
        b3.setFont(new Font("Verdana", Font.PLAIN, 15));
        JButton b4 = new JButton("CHANGE APPOINTMENT");
        b4.setBounds(795, 600, 300, 50);
        b4.setBackground(new Color(171, 222, 158));
        b4.setFont(new Font("Verdana", Font.PLAIN, 15));
        JButton b5 = new JButton("LOG OUT");
        b5.setBounds(1780, 120, 100, 30);
        b5.setFont(new Font("Verdana", Font.PLAIN, 11));
        b5.setBackground(new Color(171, 222, 158));
        JButton b6 = new JButton("FEE PAYMENT");
        b6.setBounds(795, 700, 300, 50);
        b6.setFont(new Font("Verdana", Font.PLAIN, 15));
        b6.setBackground(new Color(171, 222, 158));
        JButton b7 = new JButton("CONFIRM APPOINTMENT CHANGE");
        b7.setBounds(795, 800, 300, 50);
        b7.setFont(new Font("Verdana", Font.PLAIN, 15));
        b7.setBackground(new Color(171, 222, 158));



        JLabel l = new JLabel("Hospital Management System", JLabel.CENTER);
        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171, 222, 158));
        l.setFont(new Font("Verdana", Font.PLAIN, 30));
        l.setBounds(0, 20, 1920, 90);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                addappointment.getInstance();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                doctorsavailability.getInstance();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);

                changeRequest.getInstance();
            }
        });


        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);

                changeappointment.getInstance();

            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Feepayment.getInstance();
            }
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                confirmchangeappointment.getInstance();
            }
        });

        f.setSize(1920, 1080);
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.add(l);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.setLayout(null);
        f.setResizable(true);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
    }
    public static Receptionist getInstance(){
        return new Receptionist();
    }
    public static void main(String []args){
       new  Receptionist();
    }
}

