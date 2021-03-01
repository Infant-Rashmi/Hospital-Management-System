package MODULE_2;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;




public class Patient_Admin extends JFrame{
    JLabel Header_Label,Patient_Panel,Search_Label;
    JPanel Table_Panel;
    JTable  Table ;
    JButton Back_Button;
    
    TableRowSorter rowSorter;
    JTextField Search_TField;
    private Patient_Admin(){
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();

        Header_Label = new JLabel("Hospital Management System",JLabel.CENTER);
        Header_Label.setOpaque(true);
        Header_Label.setBackground(new Color(171, 222, 158));
        Header_Label.setFont(new Font("Verdana",Font.PLAIN,30));
        Header_Label.setBounds(0,20,(int)d.getWidth(),90);

        Patient_Panel = new JLabel("Patient Panel",JLabel.CENTER);
        Patient_Panel.setOpaque(true);
        Patient_Panel.setBackground(new Color(171, 222, 158));
        Patient_Panel.setFont(new Font("Verdana",Font.PLAIN,24));
        Patient_Panel.setBounds(0, 150, (int)d.getWidth(), 50);

        Search_Label = new JLabel("Search :");
        Search_Label.setFont(new Font("Verdana", Font.PLAIN, 23));
        Search_Label.setBounds(80, 230, 200, 50);

        Search_TField = new JTextField();
        Search_TField.setFont(new Font("Verdana", Font.PLAIN, 21));
        Search_TField.setBorder(null);
        Search_TField.setBounds(280, 230, 350, 50);

        Table_Panel = new JPanel();
        Table_Panel.setBounds(50,330,1800,670);
        Table_Panel.setLayout(new GridLayout());
        Vector <String> Data = new Vector<>();
        Data.add("Name");
        Data.add("ID");
        Data.add("Age");
        Data.add("Address");
        Data.add("Blood_Group");
        Data.add("Phone_Number");
        Data.add("Problem_Of_Visit");
        Data.add("Last_Appointment");
        Data.add("Next_Appointment");
        Data.add("No_Of_Appointment_Changes");
        Data.add("Doctor");
        Data.add("Status");
        Data.add("Fees");
        Vector<Vector<Object>> Column = new Vector<Vector<Object>>();
        try {
            Statement S=Login.getConnection().createStatement();
            ResultSet rs = S.executeQuery("select * from patient;");
            
            while(rs.next()){
                Vector <Object> temp = new Vector<>();
                temp.add(rs.getString("Name"));
                temp.add(rs.getString("ID"));
                temp.add(rs.getInt("Age"));
                temp.add(rs.getString("Address"));
                temp.add(rs.getString("Blood_Group"));
                temp.add(rs.getInt("Phone_Number"));
                temp.add(rs.getString("Problem_Of_Visit"));
                temp.add(rs.getString("Last_Appointment"));
                temp.add(rs.getString("Next_Appointment"));
                temp.add(rs.getInt("No_Of_Appointment_Changes"));
                temp.add(rs.getString("Doctor"));
                temp.add(rs.getString("Status"));
                temp.add(rs.getInt("Fees"));
                
        Column.add(temp);
                
            }
        } 
        catch (Exception e) {}
  
        DefaultTableModel model = new DefaultTableModel(Column ,Data);
        Table = new JTable();
        Table.setModel(model);
        Table.setBounds(400, 740, 1450, 250);
        Table.setFont(new Font("Verdana", Font.PLAIN, 15));
        Table.setRowHeight(30);
        Table_Panel.add(new JScrollPane(Table));
        Table.setRowHeight(30);
        Table.setBorder(null);
        rowSorter = new TableRowSorter<>(model);
        Table.setRowSorter(rowSorter);
        Search_TField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(Search_TField.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                search(Search_TField.getText());
                
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                search(Search_TField.getText());
            }
            public void search(String str){
                if(str.length()==0){rowSorter.setRowFilter(null);}
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });

        model.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e) {
                int row=e.getFirstRow();
                int Col=e.getColumn();
                try{
                String str=Table.getColumnName(Col);    
                PreparedStatement s1 = Login.getConnection().prepareStatement("UPDATE `patient` SET `"+str+"` =? WHERE `ID` = ?;");

               
                s1.setString(1, String.valueOf(Table.getValueAt(row, Col)));
                s1.setString(2, String.valueOf(Table.getValueAt(row, 1)));
                
                System.out.println(Table.getColumnName(Col)+"  "+String.valueOf(Table.getValueAt(row, Col))+"  "+String.valueOf(Table.getValueAt(row, 1)));
                System.out.println(s1.executeUpdate());
            }
                
                catch(Exception sql){}
            }
        });

        Back_Button = new JButton("Back");
        Back_Button.setFont(new Font("Verdana", Font.PLAIN, 21));
        Back_Button.setBackground(new Color(171, 222, 158));
        Back_Button.setBounds(1720,230,130,50);
        Back_Button.addActionListener(e->{
            Option.getInstance();
            dispose();
        });


        add(Back_Button);
        add(Header_Label);add(Patient_Panel);add(Table_Panel);add(Search_Label);add(Search_TField);
        setSize((int)d.getWidth(),(int)d.getHeight());
        getContentPane().setBackground(new Color(215, 247, 224));
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static Patient_Admin getInstance(){
        return new Patient_Admin();
    }
    public static void main(String[] args) {
        getInstance();
    }
}