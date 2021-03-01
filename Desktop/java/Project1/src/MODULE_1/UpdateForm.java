package MODULE_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import MODULE_2.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author Infant Rashmi
 */
public class UpdateForm {
    private UpdateForm()
    {
        JFrame updateframe=new JFrame();
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
        updateframe.add(head_label2);
        //doc id
        JLabel doc_id_lbl=new JLabel("Doctor's id :");
        doc_id_lbl.setBounds(500, 370, 200, 50);
        doc_id_lbl.setFont(new Font("Verdana",Font.PLAIN,21));

        JTextField doc_id_txtfield=new JTextField();
        doc_id_txtfield.setBounds(800, 370, 350, 50);
        doc_id_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
        doc_id_txtfield.setBorder(null);
        doc_id_txtfield.setBorder(null);
        //update field
        JLabel field_lbl=new JLabel("Fields :");
        field_lbl.setBounds(500,530,200,40);
        field_lbl.setFont(new Font("Verdana",Font.PLAIN,21));
        String Field[]={"doctor_id","first_name","second_name","age","blood_grp","gender","dept","address","ph_no","city","visiting_time","days","username","password","salary"};        
        
        JComboBox field_combo=new JComboBox(Field);    
        field_combo.setBounds(800, 530,350,40); 
        field_combo.setFont(new Font("Verdana",Font.PLAIN,18));  
         //New update value
        JLabel update_lbl = new JLabel("Enter new value :");
        update_lbl.setFont(new Font("Verdana", Font.PLAIN, 21));
        update_lbl.setBounds(500, 680, 250, 55);
        JTextField  update_txtfield= new JTextField();
        update_txtfield.setBounds(800, 680, 350, 55);
        update_txtfield.setFont(new Font("Verdana",Font.PLAIN,19));
        update_txtfield.setBorder(null);
        //submit_btn
        JButton submit_btn=new JButton("Update");//submit_btn.setBounds(200,200,200,40);
        submit_btn.setBounds(1000,830,150,40);
        submit_btn.setBackground(new Color(171,222,158));
        submit_btn.setFont(new Font("Verdana",Font.PLAIN,19));
       //back_btn
        JButton back_btn=new JButton("Back");
        back_btn.setBounds(1520,220,140,40);
        back_btn.setBackground(new Color(171,222,158));
        back_btn.setFont(new Font("Verdana",Font.PLAIN,19));
        back_btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              updateframe.dispose();
              Doctor_Main_Pane.getInstance();
           }
        });
       //Add elements
        updateframe.add(head_label);
        updateframe.add(doc_id_lbl);
        updateframe.add(doc_id_txtfield);
        updateframe.add(field_lbl);
        updateframe.add(field_combo);
        updateframe.add(submit_btn);
        updateframe.add(update_lbl);updateframe.add(update_txtfield);
        updateframe.add(back_btn);
        submit_btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        //sql database for update
            if(JOptionPane.showConfirmDialog(updateframe,"Are You Sure Do You Wanna Continue?")==0){
            try{
        
            
              if(field_combo.getSelectedItem()=="doctor_id") 
             {
                String sql = "UPDATE  doctor set doctor_id='"+update_txtfield.getText()+"' where doctor_id='"+doc_id_txtfield.getText()+"';";
                PreparedStatement st=Login.getConnection().prepareStatement(sql);
                st.executeUpdate(sql);
             }
            else if(field_combo.getSelectedItem()=="first_name")
            {
                String sql = "UPDATE  doctor set first_name='"+update_txtfield.getText()+"' where doctor_id='"+doc_id_txtfield.getText()+"';";
                PreparedStatement st=Login.getConnection().prepareStatement(sql);
                st.executeUpdate(sql);
            }
            else  if(field_combo.getSelectedItem()=="second_name")
            {
                 String sql = "UPDATE  doctor set second_name='"+update_txtfield.getText()+"' where doctor_id='"+doc_id_txtfield.getText()+"';";
             PreparedStatement st=Login.getConnection().prepareStatement(sql);
             st.executeUpdate(sql);
            }
             else  if(field_combo.getSelectedItem()=="age")
             {
                  String sql = "UPDATE  doctor set age='"+Integer.parseInt(update_txtfield.getText())+"' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
             else if(field_combo.getSelectedItem()=="blood_grp")
             {
                  String sql = "UPDATE  doctor set blood_grp='"+update_txtfield.getText()+"'where doctor_id='" +doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
             else  if(field_combo.getSelectedItem()=="gender")
             {
                  String sql = "UPDATE  doctor set gender='"+update_txtfield.getText()+"'where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
             else  if(field_combo.getSelectedItem()=="dept")
             {
                  String sql = "UPDATE  doctor set dept='"+update_txtfield.getText()+"' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
             else if(field_combo.getSelectedItem()=="address")
             {
                  String sql = "UPDATE  doctor set address='"+update_txtfield.getText()+"' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
             else if(field_combo.getSelectedItem()=="ph_no")
             {
                  String sql = "UPDATE  doctor set ph_no='"+update_txtfield.getText()+"' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
            else if(field_combo.getSelectedItem()=="city")
             {
                  String sql = "UPDATE  doctor set city='"+update_txtfield.getText()+" ' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
            else if(field_combo.getSelectedItem()=="visiting_time")
             {
                  String sql = "UPDATE  doctor set visiting_time='"+update_txtfield.getText()+" ' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
            else if(field_combo.getSelectedItem()=="days")
             {
                  String sql = "UPDATE  doctor set days='"+update_txtfield.getText()+" ' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
            else if(field_combo.getSelectedItem()=="username")
             {
                  String sql = "UPDATE  doctor set username='"+update_txtfield.getText()+" ' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
            else if(field_combo.getSelectedItem()=="password")
             {
                  String sql = "UPDATE  doctor set password='"+update_txtfield.getText()+" ' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }
            else if(field_combo.getSelectedItem()=="salary")
             {
                  String sql = "UPDATE  doctor set salary='"+Integer.parseInt(update_txtfield.getText())+"' where doctor_id='"+doc_id_txtfield.getText()+"';";
              PreparedStatement st=Login.getConnection().prepareStatement(sql);
              st.executeUpdate(sql);
             }

         
        
            }
            catch(Exception n)
            {
            System.out.println(n);
            }}}});
        updateframe.setDefaultCloseOperation(3);
        updateframe.setSize(1920,1080);
        updateframe.getContentPane().setBackground(new Color(215, 247, 224));
        updateframe.add(head_label);
        updateframe.setLayout(null);
        updateframe.setVisible(true);

     
}
    public static UpdateForm getInstance(){
        return new UpdateForm();
    }
}
