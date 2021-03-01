/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODULE_1;

/**
 *
 * @author Infant Rashmi
 */


import java.awt.Color;
import javax.swing.*;

import MODULE_2.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class AddForm {
    private AddForm(){
      JFrame addframe=new JFrame();
      /*head label*/
      JLabel head_label= new JLabel("Hospital Management System",JLabel.CENTER);
      head_label.setOpaque(true);
      head_label.setForeground(Color.BLACK);
      head_label.setBackground(new Color(171,222,158));
      head_label.setFont(new Font("Verdana",Font.PLAIN,30));
      head_label.setBounds(0,20,1920,80); 
      JLabel head_label2 = new JLabel("Doctor Details", JLabel.CENTER);
      head_label2.setFont(new Font("Verdana", Font.PLAIN, 24));
      head_label2.setOpaque(true);
      head_label2.setBackground(new Color(171, 222, 158));
      head_label2.setBounds(0, 150, 1920, 50);
      addframe.add(head_label2);
        
        //doc_id
      JLabel doc_id_lbl=new JLabel("Doctor's id :");
      doc_id_lbl.setBounds(300, 240, 200, 50);
      doc_id_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      JTextField doc_id_txtfield=new JTextField();
      doc_id_txtfield.setBounds(500, 240, 350, 50);
      doc_id_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
      doc_id_txtfield.setBorder(null);
        //doc_first_name
      JLabel doc_first_name_lbl=new JLabel("First name :");
      doc_first_name_lbl.setBounds(70, 380, 150, 40);
      doc_first_name_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      JTextField doc_first_name_txtfield=new JTextField();
      doc_first_name_txtfield.setBounds(280, 380, 290, 40);
      doc_first_name_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
      doc_first_name_txtfield.setBorder(null);
      //doc_second_name
      JLabel doc_second_name_lbl=new JLabel("Second name :");
      doc_second_name_lbl.setBounds(750, 380, 200, 40);
      doc_second_name_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      JTextField doc_second_name_txtfield=new JTextField();
      doc_second_name_txtfield.setBounds(950, 380, 290, 40);
      doc_second_name_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
      doc_second_name_txtfield.setBorder(null);
      //age
      JLabel age_lbl=new JLabel("Age :");
      age_lbl.setBounds(70, 500, 150, 40);
      age_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      JTextField age_txtfield=new JTextField();
      age_txtfield.setBounds(280, 500, 290, 40);
      age_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
      age_txtfield.setBorder(null);
      age_txtfield.addKeyListener(new KeyAdapter() {
          @Override
          public void keyReleased( KeyEvent e) {
            String v = age_txtfield.getText();
            try {
                Integer.parseInt(v);}
              catch (Exception ex) {
                age_txtfield.setText("");
                }
            }});

      //Bloodgrp
      JLabel blood_grp_lbl=new JLabel("Blood group :");
      blood_grp_lbl.setBounds(750,620,290,40);
      blood_grp_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      JTextField blood_grp_txtfield=new JTextField();
      blood_grp_txtfield.setBounds(950,620,290,40);
      blood_grp_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
      blood_grp_txtfield.setBorder(null);
      //Gender
      JLabel gender_lbl=new JLabel("Gender :");
      gender_lbl.setBounds(750, 500, 290, 40);
      gender_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      JRadioButton gender_radio1=new JRadioButton("Male",true);
      gender_radio1.setBounds(950, 500, 100, 40);
      gender_radio1.setFont(new Font("Verdana",Font.PLAIN,19));
      gender_radio1.setBackground(new Color(215, 247, 224));
      JRadioButton gender_radio2=new JRadioButton("Female");
      gender_radio2.setBounds(1100, 500, 100, 40);
      gender_radio2.setBackground(new Color(215, 247, 224));
      gender_radio2.setFont(new Font("Verdana",Font.PLAIN,19));
      doc_id_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      ButtonGroup gender_grp=new ButtonGroup();
      gender_grp.add(gender_radio1); gender_grp.add(gender_radio2);
      //Department
      JLabel dept_lbl=new JLabel("Department:");
      dept_lbl.setBounds(1300,620,170,40);
      dept_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      String dept[]={"Allergist","Cardio","Dentist","Neurologist","Paediatrician"};        
      JComboBox dept_combo=new JComboBox(dept);    
      dept_combo.setBounds(1460, 620,290,40); 
      dept_combo.setFont(new Font("Verdana",Font.PLAIN,19));
      //Address
      JLabel address_lbl=new JLabel("Address :");
      address_lbl.setBounds(1300, 380, 130, 40);
      address_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
    
      JTextArea Address_TArea = new JTextArea();
      Address_TArea.setFont(new Font("Verdana", Font.PLAIN, 19));
      Address_TArea.setBorder(null);
      JScrollPane Scrollbar = new JScrollPane(Address_TArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      Scrollbar.setBorder(null);
      Scrollbar.getViewport().setBackground(Color.WHITE);
      Scrollbar.setBounds(1440, 380, 400, 190);
      Address_TArea.setEditable(true);

         //Phone No
      JLabel phone_lbl = new JLabel("Phone :");
      phone_lbl.setFont(new Font("Verdana", Font.PLAIN, 19));
      phone_lbl.setBounds(70, 620, 150, 40);
      JTextField  phone_txtfield= new JTextField();
      phone_txtfield.setBounds(280, 620, 290, 40);
      phone_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
      phone_txtfield.setBorder(null);
      //city
      JLabel city_lbl=new JLabel("City :");
      city_lbl.setBounds(70,740,150,40);
      city_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      String City[]={"Ariyalur", "Chennai", "Coimbatore", "Cuddalore", "Dharmapuri", "Dindigul", "Erode",
      "Kanchipuram", "Kanyakumari", "Karur", "Madurai", "Nagapattinam", "Nilgiris", "Namakkal", "Perambalur",
      "Pudukkottai", "Ramanathapuram", "Salem", "Sivaganga", "Tirupur", "Tiruchirappalli", "Theni",
      "Tirunelveli", "Thanjavur", "Thoothukudi", "Tiruvallur", "Tiruvarur", "Tiruvannamalai", "Vellore",
      "Viluppuram", "Virudhunagar" };        
      JComboBox city_combo=new JComboBox(City);    
      city_combo.setBounds(280, 740,290,40); 
      city_combo.setFont(new Font("Verdana",Font.PLAIN,19));
      //visiting time
      JLabel visiting_lbl = new JLabel("Visting time :");
      visiting_lbl.setFont(new Font("Verdana", Font.PLAIN, 19));
      visiting_lbl.setBounds(750, 740, 200, 40);
      visiting_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      JTextField  visiting_txtfield= new JTextField();
      visiting_txtfield.setBounds(950, 740, 290, 40);
      visiting_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
      visiting_txtfield.setBorder(null);
      //Days
      JLabel days_lbl=new JLabel("Visiting Days:");
      days_lbl.setBounds(1300,740,290,40);
      days_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      JTextField days_txtfield=new JTextField();
      days_txtfield.setBounds(1460,740,290,40);
      days_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
      days_txtfield.setBorder(null);
      //Username
      JLabel username_lbl=new JLabel("Username :");
      username_lbl.setBounds(70,860,290,40);
      username_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
      JTextField username_txtfield=new JTextField();
      username_txtfield.setBounds(280,860,290,40);
      username_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
      username_txtfield.setBorder(null);
      //Password
      JLabel password_lbl=new JLabel("Password :");
      password_lbl.setBounds(750,860,290,40);
      password_lbl.setFont(new Font("Verdana",Font.PLAIN,19));
     JPasswordField password_field=new JPasswordField();
      password_field.setBounds(950,860,290,40);
      password_field.setFont(new Font("Verdana",Font.PLAIN,19));
      password_field.setBorder(null);
      //submit_btn
      JButton submit_btn=new JButton("Submit");//submit_btn.setBounds(200,200,200,40);
      submit_btn.setBounds(1500,860,200,50);
      submit_btn.setBackground(new Color(171,222,158));
      submit_btn.setFont(new Font("Verdana",Font.PLAIN,19));
      //back_btn
      JButton back_btn=new JButton("Back");
      back_btn.setBounds(1620,240,170,50);
      back_btn.setBackground(new Color(171,222,158));
      back_btn.setFont(new Font("Verdana",Font.PLAIN,19));

      //Adding elements to frame
      addframe.setSize(1920,1080);
      addframe.getContentPane().setBackground(new Color(215, 247, 224));
      addframe.add(Scrollbar);
      addframe.add(head_label);
      addframe.add(submit_btn); 
      addframe.add(doc_id_lbl);addframe.add(doc_id_txtfield);addframe.add(back_btn);
      addframe.add(doc_first_name_lbl);addframe.add(doc_first_name_txtfield);
      addframe.add(doc_second_name_lbl);addframe.add(doc_second_name_txtfield);
      addframe.add(age_lbl);addframe.add(age_txtfield);
      addframe.add(blood_grp_lbl);addframe.add(blood_grp_txtfield);
      addframe.add(gender_lbl);addframe.add(gender_radio1);addframe.add(gender_radio2);
      addframe.add(dept_lbl);addframe.add(dept_combo);
      addframe.add(address_lbl);addframe.getContentPane().add(Scrollbar);
      addframe.add(phone_lbl);addframe.add( phone_txtfield);
      addframe.add(city_lbl); addframe.add(city_combo);
      addframe.add(visiting_lbl); addframe.add(visiting_txtfield);
      addframe.add(days_lbl); addframe.add(days_txtfield);
      addframe.add(username_lbl); addframe.add( username_txtfield);
      addframe.add(password_lbl); addframe.add(password_field);

  
      //back_btn ActionListener
      back_btn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            addframe.dispose();
            Doctor_Main_Pane.getInstance();
          }
      });
          //submit_btn ActionListener
      submit_btn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(doc_id_txtfield.getText().isEmpty() || doc_first_name_txtfield.getText().isEmpty() || doc_second_name_txtfield.getText().isEmpty() || age_txtfield.getText().isEmpty() || blood_grp_txtfield.getText().isEmpty() || city_combo.getSelectedItem()=="Select City" || dept_combo.getSelectedItem()=="Select department" || phone_txtfield.getText().isEmpty() || visiting_txtfield.getText().isEmpty() || days_txtfield.getText().isEmpty() || username_txtfield.getText().isEmpty() || password_field.getText().isEmpty()){}
        else
              {
        if(JOptionPane.showConfirmDialog(addframe, "Do You Want To Add?")==0){
        try
          {



            PreparedStatement ps = Login.getConnection().prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            String id=doc_id_txtfield.getText();
            ps.setString(1, id);
              String first_name=doc_first_name_txtfield.getText();
            ps.setString(2,first_name);
            String second_name=doc_second_name_txtfield.getText();
            ps.setString(3,second_name);
             
            ps.setString(4, age_txtfield.getText());
            String bld_grp=blood_grp_txtfield.getText();
            ps.setString(5,bld_grp);
            if(gender_radio1.isSelected())
            {
            ps.setString(6, "Male");
            }
            else
            {
                ps.setString(6, "Female");
            }
            ps.setString(7,String.valueOf(dept_combo.getSelectedItem()));
            ps.setString(8, Address_TArea.getText());
            ps.setString(9,phone_txtfield.getText());
            ps.setString(10,String.valueOf(city_combo.getSelectedItem()));  
            ps.setString(11,visiting_txtfield.getText());
            ps.setString(12,days_txtfield.getText());
            ps.setString(13,username_txtfield.getText());
            ps.setString(14,password_field.getText());
            ps.setInt(15,40000);
            ps.executeUpdate();
            }
            catch(Exception sql){
                JOptionPane.showMessageDialog(addframe,"Not Successfully Inserted.","Alert",JOptionPane.WARNING_MESSAGE);
              }}}}});
        
        addframe.setDefaultCloseOperation(3);
        addframe.setLayout(null);
        addframe.setVisible(true);  
   }
   public static AddForm getInstance(){
    return new AddForm();
}
    
}
