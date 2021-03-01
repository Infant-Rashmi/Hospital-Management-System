package MODULE_2;
import MODULE_2.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import MODULE_1.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
// import javax.swing.plaf.ColorUIResource;
import javax.xml.transform.Result;

public class Option extends JFrame implements ActionListener{

    private JLabel Header_Label,Footer_Label,Icon_Label_1,Icon_Label_2,Icon_Label_3;
    private JButton Doctor_Button,Receptionist_Button,Patient_Button,logout,AdminDetail_Button,Salary_Button;
    private Option(){
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon i1 = new ImageIcon("MODULE_2\\doc3.png"); 
        ImageIcon i2 = new ImageIcon("MODULE_2\\recp3.png");
        ImageIcon i3 = new ImageIcon("MODULE_2\\Pat2.jpg");
        
        Header_Label = new JLabel("Hospital Management System",JLabel.CENTER);
        Header_Label.setFont(new Font("Verdana",Font.PLAIN,30));
        Header_Label.setOpaque(true);
        Header_Label.setBackground(new Color(171, 222, 158));
        Header_Label.setBounds(0,20,(int)ss.getWidth(),90);
        
        Footer_Label = new JLabel("Admin Panel",JLabel.CENTER);
        Footer_Label.setOpaque(true);
        Footer_Label.setBackground(new Color(171, 222, 158));
        Footer_Label.setFont(new Font("Verdana",Font.PLAIN,24));
        Footer_Label.setBounds(0,150,(int)ss.getWidth(),50);
        
        Icon_Label_1 = new JLabel(i1);
        Icon_Label_1.setBounds(300,310,i1.getIconWidth()-70,i1.getIconHeight()-50);
        
        Icon_Label_2 = new JLabel(i2);
        Icon_Label_2.setBounds(800,310,i2.getIconWidth()-10,i2.getIconHeight());
        
        Icon_Label_3 = new JLabel(i3);
        Icon_Label_3.setBounds(1300,310,270,280);
        
        
        Doctor_Button = new JButton("DOCTOR DETAILS");
        Doctor_Button.setFont(new Font("Verdana",Font.PLAIN,15));
        Doctor_Button.setOpaque(true);
        Doctor_Button.setBackground(new Color(171, 222, 158));
        Doctor_Button.setBounds(330, 660, 230, 60);
        Doctor_Button.addActionListener(e->{
            
            Doctor_Main_Pane.getInstance();
            dispose();
        });
        
        Receptionist_Button = new JButton("RECEPTIONIST DETAILS");
        Receptionist_Button.setFont(new Font("Verdana",Font.PLAIN,15));
        Receptionist_Button.setOpaque(true);
        Receptionist_Button.setBackground(new Color(171, 222, 158));
        Receptionist_Button.setBounds(830, 660, 230, 60);
        Receptionist_Button.addActionListener(e->{
            Receptionist_Admin.getInstance();
            dispose();
        });
        
        Patient_Button = new JButton("PATIENT DETAILS");
        Patient_Button.setFont(new Font("Verdana",Font.PLAIN,15));
        Patient_Button.setOpaque(true);
        Patient_Button.setBackground(new Color(171, 222, 158));
        Patient_Button.setBounds(1330, 660, 230, 60);
        Patient_Button.addActionListener(e->{
            Patient_Admin.getInstance();
            dispose();
        });
        

        AdminDetail_Button = new JButton("CHANGE ADMIN");
        AdminDetail_Button.setFont(new Font("Verdana",Font.PLAIN,15));
        AdminDetail_Button.setOpaque(true);
        AdminDetail_Button.setBackground(new Color(171, 222, 158));
        AdminDetail_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AdminDetail_Button.setBounds(1600,875,250,60);
        AdminDetail_Button.addActionListener(e->{
            JFrame Admin_Detail = new JFrame();
            JLabel New_Name_Label,New_Password_Label;
            JTextField New_Name_TField;
            JPasswordField New_Password_PField;
            JButton Submit_Button;

            New_Name_Label = new JLabel("New Name :");
            New_Name_Label.setFont(new Font("Verdana",Font.PLAIN,16));
            New_Name_Label.setBounds(40,100,150,50);
            Admin_Detail.add(New_Name_Label);

            New_Password_Label = new JLabel("New Password :");
            New_Password_Label.setFont(new Font("Verdana",Font.PLAIN,16));
            New_Password_Label.setBounds(40,200,150,50);
            Admin_Detail.add(New_Password_Label);

            New_Name_TField = new JTextField("");
            New_Name_TField.setFont(new Font("Verdana",Font.PLAIN,17));
            New_Name_TField.setBorder(null);
            New_Name_TField.setBounds(220,100,200,40);
            Admin_Detail.add(New_Name_TField);

            New_Password_PField = new JPasswordField("");
            New_Password_PField.setFont(new Font("Verdana",Font.PLAIN,17));
            New_Password_PField.setBorder(null);
            New_Password_PField.setBounds(220,200,200,40);
            Admin_Detail.add(New_Password_PField);

            Submit_Button = new JButton("Submit");
            Submit_Button.setFont(new Font("Verdana",Font.PLAIN,17));
            Submit_Button.setBackground(new Color(171,222,158));
            Submit_Button.setBorder(null);
            Submit_Button.setBounds(320,300,100,40);
            Submit_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Admin_Detail.add(Submit_Button);
            Submit_Button.addActionListener(e1->{
                if(New_Name_TField.getText().isEmpty() || New_Password_PField.getText().isEmpty()){
                    JOptionPane .showMessageDialog(this, "Do Enter Something");
                }
                else{
                int i=JOptionPane.showConfirmDialog(Admin_Detail, "Do Confirm ?");
                if(i==0){
                try{
                    PreparedStatement S =Login.getConnection().prepareStatement("UPDATE `adam` SET `Name`=?,`Password`=?;"); 
                    S.setString(1, New_Name_TField.getText());
                    S.setString(2, New_Password_PField.getText());
                    S.executeUpdate();
                    }
                    catch(Exception sql){}
                    Admin_Detail.dispose();
                }}
            });
            
            Admin_Detail. getContentPane().setBackground(new Color(215, 247, 224));
            Admin_Detail.setSize(480,550);
            Admin_Detail.setLocationRelativeTo(null);
            Admin_Detail.setLayout(null);
            Admin_Detail.setVisible(true);
    
        });

        Salary_Button = new JButton("Salary Details");
        Salary_Button.setFont(new Font("Verdana",Font.PLAIN,15));
        Salary_Button.setOpaque(true);
        Salary_Button.setBackground(new Color(171, 222, 158));
        Salary_Button.setBounds(1600,800,250,60);
        Salary_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Salary_Button.addActionListener(e->{

            Salary_Details.getInstance();
        });


        logout = new JButton("LOGOUT");
        logout.setFont(new Font("Verdana",Font.PLAIN,15));
        logout.setOpaque(true);
        logout.setBackground(new Color(171, 222, 158));
        logout.setBounds(1600, 950, 250, 60);
        logout.addActionListener(this);
        
        getContentPane().setBackground(new Color(215, 247, 224));
        add(Header_Label);add(Footer_Label);add(Icon_Label_1);add(Icon_Label_2);add(Icon_Label_3);add(Doctor_Button);add(Receptionist_Button);add(Patient_Button);add(AdminDetail_Button);add(logout);add(Salary_Button);
        setSize((int)ss.getWidth(),(int)ss.getHeight());
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logout){Login.getInstance();setVisible(false);}
    }   
    public static Option getInstance(){
        return new Option();
    }
    
}