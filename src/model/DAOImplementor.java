package model;
import java.sql.*;
import java.util.*;

public class DAOImplementor implements DAOprovider
{
	ResultSet rs;
	PreparedStatement pst;
	Connection con;
	CallableStatement cst;
	Employee e1;
	
	@Override
	public int insertdata(Employee e) throws ClassNotFoundException, SQLException
	{
		con=DBConnect.connectDB();
		pst=con.prepareStatement("insert into Emp_info values(?,?,?,?)");
		pst.setInt(1,e.getId());
		pst.setString(2, e.getName());
		pst.setString(3, e.getAddr());
		pst.setFloat(4, e.getSal());
		return (pst.executeUpdate());	
	}

	@Override
	public int deletedata(int id) throws ClassNotFoundException, SQLException
	{
		con=DBConnect.connectDB();
		pst=con.prepareStatement("delete from Emp_info where id=?");
		pst.setInt(1, id);
		return (pst.executeUpdate());
	}

	public int updatedata(int id, float sal) throws ClassNotFoundException, SQLException
	{
		con=DBConnect.connectDB();
		pst=con.prepareStatement("update Emp_info set sal=? where id=?");
		pst.setFloat(1, sal);
		pst.setInt(2, id);
		return (pst.executeUpdate());
	}

	@Override
	public Employee searchdata(Employee em) throws ClassNotFoundException, SQLException {
		con=DBConnect.connectDB();
		pst=con.prepareStatement("select * from emp_info where id=?");
		pst.setInt(1, em.getId());
		rs=pst.executeQuery();
		while(rs.next())
		{
			em.setId(rs.getInt(1));
			em.setName(rs.getString(2));
			em.setAddr(rs.getString(3));
			em.setSal(rs.getFloat(4));
		}
		return em;
	}

	@Override
	public List<Employee> showAll() throws ClassNotFoundException, SQLException {
		con=DBConnect.connectDB();
		List<Employee> l=new ArrayList<Employee>();
		Statement s=con.createStatement();
		rs=s.executeQuery("select * from Emp_info");
		while(rs.next())
		{
			e1=new Employee();
			e1.setId(rs.getInt(1));
			e1.setName(rs.getString(2));
			e1.setAddr(rs.getString(3));
			e1.setSal(rs.getFloat(4));
			l.add(e1);
		}
		return l;
	}

}