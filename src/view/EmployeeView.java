package view;
import java.awt.*;
import javax.swing.*;

import controller.EmpController;

public class EmployeeView
{
	public JFrame f;
	public JLabel l1,l2,l3,l4;
	public JTextField tf1,tf2,tf3,tf4;
	public JButton b1,b2,b3,b4,b5;
	public TextArea ta;
	
	public EmployeeView()
	{
		f=new JFrame("Employee Registration");
		
		l1=new JLabel("Emp_ID");
		l2=new JLabel("Name");
		l3=new JLabel("Address");
		l4=new JLabel("Salary");
		Font fo=new Font("Liberation serif",Font.ITALIC,16);
		l1.setFont(fo);
		l2.setFont(fo);
		l3.setFont(fo);
		l4.setFont(fo);
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		
		b1=new JButton("Insert");
		b2=new JButton("Delete");
		b3=new JButton("Update");
		b4=new JButton("Search");
		b5=new JButton("Show All");
		
		ta=new TextArea();
		
		l1.setBounds(10,10,80,40);
		tf1.setBounds(100,10,150,40);
		l2.setBounds(10, 60, 80, 40);
		tf2.setBounds(100, 60, 150, 40);
		l3.setBounds(10, 110, 80, 40);
		tf3.setBounds(100, 110, 150, 40);
		l4.setBounds(10, 160, 80, 40);
		tf4.setBounds(100, 160, 150, 40);
		b1.setBounds(5,210,100,40);
		b2.setBounds(110,210,100,40);
		b3.setBounds(220,210,100,40);
		b4.setBounds(330,210,100,40);
		ta.setBounds(5,260,360,150);
		b5.setBounds(380,280,100,40);
		
		f.add(l1);	f.add(tf1);
		f.add(l2);	f.add(tf2);
		f.add(l3);	f.add(tf3);
		f.add(l4);	f.add(tf4);
		f.add(b1);	f.add(b2);
		f.add(b3);	f.add(b4);
		f.add(ta);	f.add(b5);
		
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
		b1.addActionListener(new EmpController(this));
		b2.addActionListener(new EmpController(this));
		b3.addActionListener(new EmpController(this));
		b4.addActionListener(new EmpController(this));
		b5.addActionListener(new EmpController(this));
	}
}
