package MODULE_2;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import javafx.scene.control.Tab;



public class Receptionist_Admin extends JFrame {
    JLabel Header_Label,Footer_Label,Receptionist_ID_Label,First_Name_Label,Last_Name_Label,Age_Label,Gender_Label,Phone_Label,City_Label,Address_Label,Password_Label,Joining_Date_Label;
    JTextField Receptionist_ID_TField,First_Name_TField,Last_Name_TField,Age_TField,Phone_TField,Joining_Date_TField;
    JComboBox Gender_Combo,City_Combo;
    JTextArea Address_TArea;
    JScrollPane Scrollbar;
    JPasswordField Password_TField;
    JTable Table;
    JPanel Pane;
    JButton Update_Button,Remove_Button,Add_Button,Search_Button,Back;
    // static Connection Con;
    ArrayList<String> Search = new ArrayList<>();
    DefaultTableModel model;
    // DefaultTableModel DTable;
    private Receptionist_Admin(){
         Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Header_Label = new JLabel("Hospital Management System", JLabel.CENTER);
        Header_Label.setFont(new Font("Verdana", Font.PLAIN, 30));
        Header_Label.setOpaque(true);
        Header_Label.setBackground(new Color(171, 222, 158));
        Header_Label.setBounds(0, 20, (int) ss.getWidth(), 90);
        Footer_Label = new JLabel("Receptionist Details", JLabel.CENTER);
        Footer_Label.setFont(new Font("Verdana", Font.PLAIN, 24));
        Footer_Label.setOpaque(true);
        Footer_Label.setBackground(new Color(171, 222, 158));
        Footer_Label.setBounds(0, 150, (int) ss.getWidth(), 50);
        Receptionist_ID_Label = new JLabel("Receptionist ID :");
        Receptionist_ID_Label.setFont(new Font("Verdana", Font.PLAIN, 23));
        Receptionist_ID_Label.setBounds(300, 230, 200, 50);
        Receptionist_ID_TField = new JTextField();
        Receptionist_ID_TField.setFont(new Font("Verdana", Font.PLAIN, 21));
        Receptionist_ID_TField.setBorder(null);
        Receptionist_ID_TField.setBounds(600, 230, 350, 50);
        First_Name_Label = new JLabel("First Name :");
        First_Name_Label.setFont(new Font("Verdana", Font.PLAIN, 19));
        First_Name_Label.setBounds(70, 380, 150, 40);
        Last_Name_Label = new JLabel("Last Name :");
        Last_Name_Label.setFont(new Font("Verdana", Font.PLAIN, 19));
        Last_Name_Label.setBounds(750, 380, 150, 40);
        First_Name_TField = new JTextField();
        First_Name_TField.setFont(new Font("Verdana", Font.PLAIN, 19));
        First_Name_TField.setBounds(280, 380, 290, 40);
        First_Name_TField.setBorder(null);
        Last_Name_TField = new JTextField();
        Last_Name_TField.setFont(new Font("Verdana", Font.PLAIN, 19));
        Last_Name_TField.setBounds(900, 380, 290, 40);
        Last_Name_TField.setBorder(null);

        Joining_Date_Label = new JLabel("Joining Date :");
        Joining_Date_Label.setFont(new Font("Verdana", Font.PLAIN, 19));
        Joining_Date_Label.setBounds(1300, 250, 150, 40);
        Joining_Date_Label.setBorder(null);

        Joining_Date_TField = new JTextField("");
        Joining_Date_TField.setFont(new Font("Verdana", Font.PLAIN, 19));
        Joining_Date_TField.setBounds(1500, 250, 260, 40);
        Joining_Date_TField.setBorder(null);

        Age_Label = new JLabel("Age :");
        Age_Label.setFont(new Font("Verdana", Font.PLAIN, 19));
        Age_Label.setBounds(70, 500, 150, 40);
        Age_Label.setBorder(null);
        Age_TField = new JTextField();
        Age_TField.setFont(new Font("Verdana", Font.PLAIN, 19));
        Age_TField.setBounds(280, 500, 290, 40);
        Age_TField.setBorder(null);
        Age_TField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e) {
                 String v = Age_TField.getText();
                try {
                    Integer.parseInt(v);

                } catch ( Exception ex) {
                    Age_TField.setText("");
                }
            }

        });

        Gender_Label = new JLabel("Gender :");
        Gender_Label.setFont(new Font("Verdana", Font.PLAIN, 19));
        Gender_Label.setBounds(750, 500, 290, 40);
        Gender_Label.setBorder(null);

         String array[] = { "Male", "Female", "Others" };
        Gender_Combo = new JComboBox<>(array);
        Gender_Combo.setFont(new Font("Verdana", Font.PLAIN, 19));
        Gender_Combo.setBounds(900, 500, 290, 40);
        Gender_Combo.setBorder(null);
        Gender_Combo.getModel().setSelectedItem("Select Gender");

        Phone_Label = new JLabel("Phone :");
        Phone_Label.setFont(new Font("Verdana", Font.PLAIN, 19));
        Phone_Label.setBounds(70, 620, 150, 40);
        Phone_Label.setBorder(null);

        Phone_TField = new JTextField();
        Phone_TField.setFont(new Font("Verdana", Font.PLAIN, 19));
        Phone_TField.setBounds(280, 620, 290, 40);
        Phone_TField.setBorder(null);
        Phone_TField.setColumns(10);
        

        City_Label = new JLabel("City :");
        City_Label.setFont(new Font("Verdana", Font.PLAIN, 19));
        City_Label.setBounds(750, 620, 290, 40);
        City_Label.setBorder(null);

         String array2[] = { "Ariyalur", "Chennai", "Coimbatore", "Cuddalore", "Dharmapuri", "Dindigul", "Erode",
                "Kanchipuram", "Kanyakumari", "Karur", "Madurai", "Nagapattinam", "Nilgiris", "Namakkal", "Perambalur",
                "Pudukkottai", "Ramanathapuram", "Salem", "Sivaganga", "Tirupur", "Tiruchirappalli", "Theni",
                "Tirunelveli", "Thanjavur", "Thoothukudi", "Tiruvallur", "Tiruvarur", "Tiruvannamalai", "Vellore",
                "Viluppuram", "Virudhunagar" };

        City_Combo = new JComboBox<>(array2);
        City_Combo.setFont(new Font("Verdana", Font.PLAIN, 19));
        City_Combo.setBounds(900, 620, 290, 40);
        City_Combo.setBorder(null);
        City_Combo.getModel().setSelectedItem("Select City");

        Address_Label = new JLabel("Address :");
        Address_Label.setFont(new Font("Verdana", Font.PLAIN, 19));
        Address_Label.setBounds(1300, 380, 130, 40);
        Address_Label.setBorder(null);

        Address_TArea = new JTextArea();
        Address_TArea.setFont(new Font("Verdana", Font.PLAIN, 19));
        Address_TArea.setBorder(null);
        Scrollbar = new JScrollPane(Address_TArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Scrollbar.setBorder(null);
        Scrollbar.getViewport().setBackground(Color.WHITE);
        Scrollbar.setBounds(1440, 380, 400, 190);

        Password_Label = new JLabel("Password :");
        Password_Label.setFont(new Font("Verdana", Font.PLAIN, 19));
        Password_Label.setBounds(1300, 620, 290, 40);
        Password_Label.setBorder(null);

        Password_TField = new JPasswordField();
        Password_TField.setFont(new Font("Verdana", Font.PLAIN, 19));
        Password_TField.setBounds(1440, 620, 290, 40);
        Password_TField.setBorder(null);

        Pane = new JPanel();
        Pane.setBounds(400, 740, 1450, 250);
        Pane.setBackground(new Color(215, 247, 224));
        Pane.setLayout(new GridLayout());
         Vector<String> column = Table();

        Update_Button = new JButton("Update RECPTIONIST");
        Update_Button.setFont(new Font("Verdana", Font.PLAIN, 18));
        Update_Button.setBounds(50, 750, 250, 60);
        Update_Button.setBackground(new Color(171, 222, 158));
        Update_Button.addActionListener( e->{
         int i=0;
            for(i=0;i<=model.getRowCount();i++){
                if(model.getValueAt(i,0).equals(Receptionist_ID_TField.getText())){
                    break;
                }
            }
            model.removeRow(i);
            model.insertRow(i,new String[]{Receptionist_ID_TField.getText(),First_Name_TField.getText(),Last_Name_TField.getText(), Age_TField.getText(),Phone_TField.getText(), String.valueOf(Gender_Combo.getSelectedItem()),String.valueOf(City_Combo.getSelectedItem()),Address_TArea.getText(),Joining_Date_TField.getText(),"*******"});
            try{
                PreparedStatement s=Login.getConnection().prepareStatement("UPDATE `receptionist` SET `F_name`=?,`L_name`=?,`Age`=?,`Phone`=?,`Gender`=?,`City`=?,`Address`=?,`Password`=?, `Joining_Date`=? where Recp_ID='"+Receptionist_ID_TField.getText()+"';");
                // s.setString(1, Receptionist_ID_TField.getText());
                s.setString(1, First_Name_TField.getText());
                s.setString(2, Last_Name_TField.getText());
                s.setString(3, Age_TField.getText());
                s.setString(4, Phone_TField.getText());
                s.setString(5, String.valueOf(Gender_Combo.getSelectedItem()));
                s.setString(6, String.valueOf(City_Combo.getSelectedItem()));
                s.setString(7, Address_TArea.getText());
                s.setString(9, Joining_Date_TField.getText());
                s.setString(8, Password_TField.getText());
                // s.setString(10, Receptionist_ID_TField.getText());
                s.executeUpdate();
            }
            catch(Exception sql){}
        });

        Remove_Button = new JButton("REMOVE RECPTIONIST");
        Remove_Button.setFont(new Font("Verdana", Font.PLAIN, 18));
        Remove_Button.setBounds(50, 840, 250, 60);
        Remove_Button.setBackground(new Color(171, 222, 158));
        Remove_Button.addActionListener( e->{
            JLabel current = new JLabel("Are You Sure....Do You Want To Remove ? ");
            current.setFont(new Font("Verdana",Font.PLAIN,18));
            if(JOptionPane.showConfirmDialog(this, current)==0){
            int i=0;
                for(i=0;i<model.getRowCount();i++){
                if(model.getValueAt(i, 0).equals(Receptionist_ID_TField.getText())){
                    model.removeRow(i);
                }
            } 
            try{
            Statement remove=Login.getConnection().createStatement();
            remove.executeUpdate("Delete from receptionist where Recp_ID='"+Receptionist_ID_TField.getText()+"';");
        }
        catch(Exception e1){}}
        });

        Add_Button = new JButton("ADD RECPTIONIST");
        Add_Button.setFont(new Font("Verdana", Font.PLAIN, 18));
        Add_Button.setBounds(50, 930, 250, 60);
        Add_Button.setBackground(new Color(171, 222, 158));
        Add_Button.addActionListener(e->{
            JLabel current = new JLabel("Are You Sure....Do You Want To Add ? ");
            current.setFont(new Font("Verdana",Font.PLAIN,18));
            if(JOptionPane.showConfirmDialog(this, current)==0){
            if(Receptionist_ID_TField.getText().isEmpty() || First_Name_TField.getText().isEmpty() || Last_Name_TField.getText().isEmpty() || Age_TField.getText().isEmpty() || Phone_TField.getText().isEmpty() || City_Combo.getSelectedItem()=="Select City" || Gender_Combo.getSelectedItem()=="Select Gender" || Address_TArea.getText().isEmpty() || Password_TField.getText().isEmpty()){}
            else{
            try{
            PreparedStatement s=Login.getConnection().prepareStatement("Insert into receptionist values(?,?,?,?,?,?,?,?,?,?);");
            s.setString(1, Receptionist_ID_TField.getText());
            s.setString(2, First_Name_TField.getText());
            s.setString(3, Last_Name_TField.getText());
            s.setString(4, Age_TField.getText());
            s.setString(5, Phone_TField.getText());
            s.setString(6, String.valueOf(Gender_Combo.getSelectedItem()));
            s.setString(7, String.valueOf(City_Combo.getSelectedItem()));
            s.setString(8, Address_TArea.getText());
            s.setString(10, Joining_Date_TField.getText());
            s.setString(9, Password_TField.getText());
            s.executeUpdate();
        }
            catch(Exception sql){}
            
            model.addRow(new String[]{Receptionist_ID_TField.getText(),First_Name_TField.getText(),Last_Name_TField.getText(), Age_TField.getText(),Phone_TField.getText(), String.valueOf(Gender_Combo.getSelectedItem()),String.valueOf(City_Combo.getSelectedItem()),Address_TArea.getText(),Joining_Date_TField.getText(),"*******"});
            
        }
    }
        });
        
        Search_Button = new JButton("Search");
        Search_Button.setFont(new Font("Verdana", Font.PLAIN, 18));
        Search_Button.setBounds(1050, 235, 180, 40);
        Search_Button.setBackground(new Color(171, 222, 158));
        Search_Button.addActionListener(e -> {
            if(!Receptionist_ID_TField.getText().isEmpty()){
            Search.clear();
            try {
                 String Str = Receptionist_ID_TField.getText();
                 Statement S = Login.getConnection().createStatement();
                 ResultSet rs = S.executeQuery("SELECT * FROM `receptionist` WHERE Recp_ID='" + Str + "';");
                while (rs.next()) {

                    for ( String i : column) {
                        Search.add(rs.getString(i));
                    }
                }
            }

            catch ( Exception sql) {
            }

            First_Name_TField.setText(Search.get(1));
            Last_Name_TField.setText(Search.get(2));
            Age_TField.setText(Search.get(3));
            Gender_Combo.getModel().setSelectedItem(Search.get(5));
            Phone_TField.setText(Search.get(4));
            City_Combo.getModel().setSelectedItem(Search.get(6));
            Address_TArea.setText(Search.get(7));
            Password_TField.setText(Search.get(9));
            Joining_Date_TField.setText(Search.get(8));
        }
        else{
            First_Name_TField.setText("");
            Last_Name_TField.setText("");
            Age_TField.setText("");
            Gender_Combo.getModel().setSelectedItem("Select Gender");
            Phone_TField.setText("");
            City_Combo.getModel().setSelectedItem("Select City");
            Address_TArea.setText("");
            Password_TField.setText("");
            Joining_Date_TField.setText("");

        }
        });

        Back = new JButton("Back");
        Back.setFont(new Font("Verdana",Font.PLAIN,18));
        Back.setBackground(new Color(171, 222, 158));
        Back.setBounds(70,230,120,40);
        Back.addActionListener(e->{
            setVisible(false);
            Option.getInstance();
        });
        add(Header_Label);
        add(Footer_Label);
        add(Receptionist_ID_Label);
        add(Receptionist_ID_TField);
        add(First_Name_Label);
        add(Last_Name_Label);
        add(Joining_Date_Label);
        add(Joining_Date_TField);
        add(First_Name_TField);
        add(Last_Name_TField);
        add(Age_Label);
        add(Age_TField);
        add(Gender_Label);
        add(Gender_Combo);
        add(Phone_Label);
        add(Phone_TField);
        add(City_Label);
        add(City_Combo);
        add(Address_Label);
        add(Scrollbar);
        add(Password_Label);
        add(Password_TField);
        add(Pane);
        add(Update_Button);
        add(Add_Button);
        add(Remove_Button);
        add(Search_Button);
        add(Back);
        getContentPane().setBackground(new Color(215, 247, 224));
        setSize((int) ss.getWidth(), (int) ss.getHeight());
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    Vector<String> Table() {
         Vector<String> column = new Vector<>();
        column.add("Recp_ID");
        column.add("F_name");
        column.add("L_name");
        column.add("Age");
        column.add("Phone");
        column.add("Gender");
        column.add("City");
        column.add("Address");
        column.add("Joining_Date");
        column.add("Password");
        
        // String
        // d[][]={{"R_ID_001","Hari","Krish","20","635341897","Male","Theni","XXXX,YYYY","HELLO"}};
         Vector<Vector<String>> data = new Vector<Vector<String>>();
        try {
             Statement S = Login.getConnection().createStatement();
             ResultSet rs = S.executeQuery("SELECT * FROM receptionist ORDER BY Recp_ID;");
            while (rs.next()) {
                 Vector<String> temp = new Vector<>();
                 temp.clear();
                 temp.add(rs.getString("Recp_ID"));
                temp.add(rs.getString("F_name"));
                temp.add(rs.getString("L_name"));
                temp.add(rs.getString("Age"));
                temp.add(rs.getString("Phone"));
                temp.add(rs.getString("Gender"));
                temp.add(rs.getString("City"));
                temp.add(rs.getString("Address"));
                temp.add(rs.getString("Joining_Date"));
                temp.add("*******");
                data.add(temp);
                

            }
            
        } catch ( Exception sql) {}
        model = new DefaultTableModel(data,column);
        Table = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Table.setModel(model);
        Table.setAutoCreateRowSorter(true);
        Table.setBounds(400, 740, 1450, 250);
        Table.setFont(new Font("Verdana", Font.PLAIN, 15));
        Table.setRowHeight(30);
        Pane.add(new JScrollPane(Table));
        // Table.setModel(new dummy());
        
        return column;
    }
    public static Receptionist_Admin getInstance(){
        return new Receptionist_Admin();
    }

   

}