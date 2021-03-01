package MODULE_4;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import MODULE_2.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class totalpatients {

    DefaultTableModel model;JTable tb;JPanel Pane=new JPanel();
    TableRowSorter rowSorter;  JTextField t1=new JTextField();
    private totalpatients(){
        JFrame f=new JFrame();
        JLabel l= new JLabel("Hospital Management System",JLabel.CENTER);

        JButton b1=new JButton("LOG OUT");b1.setBounds(1780,120,100,30);
        b1.setFont(new Font("Verdana", Font.PLAIN,11));b1.setBackground(new Color(171,222,158));
        JButton b2=new JButton("BACK");b2.setBounds(20,120,100,30);
        b2.setFont(new Font("Verdana", Font.PLAIN,11));b2.setBackground(new Color(171,222,158));



        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBackground(new Color(171,222,158));
        l.setFont(new Font("Verdana",Font.PLAIN,30));
        l.setBounds(0,20,1920,90);

        JLabel l1=new JLabel("PATIENT'S DETAILS",JLabel.CENTER);
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

      t1.setBounds(900,220,200,40);
        t1.setFont(new Font("Verdana", Font.PLAIN,20));


        Pane.setBounds(200,300,1500,600);
        Pane.setBackground(new Color(215,247,224));
        Pane.setLayout(new GridLayout());
        Vector<String> column=Table();


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s[]={};
                Main.getInstance();
                f.setVisible(false);
            }
        });

        b1.addActionListener(e->{
            Login.getInstance();
            f.setVisible(false);
        });

        f.setSize(1920,1080);
        f.getContentPane().setBackground(new Color(215, 247, 224));
        f.add(l);f.add(l1);f.add(b1);f.add(b2);f.add(Pane);f.add(l2);
        f.add(t1);
        f.setLayout(null);f.setResizable(true);f.setDefaultCloseOperation(3);
        f.setVisible(true);
    }
    Vector<String> Table(){
        Vector<String> column=new Vector<>();
        column.add("ID");
        column.add("NAME");
        column.add("AGE");
        column.add("GERDER");
        column.add("PHONE_NUMBER");
        column.add("ADDRESS");
        column.add("BLOOD GROUP");
        column.add("PROBLEM OF VISIT");
        column.add("LAST_APPOINTMENT");
        column.add("NEXT_APPOINTMENT");
        column.add("NO_OF_APPOINTMENT_CHANGES");
        column.add("FEES");
        column.add("DOCTOR");
        Vector<Vector<String>> data=new Vector<Vector<String>>();
        try{
            PreparedStatement  ps=Login.getConnection().prepareStatement("SELECT * from patient WHERE doctor=?;");
            ps.setString(1, Login.Doctor_Login_ID);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Vector<String> temp=new Vector<>();
                temp.clear();
                temp.add(rs.getString("ID"));
                temp.add(rs.getString("NAME"));
                temp.add(String.valueOf(rs.getInt("AGE")));
                temp.add(rs.getString("Gender"));
                temp.add(rs.getString("PHONE_NUMBER"));
                temp.add(rs.getString("ADDRESS"));
                temp.add(rs.getString("BLOOD_GROUP"));
                temp.add(rs.getString("PROBLEM_OF_VISIT"));
                temp.add(String.valueOf(rs.getObject("LAST_APPOINTMENT")));
                temp.add(String.valueOf(rs.getObject("NEXT_APPOINTMENT")));
                temp.add(String.valueOf(rs.getInt("NO_OF_APPOINTMENT_CHANGES")));
                temp.add(String.valueOf(rs.getInt("FEES")));
                temp.add(rs.getString("doctor_id"));
                data.add(temp);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        model = new DefaultTableModel(data, column);
        tb = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        tb.setColumnSelectionAllowed(false);
        tb.setRowSelectionAllowed(true);
      //  tb.getSelectionModel().setSelectionInterval(0,7);
        tb.setModel(model);
        tb.setBounds(500, 500, 400, 300);
        tb.setFont(new Font("Verdana", Font.PLAIN, 15));
        tb.setRowHeight(30);
        Pane.add(new JScrollPane(tb));
        rowSorter = new TableRowSorter<>(model);
        tb.setRowSorter(rowSorter);
        t1.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(t1.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                search(t1.getText());

            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                search(t1.getText());
            }
            public void search(String str){
                if(str.length()==0){rowSorter.setRowFilter(null);}
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });

        return column;
    }

    public static totalpatients getInstance(){
        return new totalpatients();
    }
    public static void main(String[] args) {
        getInstance();
    }
}
