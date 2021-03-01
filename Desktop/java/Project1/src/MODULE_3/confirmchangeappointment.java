package MODULE_3;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import MODULE_2.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class confirmchangeappointment {

    JFrame f=new JFrame();DefaultTableModel model;JTable tb;JPanel Pane=new JPanel();String s,s1;JTextField t1=new JTextField();
    private confirmchangeappointment(){
        JLabel l= new JLabel("Hospital Management System",JLabel.CENTER);
        JButton b1=new JButton("LOG OUT");b1.setBounds(1780,120,100,30);
        b1.setFont(new Font("Verdana", Font.PLAIN,11));b1.setBackground(new Color(171,222,158));
        JButton b2=new JButton("BACK");b2.setBounds(20,120,100,30);
        b2.setFont(new Font("Verdana", Font.PLAIN,11));b2.setBackground(new Color(171,222,158));
        JButton b3=new JButton("SEARCH");b3.setBounds(1150,220,150,40);
        b3.setFont(new Font("Verdana", Font.PLAIN,11));b3.setBackground(new Color(171,222,158));
        JButton b4=new JButton("CONFIRM");b4.setBounds(900,520,100,40);
        b4.setFont(new Font("Verdana", Font.PLAIN,11));b4.setBackground(new Color(171,222,158));
        JButton Refresh=new JButton("Refresh");Refresh.setBounds(1300,550,200,30);
        Refresh.setFont(new Font("Verdana",Font.PLAIN,20));Refresh.setBackground(new Color(171,222,158));

        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171,222,158));
        l.setFont(new Font("Verdana",Font.PLAIN,30));
        l.setBounds(0,20,1920,90);

        JLabel l1=new JLabel("CONFIRM APPOINTMENT CHANGE",JLabel.CENTER);
        l1.setOpaque(true);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Verdana",Font.PLAIN,20));
        l1.setBounds(700,120,500,30);
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

        JLabel l4=new JLabel("APPOINTMENT DATE",JLabel.CENTER);
        l4.setOpaque(true);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Verdana",Font.PLAIN,20));
        l4.setBounds(560,426,300,30);
        l4.setBackground(new Color(215, 247, 224));


        t1.setBounds(900,220,200,40);
        t1.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t2=new JTextField();t2.setBounds(900,320,300,40);
        t2.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t3=new JTextField();t3.setBounds(900,420,200,40);
        t3.setFont(new Font("Verdana", Font.PLAIN,20));
        t3.setEditable(false);

        Pane.setBounds(500,600,1000,200);
        Pane.setBackground(new Color(215,247,224));
        Pane.setLayout(new GridLayout());
        Vector<String> column=Table();


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
                try{
                    PreparedStatement ps=Login.getConnection().prepareStatement("SELECT * from patient WHERE ID=(?) AND INFORMED=(?) AND APPOINTMENT_CHANGE_REQUEST=(?) ");
                    ps.setString(1,t1.getText());
                    ps.setInt(2,0);
                    ps.setInt(3,0);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        t2.setText(rs.getString(1));
                        t3.setText(rs.getString(10));
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
                int a=JOptionPane.showConfirmDialog(f,"Are you sure?");
                if(a==JOptionPane.YES_OPTION){
                    if((t2.getText().isEmpty())||(t3.getText().isEmpty())){
                        JOptionPane.showMessageDialog(f, "INVALID", "Alert", JOptionPane.WARNING_MESSAGE);

                    }
                    else{
                    t2.setText("");
                    t3.setText("");
                    confirm();
                    }
                }
            }
        });

        Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int j=0;
                model=(DefaultTableModel)tb.getModel();
                for(int i=0;i<model.getRowCount();i++)
                {
                    {
                        if(String.valueOf(model.getValueAt(i,j)).equals(s1)) {
                            model.removeRow(i);

                        }
                    }
                }
            }
        });


        f.setSize(1920, 1080);
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.setLayout(null);
        f.setResizable(true);
        f.setVisible(true); f.setDefaultCloseOperation(3);
        f.add(l);f.add(b1);f.add(b2);f.add(l1);f.add(Pane);f.add(l2);f.add(t1);
        f.add(b3);f.add(l3);f.add(t2);f.add(t3);f.add(l4);f.add(b4);f.add(Refresh);

    }

    Vector<String> Table(){
        Vector<String> column=new Vector<>();
        column.add("ID");
        column.add("NAME");
        column.add("PHONE_NUMBER");
        column.add("LAST_APPOINTMENT");
        column.add("NEXT_APPOINTMENT");
       // column.add("NO_OF_APPOINTMENT_CHANGES");
        Vector<Vector<String>> data=new Vector<Vector<String>>();
        try{
            Statement s=Login.getConnection().createStatement();
            ResultSet rs=s.executeQuery("SELECT * from patient WHERE  INFORMED='0' AND APPOINTMENT_CHANGE_REQUEST='0' ");
            while (rs.next()){
                Vector<String> temp=new Vector<>();
                temp.clear();
                temp.add(rs.getString("ID"));
                temp.add(rs.getString("NAME"));
                temp.add(String.valueOf(rs.getInt("PHONE_NUMBER")));
                temp.add(String.valueOf(rs.getObject("LAST_APPOINTMENT")));
                temp.add(String.valueOf(rs.getObject("NEXT_APPOINTMENT")));
                //temp.add(String.valueOf(rs.getInt("NO_OF_APPOINTMENT_CHANGES")));
                data.add(temp);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        model = new DefaultTableModel(data, column);
        tb = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tb.setModel(model);
        tb.setBounds(500, 500, 400, 300);
        tb.setFont(new Font("Verdana", Font.PLAIN, 15));
        tb.setRowHeight(30);
        Pane.add(new JScrollPane(tb));

        return column;
    }
    public  void confirm(){
           s1=t1.getText();
        try{
                PreparedStatement ps = Login.getConnection().prepareStatement("UPDATE patient SET INFORMED=(?)  WHERE ID=(?)");
                ps.setInt(1,1);
                //ps.setInt(2,0);
                ps.setString(2,s1);
                int a=ps.executeUpdate();
                
            }
            catch (Exception ec){
                System.out.println(ec);
            }
    }
    public static confirmchangeappointment getInstance(){
        return new confirmchangeappointment();
    }
    public static void main(String[] args) {
        getInstance();
    }

}
