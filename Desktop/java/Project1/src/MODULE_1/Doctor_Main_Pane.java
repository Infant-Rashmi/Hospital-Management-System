package MODULE_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//  */
// package hospital.management.system;

/**
 */
 
import javax.swing.*;
import MODULE_2.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Doctor_Main_Pane {

    private Doctor_Main_Pane(){
        JFrame mainframe=new JFrame();
        JLabel head_label= new JLabel("Hospital Management System",JLabel.CENTER);
        head_label.setOpaque(true);
        head_label.setForeground(Color.BLACK);
        head_label.setBackground(new Color(171,222,158));
        head_label.setFont(new Font("Verdana",Font.PLAIN,30));
        head_label.setBounds(0,20,1920,90);
        //AddForm_Button
        JLabel Doc_Panel = new JLabel("Doctor Details",JLabel.CENTER);
        Doc_Panel.setOpaque(true);
        Doc_Panel.setBackground(new Color(171,222,158));
        Doc_Panel.setFont(new Font("Verdana",Font.PLAIN,24));
        Doc_Panel.setBounds(0,150,1920,50);
        mainframe.add(Doc_Panel);

        JPanel Pane = new JPanel();
        Pane.setBackground(new Color(171,222,158));
        Pane.setBounds(200, 250, 1500, 540);
        Pane.setLayout(null);

       JButton addframe_btn=new JButton("Add Doctor");
       addframe_btn.setBounds(590,50,350,70);
       addframe_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
       addframe_btn.setBorder(null);
        addframe_btn.setBackground(new Color(215, 247, 224));
        addframe_btn.setFont(new Font("Verdana",Font.PLAIN,18));
        // addframe_btn.setBorder(null);
       Pane.add(addframe_btn);
       addframe_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.dispose();
                AddForm.getInstance();
            }
        });
       //Updateform_btn
       JButton updateframe_btn=new JButton("Update Doctor");
       updateframe_btn.setBounds(590,170,350,70);
        updateframe_btn.setBackground(new Color(215, 247, 224));
        updateframe_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateframe_btn.setFont(new Font("Verdana",Font.PLAIN,18));
        updateframe_btn.setBorder(null);
       Pane.add(updateframe_btn);
       updateframe_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.dispose();
                UpdateForm.getInstance();
            }
        });
       //Deleteform_btn
       JButton deleteframe_btn=new JButton("Delete Doctor");
      deleteframe_btn.setBounds(590,290,350,70);
        deleteframe_btn.setBackground(new Color(215, 247, 224));
        deleteframe_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteframe_btn.setFont(new Font("Verdana",Font.PLAIN,18));
        deleteframe_btn.setBorder(null);
       Pane.add(deleteframe_btn);
       deleteframe_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.dispose();
                DeleteForm.getInstance();
            }
        });
       //Viewform_btn
       JButton viewframe_btn=new JButton("View Doctor Details");
       viewframe_btn.setBounds(590,410,350,70);
         viewframe_btn .setBackground(new Color(215, 247, 224));
         viewframe_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
         viewframe_btn.setFont(new Font("Verdana",Font.PLAIN,18));
         viewframe_btn.setBorder(null);
       Pane.add(viewframe_btn);
       viewframe_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.dispose();
                ViewForm.getInstance();
            }
        });
       
        JButton Back_Btn = new JButton("Back");
        Back_Btn.setBounds(1530,900,170,60);
        Back_Btn.setBackground(new Color(171,222,158));
        Back_Btn.setFont(new Font("Verdana",Font.PLAIN,18));
        Back_Btn.addActionListener(e->{
            mainframe.dispose();
            Option.getInstance();
        });
        mainframe.add(Back_Btn);
        


        mainframe.add(Pane);
        mainframe.setSize(1920,1080);
        mainframe.getContentPane().setBackground(new Color(215, 247, 224));
        mainframe.add(head_label);
        mainframe.setLayout(null);
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    public static Doctor_Main_Pane getInstance(){
        return new Doctor_Main_Pane(); 
    }
    
}
