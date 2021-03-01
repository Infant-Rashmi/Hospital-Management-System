package MODULE_3;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import MODULE_2.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class doctorsavailability {
DefaultTableModel model;JPanel pane=new JPanel();
JTable tb = new JTable() {
    public boolean isCellEditable(int row, int column) {
        return false;
    }
};
    private doctorsavailability(){
        JFrame f=new JFrame();

        JButton b1=new JButton("LOG OUT");b1.setBounds(1780,120,100,30);
        b1.setFont(new Font("Verdana", Font.PLAIN,11));b1.setBackground(new Color(171,222,158));
        JButton b2=new JButton("BACK");b2.setBounds(20,120,100,30);
        b2.setFont(new Font("Verdana", Font.PLAIN,11));b2.setBackground(new Color(171,222,158));

        JLabel l = new JLabel("Hospital Management System", JLabel.CENTER);
        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171, 222, 158));
        l.setFont(new Font("Verdana", Font.PLAIN, 30));
        l.setBounds(0, 20, 1920, 90);

        JLabel l1=new JLabel("DOCTOR'S AVAILABILITY",JLabel.CENTER);
        l1.setOpaque(true);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Verdana",Font.PLAIN,20));
        l1.setBounds(800,120,300,30);
        l1.setBackground(new Color(215, 247, 224));

        pane.setBounds(500,200,1000,600);
        pane.setBackground(new Color(215,247,224));
        pane.setLayout(new GridLayout());
        Vector<String> column=Table();

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s[]={};
                Receptionist.getInstance();
                f.setVisible(false);
            }
        });

        f.setSize(1920,1080);
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.add(l);f.add(l1);f.add(b1);f.add(b2);f.add(pane);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);

    }

    Vector<String >Table() {
        Vector<String> column = new Vector<>();
        column.add("NAME");
        column.add("VISITING TIME");
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        try {
            Login.getConnection().setAutoCommit(false);
            Statement s = Login.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * from doctor");
            while (rs.next()) {
                String name=rs.getString(2)+rs.getString(3);
                Vector<String> temp = new Vector<>();
                temp.clear();
                temp.add(name);
                temp.add(rs.getString("VISITING_TIME"));
                data.add(temp);
            }
            Login.getConnection().commit();
        } catch (Exception eq) {
            System.out.println(eq);
        }
        model = new DefaultTableModel(data, column);
       /* DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tb.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);*/
        tb.setModel(model);
        tb.setBounds(500, 500, 400, 300);
        tb.setFont(new Font("Verdana", Font.PLAIN, 15));
        tb.setRowHeight(30);
        pane.add(new JScrollPane(tb));

        return column;
    }
    public static doctorsavailability getInstance(){
        return  new doctorsavailability();
    }


}
