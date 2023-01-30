package model;

import java.sql.*;
import java.util.*;

public interface DAOprovider
{
	String DBDRIVER="com.mysql.cj.jdbc.Driver";
	String DBURL="jdbc:mysql://localhost:3306/Employee";
	String DBUSER="root";
	String DBPASS="Ankita#98@11";
	int insertdata(Employee e) throws ClassNotFoundException,SQLException;
	int deletedata(int id) throws ClassNotFoundException,SQLException;
	int updatedata(int id,float sal) throws ClassNotFoundException, SQLException;
	Employee searchdata(Employee em) throws ClassNotFoundException,SQLException;
	public List<Employee> showAll() throws ClassNotFoundException,SQLException;
}
