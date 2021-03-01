
package MODULE_3;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import MODULE_2.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class changeappointment  {
    JTable tb;String s2,s;DefaultTableModel model;String id;int val=0;

    JPanel Pane=new JPanel();
    private changeappointment(){
        JFrame f=new JFrame();




        JLabel l= new JLabel("Hospital Management System",JLabel.CENTER);
        JButton b1=new JButton("LOG OUT");b1.setBounds(1780,120,100,30);
        b1.setFont(new Font("Verdana", Font.PLAIN,11));b1.setBackground(new Color(171,222,158));
        JButton b2=new JButton("BACK");b2.setBounds(20,120,100,30);
        b2.setFont(new Font("Verdana", Font.PLAIN,11));b2.setBackground(new Color(171,222,158));
        JButton b3=new JButton("SEARCH");b3.setBounds(1300,250,200,40);
        b3.setFont(new Font("Verdana", Font.PLAIN,20));b3.setBackground(new Color(171,222,158));
        JButton b4=new JButton("SAVE");b4.setBounds(650,450,200,40);
        b4.setFont(new Font("Verdana", Font.PLAIN,20));b4.setBackground(new Color(171,222,158));
        JButton b5=new JButton("CANCEL");b5.setBounds(1050,450,200,40);
        b5.setFont(new Font("Verdana", Font.PLAIN,20));b5.setBackground(new Color(171,222,158));
        JButton Refresh=new JButton("Refresh");Refresh.setBounds(1300,550,200,30);
        Refresh.setFont(new Font("Verdana",Font.PLAIN,20));Refresh.setBackground(new Color(171,222,158));

        JTextField t1=new JTextField();t1.setBounds(650,250,600,40);
        t1.setFont(new Font("Verdana", Font.PLAIN,20));

        JTextField t2=new JTextField();t2.setBounds(850,350,200,40);
        t2.setFont(new Font("Verdana", Font.PLAIN,20));







        JLabel l1=new JLabel("CHANGE APPOINTMENT",JLabel.CENTER);
        l1.setOpaque(true);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Verdana",Font.PLAIN,20));
        l1.setBounds(800,120,300,30);
        l1.setBackground(new Color(215, 247, 224));

        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171,222,158));
        l.setFont(new Font("Verdana",Font.PLAIN,30));
        l.setBounds(0,20,1920,90);



        Pane.setBounds(500,600,1000,200);
         Pane.setBackground(new Color(215,247,224));
        Pane.setLayout(new GridLayout());
        Vector<String> column=Table();


        Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id=s;int j=0;
                model=(DefaultTableModel)tb.getModel();
                for(int i=0;i<model.getRowCount();i++)
                {
                    {
                        if(String.valueOf(model.getValueAt(i,j)).equals(id)) {
                            model.removeRow(i);

                        }
                    }
                }
                try{
                    PreparedStatement ps=Login.getConnection().prepareStatement("SELECT * from patient WHERE ID=(?)");
                    ps.setString(1,s);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        val=rs.getInt(11);val=val+1;
                    }

                }
                catch (Exception eq){
                    System.out.println(eq);
                }

                update();
                //System.out.println(val);
            }
        });





        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1[]={};
                Receptionist.getInstance();
                f.dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.setText("");
                 s=t1.getText();
                int n=s.length();
                if(n!=0){
                    try{
                        Login.getConnection().setAutoCommit(false);
                        PreparedStatement ps=Login.getConnection().prepareStatement("SELECT * from patient WHERE ID=(?) AND APPOINTMENT_CHANGE_REQUEST=(?)");
                        ps.setString(1,s);
                        ps.setInt(2,1);
                        ResultSet rs = ps.executeQuery();
                        String date = "";
                        while (rs.next()) {
                            date = rs.getString(10);
                            t2.setText(date);
                        }s2=t2.getText();
                        //System.out.println(s);
                        
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
                int a=JOptionPane.showConfirmDialog(f,"Are you sure?");
                if(a==JOptionPane.YES_OPTION)
                {
                    s = t1.getText();
                    String date = t2.getText();
                    String id = t1.getText();
                    if (date.isEmpty()) {
                    }
                    else {
                        try {
                        Login.getConnection().setAutoCommit(false);
                        PreparedStatement ps = Login.getConnection().prepareStatement("UPDATE patient SET NEXT_APPOINTMENT=?,APPOINTMENT_CHANGE_REQUEST=? WHERE ID=?");
                        ps.setString(1, date);
                        ps.setString(3, id);

                        if (s2.equals(t2.getText())) {
                            JOptionPane.showMessageDialog(f, "APPOINTMENT DATE NOT CHANGED", "Alert", JOptionPane.WARNING_MESSAGE);

                            ps.setInt(2, 1);
                        } else {

                            JOptionPane.showMessageDialog(f, "DATE CHANGED SUCCESSFULLY", "Alert", JOptionPane.WARNING_MESSAGE);
                            ps.setInt(2, 0);

                        }
                        int i = ps.executeUpdate();
                        t1.setText("");
                        t2.setText("");
                        ps.close();
                        


                        }
                        catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                }
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1[]={};
                Receptionist.getInstance();
                f.setVisible(false);
            }
        });
        f.setSize(1920,1080);
        //System.out.println(model.getRowCount());
        //System.out.println(s);
        //System.out.println(tb.getValueAt(1,1));
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.add(l);f.add(b1);f.add(b2);f.add(t1);f.add(b3);f.add(t2);f.add(b4);f.add(b5);f.add(l1);f.add(Pane);f.add(Refresh);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);

    }
    Vector<String> Table(){
        Vector<String> column=new Vector<>();
        column.add("ID");
        column.add("NAME");
        column.add("PHONE_NUMBER");
        column.add("LAST_APPOINTMENT");
        column.add("NEXT_APPOINTMENT");
        column.add("NO_OF_APPOINTMENT_CHANGES");
        Vector<Vector<String>> data=new Vector<Vector<String>>();
        try{
            Statement s=Login.getConnection().createStatement();
            ResultSet rs=s.executeQuery("SELECT * from patient WHERE APPOINTMENT_CHANGE_REQUEST='1'");
            
            while (rs.next()){
                Vector<String> temp=new Vector<>();
                temp.clear();
                temp.add(rs.getString("ID"));
                temp.add(rs.getString("NAME"));
                temp.add(String.valueOf(rs.getInt("PHONE_NUMBER")));
                temp.add(String.valueOf(rs.getObject("LAST_APPOINTMENT")));;
                temp.add(String.valueOf(rs.getObject("NEXT_APPOINTMENT")));
                temp.add(String.valueOf(rs.getInt("NO_OF_APPOINTMENT_CHANGES")));
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
    public void update(){
        try{
            Login.getConnection().setAutoCommit(false);
            PreparedStatement ps=Login.getConnection().prepareStatement("UPDATE patient SET NO_OF_APPOINTMENT_CHANGES=(?) WHERE ID=(?)");
            ps.setInt(1,val);
            ps.setString(2,s);
            int a=ps.executeUpdate();
            Login.getConnection().commit();
        }
        catch (Exception ry){
            System.out.println(ry);
        }
    }
    public static changeappointment getInstance(){
        return new changeappointment();
    }
    public static void main(String[] args) {
        getInstance();
    }
}


   /* String data[][]={};
    String column[]={"ID","LAST APPOINTMENT","NEXT APPOINTMENT","CHANGE REQUEST"};
    DefaultTableModel model = new DefaultTableModel(data,column);
        tb=new JTable(model);
                tb.setBounds(500,500,400,300);
                tb.setFont(new Font("Verdana",Font.PLAIN,15));
                JPanel pane=new JPanel();
                pane.setBounds(500,600,1000,200);
                pane.setLayout(new GridLayout());
                pane.setBackground(new Color(171,222,158));
                pane.add(new JScrollPane(tb));

*/
