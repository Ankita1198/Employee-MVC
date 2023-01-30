package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;

import model.*;
import view.EmployeeView;


public class EmpController implements ActionListener
{
	EmployeeView v;
	public EmpController(EmployeeView v)
	{
		this.v=v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DAOImplementor di=new DAOImplementor();
		Employee emp=new Employee();
		
		if(e.getSource()==v.b1)
		{
			emp.setId(Integer.parseInt(v.tf1.getText()));
			emp.setName(v.tf2.getText());
			emp.setAddr(v.tf3.getText());
			emp.setSal(Float.parseFloat(v.tf4.getText()));
			int z;
			try
			{
				z=di.insertdata(emp);
				if(z>0)
				{
					JOptionPane.showMessageDialog(v.f, "Data inserted");
				}
			}
			catch(ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			v.tf1.setText("");
			v.tf2.setText("");
			v.tf3.setText("");
			v.tf4.setText("");
		}
		
		if(e.getSource()==v.b2)
		{
			int id=Integer.parseInt(v.tf1.getText());
			int z;
			try
			{
				z=di.deletedata(id);
				if(z>0)
				{
					JOptionPane.showMessageDialog(v.f, "Data deleted");
				}
			}
			catch(Exception ex)
			{}
			v.tf1.setText("");
		}
		
		if(e.getSource()==v.b3)
		{
			int id=(Integer.parseInt(v.tf1.getText()));
			float sal=(Float.parseFloat(v.tf4.getText()));
			try
			{
				int z=di.updatedata(id,sal);
				if(z>0)
				{
					JOptionPane.showMessageDialog(v.f, "Data updated");
				}
			}
			catch (ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		
		
		if(e.getSource()==v.b4)
		{
			emp.setId(Integer.parseInt(v.tf1.getText()));
			try
			{
				emp=di.searchdata(emp);
				v.tf1.setText(Integer.toString(emp.getId()));
				v.tf2.setText(emp.getName());
				v.tf3.setText(emp.getAddr());
				v.tf4.setText(Float.toString(emp.getSal()));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		
		
		if(e.getSource()==v.b5)
		{
			List<Employee> l=new ArrayList<Employee>();
			try
			{
				l=di.showAll();
				for(Employee e1:l)
				{
					v.ta.append(e1.toString()+"\n");
				}
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
		
		
	}
	

}