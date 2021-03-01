/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Infant Rashmi
 */
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
class TableDemo extends JFrame 
{ 
	JTable tb; 
	JScrollPane sp; 
	TableDemo() 
	{ 
		String headers[]={"Sl.No","Item","Price"}; 
		Object content[][]={ 
		{1,"Item1",100}, 
		{2,"Item2",110}, 
		{3,"Item3",200}, 
		{4,"Item4",100}, 
		{5,"Item5",150}}; 
		tb=new JTable(content,headers); 
		sp=new JScrollPane(tb); 
		setLayout(new BorderLayout()); 
		setSize(300,200); 
		add(sp,BorderLayout.CENTER); 
		setVisible(true); 
	} 
	public static void main(String args[]) 
	{ 
		new TableDemo(); 
	} 
} 