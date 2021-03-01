package MODULE_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MODULE_2.Login;
/**
 *
 * @author Infant Rashmi
 */
public class DeleteForm {
    private DeleteForm()
    {
        JFrame deleteframe=new JFrame();
        JLabel head_label= new JLabel("Hospital Management System",JLabel.CENTER);
        head_label.setOpaque(true);
        head_label.setForeground(Color.BLACK);
        head_label.setBackground(new Color(171,222,158));
        head_label.setFont(new Font("Verdana",Font.PLAIN,30));
        head_label.setBounds(0,20,1920,80);

        JLabel l2 = new JLabel("Doctor Details", JLabel.CENTER);
        l2.setFont(new Font("Verdana", Font.PLAIN, 24));
        l2.setOpaque(true);
        l2.setBackground(new Color(171, 222, 158));
        l2.setBounds(0, 150, 1920, 50);
        deleteframe.add(l2);

        JPanel Panel = new JPanel();
        Panel.setBounds(250,350,1470,500);
        Panel.setBackground(new Color(171,222,158));
        Panel.setLayout(null);;
        deleteframe.add(Panel);
        //doc id
        JLabel doc_id_lbl=new JLabel("Doctor's id :");
        doc_id_lbl.setBounds(410, 150, 150, 50);
        doc_id_lbl.setFont(new Font("Verdana",Font.PLAIN,21));

        JTextField doc_id_txtfield=new JTextField();
        doc_id_txtfield.setBounds(710, 150, 350, 60);
        doc_id_txtfield.setFont(new Font("Verdana",Font.PLAIN,21));
        doc_id_txtfield.setBackground(Color.WHITE);
        doc_id_txtfield.setBorder(null);
        //back_btn
        JButton back_btn=new JButton("Back");
        back_btn.setBounds(1520,250,200,60);
        back_btn.setBackground(new Color(171,222,158));
        back_btn.setFont(new Font("Verdana",Font.PLAIN,19));
        back_btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               deleteframe.dispose();
               Doctor_Main_Pane.getInstance();
            }
        });
        //submit
        JButton submit_btn=new JButton("Delete");
        submit_btn.setBounds(913,300,150,50);
        submit_btn.setBorder(null);
        submit_btn.setCursor(new Cursor(12));
        submit_btn.setBackground(new Color(215, 247, 224));
        submit_btn.setFont(new Font("Verdana",Font.PLAIN,19));
        submit_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(submit_btn,"Are You Sure...Do You Want To Delete?")==0){
                try{
                    String sql = "Delete from doctor where doctor_id='"+doc_id_txtfield.getText()+"';";
                    Statement st = Login.getConnection().createStatement();
                    st.executeUpdate(sql);
                    }
                catch(Exception n)
                    {
                    System.out.println(n);
                    }
                    }}});
       //add elements
        deleteframe.add(back_btn);
        Panel.add(submit_btn);
        Panel.add(doc_id_lbl);
        Panel.add(doc_id_txtfield);
        deleteframe.add(head_label);
        deleteframe.setDefaultCloseOperation(deleteframe.EXIT_ON_CLOSE);
        deleteframe.setSize(1920,1080);
        deleteframe.getContentPane().setBackground(new Color(215, 247, 224));
        deleteframe.add(head_label);
        deleteframe.setLayout(null);
        deleteframe.setVisible(true);
        }

    public static DeleteForm getInstance(){
        return new DeleteForm();
    }
     
}
